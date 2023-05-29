<template>
  <div class="items-body">
    <child-menu></child-menu>
    <item-child-body></item-child-body>
    <turn-page ></turn-page>
  </div>
</template>

<script>
import ItemChildBody from "./ItemChildBody";
import TurnPage from "./TurnPage";
import ChildMenu from "./ChildMenu";
export default {
  name: "ItemsBody",
  components: {ChildMenu, TurnPage, ItemChildBody}
}
</script>

<style scoped>
.items-body{
  margin: 80px 250px 200px 250px;
  height: 2000px;
  position: relative;
  z-index: 200;
}
</style>
