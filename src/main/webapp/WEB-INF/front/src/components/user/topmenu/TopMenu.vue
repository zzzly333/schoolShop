<template>
  <div class="menu-div">
    <div id="menuDiv">
      <el-menu  router :default-active="index_active" class="el-menu-demo" mode="horizontal" >
        <el-menu-item index="/schoolshop/home" @click="toHome()" ><div class="top-item"> 首页</div></el-menu-item>
        <el-menu-item index="/schoolshop/orders" @click="getOrders()"><div class="top-item">订单记录</div></el-menu-item>
        <el-menu-item index="/schoolshop/shopcart" @click="getCart()"><div class="top-item">购物车</div></el-menu-item>
        <el-menu-item index="/schoolshop/profile" id="profile" ><div class="top-item">会员中心</div></el-menu-item>
      </el-menu>
    </div>
    <div>
      <router-view ref="child"></router-view>
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
      index_active:"/schoolshop/home",
      isShow: false,
      searchStyle:{
        width:"500px",
        position: 'absolute',
        zIndex: "10",
        margin:'10px 0px 10px -500px',
      },
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

      let param = new URLSearchParams()
      param.append("username",this.$store.state.user.username)
      axios({
        url:"http://localhost:8081/shoolShop_war_exploded/getShopCart",
        method:'post',
        data:param
      }).then((result) => {
        console.log(result.data)
        store.commit("getCart",result.data)
      })
    },
    getOrders(){
      let param = new URLSearchParams()
      param.append("username",this.$store.state.user.username)
      axios({
        url:"http://localhost:8081/shoolShop_war_exploded/getAllOrders",
        method:'post',
        data:param
      }).then((result) => {
        store.commit("getOrders",result.data)
      })
    },
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
