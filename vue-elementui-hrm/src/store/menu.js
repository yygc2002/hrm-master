export default {
  namespaced: true,
  state: {
    // state定义了模块的状态，这里只有一个menuList数组
    // 首页是所有员工都可访问的
    menuList: [
      {
        id: 0,
        code: 'home',
        name: '首页',
        icon: 's-home',
        path: '/home',
        children: []
      }
    ]
  },
  mutations: {
    // mutations定义了更改状态的方法
    SET_MENU (state, menuList) {
      state.menuList = menuList
    },
    // CLEAR_MENU用于重置菜单列表到初始状态
    CLEAR_MENU (state) {
      state.menuList = [
        {
          id: 0,
          code: 'home',
          name: '首页',
          icon: 's-home',
          path: '/home',
          children: []
        }
      ]
    }
  },
  actions: {
  }
}
