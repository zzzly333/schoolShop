<template>
<div class="profile-body">
<!--  <div>-->
<!--    <div >-->
<!--      <span>用户ID:</span><p style="display: inline;padding-left: 5px">{{this.$store.state.user.username}}</p>-->
<!--      <el-upload style="display: inline-block;margin-left: 150px" class="upload-demo" action="https://jsonplaceholder.typicode.com/posts/"-->
<!--                 :on-preview="handlePreview" :on-remove="handleRemove" :before-remove="beforeRemove" multiple-->
<!--                 :limit="3" :on-exceed="handleExceed" :file-list="fileList">-->
<!--&lt;!&ndash;        <el-button style="font-size: 16px" size="small" type="primary">更换头像</el-button>&ndash;&gt;-->
<!--      </el-upload>-->
<!--    </div>-->
<!--    <div>-->
<!--      <span>昵&nbsp;&nbsp;&nbsp;&nbsp;称:</span>-->
<!--      <input type="text" :value="this.$store.state.user.nickname">-->
<!--    </div>-->

<!--    <div>-->
<!--      <span>账号:</span>-->
<!--      <input type="text" :value="this.$store.state.user.tel">-->
<!--    </div>-->

<!--    <div class="paswd">-->
<!--      <span class="a">-->
<!--        <el-collapse v-model="activeNames">-->
<!--          <el-collapse-item title="修改密码" name="1">-->
<!--            <template slot="title">-->
<!--              <span style="float:left;font-size:18px;color:black;">修改密码</span>-->
<!--            </template>-->
<!--            <div class="edit">-->
<!--              <span class="b">旧密码：<input type="password" :value="oldpaswd"></span>-->
<!--              <span class="c">新密码：<input type="password" :value="newpaswd"></span><br><br>-->
<!--              <el-button style="margin: auto;margin-top:0px;display: block;">确认修改</el-button>-->
<!--            </div>-->
<!--          </el-collapse-item>-->
<!--        </el-collapse>-->
<!--      </span>-->
<!--    </div>-->
<!--  </div>-->
<!--  <el-button type="primary" plain style="display:block;position: absolute;bottom: 10px;left: 47%">保存</el-button>-->
  <el-descriptions class="margin-top" title="个人信息" :column="2" direction="vertical" style="margin-top: 100px;margin-left: 50px">
    <el-descriptions-item label="昵称">{{this.$store.state.user.name}}</el-descriptions-item>
    <el-descriptions-item label="账号">{{this.$store.state.user.username}}</el-descriptions-item>
    <el-descriptions-item label="密码" >{{this.$store.state.user.password}}</el-descriptions-item>
    <el-descriptions-item label="地址">{{this.$store.state.user.address}}</el-descriptions-item>
  </el-descriptions>
  <!-- 修改物品 -->
  <el-button type="primary" icon="el-icon-edit" @click="showEditDialog()" style="margin-top: 20px;margin-left: 70px"></el-button>

    <!-- 修改物品信息 -->
    <el-dialog title="修改个人信息" :visible.sync="editDialogVisible" width="50%">
        <span>
            <el-form :model="editForm" label-width="70px">
                <el-form-item label="昵称" prop="name">
                    <el-input v-model="editForm.name"></el-input>
                </el-form-item>
                <el-form-item label="账号" prop="username">
                    <el-input v-model="editForm.username"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                    <el-input v-model="editForm.password"></el-input>
                </el-form-item>
                <el-form-item label="地址" prop="address">
                    <el-input v-model="editForm.address"></el-input>
                </el-form-item>
            </el-form>
        </span>
    <!-- 底部区域 -->
    <span slot="footer" class="dialog-footer">
        <el-button @click="editDs">取消</el-button>
        <el-button type="primary" @click="editUserInfo">确定</el-button>
    </span>
  </el-dialog>
</div>
</template>

<script>
import LeftButton from "../home/LeftButton";
export default {
  name: "ProfileInfo",
  components: {LeftButton},
  data(){
    return{
      editForm: {
        name:this.$store.state.user.name,
        username:this.$store.state.user.username,
        password:this.$store.state.user.password,
        address:this.$store.state.user.address
      },
      // 控制修改窗口的显示与隐藏
      editDialogVisible: false,
    }
  },
  methods:{
    // 展示修改物品的对话框
    showEditDialog() {
      this.editDialogVisible = true;
    },
    editDs() {
      this.editDialogVisible = false
    },
    // 修改物品信息并提交
    async editUserInfo() {
      const id = this.$store.state.user.id
      const result = await this.$axios.post("http://localhost:8081/schoolShop_war_exploded/updateUser2?id="+id+
        "&name="+this.editForm.name+"&username="+this.editForm.username+"&password="+this.editForm.password+"&address="+this.editForm.address);
      console.log(result);
      if (result.status  != '200') {
        return this.$Message.error("修改个人信息失败！")
      }
      // 关闭对话框
      this.editDialogVisible = false;
      // 提示更新成功
      this.$Message.success('修改个人信息成功！')
    },
  }
}
</script>

<style scoped>
.profile-body{
  height: 97%;
}
</style>
