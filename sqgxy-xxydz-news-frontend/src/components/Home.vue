<template>
  <el-container class='home-container'>
    <!-- 主页头部 -->
    <el-header>
      <div>
        <img src='../assets/logoxmp3.png' alt='' style='height: 80%;width: 80%' />
      </div>
      <div>
        <img src='../assets/logo-right.png' alt='' />
      </div>
    </el-header>
    <!-- 主页导航栏 -->
    <el-row>
      <el-menu mode='horizontal' background-color='rgb(64, 112, 186)' text-color='white' class='menu'
               active-text-color='#000000' :default-active='activeIndex' @select='handleSelect'>
        <el-menu-item :key='index' v-for='(item, index) in menuList' :index='item.id.toString()'>
          {{ item.name }}
        </el-menu-item>
      </el-menu>
    </el-row>
    <el-container>
      <!-- 更变的内容区域 -->
      <el-main class='main'>
        <router-view class='box'></router-view>
      </el-main>
    </el-container>
    <el-footer>@商丘工学院&emsp;信息与电子与工程学院</el-footer>
  </el-container>
</template>

<script>
import axios from 'axios'

export default {
  name: '',
  data() {
    return {
      activeIndex: '1',
      menuList: [
        { name: '首页', id: 1 },
        { name: '走进信电', id: 2 },
        { name: '学风建设', id: 3 },
        { name: '信电之星', id: 4 },
        { name: '学科竞赛', id: 5 },
        { name: '党史学习', id: 6 },
        { name: '归德书院', id: 7 },
        { name: '学校首页', id: 8 },
        { name: '联系我们', id: 9 }
      ],
      menuList2: []
    }
  },
  created() {
  },
  mounted() {
    // todo 部署端口10086
    let api3 = 'http://180.76.56.118:10086/news_type/all'
    //let api3 = 'http://43.138.103.28:10086/news_type/all'
    //let api3 = 'http://localhost:10086/news_type/all'
    axios
      .get(api3)
      .then(res => {
        this.menuList2 = res.data.data
      })
      .catch(error => {
        console.log(error)
      })
  },
  watch: {},
  methods: {
    formatterTitle(t) {
      switch (t) {
        case '1':
          return 'index'
        case '2':
          return 'introduce'
        case '3':
          return 'XueFengBuild'
        case '4':
          return 'Star'
        case '5':
          return 'Competition'
        case '6':
          return 'HistoryStudy'
        case '7':
          return 'Academy'
        case '8':
          return 'Sqgxy'
        case '9':
          return 'Info'
      }
    },
    handleSelect(key, keyPath) {
      if (key == '8') {
        window.open('http://www.sqgxy.edu.cn/')
      } else {
        this.$router.push({
          path: '/home/' + this.formatterTitle(key),
          query: {
            title: this.formatterTitle(key),
            id: key
          }
        })
      }
    }
  }
}
</script>

<style lang='less' scoped>
.home-container {
  height: 100%;
}

.el-header {
  background-color: rgb(1, 72, 153);
}

.el-header {
  height: 120px !important;
  padding: 0 80px 0 120px;
  overflow: hidden;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.el-menu {
  .el-menu-item {
    width: 150px;
    font-size: 15px;
    text-align: center;
  }
}

.menu {
  display: flex;
  justify-content: space-between;
}

.el-footer {
  background-color: rgb(85, 81, 82);
}

.main {
  padding: 20px 5px;
}

.el-footer {
  font-size: 15px;
  color: white;
  text-align: center;
  line-height: 60px;
}

.box {
  width: 1200px;
  margin: 0 auto;
}
</style>
