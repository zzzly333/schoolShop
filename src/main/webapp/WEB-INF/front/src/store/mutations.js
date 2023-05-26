export default {
  changeBoolean(state){

    state.isSelectAll = !state.isSelectAll
    if(state.isSelectAll){
      for(let i in state.checked){
        state.checked[i] = true
      }
    }else{
      for(let i in state.checked){
        state.checked[i] = false
      }
    }
  },
  changeCheck(state,index){
    let flag = true
    state.checked[index] = !state.checked[index]
    for(let i = 0 ; i < state.checked.length ; i++){
      if(!state.checked[i])
        flag = false
    }
    if(flag)
      state.isSelectAll = true
  },
  deleteItems(state) {
    for(let i = 0 ; i < state.checked.length ; i++){
      if(state.checked[i]){
        state.checked.splice(i,1)
        state.items.splice(i,1)
      }

    }
  },
  logOut(state){
    state.isLogin = false
    state.hideUsr = true
    state.hideManager = true
    state.hideLogin = false
    state.user = ''
  },
  managerLogOut(state){
    state.hideLogin = false
    state.hideManager = true
  },
  login(state,user){
    state.user.id = user.id
    state.user.name = user.name
    state.user.username = user.username
    state.user.password = user.password
    state.user.address = user.address
    state.user.state = user.state
  },
  getGoods(state,data){
    state.items = data
  },
  detail(state,index){
    state.indexGoods = index
  },
  getCart(state,cart){
    state.shopcart = cart
  },
  managerLogin(state){
    state.hideUsr = true
    state.hideManager = false
    state.hideLogin = true
  }
}
