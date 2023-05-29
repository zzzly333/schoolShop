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
    user:{
      id:'',
      name:'',
      username:'',
      password:'',
      address:'',
      state:'',
    },
    shopCart:[],
    indexGoods:'',
    manager:''
  },
  actions,
  getters,
  mutations

})
