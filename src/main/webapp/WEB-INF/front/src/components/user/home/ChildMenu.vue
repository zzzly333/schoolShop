<template>
  <div id="child-menu">
    <div>
      <button>综合排序</button>
    </div>
    <div>
      <el-select :style="priceSelectCSS" v-model="value" clearable placeholder="价格排序">
        <el-option v-for="(item,index) in prices" :key="item.value" :label="item.label" :value="item.value" > </el-option>
      </el-select>
    </div>

  </div>
</template>

<script>
export default {
  name: "childMenu",
  components: {},
  data(){
    return{
      prices: [{
        value: '选项1',
        label: '价格升序'
      }, {
        value: '选项2',
        label: '价格降序'
      }],
      value: '',
      priceSelectCSS:{
        height: "40px",
        width: "105px",
        margin:'0',
        padding:'0'
      }
    }
  }

}
</script>

<style scoped>
button{
  height: 40px;
  width: 105px;
}
#child-menu{
  border: 1px #ece0e0 solid;
  border-top: 0px;
  border-bottom: 0px;
  margin: 100px 250px 0px 250px;
  height: 60px;
  position: relative;
  float: top;
}
#child-menu div{
  display: inline-block;
  padding: 10px 0px 10px 10px;
}
</style>
