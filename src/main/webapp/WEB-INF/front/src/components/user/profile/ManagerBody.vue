<template>
  <div class="form-body" >
    <div class="sticky-button" style="margin-top: 20px">
      <el-button @click="toggleSelection()">取消选择</el-button>
      <el-button type="danger" style="width:97.6px;display: inline" @click="deleteAll">一键删除</el-button>
      <el-input :style="inputStyle" placeholder="请输入内容" prefix-icon="el-icon-search" v-model="input">
      </el-input>

    </div>
    <div class="form">
      <template>
        <el-table ref="multipleTable" :data="this.$store.state.items" style="width: 100%" :default-sort = "{prop: 'date', order: 'descending'}" border @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="55" > </el-table-column>
          <slot>
            <el-table-column prop="data" :label="label1" sortable width="250"> </el-table-column>
            <el-table-column prop="name" :label="label2"  width="150"> </el-table-column>
            <el-table-column prop="address" :label="label3" sortable :formatter="formatter"> </el-table-column>
          </slot>
          <el-table-column label="">
            <template slot-scope="scope">
              <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </template>
    </div>
    <div class="page"><turn-page></turn-page></div>
  </div>
</template>

<script>
import TurnPage from "../home/TurnPage";
export default {
  name: "Form",
  components: {TurnPage},
  data() {
    return {
      multipleSelection: [],
      input:'',
      inputStyle:{
        display:'inline-block',
        width:'230px',
        marginLeft: '50px'
      },
      label1:'编号',
      label2:'价格',
      label3:'名称'
    }
  },
  methods: {
    toggleSelection(rows) {
      if (rows) {
        rows.forEach(row => {
          this.$refs.multipleTable.toggleRowSelection(row);
        });
      } else {
        this.$refs.multipleTable.clearSelection();
      }
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    formatter(row, column) {
      return row.address;
    },
    request(arr){
      let kind = ''
      if(!this.$parent.hideGoods)
        kind = 'goods'
      else if(!this.$parent.hideUsers)
        kind = 'users'
      else if(!this.$parent.hideOrders)
        kind = 'orders'
      this.$axios({
        url:"http://localhost:8080/Library_war_exploded/DeleteItemsServlet",
        method:'post',
        params:{
          arr: arr,
          kind:kind
        },
        headers: {"Content-Type": "application/x-www-form-urlencoded;charset=UTF-8"}
      }).then((result) => {
        // this.$store.commit("getGoods",result.data)
      }, function () {
        console.log('传输失败');
      })
    },
    handleDelete(index, row) {
      let arr = "\'" + row.data+"\'"
      this.request(arr)
    },
    deleteAll(){
      let arr = ''
      for( let i in this.multipleSelection){
        arr += "\'" + this.multipleSelection[i].data+"\'"
        if(i < this.multipleSelection.length-1)
          arr += ','
      }
      this.request(arr)
    },
  }
}
</script>

<style scoped>
.sticky-button{
  position: -webkit-sticky; /* Safari */
  position: sticky;
  top: 0;
  z-index: 100;
  background-color: #ece7e7;
  margin-top: 0;
  padding: 10px;
}
.form-body{
  display: flex;
  flex-direction: column;
  height: 100%;
  width: 100%;
  position: relative;
}
.form{
  flex: 19;
}
.page{
  flex: 1;
  position: relative;
  border-top: 1px solid rosybrown;
}
</style>
