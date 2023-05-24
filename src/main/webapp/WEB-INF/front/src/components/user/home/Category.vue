<template>
  <div class="category">
    <div class="left">
      <h3>分类</h3>
      <el-tabs :tab-position="tabPosition" :style="leftStyle">
        <el-tab-pane label="学习教育"></el-tab-pane>
        <el-tab-pane label="电子数码">电子数码</el-tab-pane>
        <el-tab-pane label="服饰鞋包">服饰鞋包</el-tab-pane>
        <el-tab-pane label="美妆护肤">美妆护肤</el-tab-pane>
        <el-tab-pane label="居家生活">居家生活</el-tab-pane>
        <el-tab-pane label="宠物">宠物</el-tab-pane>

      </el-tabs>
    </div>
    <div class="right">
      <left-button><a href="javascript:scrollTo(0, 0)"><i class="el-icon-caret-top"></i></a> </left-button>
    </div>
  </div>
</template>

<script>
import LeftButton from "./LeftButton";
export default {
  name: "Category",
  components: {LeftButton},
  data() {
    return {
      tabPosition: 'left',
      isShow: false,
      leftStyle:{
        position:'fixed',
        height: "240px"
      },
    };
  },
}
</script>

<style scoped>
.category{
  margin-top: 100px;
  position: fixed;
  width: 100%;
  height: 300px;

}
.right{
  width: 60px;
  height: 100%;
  position: absolute;
  right: 30px;
  top: 90%;
}
.left{
  float: left;
  margin-left: 100px;
}
a{
  color: black;
}
h3{
  width: 96px;
  text-align: center;
  margin: 0px;
  background-color: #cdcbcb;
}

</style>
