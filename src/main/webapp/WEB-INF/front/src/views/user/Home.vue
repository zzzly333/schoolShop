<template>
  <div class="home"  >
    <div class="home-left">
      <category/>
    </div>
    <div class="home-middle">
      <items-body></items-body>
    </div>
    <div class="home-right">

    </div>
  </div>


</template>

<script>
import ItemsBody from "../../components/user/home/ItemsBody";
import Category from "../../components/user/home/Category";

export default {
  name: "Home",
  components: {Category, ItemsBody},
}
</script>

<style scoped>
.home {
  width: 100%;
  overflow: auto;
}</style>
