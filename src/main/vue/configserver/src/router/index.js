import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import UserInfo from '@/components/UserInfo'
import HelloWorld from '@/components/HelloWorld'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/users',
      name: 'UserInfo',
      component: UserInfo
    },
    {
      path: '/helloworld/:name',
      name: 'HelloWorld',
      component: HelloWorld
    }
  ]
})
