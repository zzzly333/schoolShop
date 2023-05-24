<template>
  <div class="detail">
    <el-page-header @back="goBack" content="详情页面"></el-page-header>
    <div class="body">

      <div class="item">
        <div class="imgs">
          <!--        <template>-->
          <!--          <el-carousel indicator-position="outside"  :key="item" height="500px" >-->
          <!--            <el-carousel-item v-for="item in 4">-->
          <!--              <h3>{{ item }}</h3>-->
          <!--            </el-carousel-item>-->
          <!--          </el-carousel>-->
          <!--        </template>-->
        </div>
        <div class="info">
          <span class="title" style="height: 50px;font-size: 20px"><p>{{this.$store.state.items[this.$store.state.indexGoods].title}}</p></span>
          <!--        <span class="label" style="height: 80px">{{this.$store.state.items[this.$route.params.index].title}}</span>-->
          <span class="text" style="height: 300px">描述：<p>{{this.$store.state.items[this.$store.state.indexGoods].text}}</p></span>
          <span class="price" style="height: 60px;font-size: 20px">价格： <p >￥{{this.$store.state.items[this.$store.state.indexGoods].price}}</p></span>
          <span class="add-to-cart"><el-button style="margin: auto;display: block;margin-top: 30px" @click="addCart">加入购物车</el-button></span>
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
          goodsno:store.state.items[store.state.indexGoods].goodsno,
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
}
.detail{
  height: 700px;border: 1px solid #fcfbfb;
  padding: 0px 100px;
}
.body{
  margin: 0px 100px;
  height: 600px;
  border: 1px solid gray;
  border-radius: 10px;
}

</style>
