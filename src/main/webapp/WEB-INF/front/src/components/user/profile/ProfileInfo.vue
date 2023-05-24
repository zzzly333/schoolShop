<template>
<div class="profile-body">
  <div>
    <div >
      <span>用户ID:</span><p style="display: inline;padding-left: 5px">{{this.$store.state.user.username}}</p>
<!--      <el-upload style="display: inline-block;margin-left: 150px" class="upload-demo" action="https://jsonplaceholder.typicode.com/posts/"-->
<!--                 :on-preview="handlePreview" :on-remove="handleRemove" :before-remove="beforeRemove" multiple-->
<!--                 :limit="3" :on-exceed="handleExceed" :file-list="fileList">-->
<!--&lt;!&ndash;        <el-button style="font-size: 16px" size="small" type="primary">更换头像</el-button>&ndash;&gt;-->
<!--      </el-upload>-->
    </div>
    <div>
      <span>昵&nbsp;&nbsp;&nbsp;&nbsp;称:</span>
      <input type="text" :value="this.$store.state.user.nickname">
    </div>

    <div>
      <span>手机号:</span>
      <input type="text" :value="this.$store.state.user.tel">
    </div>
    <div>
      <span>性&nbsp;&nbsp;&nbsp;&nbsp;别:</span>
      <el-radio v-model="radio" label="男">男</el-radio>
      <el-radio v-model="radio" label="女">女</el-radio>
    </div>

    <div class="paswd">
      <span class="a">
        <el-collapse v-model="activeNames">
          <el-collapse-item title="修改密码" name="1">
            <template slot="title">
              <span style="float:left;font-size:18px;color:black;">修改密码</span>
            </template>
            <div class="edit">
              <span class="b">旧密码：<input type="password" :value="oldpaswd"></span>
              <span class="c">新密码：<input type="password" :value="newpaswd"></span><br><br>
              <el-button style="margin: auto;margin-top:0px;display: block;">确认修改</el-button>
            </div>
          </el-collapse-item>
        </el-collapse>
      </span>
    </div>
  </div>
  <el-button type="primary" plain style="display:block;position: absolute;bottom: 10px;left: 47%">保存</el-button>
</div>
</template>

<script>
import LeftButton from "../home/LeftButton";
export default {
  name: "ProfileInfo",
  components: {LeftButton},
  data(){
    return{
      oldpaswd:'',
      newpaswd:'',
      activeNames: ['1'],
      nickname:'xxxxx',
      id: 'xxxxx',
      realname:'xxxx',
      radio: this.$store.state.user.gender,
      tel:'12345678900'
    }
  }
}
</script>

<style scoped>
.profile-body{
  height: 97%;
}
.el-collapse{
  border: 0px;
}
div>div>div>span:not(.a,.b,.c){
  width: 100px;
  display: inline-block;
  margin-right: 30px;
  text-align: right;
}
.edit{
  font-size: 18px;
  height: 90px;
}
.edit>span{
  margin: 0px 0px 0px 130px;
}
input[type=text]{
  width: 150px;
  height: 25px;
}
input[type=password]{
  height: 25px;
}
div{
  /*border: 1px solid #6feada;*/
}
div>div:not(.paswd){
  padding: 8px 10px;
  text-align: left;
}
</style>
