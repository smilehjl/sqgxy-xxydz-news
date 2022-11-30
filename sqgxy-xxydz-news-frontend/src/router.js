import Vue from 'vue'
import Router from 'vue-router'
import Login from './components/Login.vue'
import Home from './components/Home.vue'
import NotFound from './components/NotFound.vue'
import index from './components/page/index.vue'
import introduce from './components/page/introduce.vue'
import XueFengBuild from './components/page/XueFengBuild.vue'
import Star from './components/page/Star.vue'
import Competition from './components/page/Competition.vue'
import HistoryStudy from './components/page/HistoryStudy.vue'
import Academy from './components/page/Academy.vue'
import Sqgxy from './components/page/Sqgxy.vue'
import Info from './components/page/Info.vue'
import News from './components/page/News.vue'
import moreMessage from './views/homePage/moreMessage'
import Administrator from './components/Administrator/AdminHome.vue'
import File from './components/Administrator/File.vue'
import Main from './components/Administrator/Main.vue'
import Edit from './components/Administrator/Edit.vue'
import EditLunBo from './components/Administrator/EditLunBo.vue'
import AdMain from './components/Administrator/AdMain.vue'
import AdEdit from './components/Administrator/AdEdit.vue'
import InfoUs from '@/components/Administrator/InfoUs'
import XdStarManager from '@/components/Administrator/XdStarManager/XdStarManager'
import PhoneManager from '@/components/Administrator/PhoneManager/PhoneManager'
import EditXdstar from '@/components/Administrator/XdStarManager/EditXdstar'
import AddXdstarView from '@/components/Administrator/XdStarManager/AddXdstarView'
import StarDetail from '@/components/page/StarDetail'
import addInformationView from '@/components/Administrator/PhoneManager/AddInformationView'
import EditInformation from '@/components/Administrator/PhoneManager/EditInformation'
import DataView from '@/components/Administrator/DataView'
import Map from '@/components/Administrator/MapView'
import MapView from '@/components/page/MapView'
import Edition from '@/components/Administrator/Edition'
import agency from '@/components/Administrator/Agency.vue'

Vue.use(Router)

const router = new Router({
  routes: [
    { path: '/', redirect: '/home' },
    { path: '/login', component: Login },
    {
      path: '/administrator',
      component: Administrator,
      children: [
        { path: 'file', component: File },
        { path: 'main', component: Main },
        { path: 'edit', component: Edit },
        { path: 'news', component: News },
        { path: 'editlunbo', component: EditLunBo },
        { path: 'admain', component: AdMain },
        { path: 'adedit', component: AdEdit },
        { path: 'InfoUs', component: InfoUs },
        { path: 'XdStarManager', component: XdStarManager },
        { path: 'EditXdstar', component: EditXdstar },
        { path: 'AddXdstarView', component: AddXdstarView },
        { path: 'PhoneManager', component: PhoneManager },
        { path: 'addInformationView',component: addInformationView },
        { path: 'EditInformation',component: EditInformation },
        { path: 'dataView',component: DataView },
        { path: 'map',component: Map },
        { path: 'Edition',component: Edition },
        { path: 'agency',component: agency }
      ]
    },
    {
      path: '/home',
      component: Home,
      children: [
        {
          path: '/home',
          redirect: 'index'
        },
        {
          path: 'index',
          component: index
        },
        {
          path: 'introduce',
          name: 'introduce',
          component: introduce
        },
        {
          path: 'XueFengBuild',
          name: 'XueFengBuild',
          component: XueFengBuild
        },
        {
          path: 'Star',
          name: 'Star',
          component: Star
        },
        {
          path: 'Competition',
          name: 'Competition',
          component: Competition
        },
        {
          path: 'HistoryStudy',
          name: 'HistoryStudy',
          component: HistoryStudy
        },
        {
          path: 'Academy',
          name: 'Academy',
          component: Academy
        },
        {
          path: 'Sqgxy',
          name: 'Sqgxy',
          component: Sqgxy
        },
        {
          path: 'Info',
          name: 'Info',
          component: Info
        },
        {
          path: 'moreMessage',
          name: 'moreMessage',
          component: moreMessage
        },
        {
          path: 'news',
          name: 'News',
          component: News
        },
        {
          path: 'StarDetail',
          name: 'StarDetail',
          component: StarDetail
        },
      ]
    },
    { path: '/MapView' ,component: MapView},
    { path: '*', component: NotFound }
  ],
  scrollBehavior(to, from, savedPosition) {
    //页面跳转后自动回到顶部
    if (savedPosition) {
      return savedPosition
    }
    return { x: 0, y: 0 }
  }
})

// 挂载路由导航守卫
router.beforeEach((to, from, next) => {
  // to 将要访问的路径
  // from 代表从哪个路径跳转而来
  // next 是一个函数，表示放行
  //     next()  放行    next('/login')  强制跳转
  // if (to.path === '/administrator/main' && !tokenStr) return next()
  // if (to.path === '/home/index') return next()
  // 获取token
  const tokenStr = window.sessionStorage.getItem('token')
  if (to.path === '/administrator/main' && !tokenStr) return next('/login')
  if (to.path === '/administrator/admain' && !tokenStr) return next('/login')
  if (to.path === '/administrator' && !tokenStr) return next('/login')
  if (to.path === '/administrator/edit' && !tokenStr) return next('/login')
  if (to.path === '/administrator/welcome' && !tokenStr) return next('/login')
  // if (!tokenStr) return next('/login')
  next()
})

export default router
