<template>
  <div  id="left-button">
    <slot></slot>
  </div>

</template>

<script>
export default {
  name: "LeftButton"
}
</script>

<style scoped>
#left-button{
  font-size: 40px;
  width: 50px;
  height: 50px;
  background-color: #f5f2f2;
  border-radius: 5px;
  text-align: center;
  margin: 5px;
}
#left-button:hover{
  background-color: #d2d3d4;
}
</style>
