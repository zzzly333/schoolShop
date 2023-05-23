<template>
  <el-container class="home-container">
    <!-- 头部区域 -->
    <el-header>
      <div>
        <!--        <img src="" alt="" width="30" height="30">-->
        <span>营销经理管理系统</span>
      </div>
      <el-avatar>{{admin}}</el-avatar>
      <el-button type="info" @click="logout()">退出</el-button>
    </el-header>
    <el-container>
      <!-- 左边菜单栏 -->
      <el-menu
        router
        :default-active="this.$route.path"
        class="el-menu-vertical-demo"
        @open="handleOpen"
        @close="handleClose"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b">
        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-location"></i>
            <span>商品专员</span>
          </template>
          <el-menu-item index="/backPage2/goodsType">商品类型管理</el-menu-item>
          <el-menu-item index="/backPage2/goods">商品管理</el-menu-item>
        </el-submenu>
        <el-submenu index="2" >
          <template slot="title">
            <i class="el-icon-menu"></i>
            <span>营销经理</span>
          </template>
          <el-menu-item index="/user">用户管理</el-menu-item>
        </el-submenu>
        <el-submenu index="3" disabled>
          <template slot="title">
            <i class="el-icon-document"></i>
            <span>系统管理员</span>
          </template>
          <el-menu-item index="/">商品专员管理</el-menu-item>
          <el-menu-item index="/">营销经理管理</el-menu-item>
        </el-submenu>
      </el-menu>
      <el-main><router-view></router-view> </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  name:"bakePage2",
  data () {
    return {
      admin:'123'
    }
  },
  created () {
    // this.admin = localStorage.getItem("username");
  },
  methods: {
    logout () {
      // localStorage.removeItem("username");
      // localStorage.removeItem("userid");
      // this.$router.push('/login');
    },
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>

<style lang="less" scoped>
.home-container {
  //height: 100%;
  height: 660px;
}
//
.el-submenu span{
  padding-left: 0px !important;
}

.el-header {
  background-color: #373d41;
  display: flex;// 流式布局
  justify-content: space-between;
  padding-left: 0;
  align-items: center;
  color: #fff;
  font-size:15px;
  > div{
    display: flex;
    align-items: center;
    span {
      margin-left: 15px;
    }
  }
  .el-avatar {
    margin-right: 10px;
    margin-left: 76%;
    /*position: fixed;*/
    color: #333744;
    background: #fff;
    height: 50px;
    width: 50px;
    line-height: 50px;
    right: 0;
  }
  .el-button {
    background: #fff;
    color: #333744;
    border-radius: 33px;
  }
  img {
    margin-left: 15px;
  }
}

.el-aside {
  background-color: #333744;
  .el-menu {
    border-right:none;
  }
}

.el-main {
  background-color: #eaedf1;
}

.iconfont {
  margin-right: 10px;
}

.toggle-button {
  background-color: #4A5064;
  font-size: 10px;
  line-height: 24px;
  color:#fff;
  text-align: center;
  letter-spacing: 0.2em;
  cursor: pointer;
}
</style>

