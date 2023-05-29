<template>
  <div class="detail">
    <el-page-header @back="goBack" content="详情页面"></el-page-header>
    <div class="body">

      <div class="item">
        <div class="imgs">

        </div>
        <div class="info">
          <span class="title">
            <h3>{{this.$store.state.goods[this.$store.state.indexGoods].goodsName}}</h3>
          </span>
          <span class="text" >
            <h4>描述：</h4>
            <p>{{this.$store.state.goods[this.$store.state.indexGoods].goodsInfo}}</p>
          </span>
          <span class="price">
            <h4 style="margin: 0">价格：</h4>
            <p >￥{{this.$store.state.goods[this.$store.state.indexGoods].goodsPrice}}</p>
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
export default {
  name: "ItemDetail",
  methods:{
    goBack(){
      this.$router.go(-1);
    },
    addCart(){
      this.$axios({
        url:"http://localhost:8080/Library_war_exploded/AddCartServlet",
        method:'post',
        params:{
          goodsno:store.state.goods[store.state.indexGoods].goodsno,
          user:store.state.user.username
        },
        headers: {"Content-Type": "application/x-www-form-urlencoded;charset=UTF-8"}
      }).then((result) => {
        // this.$store.commit("getGoods",result.data)
      }, function () {
        console.log('传输失败');
      })
      this.$message.success("加入购物车成功")
    }
  }
}
</script>

<style scoped>
.title{
  height: 50px;font-size: 20px
}
.price{
  height: 60px;font-size: 20px
}
.text{
  height: 300px
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
