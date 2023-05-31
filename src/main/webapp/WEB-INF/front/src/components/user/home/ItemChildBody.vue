<template>
<div class="item-child-body" ref="goods">
  <div class="item grid-item" @click="detail(index)"
       v-for="(goods,index) in this.$store.state.goods" :key="index"
        v-if="goods.state === '启用' && goods.goodsNum > 0">
    <div class="img">
      <img :src="goods.goodsImage">
    </div>
    <div class="info">
      <div class="msg">{{goods.goodsName}}</div>
      <div class="price">￥{{goods.goodsPrice}}</div>
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
  watch: {
    search: {
      //首次绑定是否执行handler
      immediate: true,
      //一般情况下，数据发生变化handler才会执行
      handler (val) {
        if(val=='')
          this.getGoods()
        else {
          // console.log(this.goods)
          this.filterList = this.$store.state.goods.filter((item) => {
            //判断是否在数组中存在
            return item.goodsName.indexOf(val) !== -1
          })
          this.goods = this.filterList
          this.$store.commit("getGoods",this.goods)
        }
      }
    }
  },
  methods:{
    searchGoods(){
      if(this.index_page !== 'home'){
        this.filterList = this.goods.filter((item) => {
          //判断是否在数组中存在
          return item.goodsName.indexOf(this.search) !== -1
        })
        this.goods = this.filterList
        // this.$store.commit("getGoods",this.goods)
      }
    },
    show(i){
      return i <= this.$store.state.items.length
    },
    detail(index){
      this.$router.push('/schoolshop/detail')
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
  grid-template-columns: 235px 235px 235px 235px;
  grid-template-rows: 304px 304px 304px 304px 304px 304px ;
  grid-column-gap: 20px;
  grid-row-gap: 20px;
}
img{
  width: 191.6px;
  height: 191.4px;
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
