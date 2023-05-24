<template>
  <div class="menu-div">
    <div id="menuDiv">
      <el-input placeholder="请输入内容" prefix-icon="el-icon-search" v-model="inputvalue" :style="search"></el-input>
      <el-menu  default-active="1" class="el-menu-demo" mode="horizontal" >
        <el-menu-item index="1" @click="getGoods" ><top-menu-item path="/home">首页</top-menu-item></el-menu-item>
        <el-menu-item index="2"><top-menu-item path="/orders">订单记录</top-menu-item></el-menu-item>
        <el-menu-item index="3" @click="getCart"><top-menu-item path="/shopcart">购物车</top-menu-item></el-menu-item>
        <el-menu-item index="4" id="profile"><top-menu-item path="/profile">会员中心</top-menu-item></el-menu-item>

        <!--        <el-menu-item index="4" id="profile" :class="{show:$store.state.isLogin}"><top-menu-item path="/profile">我的</top-menu-item></el-menu-item>-->
        <!--        <el-menu-item index="5" id="loginInMenu" :class="{show:!$store.state.isLogin}"><top-menu-item path="/login">登录</top-menu-item></el-menu-item>-->
      </el-menu>

    </div>
    <div>
      <router-view ></router-view>
    </div>
  </div>
</template>

<script>
import TopMenuItem from "./TopMenuItem";
import store from "../../../store";

export default {
  name: "TopMenu",
  components: {TopMenuItem},
  data(){
    return{
      isShow: false,
      search:{
        width:"300px",
        position: 'absolute',
        zIndex: "10",
        margin:'10px 0px 10px 500px',
        display:'none'
      },
      tag:'li',
      inputvalue:'',
    }
  },
  methods:{
    getGoods(){
      this.$axios({
        url:"http://localhost:8080/Library_war_exploded/GetGoodsServlet",
        method:'post',
        headers: {"Content-Type": "application/x-www-form-urlencoded;charset=UTF-8"}
      }).then((result) => {
        this.$store.commit("getGoods",result.data)
      }, function () {
        console.log('传输失败');
      })
    },
    getCart(){
      this.$axios({
        url:"http://localhost:8080/Library_war_exploded/GetCartServlet",
        method:'post',
        params:{
          user: store.state.user.username
        },
        headers: {"Content-Type": "application/x-www-form-urlencoded;charset=UTF-8"}
      }).then((result) => {
        console.log(result.data)
        store.commit("getCart",result.data)
      }, function () {
        console.log('传输失败');
      })
    }
  }
}
</script>

<style scoped>
.el-menu-item{
  padding: 0;
}

.show{
  display: none;
}
.menu-div{
  width: 100%;
  padding: 0;
  margin: 0;
}
#menuDiv{
  z-index: 300;
  border: 0.8px #eae1c2 solid;
  width: 1300px;
  margin-left: 120px;
  border-radius: 31.2px;
  position: fixed;
  height: 60px;
  right: 0;
  left: 0;
}
.el-menu-demo{
  height: 60px;
  padding: 0px 0px 0px 950px;
  position: relative;
  background-color: #f5f5f1;
  border-radius: 31.2px;
}
</style>
