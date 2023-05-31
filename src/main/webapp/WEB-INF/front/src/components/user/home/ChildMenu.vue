<template>
  <div id="child-menu">
    <!--    <div>-->
    <!--      <button >综合排序</button>-->
    <!--    </div>-->
    <!--    <div>-->
    <!--      <el-select :style="priceSelectCSS" v-model="value" clearable placeholder="价格排序" >-->
    <!--        <el-option v-for="(item,index) in prices" :key="item.value" :label="item.label" :value="item.value"  > </el-option>-->
    <!--      </el-select>-->
    <!--    </div>-->
    <div>
      <el-input placeholder="搜索" suffix-icon="el-icon-search" v-model="search" :style="searchCSS"
                @keyup.enter.native="searchGoods()"></el-input>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "childMenu",
  components: {},
  data() {
    return {
      search: '',
      goods: this.$store.state.goods,
      // defaultGoods:
      prices: [{
        value: '选项1',
        label: '价格升序'
      }, {
        value: '选项2',
        label: '价格降序'
      }],
      value: '',
      priceSelectCSS: {
        height: "40px",
        width: "105px",
        margin: '0',
        padding: '0'
      },
      searchCSS: {
        marginTop: "-10px",
      }

    }
  }
  ,
  watch: {
    search: {
      //首次绑定是否执行handler
      immediate: true,
      //一般情况下，数据发生变化handler才会执行
      handler (val) {
        if(val=='')
          this.$store.commit("getGoods",this.goods)
        // else {
        //   // console.log(this.goods)
        //   this.filterList = this.$store.state.goods.filter((item) => {
        //     //判断是否在数组中存在
        //     return item.goodsName.indexOf(val) !== -1
        //   })
        //   this.goods = this.filterList
        //   if(this.goods.length == 0)
        //     this.$message.error("未查找到该商品！")
        //   else
        //     this.$store.commit("getGoods",this.goods)
        // }
      }
    }
  },
  methods: {
    // option(){
    //   console.log(this.value)
    //   if (this.value == '价格升序')
    //     this.upSort()
    //   else
    //     this.downSort()
    // },
    // defaultSort(){
    //   // this.getGoods()
    //
    // },
    // upSort(){
    //   let sortKeys = Object.keys(this.defaultGoods).sort((a, b) => {
    //     return this.defaultGoods[a].goodsPrice - this.defaultGoods[b].goodsPrice
    //   })
    //   this.$store.commit("getGoods",sortKeys)
    // },
    // downSort(){
    //   let sortKeys = Object.keys(this.defaultGoods).sort((a, b) => {
    //     return this.defaultGoods[b].goodsPrice - this.defaultGoods[a].goodsPrice
    //   })
    //   this.$store.commit("getGoods",sortKeys)
    // },
    getGoods() {
      axios.post("http://localhost:8081/schoolShop_war_exploded/getAllGoods"
      ).then((result) => {
        this.$store.commit("getGoods", result.data)
      })
    },
    searchGoods() {
      if(this.search != ''){
        let filterList = []
        filterList = this.$store.state.goods.filter((item) => {
          //判断是否在数组中存在
          return item.goodsName.indexOf(this.search) !== -1 || this.search.indexOf(item.goodsName) !== -1
        })
        // this.goods = filterList
        if (filterList.length == 0)
          this.$message.error("未查找到该商品！")
        else
          this.$store.commit("getGoods", filterList)
      }
    }
  }

}
</script>

<style scoped>
button {
  height: 40px;
  width: 105px;
}

#child-menu {
  /*border: 1px #ece0e0 solid;*/
  /*border-top: 0px;*/
  /*border-bottom: 0px;*/
  margin: 80px 0px 30px 0px;
  height: 40px;
  position: relative;
  float: top;
  padding: 0;
  display: flex;
}

#child-menu div {
  padding: 10px 0px 10px 10px;
  float: left;
  height: 40px;
  margin-top: 0px;
}

#child-menu div:last-child {
  /*padding-top: 25px;*/
  position: relative;
  width: 400px;
}

</style>
