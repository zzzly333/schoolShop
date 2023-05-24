<template>
  <div id="shop-cart-pay" ref="" >
<!--    <div class="selectAll"><input type="checkbox" value="" @click="selectAll" class="all" >全选</div>-->
    <div class="delete"><el-button type="text" @click="deleteItems">删除</el-button></div>
    <div class="right">
      <span>
        <span>已选商品: </span><span class="highlight">{{num}}</span> <span>件</span>
      </span>
      <span>
        <span>合计：</span>
        <span class="highlight">{{price | showPrice}}</span>
      </span>
      <span><button @click="pay">结算</button></span>
    </div>
  </div>
</template>

<script>
export default {
  name: "ShopCartPay",
  data(){
    return{
      num: 0,
      price:0
    }
  },
  props:{
    sum:{
      type:Number,
      default:0
    }
  },
  methods:{
    selectAll(){
      this.$store.commit("changeBoolean")
      console.log(this.$store.state.checked)
    },
    deleteItems(){
      this.$parent.delete()
    },
    pay(){
      this.$parent.pay()
    }
  },
  filters:{//过滤器
    showPrice(price){
      return  parseFloat(price).toFixed(2)
    }
  },

}

</script>

<style scoped>

.right>span{
  margin: 0px 10px;
}
.el-button{
  font-size: 20px;
  color: black;
}
.el-button:hover{
  color: #f87b54;
}
button:not(.el-button){
  background-color: #f87b54;
  border-radius: 25px;
  border-color: #f87b54;
  color: white;
  font-size: 20px;
  height: 50px;
  width: 100px;
}
input[type=checkbox]{
  width: 20px;
  height: 20px;
}
#shop-cart-pay{
  height: 100%;
  /*border: 1px black solid;*/
  width: 100%;
  display: flex;
  font-size: 20px;
}
#shop-cart-pay div:not(.right){
  margin: auto;
  text-align: center;
}
.selectAll{
   flex: 1;
 }
.delete{
  flex: 1;
}
.right{
  flex: 8;
  text-align: right;
  padding: 5px 10px;
}
.highlight{
  color: #f64f4f;
  font-weight: bolder;
  font-size: 30px;
}
</style>
