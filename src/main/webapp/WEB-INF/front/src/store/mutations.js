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
  logOut(state){
    state.isLogin = false
    state.hideUsr = true
    state.hideManager = true
    state.hideLogin = false
    state.user = ''
  },
  login(state,user){
    console.log(user)
    state.user.id = user.id
    state.user.name = user.name
    state.user.username = user.username
    state.user.password = user.password
    state.user.address = user.address
    state.user.state = user.state

  },
  toHome(state,data){
    state.category = data[1]
    state.goods = data[0]
  },
  getGoods(state,data){
    state.goods = data
  },
  detail(state,index){
    state.indexGoods = index
  },
  getCart(state,cart){
    state.shopCart = cart
    state.checked = []
    for(let i=0; i<state.shopCart.length; i++){
      state.checked.push(false)
    }
  },
  // clearCheckBox(state){
  //   for(let i=0 ; i<state.checked.length ; i++){
  //     state.checked[i] = false
  //   }
  // },
  getOrders(state,data){
    state.orders = data
  },
  getManager(state,data){
    state.manager = data
  }
}
