// 对axios的封装
import axios from 'axios'
//axios.defaults.withCredentials=true
// eslint-disable-next-line camelcase

//todo 端口10086
//let is_baseURL = 'http://localhost:10086/' // 测试环境
let is_baseURL = 'http://180.76.56.118:10086/' // 生产环境##
//let is_baseURL = 'http://43.138.103.28:10086/' // 生产环境

// 创建axios实例

const request = axios.create({
  baseURL: is_baseURL,
//todo  'application/x-www-form-urlencoded'
  headers: { 'Content-Type': 'application/json;charset=utf-8' }
})

// response服务器响应拦截器
request.interceptors.response.use(
  response => {
    const res = response.data
    return res
  },
  error => {
    console.log('err', error)
  }
)

export default request
