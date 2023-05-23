<template>
  <div id="app">
    <login-input/>
  </div>
</template>
<script>
import HelloWorld from "./components/HelloWorld";
import LoginInput from "./components/login/LoginInput";
export default {
  components: {LoginInput, HelloWorld}
}
</script>
<style lang="less">
// html,body {
//   width: 100%;
//   height: 100%;
//   box-sizing: border-box;
//   padding: 0px;
//   margin: 0px;
// }
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  height: 100%;
  width: 100%;
  margin:0;
  padding: 0;
  position: relative;
}

nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>

