<template>
<div class="item-child-body">
  <div class="item grid-item" @click="detail(index)"
       v-for="(goods,index) in this.$store.state.items" :key="index"
        v-if="goods.num == 1">
    <div class="img">
      <img :src="goods.img">
    </div>
    <div class="info">
      <div class="msg">{{goods.title}}</div>
      <div class="price">￥{{goods.price}}</div>
    </div>

  </div>
</div>
</template>

<script>
export default {
  name: "ItemChildBody",
  data(){
    return{
      // row:
    }
  },
  computed:{
    row(){
      return this.$store.state.items.length
    },
  },
  methods:{
    show(i){
      return i <= this.$store.state.items.length
    },
    detail(index){
      this.$router.push('/detail')
      this.$store.commit('detail',index)
    }
  }
}
</script>

<style scoped>
.grid-item {
  padding: 20px;
  font-size: 30px;
  position: relative;
}
.item-child-body{
  padding-right: 20px;
  border: 1px solid #dbd7d7;
  height: 97%;
  width: 100%;
  display: grid;
  grid-template-columns: auto auto auto auto;
  grid-template-rows: auto auto auto auto auto auto ;
}
div,span{
}
.img{
  flex: 5;
  border: 0.5px solid #eeebeb;
}
.msg{
  font-size: 22px;
  overflow: hidden;
  text-overflow:ellipsis;
  white-space: nowrap;
}
.price{
  color: #f64f4f;
}
.item{
  border: 0.1px #f5e9e9 solid;
  margin: 20px 0px 0px 20px;
  display: flex;
  flex-direction: column;
  width: 193.2px;
  height: 261.8px;
}
.item:hover{
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
</style>
