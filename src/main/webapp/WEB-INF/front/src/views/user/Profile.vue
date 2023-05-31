<template>
<div class="profile"  >
<!--  <div class="menu">-->
    <div class="head-img" >
      <template>
        <el-avatar :size="100" src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
      </template>
    </div>
    <div class="menu">
      <el-menu default-active="1" class="el-menu-vertical-demo" background-color="#545c64" text-color="#fff" active-text-color="#ffd04b">
        <el-menu-item index="1"  @click="infoClick">
          <i class="el-icon-document"></i>
          <span slot="title">个人资料</span>
        </el-menu-item>
<!--        <el-menu-item index="2" @click="recClick">-->
<!--          <i class="el-icon-goods"></i>-->
<!--          <span slot="title">购买记录</span>-->
<!--        </el-menu-item>-->
        <el-menu-item index="2" @click="setClick">
          <i class="el-icon-setting"></i>
          <span slot="title">设&nbsp; &nbsp; &nbsp; &nbsp; 置</span>
        </el-menu-item>
        <el-menu-item index="3" @click="logoutClick">
          <i class="el-icon-bottom-left"></i>
          <span slot="title">退出登录</span>
        </el-menu-item>
        <el-menu-item index="4" @click="deleteClick">
          <i class="el-icon-remove"></i>
          <span slot="title">注销账户</span>
        </el-menu-item>
      </el-menu>
    </div>
  <div class="body">
      <div class="information" :class="{hide:showInfo}">
          <profile-info></profile-info>
      </div>
<!--    <div class="record" :class="{hide:showReco}">-->
<!--      <manager-body></manager-body>-->
<!--    </div>-->
    <div class="setting" :class="{hide:showSet}">
      <template>
<!--        <el-button type="text" @click="openLogout" style="margin-top: 50px">退出登录</el-button><br>-->
<!--        <el-button type="text" @click="openDelete" >注销账户</el-button>-->
      </template>
    </div>
  </div>

</div>
</template>

<script>
import ProfileInfo from "../../components/user/profile/ProfileInfo";
export default {
  name: "Profile",
  components: { ProfileInfo},
  data(){
    return{
      tabPosition:"left",
      showInfo: false,
      showReco: true,
      showSet: true,
      showLogout:true,
      showDelete:true,
      num :0
    }
  },
  methods:{
    infoClick(){
      this.showInfo = false
      this.showReco = true
      this.showSet = true
      this.showLogout = true
      this.showDelete = true
    },
    logoutClick(){
      this.showInfo = true
      this.showReco = true
      this.showSet = true
      this.showLogout = false
      this.showDelete = true
      this.openLogout()
    },
    deleteClick(){
      this.showInfo = true
      this.showReco = true
      this.showSet = true
      this.showLogout = true
      this.showDelete = false
      this.openDelete()
    },
    setClick(){
      this.showInfo = true
      this.showReco = true
      this.showSet = false
      this.showLogout = true
      this.showDelete = true
    },
    openLogout() {
      this.$confirm('是否确认退出登录', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$store.commit('logOut')
        this.$router.replace('/login')
      }).catch(() => {
      });
    },
    openDelete() {
      this.$confirm('是否确认注销账户', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$axios({
          url:"http://localhost:8081/schoolShop_war_exploded/delUser",
          method:'post',
          params:{
            type:'user',
            user:this.$store.state.user
          }
        }).then((result) => {
          this.$router.replace('/login')
        }, function () {
          console.log('传输失败');
        })
      }).catch(() => {
      });
    },


  }
}
</script>

<style scoped>
.form-body /deep/ .sticky-button{
  top:60px;
}
.record{
  height: 1500px;
  position: relative;
}
.hide{
  display: none;
}
.information,.setting{
  height: 470px;
  border: 5px solid darkgray;
  border-radius: 10px;
  width: 90%;
  padding: 0px 50px;
  position: relative;
}
.el-tabs--left .el-tabs__header.is-left{
  height: 200px;
}
.el-tab-pane>div{
  height: 400px;
  overflow: auto;
}
div{
  /*border: 1px solid #e7b2b2;*/
}
.el-avatar{
  margin: auto;
  display: block;
  margin-top: 10px;
  margin-bottom: 10px;
}
.head-img{
  width: 150px;
  height: 120px;
  margin-top: 50px;
  position: fixed;
}
.body{
  margin: 100px 60px 100px 220px;
  font-size: 18px;
}
.menu{
  width: 150px;
  margin-top: 200px;
  position: fixed;
}
.profile{
  width: 92%;
  /*height: 1000px;*/
  position: relative;
  padding: 50px 60px 0 60px;
}
</style>
