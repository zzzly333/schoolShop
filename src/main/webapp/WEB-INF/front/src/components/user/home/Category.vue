<template>
  <div class="category">
    <div class="left">
      <h3>分类</h3>
      <el-tabs :tab-position="tabPosition" :style="leftStyle" >
        <el-tab-pane v-for="(item,index) in this.$store.state.category" :label="item" :key="index">
          <div slot="label" @click="selectGoods(item)">{{item}}</div>
        </el-tab-pane>
      </el-tabs>
    </div>
    <div class="right">
      <left-button><a href="javascript:scrollTo(0, 0)"><i class="el-icon-caret-top"></i></a> </left-button>
    </div>
  </div>
</template>

<script>
import LeftButton from "./LeftButton";
import axios from "axios";
export default {
  name: "Category",
  components: {LeftButton},
  data() {
    return {
      tabPosition: 'left',
      // isShow: false,
      leftStyle:{
        position:'fixed',
        height: 40*this.$store.state.category.length+""+"px",
      },
    };
  },
  methods:{
    async selectGoods(item){
      console.log(item)
      let param = new URLSearchParams()
      param.append('goodsType', item)
      await axios({
        method: 'post',
        url: "http://localhost:8081/shoolShop_war_exploded/getCategoryGoods",
        data: param
      }).then((result)=>{
          this.$store.commit('getGoods',result.data)
      })
    }
  }
}
</script>

<style scoped>
.category{
  margin-top: 200px;
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
