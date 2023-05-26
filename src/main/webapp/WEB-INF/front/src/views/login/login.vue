<template>
  <div class="input-frame" style="background-color: #fdf8f8">

    <div> <h1 style="color: #f8f1e9">Welcome !</h1></div>
    <div class="login-input">
      <div class="character">
        <span :class="{'highlight-border':this.manager}" @click="changeToManager">管理员</span>
        <span :class="{'highlight-border':this.commonUsr}" @click="changeToUser">普通用户</span>
      </div>
      <div id="login">
        <div class="input" :class="{hide:this.login}">
          <el-input placeholder="用户名"  prefix-icon="el-icon-user-solid" v-model="username"></el-input>
          <el-input placeholder="密码"  type="password" style="margin-top: 20px" prefix-icon="el-icon-lock" v-model="password"></el-input>
        </div>
        <div class="button" :class="{hide:login}">
          <el-button type="primary" @click="log">登录</el-button>
          <a href="javascript:" @click="change" :class="{a:true,hide:this.manager}">去注册 ></a>
        </div>
        <div class="input" :class="{hide:!login}">
          <el-input placeholder="昵称"  prefix-icon="el-icon-user-solid" v-model="nickname"></el-input>
          <el-input placeholder="密码(至少8位)" type="password" style="margin-top: 20px" prefix-icon="el-icon-lock" v-model="password1"></el-input>
        </div>
        <div class="button" :class="{hide:!login}">
          <el-button type="primary" @click="regist">注册</el-button>
          <a  href="javascript:" @click="change" :class="{a:true,hide:this.manager}">< 去登录</a>
        </div>
      </div>
    </div>
  </div>


</template>

<script type="text/javascript">
import router from '../../router/index'
import store from '../../store/index'
export default {
  data() {
    return {
      commonUsr: true,
      manager: false,
      username: '',
      password: '',
      code:'',
      codeWrong:false,
      upWrong:false,
      warn:'',
      result:false,
      login:false,
      nickname:'',
      password1:'',
      registed:false,

    }
  },
  methods: {
    change(){
      this.login = !this.login
    },
    changeToUser() {
      if (!this.commonUsr) {
        this.manager = false
        this.commonUsr = true
      }

    },
    changeToManager() {
      if (!this.manager) {
        this.manager = true
        this.commonUsr = false
        this.login = false
      }
    },
    getGoods(str){
      this.$axios({
        url:"http://localhost:8080/Library_war_exploded/"+str,
        method:'post',
        headers: {"Content-Type": "application/x-www-form-urlencoded;charset=UTF-8"}
      }).then((result) => {
        this.$store.commit("getGoods",result.data)
      }, function () {
        console.log('传输失败');
      })
    },
    async userLogin(){
      const result = await this.$axios.post("http://localhost:8081/shoolShop_war_exploded/login",{
        username:this.username,
        password:this.password
      });
      store.commit('login',result.data)
      console.log(result)
      await router.push('/schoolshop')
      // let p = false
      // this.$axios({
      //   url:"http://localhost:8080/Library_war_exploded/ValidateLoginServlet",
      //   method:'post',
      //   params:{
      //     username:this.username,
      //     password:this.password,
      //   },
      //   headers: {"Content-Type": "application/x-www-form-urlencoded;charset=UTF-8"}
      // }).then((result) => {
      //   if(result.data.exit){
      //     router.push('/home')
      //     store.commit('login',result.data)
      //     console.log(this.$store.state.user)
      //     p = true
      //     this.getGoods("GetGoodsServlet")
      //   }
      // }, function () {
      //   console.log('传输失败');
      // })
      // if (p)
      //   this.result = true
      // this.p()
    },
    managerLogin(){
      let p = false
      this.$axios({
        url:"http://localhost:8080/Library_war_exploded/ManagerServlet",
        method:'post',
        params:{
          id:this.username,
          password:this.password,
        },
        headers: {"Content-Type": "application/x-www-form-urlencoded;charset=UTF-8"}
      })
        .then((result) => {
          if(result.data.exit){
            store.commit('managerLogin')
            p = true
            this.getGoods("ManagerGetGoodsServlet")
          }
        }, function () {
          console.log('传输失败');
        })
      if(p)
        this.result = true
      this.p()
    },
    log() {
      if(this.username=='' && this.password=='')
        this.$message.error("输入不能为空！")
      else{
        if(this.commonUsr)
          this.userLogin()
        else
          this.managerLogin()
      }
    },
    p(){
      // if(this.result)
      this.$message.success("登陆成功！")
      // else
      //   this.$message.error("用户名或密码错误！")
    },
    regist(){
      let p = false
      if(this.tel=='' && this.password1=='')
        this.$message.error("输入不能为空！")
      else{
        this.$axios({
          url:"http://localhost:8080/Library_war_exploded/ValidateRegisterServlet",
          method:'post',
          params:{
            tel:this.tel,
            password:this.password1
          },
          headers: {"Content-Type": "application/x-www-form-urlencoded;charset=UTF-8"}
        }).then(result =>{
          if(!result.data.exit){
            let msg = result.data.msg
            store.commit(
              'login',
              {
                username:msg,
                password:this.password,
                nickname:'',
                gender:'',
                tel:this.tel
              }
            )
            router.replace('/home')
            this.getGoods("GetGoodsServlet")
            p = true
          }
        }, function () {
          console.log('传输失败');
        })
        if(!p)
          this.registed = true
        // if(!this.registed)
        this.$message.success("注册成功！")
        // else
        // this.$message.warning("该手机号已经注册过！")
      }
    }
  }
}
</script>
<style scoped>

.input-frame{
  /*position: relative;/*/
  height: 93vh;
  margin: 0;
  padding-top:50px;
  background-image: url("../../assets/imgs/photo2.jpg");
  background-repeat: no-repeat;
  background-position: right top;
  /*backdrop-filter: blur(5px);*/
}
.login-input{
  border: #3e3e3f 1px solid;
  box-shadow: 0 4px 8px 0 rgb(31, 31, 31), 0 6px 20px 0 rgb(29, 29, 30);
  width: 400px;
  height: 60vh;
  margin: auto;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background: rgba(75, 74, 74, 0.5);
  /*opacity: 1;*/
}
.a{
  display: block;
  width: 70px;
  margin: auto;
  margin-top: 40px;
}
.hide{
  display: none;
}
.el-button{
  /*flex: 1;*/
  border: 0;
  margin-top: 10px;
  width: 100%;
}
.hide{
  display: none;
}
.highlight-border{
  border-bottom: 4px solid #17b7f1;
}

#checkName,#checkCode{
  color: red;
}
h1{
  text-align: center;
  display: block;
  margin: 20px 0px;
}
#code{
  width: 60px;
  height: 30px;
  margin-left: 50px;
  flex: 1;
}
#codeDiv{
  display: flex;
}
#codeDiv img,a{
  display: block;
  padding: 0;
  margin-top: 25px;
  margin-left: 20px;
}
#codeDiv span{
  display: block;
  flex: 3;
  padding: 0px 0px -20px 40px;
}
a{
  display: block;
  margin-left: 120px;
  margin-top: -25px;
}
input::placeholder{
  /*color: #c1bdbd;*/
}
/*input:not(#code){*/
/*  display: block;*/
/*  width: 271px;*/
/*  left: 0;*/
/*  right: 0;*/
/*  height: 40px;*/
/*}*/
.input input:not(#password){
  /*margin: 20px 0px 0px 0px;*/
}
.button{
  width: 100%;
  margin-top: 40px;
  /*display: flex;*/
}

#login{
  width: 284px;
  height: 350px;
  flex: 5;
  margin-top: 15%;

}
.character{
  height: 70px;
  display: flex;
  width: 100%;
  font-size: 24px;
  text-align: center;
  color: #3d3d3d;

  /*border-radius: 10px;*/
  flex: 1;
}
.character span{
  flex: 1;
  padding: 19px 0;
  background-color: #fdfcfb;
  opacity: 0.7;
}
.character span:hover{
  /*background-color: #d0cfcf;*/
  box-shadow: 0 4px 8px 0 rgb(31, 31, 31), 0 6px 20px 0 rgb(31, 31, 31);

}
.character span:first-child{
  border-right: 1px solid #cecdcc;
}
input{
  border-radius: 3px;
  border:1px #a5a2a2 solid;
}

</style>
