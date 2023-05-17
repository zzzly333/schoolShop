import Vue from 'vue'
import Router from 'vue-router'
import FrontPage from "../views/frontPage";
import BackPage from "../views/backPage";

Vue.use(VueRouter)

const routes = [{
  path: '/',
  name: 'FrontPage',
  component: FrontPage,
  meta: { isAuth: true, title: "首页" }
  },
  {
    path: '/BackPage',
    name: 'BackPage',
    component: BackPage,
    meta: { isAuth: true, title: "首页" },
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

// 全局前置守卫---初始化的时候被调用，每次路由切换之前被调用
router.beforeEach((to, from, next) => {
  console.log("网站前端守卫者", to, from);
  if (to.meta.isAuth) { // 判断是否需要鉴权
    next();
    // if(localStorage.getItem("user") != null) {
    //     next();
    // }else{
    //     alert("你还没有登录！");
    // }
  } else {
    next();
  }
})

// 全局后置守卫
router.afterEach((to, from) => {
  console.log("网站后置守卫", to, from)

  document.title = to.meta.title || "vue网站"
})

export default router
