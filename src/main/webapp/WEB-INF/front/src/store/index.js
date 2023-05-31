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
    checked:[],
    goods:[],
    category:[],
    user:{
      id:'',
      name:'',
      username:'',
      password:'',
      address:'',
      state:'',
    },
    manager:{
      id:'',
      username:'',
      password:'',
      state:'',
    },
    shopCart:[],
    orders:[],
    isLogin: true,
    hideUsr:true,
    hideManager:true,
    hideLogin:false,
    indexGoods:'',
    // manager:''
  },
  actions,
  getters,
  mutations

})
