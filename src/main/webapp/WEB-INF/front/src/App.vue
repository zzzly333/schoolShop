<template>
  <div id="app">
    <top-menu :class="{hide:this.$store.state.hideUsr}"></top-menu>
    <back-page1 :class="{hide:this.$store.state.hideManager}"></back-page1>
    <login  :class="{hide:this.$store.state.hideLogin}"></login>
  </div>
</template>
<script>
import TopMenu from "./components/user/topmenu/TopMenu";
import BackPage1 from "./views/manager/backPage1";
import Login from "./views/login/login";

export default {
  name: 'App',
  components:{TopMenu,BackPage1,Login}
}
</script>
<style lang="less">
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
.hide{
  display: none;
}
</style>

