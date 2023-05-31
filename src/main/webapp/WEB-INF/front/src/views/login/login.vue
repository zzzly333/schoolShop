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
          <div class="role" :class="{hide:!this.manager}">
            <el-radio-group v-model="radio">
              <el-radio :label="1">商品专员</el-radio>
              <el-radio :label="2">营销经理</el-radio>
              <el-radio :label="3">系统管理员</el-radio>
            </el-radio-group>
          </div>
          <el-input placeholder="用户名/手机号"  prefix-icon="el-icon-user-solid" v-model="username"></el-input>
          <el-input placeholder="密码"  type="password" style="margin-top: 20px" prefix-icon="el-icon-lock" v-model="password"></el-input>
        </div>
        <div class="button" :class="{hide:this.login}">
          <el-button type="primary" @click="log">登录</el-button>
          <a href="javascript:" @click="change" :class="{a:true,hide:this.manager}">去注册 ></a>
        </div>
        <div class="input" :class="{hide:!this.login}">
          <el-input placeholder="手机号"  prefix-icon="el-icon-user-solid" v-model="username"></el-input>
          <el-input placeholder="密码(至少8位)" type="password" style="margin-top: 20px" prefix-icon="el-icon-lock" v-model="password"></el-input>
        </div>
        <div class="button" :class="{hide:!this.login}">
          <el-button type="primary" @click="regist">注册</el-button>
          <a  href="javascript:" @click="change" :class="{a:true,hide:this.manager}">< 去登录</a>
        </div>
      </div>
    </div>
  </div>


</template>

<script type="text/javascript">
import router from '../../router/index'
import axios from "axios";
export default {
  data() {
    return {
      commonUsr: true,
      manager: false,
      username:'',
      tel: '',
      password: '',
      // code:'',
      // codeWrong:false,
      upWrong:false,
      warn:'',
      result:false,
      login:false,
      registed:false,
      radio: 1
    }
  },
  methods: {
    clearInput(){
      this.username = ''
      this.password = ''
    },
    change(){
      this.login = !this.login
      this.clearInput()
    },
    changeToUser() {
      if (!this.commonUsr) {
        this.manager = false
        this.commonUsr = true
        this.clearInput()
      }

    },
    changeToManager() {
      if (!this.manager) {
        this.manager = true
        this.commonUsr = false
        this.login = false
        this.clearInput()
      }
    },
    async userLogin(){
      let param = new URLSearchParams()
      param.append('username', this.username)
      param.append('password', this.password)
      await axios({
        method: 'post',
        url: "http://localhost:8081/schoolShop_war_exploded/userLogin",
        data: param
      }).then((result)=>{
        if(result.data === "")
          this.$message.error("用户名或密码错误！")
        else {
          console.log(result.data)
          this.$store.commit('login',result.data)
          axios.post("http://localhost:8081/schoolShop_war_exploded/getHome"
          ).then(result=>{
            this.$store.commit('toHome',result.data)
          })
          if(this.$store.state.user.state == '启用'){
            this.$message.success("登陆成功！")
            router.push('/schoolshop')
          }
          else
            this.$message.error("该账号已被禁用！")
        }
      })
    },
    async managerLogin() {
      let param = new URLSearchParams()
      param.append('username', this.username)
      param.append('password', this.password)
      let url = 'http://localhost:8081/schoolShop_war_exploded/'
      if (this.radio === 1)
          url += 'manager1Login'
      else if(this.radio === 2)
          url += 'manager2Login'
      else if(this.radio === 3)
          url += 'manager3Login'

      await axios({
        method: 'post',
        url: url,
        data: param
      }).then((result) => {
        if (result.data === "")
          this.$message.error("用户名或密码错误！")
        else {
          this.$store.commit('getManager',result.data)

          if(this.$store.state.manager.state === '启用')
          {
            this.$message.success("登陆成功！")
            if(this.radio === 1){
              localStorage.setItem('username1',this.$store.state.manager.username)
              router.push('/backPage1')
            }
            else if(this.radio === 2){
              localStorage.setItem('username2',this.$store.state.manager.username)
              router.push('/backPage2')
            }
            else if(this.radio === 3){
              localStorage.setItem('username3',this.$store.state.manager.username)
              router.push('/backPage3')
            }

          }
          else
            this.$message.error("该账号已被禁用！")
        }
      })
    },
    log() {
      if(this.username==='' && this.password==='')
        this.$message.error("输入不能为空！")
      else{
        if(this.commonUsr)
          this.userLogin()
        else
          this.managerLogin()
      }
    },
    async regist(){
      if(this.username==='' && this.password==='')
        this.$message.error("输入不能为空！")
      else{
        let param = new URLSearchParams()
        param.append('username', this.username)
        param.append('password', this.password)
        await axios({
          url:"http://localhost:8081/schoolShop_war_exploded/regist",
          method:'post',
          data:param
        }).then(result =>{
          if(result.data == ""){
            this.$message.success("注册成功！")
          }
          else
            this.$message.error("该手机号已经注册过！")
        })
      }
    }
  }
}
</script>
<style scoped>
.role{
  width: 400px;
  margin:-20px 0px 30px -60px;
}
.el-radio__input /deep/ .el-radio__label{
  color: #da1616;
}
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
