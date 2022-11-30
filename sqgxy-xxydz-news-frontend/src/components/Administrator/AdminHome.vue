<template>
  <el-container class='home-container'>
    <el-header>
      <div>
        <img src='../../assets/admin-logo.jpg' alt='' />
        <span>新闻后台管理系统</span>
      </div>
      <el-button type='info' @click='logout'>退出</el-button>
    </el-header>

    <el-container>
      <el-menu :default-active='$route.path' class='el-menu-vertical-demo' @open='handleOpen' @close='handleClose'
               router
               :collapse='isCollapse'>
        <el-menu-item index='admain'>
          <i class='el-icon-document-copy'></i>
          <span slot='title'>新闻管理</span>
        </el-menu-item>
        <el-menu-item index='Agency'>
          <i class='el-icon-edit-outline'></i>
          <span slot='title'>待办事项</span>
        </el-menu-item>
        <el-menu-item index='dataView'>
          <i class='el-icon-s-data'></i>
          <span slot='title'>数据分析</span>
        </el-menu-item>
        <el-menu-item index='map'>
          <i class='el-icon-s-flag'></i>
          <span slot='title'>地图显示</span>
        </el-menu-item>
        <el-menu-item index='file'>
          <i class='el-icon-folder'></i>
          <span slot='title'>文件管理</span>
        </el-menu-item>
        <el-menu-item index='XdStarManager'>
          <i class='el-icon-star-off'></i>
          <span slot='title'>信电之星</span>
        </el-menu-item>
        <el-menu-item index='PhoneManager'>
          <i class='el-icon-phone'></i>
          <span slot='title'>联系方式</span>
        </el-menu-item>
        <el-menu-item index='InfoUs'>
          <i class='el-icon-user-solid'></i>
          <span slot='title'>关于我们</span>
        </el-menu-item>

        <el-submenu index='/'>
          <template slot='title'>
            <i class='el-icon-location'></i>
            <span slot='title'>关于</span>
          </template>
          <el-menu-item-group>
            <span slot='title'>关于本站</span>      <!-- todo 10086 -->
            <el-menu-item onclick="javascript:window.open('http://180.76.56.118:10086/swagger-ui.html')">后端接口</el-menu-item>
            <el-menu-item onclick="javascript:window.open('https://gitee.com/love-code-bear/News-Sqgxy')">项目地址</el-menu-item>
            <el-menu-item index='Edition'>系统版本</el-menu-item>
          </el-menu-item-group>
        </el-submenu>

      </el-menu>
      <!--2--->
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  data() {
    return {
      isCollapse: true
    }
  },
  created() {
  },
  methods: {
    logout() {
      //清空token
      window.sessionStorage.clear()
      //跳转到登录页
      this.$router.push('/login')
    },
    handleOpen(key, keyPath) {
      console.log(key, keyPath)
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath)
    }
  }
}
</script>

<style lang='less' scoped>
.home-container {
  height: 100%;
}

.el-header {
  background-color: rgb(55, 61, 63);
  display: flex;
  justify-content: space-between;
  padding-left: 0;
  align-items: center;
  color: #fff;
  font-size: 20px;

  > div {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 300px;
    height: 60px;

    img {
      width: 60px;
      height: 100%;
      border-radius: 50%;
    }

    span {
      margin-left: 15px;
    }
  }
}

.iconfont {
  margin-right: 10px;
}
</style>
