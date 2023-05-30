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
    goods:[],
    isLogin: true,
    hideUsr:true,
    hideManager:true,
    hideLogin:false,
    category:[],
    user:{
      id:'1006',
      name:'1',
      username:'1',
      password:'1',
      address:'1',
      state:'1',
    },
    shopCart:[],
    indexGoods:'',
    manager:''
  },
  actions,
  getters,
  mutations

})
