<template>
  <div class="menu-div">
    <div id="menuDiv">
      <el-input placeholder="请输入内容" prefix-icon="el-icon-search" v-model="inputvalue" :style="search"></el-input>
      <el-menu  router :default-active="default_active" class="el-menu-demo" mode="horizontal" >
        <el-menu-item index="/schoolshop/home" @click="toHome" ><div class="top-item"> 首页</div></el-menu-item>
        <el-menu-item index="/schoolshop/orders"><div class="top-item">订单记录</div></el-menu-item>
        <el-menu-item index="/schoolshop/shopcart" @click="getCart"><div class="top-item">购物车</div></el-menu-item>
        <el-menu-item index="/schoolshop/profile" id="profile"><div class="top-item">会员中心</div></el-menu-item>
      </el-menu>
    </div>
    <div>
      <router-view></router-view>
    </div>
  </div>
</template>

<script>

import store from "../../../store";
import axios from "axios";

export default {
  name: "TopMenu",
  data(){
    return{
      default_active:"/schoolshop/home",
      isShow: false,
      search:{
        width:"500px",
        position: 'absolute',
        zIndex: "10",
        margin:'10px 0px 10px -500px',
      },
      tag:'li',
      inputvalue:'',
    }
  },
  methods:{
    toHome(){
      axios.post("http://localhost:8081/shoolShop_war_exploded/getHome"
      ).then((result) => {
        this.$store.commit("toHome",result.data)
      })
    },
    getCart(){
      this.$axios.post("http://localhost:8081/shoolShop_war_exploded/getShopCart"
      ).then((result) => {
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

/*.show{*/
/*  display: none;*/
/*}*/
.top-item{
  margin: 0;
  padding: 0;
  width: 68px;
  text-align: center;
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
