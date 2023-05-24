<template>
  <div id="top-menu-item" @click="goRouter">
    <slot></slot>
  </div>

</template>

<script>
export default {
  name: "TopMenuItem",
  props:{
    path:String
  },
  methods:{
    goRouter(){
      this.$router.replace(this.path)
    }
  }
}
</script>

<style scoped>
div{
  margin: 0;
  padding: 0;
  width: 68px;
  text-align: center;
}
</style>
