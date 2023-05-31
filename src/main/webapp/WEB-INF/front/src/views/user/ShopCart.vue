<template>
  <div id="shop-cart">
    <div id="shop-cart-body">
      <div class="items">
        <div class="shop-cart-item" v-for="(item,index) in $store.state.shopCart" :key="item.goodsno">
          <el-col>
            <el-card shadow="hover">
              <div class="item-message">
                    <span class="click">
                      <input class="click-box" type="checkbox" @click="check(index,item)" :checked="$store.state.checked[index]">
                    </span>
                    <span class="shop-cart-item-info">
                          <span class="img"><img :src="item.goodsImage" alt="商品"></span>
                          <span class="goods-name"><p>{{ item.goodsName }}</p></span>
                          <span class="goods-price"><p>￥{{ item.goodsPrice }}</p> </span>
                          <span class="goods-num"><p>数量&nbsp;:&nbsp;&nbsp;{{ item.num }}</p></span>
                    </span>
              </div>
            </el-card>
          </el-col>
        </div>
      </div>
      <div id="pay" :class="{fixedPay:!isDisplay}">
        <shop-cart-pay ref="child"></shop-cart-pay>

      </div>
    </div>

  </div>
</template>

<script>
import ShopCartPay from "../../components/user/shopcart/ShopCartPay";
import axios from "axios";
import store from "../../store";

export default {
  name: "ShopCart",
  components: {ShopCartPay},
  data() {
    return {
      top: '',
      isDisplay: false,
      arr: []
    }
  },
  computed: {
    cards() {
      return document.getElementsByClassName('el-card')
    },
  },
  methods: {
    getArr() {
      let str = []
      for (let i in this.arr) {
        str.push(this.arr[i])
      }
      return str
    },
    async getShopCart() {
      let param = new URLSearchParams()
      param.append("username", this.$store.state.user.username)
      await axios({
        url: "http://localhost:8081/shoolShop_war_exploded/getShopCart",
        method: 'post',
        data: param
      }).then((result) => {
        store.commit("getCart", result.data)
      })
    },
    async delete() {
      let param = new URLSearchParams()
      param.append("removeNo", this.getArr())
      await axios({
        url: "http://localhost:8081/shoolShop_war_exploded/removeShopCart",
        method: 'post',
        data: param
      })
      this.$message.success("商品移出购物车成功！")
      await this.getShopCart()
    },
    async pay() {
      let param = new URLSearchParams()
      param.append("payGoods", this.getArr())
      param.append("username", this.$store.state.user.username)
      await axios({
        url: "http://localhost:8081/shoolShop_war_exploded/payShopCart",
        method: 'post',
        data: param
      })
      this.$message.success("商品结算成功！")
      await this.getShopCart()
    },
    check(index, item) {
      this.arr = []
      this.$store.commit("changeCheck", index)
      this.$refs.child.num = 0
      this.$refs.child.price = 0
      for (let i = 0; i < this.$store.state.shopCart.length; i++) {
        if (this.$store.state.checked[i]) {
          this.$refs.child.num++
          this.$refs.child.price += parseFloat(this.$store.state.shopCart[i].goodsPrice)
          this.arr.push(this.$store.state.shopCart[i].goodsno)
        }
      }
    },

  },
  mounted() {
    window.addEventListener('scroll', () => {
      this.top = document.documentElement.scrollTop
    })
  },
  watch: {
    top(newValue, oldValue) {
      if (newValue >= 1200)
        this.isDisplay = true
      else
        this.isDisplay = false
    },

  },


}

</script>

<style scoped>
.goods-name{
  width: 450px;height: 60px;margin-left: 30px;text-align: left
}
.goods-price{
  height: 50px;width: 100px;font-size: 20px;text-align: left
}
img {
  width: 80px;
  height: 100px;
}

p{
  text-align: left;
}
span {
  display: inline-block;
  /*float: top;*/
}

.color {
  border: 1px #fc9375 solid;
}

.shop-cart-item {
  width: 100%;
  height: 150px;
  margin-bottom: 30px;
}

.el-card {
  display: flex;
  height: 150px;
  flex-direction: column;
}

input[type=checkbox], span {
  height: 20px;
  width: 20px;
}

.saler {
  flex: 1;
  border-bottom: 0.5px #d4d2d2 solid;
  height: 20px;
  padding: 0 5px;
}

.item-message {
  flex: 4;
  height: 70px;
  display: flex;
}
.item-message .click{
  flex: 1;
}
.shop-cart-item-info{
  flex: 19;
  display: flex;
  padding-left: 20px;
}
.shop-cart-item-info .img {
  border: 1px solid #ead5d5;
  height: 100px;
  width: 80px;
}
.shop-cart-item-info .goods-name{
  flex: 8;
  margin: 0;
  padding-left: 30px;
}
.shop-cart-item-info .goods-price{
  flex: 4;
}
.shop-cart-item-info .goods-num{
  flex: 2;
}
.fixedPay {
  height: 100px;
  width: 70.9%;
  position: fixed;
  margin-top: 525px;
  box-shadow: 0 4px 8px 0 rgb(62, 62, 63), 0 6px 20px 0 rgb(62, 62, 63);
}

#pay, .fixedPay {
  padding: 20px;
  background-color: #f5f2f2;
  border-radius: 10px;
  height: 50px;
}

.items {
  padding: 50px;
  flex: 20;
}

#shop-cart {
  padding: 100px 200px;
  margin-bottom: 20px;
  height: 2000px;
  position: relative;
}

#shop-cart-body {
  height: 100%;
  border-radius: 10px;
  position: relative;
  border: 1px #c24562 solid;
  display: flex;
  flex-direction: column;
}
</style>
