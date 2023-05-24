<template>
  <div class="items-body">
    <item-child-body></item-child-body>
    <turn-page ></turn-page>
  </div>
</template>

<script>
import ItemChildBody from "./ItemChildBody";
import TurnPage from "./TurnPage";
export default {
  name: "ItemsBody",
  components: {TurnPage, ItemChildBody}
}
</script>

<style scoped>
.items-body{
  margin: 100px 250px 200px 250px;
  height: 2000px;
  position: relative;
  z-index: 200;
}
</style>
