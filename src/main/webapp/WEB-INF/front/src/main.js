// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import Element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import less from 'less'
import axios from 'axios'
import qs from 'qs'

Vue.config.productionTip = false

Vue.use(Element)
Vue.use(less)
// 安装命令 npm install less-loader@4.1.0 less@3.9.0 --save
// vue2 全局挂载axios
Vue.prototype.$axios = axios
// 全局挂载 Message
Vue.prototype.$Message = Element.Message
// 全局挂载 confirm
Vue.prototype.$confirm = Element.MessageBox.confirm
Vue.use(qs)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
