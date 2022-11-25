<template>
  <div class='login'>
    <el-form class='login-form' :model='loginForm'>
      <h3 class='title'>新闻管理平台</h3>
      <el-form-item>
        <el-input v-model='loginForm.username' prefix-icon='el-icon-user-solid' type='text' placeholder='账号'></el-input>
      </el-form-item>
      <el-form-item>
        <el-input v-model='loginForm.password' show-password prefix-icon='el-icon-lock' type='password'
                  placeholder='密码'></el-input>
      </el-form-item>
      <el-checkbox style='margin: 0px 0px 25px 0px'>记住密码</el-checkbox>
      <el-form-item>
        <el-button @click='Login' size='medium' type='primary'>
          <span>登录</span>
        </el-button>
      </el-form-item>
    </el-form>
    <div class='el-login-fotter'>
      <span>Copyright © 2022-2022.</span>
    </div>
  </div>
</template>

<script>
import { login } from '../api/api'

export default {
  data() {
    return {
      // 这是登录表单的数据绑定对象
      loginForm: {
        username: '',
        password: ''
      }
    }
  },
  methods: {
    // 点击重置按钮，重置登录表单
    resetLoginForm() {
      this.$refs.loginFormRef.resetFields()
    },
    Login() {
      const data = {
        username: this.loginForm.username,
        password: this.loginForm.password
      }
      login(data).then(res => {
        console.log(res)
        if (res.code !== 200) {
          this.$message.error('登录失败！')
        } else if (res.data.role == '超级管理员') {
          this.$message.success('超管登录成功！')
          window.sessionStorage.setItem('token', res.cookie)
          this.$router.push('/administrator/admain')
        } else {
          this.$message.success('登录成功！')
          window.sessionStorage.setItem('token', res.cookie)
          this.$router.push('/administrator/main')
        }
      })
    }
  }
}
</script>

<style lang='less' scoped>
.login {
  //background-image: url('../assets/bg2.png');
  background-image: url('../assets/bg-login.png');
  background-size: 100% 100%;
  // background-size: auto;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  position: relative;

  .login-form {
    background-image: url('../assets/inputBg.png');
    border-radius: 6px;
    position: absolute;
    width: 490px;
    height: 444px;
    right: 250px;
    padding: 45px 50px 0 50px;

    .title {
      height: 40px;
      line-height: 40px;
      font-size: 28px;
      width: 100%;
      font-family: PingFang SC;
      color: #3360c2;
      text-align: center;
      margin-bottom: 35px;
    }

    .el-input {
      margin-bottom: 20px;
    }

    .el-button {
      width: 100%;
      margin: 35px 0;
      background-color: #3360c2;
    }

    .el-button:hover {
      background-color: #3360c2d5;
    }
  }

  .el-login-fotter {
    position: fixed;
    bottom: 0;
    height: 40px;
    line-height: 40px;
    color: #fff;
    font-size: 12px;
    font-family: Arial;
    letter-spacing: 1px;
  }
}
</style>
