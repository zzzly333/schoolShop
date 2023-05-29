<template>
  <div class="turn-page">
    <el-pagination layout="prev, pager, next" :total="this.$store.state.goods.length" :page-size="24" :class="pageStyle"></el-pagination>
  </div>
</template>

<script>
export default {
  name: "TurnPage",
  data(){
    return{
      pageStyle:{
        float: "bottom",
        padding:'0',
        width:'100px'
      }
    }
  }
}
</script>

<style scoped>
.turn-page{
  position: absolute;
  bottom: 0;
  left: 50%;
  transform: translate(-50%, -50%);
}
</style>
