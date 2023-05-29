<template>
  <div>
    <!-- 面包屑导航区 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item>首页</el-breadcrumb-item>
      <el-breadcrumb-item>营销经理管理</el-breadcrumb-item>
      <el-breadcrumb-item>用户管理</el-breadcrumb-item>
    </el-breadcrumb>
    <!-- 卡片视图 -->
    <el-card class="box-card">
      <!-- 搜索和添加区域 -->
      <el-row :gutter="20">
        <el-col :span="7">
          <el-input v-model="search" placeholder="请输入内容" clearable>
            <el-button slot="append" icon="el-icon-search"></el-button>
          </el-input>
        </el-col>
        <el-col :span="4">
          <el-button type="primary" @click="addDialogVisible = true">添加用户</el-button>
        </el-col>
      </el-row>
      <!-- 物品列表区域 -->
      <el-table :data="userlist" border stripe :header-cell-style="{ 'text-align': 'center' }"
                :cell-style="{ 'text-align': 'center' }">
        <el-table-column prop="id" label="编号" width="60px"></el-table-column>
        <el-table-column prop="name" label="用户名称"></el-table-column>
        <el-table-column prop="username" label="用户账号"></el-table-column>
        <el-table-column prop="password" label="用户密码"></el-table-column>
        <el-table-column prop="address" label="收货地址"></el-table-column>
        <el-table-column prop="state" label="状态"></el-table-column>
        <el-table-column width="180px" label="操作">
          <!-- slot-scope="scope" -->
          <template slot-scope="scope">
            <!-- 修改物品 -->
            <el-button type="primary" icon="el-icon-edit" @click="showEditDialog(scope.row)"></el-button>
            <!-- 删除物品 -->
            <el-button type="danger" icon="el-icon-delete"
                       @click="removeUserById(scope.row)"></el-button>
          </template>
        </el-table-column>
      </el-table>
      <!-- 分页区域 -->
      <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
                     :current-page="queryInfo.pagenum" :page-sizes="[5, 10, 15]" :page-size="queryInfo.pagesize"
                     layout="total, sizes, prev, pager, next, jumper" :total="total">
      </el-pagination>
    </el-card>

    <!-- 添加物品信息 -->
    <el-dialog title="添加用户" :visible.sync="addDialogVisible" width="50%" @close="addDialogClosed">
            <span>
                <el-form :model="addForm" label-width="70px">
                    <el-form-item label="用户ID" prop="id">
                        <el-input v-model="addForm.id"></el-input>
                    </el-form-item>
                    <el-form-item label="用户名称" prop="name">
                        <el-input v-model="addForm.name"></el-input>
                    </el-form-item>
                    <el-form-item label="用户账号" prop="username">
                        <el-input v-model="addForm.username"></el-input>
                    </el-form-item>
                    <el-form-item label="用户密码" prop="password">
                        <el-input v-model="addForm.password"></el-input>
                    </el-form-item>
                    <el-form-item label="收货地址" prop="address">
                        <el-input v-model="addForm.address"></el-input>
                    </el-form-item>
                    <el-form-item label="状态" prop="state">
                        <el-input v-model="addForm.state"></el-input>
                    </el-form-item>
                </el-form>
            </span>
      <!-- 底部区域 -->
      <span slot="footer" class="dialog-footer">
                <el-button @click="addDialogVisible = false">取消</el-button>
                <el-button type="primary" @click="addUser">确定</el-button>
            </span>
    </el-dialog>

    <!-- 修改物品信息 -->
    <el-dialog title="修改用户" :visible.sync="editDialogVisible" width="50%" @close="editDialogClosed">
            <span>
                <el-form :model="editForm" label-width="70px">
                    <el-form-item label="ID" prop="id">
                        <el-input v-model="editForm.id"></el-input>
                    </el-form-item>
                    <el-form-item label="用户名称" prop="name">
                        <el-input v-model="editForm.name"></el-input>
                    </el-form-item>
                  <el-form-item label="用户账号" prop="username">
                        <el-input v-model="editForm.username"></el-input>
                    </el-form-item>
                    <el-form-item label="用户密码" prop="password">
                        <el-input v-model="editForm.password"></el-input>
                    </el-form-item>
                    <el-form-item label="收货地址" prop="address">
                        <el-input v-model="editForm.address"></el-input>
                    </el-form-item>
                  <el-form-item label="状态" prop="state">
                        <el-input v-model="editForm.state"></el-input>
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
import qs from 'qs'
export default {
  data() {
    return {
      queryInfo: {
        pagenum: 1,
        pagesize: 5
      },
      userlist: [
      ],
      total: 0,
      // 控制添加物品对话框显示与隐藏
      addDialogVisible: false,
      // 添加物品的表单数据
      addForm: {
        id: '',
        name:'',
        username:'',
        password:'',
        address:'',
        state:''
      },
      // 控制修改窗口的显示与隐藏
      editDialogVisible: false,
      editForm: {},
      // 查找
      search:'',
      filterList:[]
    }
  },
  created() {
    this.getPage();
    this.getUserList();
  },
  watch: {
    search: {
      //首次绑定是否执行handler
      immediate: true,
      //一般情况下，数据发生变化handler才会执行
      handler (val) {
        console.log(val)
        //过滤数据赋值给新数组
        if(val=='')
          this.getUserList()
        else {
          this.filterList = this.userlist.filter((item) => {
            //判断是否在数组中存在
            return item.id.indexOf(val) !== -1
          })
          this.userlist = this.filterList
        }
      }
    }
  },
  methods: {
    // 获取总数
    async getPage() {
      const result = await this.$axios.post("http://localhost:8081/schoolShop_war_exploded/getPage?table=user")
      console.log("getPage:")
      console.log(result)
      this.total = result.data
    },
    // 获取物品列表
    async getUserList() {
      const result = await this.$axios.post("http://localhost:8081/schoolShop_war_exploded/getUser?pagenum="+this.queryInfo.pagenum+"&pagesize="+this.queryInfo.pagesize);
      console.log('getUser:');
      console.log(result)
      this.userlist = result.data
    },
    // pagesize 改变的事件
    handleSizeChange(newSize) {
      console.log(newSize);
      this.queryInfo.pagesize = newSize
      this.getUserList();
    },
    // 页面值 改变的事件
    handleCurrentChange(newPage) {
      console.log(newPage);
      this.queryInfo.pagenum = newPage;
      this.getUserList();
    },
    // 添加物品
    async addUser() {
      // async 和 await 配套使用，这样异步调用接口
      console.log('addForm:')
      console.log(this.addForm)
      const result = await this.$axios.post("http://localhost:8081/schoolShop_war_exploded/addUser",qs.stringify(this.addForm));
      console.log('addUser:')
      console.log(result)

      if (result.status != '200') {
        return this.$Message.error('添加失败！')
      }
      this.addDialogVisible = false;
      this.getPage()
      this.getUserList();
      this.$Message.success('添加成功！')

    },
    // 展示修改物品的对话框
    showEditDialog(userinfo) {
      console.log(userinfo)
      this.editForm = userinfo
      this.editDialogVisible = true;
    },
    // 修改物品信息并提交
    async editUserInfo() {
      // 发起修改物品信息接口
      const result = await this.$axios.post("http://localhost:8081/schoolShop_war_exploded/updateUser", qs.stringify(this.editForm));
      console.log(result);
      //this.editForm="";
      if (result.status  != '200') {
        return this.$Message.error("修改物品信息失败！")
      }
      // 关闭对话框
      this.editDialogVisible = false;
      // 提示更新成功
      this.$Message.success('修改物品成功！')
      // 刷新数据
      this.getUserList();
    },
    // 根据id删除物品信息
    async removeUserById(row) {
      console.log('row:')
      console.log(row)
      // console.log(row.id)
      // 发送请求删除
      const confirmResult = await this.$confirm('此操作将永久删除该物品，是否继续？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).catch(err => err);
      if (confirmResult != "confirm") {
        return this.$Message.info('已经取消删除！');
      }
      // 删除操作
      const result = await this.$axios.post("http://localhost:8081/schoolShop_war_exploded/delUser",qs.stringify(row));
      console.log('removeUserById:')
      console.log(result)
      if (result.status  != '200') {
        return this.$Message.error('删除失败！');
      }
      this.$Message.success('删除成功！');
      this.getPage()
      this.getUserList();
    },

    editDialogClosed() {
      this.$refs.editFormRef.resetFields();
    },
    addDialogClosed() {
      this.$refs.addFormRef.resetFields();
    },
    editDs() {
      this.editForm = "";
      this.editDialogVisible = false
      this.getUserList();
    },
  }
}
</script>

<style>
.el-breadcrumb {
  margin-bottom: 5px;
}

.el-row {
  margin-bottom: 18px;
}

.el-pagination {
  margin-top: 15px;
}

.avatar-uploader {
  text-align: left;
}

.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;

}

.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}

.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px !important;
  text-align: center;
}

.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>
