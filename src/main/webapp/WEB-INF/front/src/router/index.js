// 全局前置守卫---初始化的时候被调用，每次路由切换之前被调用
// router.beforeEach((to, from, next) => {
//   console.log("网站前端守卫者", to, from);
//   if (to.meta.isAuth) { // 判断是否需要鉴权
//     next();
//     // if(localStorage.getItem("user") != null) {
//     //     next();
//     // }else{
//     //     alert("你还没有登录！");
//     // }
//   } else {
//     next();
//   }
// })
//
// // 全局后置守卫
// router.afterEach((to, from) => {
//   console.log("网站后置守卫", to, from)
//
//   document.title = to.meta.title || "vue网站"
// })
//
// export default router

import Vue from 'vue'
// import Router from 'vue-router'
import VueRouter from 'vue-router'
import goods from "../components/manager/goods";
import goodsType from "../components/manager/goodsType";
import user from "../components/manager/user";
import saleManager from "../components/manager/saleManager";
import goodserManager from "../components/manager/goodserManager";
import backPage3 from "../views/manager/backPage3";
import backPage2 from "../views/manager/backPage2";
import backPage1 from "../views/manager/backPage1";
import login from "../views/login/login";

Vue.use(VueRouter)


const routes = [{
    path: '/',
    name: 'login',
    component: login,
    meta: { isAuth: true, title: "登录" }
  },
  {
    path: '/backPage1',
    name: 'backPage1',
    component: backPage1,
    meta: { isAuth: true, title: "商品专员管理系统" },
    children:[{
      path: '/goodsType',
      name: 'goodsType',
      component: goodsType,
      meta: { isAuth: true, title: "商品类型" }
    },{
      path: '/goods',
      name: 'goods',
      component: goods,
      meta: { isAuth: true, title: "商品" }
    }]
  },
  {
    path: '/backPage2',
    name: 'backPage2',
    component: backPage2,
    meta: { isAuth: true, title: "营销经理管理系统" },
    children:[{
      path: '/user',
      name: 'user',
      component: user,
      meta: { isAuth: true, title: "用户管理" }
    },{
      path: 'goodsType',
      name: 'goodsType',
      component: goodsType,
      meta: { isAuth: true, title: "商品类型" }
    },{
      path: 'goods',
      name: 'goods',
      component: goods,
      meta: { isAuth: true, title: "商品" }
    }]
  },
  {
    path: '/backPage3',
    name: 'backPage3',
    component: backPage3,
    meta: { isAuth: true, title: "系统管理员管理系统" },
    children:[{
      path: '/goodserManager',
      name: 'goodserManager',
      component: goodserManager,
      meta: { isAuth: true, title: "商品专员管理" }
    },{
      path: '/saleManager',
      name: 'saleManager',
      component: saleManager,
      meta: { isAuth: true, title: "营销经理" }
    },{
      path: 'user',
      name: 'user',
      component: user,
      meta: { isAuth: true, title: "用户管理" }
    },{
      path: 'goodsType',
      name: 'goodsType',
      component: goodsType,
      meta: { isAuth: true, title: "商品类型" }
    },{
      path: 'goods',
      name: 'goods',
      component: goods,
      meta: { isAuth: true, title: "商品" }
    }]
  }
]

const router = new VueRouter({
  mode: 'history',
  routes
})
export default router
// 全局前置守卫---初始化的时候被调用，每次路由切换之前被调用
// router.beforeEach((to, from, next) => {
//   console.log("网站前端守卫者", to, from);
//   if (to.meta.isAuth) { // 判断是否需要鉴权
//     next();
//     // if(localStorage.getItem("user") != null) {
//     //     next();
//     // }else{
//     //     alert("你还没有登录！");
//     // }
//   } else {
//     next();
//   }
// })
//
// // 全局后置守卫
// router.afterEach((to, from) => {
//   console.log("网站后置守卫", to, from)
//
//   document.title = to.meta.title || "vue网站"
// })

