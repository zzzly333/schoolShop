<template>
  <div>
    <!-- 面包屑导航区 -->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item>首页</el-breadcrumb-item>
      <el-breadcrumb-item>商品专员管理</el-breadcrumb-item>
      <el-breadcrumb-item>商品管理</el-breadcrumb-item>
    </el-breadcrumb>
    <!-- 卡片视图 -->
    <el-card class="box-card">
      <!-- 搜索和添加区域 -->
      <el-row :gutter="20">
        <el-col :span="7">
          <el-input v-model="search" placeholder="请输入内容" clearable>
            <el-button slot="append" icon="el-icon-search" ></el-button>
          </el-input>
        </el-col>
        <el-col :span="4">
          <el-button type="primary" @click="addDialogVisible = true">添加商品</el-button>
        </el-col>
      </el-row>
      <!-- 物品列表区域 -->
      <el-table :data="userlist" border stripe :header-cell-style="{ 'text-align': 'center' }"
                :cell-style="{ 'text-align': 'center' }">
        <el-table-column prop="id" label="编号" width="60px"></el-table-column>
        <el-table-column prop="goodsName" label="商品名称"></el-table-column>
        <el-table-column prop="goodsType" label="商品类型"></el-table-column>
        <el-table-column prop="goodsImage" label="商品图片">
          <template slot-scope="scope">
            <!-- 文本 -->
            <img :src="scope.row.goodsImage" height="80px" alt="">
          </template>
        </el-table-column>
        <el-table-column prop="goodsPrice" label="商品价格"></el-table-column>
        <el-table-column prop="goodsNum" label="商品数量"></el-table-column>
        <el-table-column prop="goodsInfo" label="商品描述"></el-table-column>
        <el-table-column prop="state" label="商品状态"></el-table-column>
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
    <el-dialog title="添加商品" :visible.sync="addDialogVisible" width="50%" @close="addDialogClosed">
            <span>
                <el-form :model="addForm" label-width="70px">
                    <el-form-item label="商品ID" prop="id">
                        <el-input v-model="addForm.id"></el-input>
                    </el-form-item>
                    <el-form-item label="商品名称" prop="goodsName">
                        <el-input v-model="addForm.goodsName"></el-input>
                    </el-form-item>
                  <el-form-item label="商品类型" prop="goodsType">
                        <el-input v-model="addForm.goodsType"></el-input>
                    </el-form-item>
                    <el-form-item label="商品图片" prop="goodsImage">
                        <el-upload class="avatar-uploader" action="http://localhost:8081/schoolShop_war_exploded/uploadImage" :show-file-list="false"
                                   name="file"
                                   :on-success="handleAvatarSuccess" :before-upload="beforeAvatarUpload">
                            <img v-if="addForm.goodsImage" :src="addForm.goodsImage" class="avatar">
                            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                        </el-upload>
                      <!-- <el-input v-model="addForm.goodsImage"></el-input> -->
                    </el-form-item>
                    <el-form-item label="商品价格" prop="goodsPrice">
                        <el-input v-model="addForm.goodsPrice"></el-input>
                    </el-form-item>
                    <el-form-item label="商品数量" prop="goodsNum">
                        <el-input v-model="addForm.goodsNum"></el-input>
                    </el-form-item>
                    <el-form-item label="商品描述" prop="goodsInfo">
                        <el-input v-model="addForm.goodsInfo"></el-input>
                    </el-form-item>
                  <el-form-item label="商品状态" prop="state">
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
    <el-dialog title="修改商品" :visible.sync="editDialogVisible" width="50%" @close="editDialogClosed">
            <span>
                <el-form :model="editForm" label-width="70px">
                    <el-form-item label="商品ID" prop="id">
                        <el-input v-model="editForm.id"></el-input>
                    </el-form-item>
                    <el-form-item label="商品名称" prop="goodsName">
                        <el-input v-model="editForm.goodsName"></el-input>
                    </el-form-item>
                  <el-form-item label="商品类型" prop="goodsName">
                        <el-input v-model="editForm.goodsType"></el-input>
                    </el-form-item>
                    <el-form-item label="商品图片" prop="goodsImage">
                        <el-upload class="avatar-uploader" action="http://localhost:8081/schoolShop_war_exploded/uploadImage" :show-file-list="false"
                                   :on-success="handleAvatarSuccess2" :before-upload="beforeAvatarUpload">
                            <img v-if="editForm.goodsImage" :src="editForm.goodsImage" class="avatar">
                            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                        </el-upload>

                      <!-- <el-input v-model="editForm.goodsImage"></el-input> -->
                    </el-form-item>
                    <el-form-item label="商品价格" prop="goodsPrice">
                        <el-input v-model="editForm.goodsPrice"></el-input>
                    </el-form-item>
                    <el-form-item label="商品数量" prop="goodsNum">
                        <el-input v-model="editForm.goodsNum"></el-input>
                    </el-form-item>
                    <el-form-item label="商品描述" prop="goodsInfo">
                        <el-input v-model="editForm.goodsInfo"></el-input>
                    </el-form-item>
                  <el-form-item label="商品状态" prop="state">
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
import axios from "axios";
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
        goodsName: '',
        goodsType: '',
        goodsImage: '',
        goodsPrice: '',
        goodsNum: '',
        goodsInfo: '',
        state: ''
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
      const result = await this.$axios.post("http://localhost:8081/schoolShop_war_exploded/getPage?table=goods")
      console.log("getPage:")
      console.log(result)
      this.total = result.data
    },
    // 获取物品列表
    async getUserList() {
      const result = await this.$axios.post("http://localhost:8081/schoolShop_war_exploded/getGoods?pagenum="+this.queryInfo.pagenum+"&pagesize="+this.queryInfo.pagesize);
      console.log('getGoods:');
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
      const result = await this.$axios.post("http://localhost:8081/schoolShop_war_exploded/addGoods",qs.stringify(this.addForm));
      console.log('addGoods:')
      console.log(result)

      if (result.status != '200') {
        return this.$Message.error('添加失败！')
      }
      this.addDialogVisible = false;
      this.getPage();
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
      const result = await this.$axios.post("http://localhost:8081/schoolShop_war_exploded/updateGoods", qs.stringify(this.editForm));
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

      // console.log(confirmResult);

      if (confirmResult != "confirm") {
        return this.$Message.info('已经取消删除！');
      }

      // 删除操作
      const result = await this.$axios.post("http://localhost:8081/schoolShop_war_exploded/delGoods",qs.stringify(row));
      console.log('removeGoodsById:')
      console.log(result)
      if (result.status  != '200') {
        return this.$Message.error('删除失败！');
      }
      this.$Message.success('删除成功！');
      this.getPage();
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
    handleAvatarSuccess(res, file) {
      console.log(res)
      this.addForm.goodsImage = 'http://localhost:80/images/'+res.url;
    },
    handleAvatarSuccess2(res, file) {
      console.log(res)
      this.editForm.goodsImage = 'http://localhost:80/images/'+res.url;
    },
    beforeAvatarUpload(file) {
      const isLt2M = file.size / 1024 / 1024 < 4;
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!');
      }
      return isLt2M;
    }

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
