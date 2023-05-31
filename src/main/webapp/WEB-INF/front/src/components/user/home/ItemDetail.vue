<template>
  <div class="detail">
    <el-page-header @back="goBack" content="详情页面"></el-page-header>
    <div class="body">

      <div class="item">
        <div class="imgs">
        <img :src="indexItem.goodsImage">
        </div>
        <div class="info">
          <span class="title">
            <h3>{{indexItem.goodsName}}</h3>
          </span>
          <span class="text" >
            <h4>描述：</h4>
            <p>{{indexItem.goodsInfo}}</p>
          </span>
          <span class="price">
            <h5 style="margin: 0">价格：</h5>
            <h1 style="text-align: center;color: #ea4716">￥{{indexItem.goodsPrice}}</h1>
          </span>
          <span class="num" style="margin-top: 50px">
            <h4>数量：</h4>
            <el-input-number style="display: block;margin: auto;" v-model="num" @change="handleChange" :min="1" :max="10" label="描述文字"></el-input-number>
          </span>
          <span class="add-to-cart" style="margin-top: 40px">
            <el-button style="display: block;margin: 30px auto auto;" @click="addCart">加入购物车</el-button>
          </span>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import store from "../../../store/index";
import axios from "axios";
export default {
  name: "ItemDetail",
  data(){
    return{
      num:1,
      indexItem:this.$store.state.goods[this.$store.state.indexGoods],
      // addItem:{
      //   username:this.$store.state.user.username,
      //   goodsno:this.indexItem.id,
      //   goodsName: this.indexItem.goodsName,
      //   goodsPrice:this.indexItem.goodsPrice,
      // }
    }
  },
  methods:{
    handleChange(value) {
      console.log(value);
    },
    goBack(){
      this.$router.go(-1);
    },
    async addCart() {
      let param = new URLSearchParams()
      param.append("username", store.state.user.username)
      param.append("goodsno", this.indexItem.id)
      param.append("goodsName", this.indexItem.goodsName)
      param.append("goodsImage",this.indexItem.goodsImage)
      param.append("goodsPrice", this.indexItem.goodsPrice)
      param.append("num", this.num)
      param.append("state", this.indexItem.state)
      if(this.num > this.indexItem.goodsNum)
        this.$message.error("购买数量超过库存！")
      else {
        await axios({
          url: "http://localhost:8081/schoolShop_war_exploded/addToShopCart",
          method: 'post',
          data: param
        })
        this.$message.success("加入购车成功！")
      }


    }
  }
}
</script>

<style scoped>
img{
  width: 716.8px;
  height: 510px;
}
.title{
  height: 50px;font-size: 20px
}
.price{
  height: 60px;font-size: 20px
}
.text{
  height: 160px
}
.text p{
  text-indent: 50px;
}
.el-page-header{
  margin: 80px 0px 20px 100px;
}
.imgs{
  margin-top: 20px;
}
.price p{
  font-size: 28px;
  color: #f64f4f;
  display: inline;
  text-align: center;
  margin-top: 0;
}
.el-carousel__item h3 {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
}
.info span{
  width: 100%;
  display: block;
  padding: 0px 20px;
}
.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}
.item{
  height: 95%;
  display: flex;
}
.imgs{
  flex: 2;
  padding: 20px;
}
.info{
  flex: 1;
  border-left: 1px solid rosybrown;
  margin-top: 20px;
  text-align: left;
}
.price p{
  display: block;
}
.detail{
  height: 700px;border: 1px solid #fcfbfb;
  padding: 0px 100px;
  margin-bottom: 50px;
}
.body{
  margin: 0px 100px;
  height: 600px;
  border: 1px solid gray;
  border-radius: 10px;
}

</style>
