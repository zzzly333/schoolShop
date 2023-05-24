import Vue from 'vue'
import Vuex from 'vuex'
import actions from "./actions"
import mutations from "./mutations"
import getters from "./getters"
Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    obj: '',
    isSelectAll: false,
    checked:[false,false,false,false,false,false,false,false,false,false],
    items:[],
    isLogin: true,
    hideUsr:true,
    hideManager:true,
    hideLogin:false,
    user:{
      username:'',
      password:'',
      nickname:'',
      gender:'',
      tel:'',
    },
    shopcart:[],
    indexGoods:'',
    manager:''
  },
  actions,
  getters,
  mutations

})
