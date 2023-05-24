<template>
  <div id="shop-cart" >
    <div id="shop-cart-body">

      <!--    <div class="items">-->
      <!--      <div class="shop-cart-item" v-for="(item,index) in $store.state.shopcart" :key="item.id">-->
      <!--        <el-col >-->
      <!--          <el-card shadow="hover"  >-->
      <!--                  <div class="item-message" >-->
      <!--                    <input class="single" type="checkbox" style="margin-right: 20px" @click="check(index,item)" :checked="$store.state.checked[index]">-->
      <!--                    <span class="img" ><img :src="item.img"></span>-->
      <!--                    <span style="width: 450px;height: 60px;margin-left: 30px">{{item.title}}</span>-->
      <!--                    <span style="margin-left: 220px;height: 50px;width: 100px;font-size: 20px">￥{{item.price}}</span>-->
      <!--                  </div>-->
      <!--          </el-card>-->
      <!--        </el-col>-->
      <!--      </div>-->
      <!--    </div>-->

      <items-body></items-body>
<!--      <div id="pay" :class="{fixedPay:!isDisplay}">-->
<!--        <shop-cart-pay ref="child"></shop-cart-pay>-->
<!--      </div>-->
    </div>

  </div>
</template>

<script>
// import ShopCartPay from "../../components/user/shopcart/ShopCartPay";
import ItemsBody from "../../components/user/shopcart/ItemsBody";
export default {
  name: "MyOrders",
  components: {ItemsBody},
  data() {
    return {
      top:'',
      isDisplay: false,
      arr:[]
    }
  },
  computed:{
    cards() {
      return document.getElementsByClassName('el-card')
    },
  },
  methods:{
    getArr(){
      let str = ''
      for( let i in this.arr)
      {
        str += '\''+this.arr[i]+"\'"
        if(i < this.arr.length -1)
          str += ','
      }
      return str
    },
    delete(){
      console.log(this.arr)
      let str = this.getArr()
      this.$axios({
        url:"http://localhost:8080/Library_war_exploded/RemoveItemsServlet",
        method:'post',
        params:{
          arr: str,
          user:this.$store.state.user.username,
          kind:'remove'
        },
        headers: {"Content-Type": "application/x-www-form-urlencoded;charset=UTF-8"}
      }).then((result) => {
        // this.$store.commit("getGoods",result.data)
      }, function () {
        console.log('传输失败');
      })
    },
    pay(){
      console.log("wolai")
      let str = this.getArr()
      this.$axios({
        url:"http://localhost:8080/Library_war_exploded/RemoveItemsServlet",
        method:'post',
        params:{
          arr: str,
          user:this.$store.state.user.username,
          kind:'pay'
        },
        headers: {"Content-Type": "application/x-www-form-urlencoded;charset=UTF-8"}
      }).then((result) => {
        this.$store.commit("getGoods",result.data)
      }, function () {
        console.log('传输失败');
      })
    },
    check(index,item){
      this.arr = []
      this.$store.commit("changeCheck",index)
      this.$refs.child.num = 0
      this.$refs.child.price = 0
      for(let i = 0 ; i < this.$store.state.shopcart.length ; i++){
        if(this.$store.state.checked[i]){
          this.$refs.child.num++
          this.$refs.child.price += parseFloat(this.$store.state.shopcart[i].price)
          this.arr.push(this.$store.state.shopcart[i].goodsno)
        }
      }
    },

  },
  mounted() {
    window.addEventListener('scroll', () => {
      this.top = document.documentElement.scrollTop
    })
  },
  watch:{
    top(newValue,oldValue){
      if(newValue >= 1200)
        this.isDisplay = true
      else
        this.isDisplay = false
    },

  },


}

</script>

<style scoped>

.fixedPay{
  height: 100px;
  width: 70%;
  position: fixed;
  margin-top: 530px;
  box-shadow: 0 4px 8px 0 rgb(138, 136, 136), 0 6px 20px 0 rgb(115, 115, 115);
}
#pay,.fixedPay{
  padding: 20px;
  background-color: #f5f2f2;
  border-radius: 10px;
  height: 50px;


}
#shop-cart{
  padding: 100px 200px;
  margin-bottom: 20px;
  height: 2000px;
  position: relative;
}
#shop-cart-body{
  height: 100%;
  border-radius: 10px;
  position: relative;
  border: 1px #c24562 solid;
  display: flex;
  flex-direction: column;
}
</style>
