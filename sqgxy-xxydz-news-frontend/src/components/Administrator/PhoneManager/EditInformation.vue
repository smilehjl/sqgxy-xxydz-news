<template>
  <div style='width: 60%;margin-top: 20px;margin-left: 15px'>
    <el-card class='box-card'>
      <div style='margin-bottom: 30px;margin-left: 48px;margin-top: 30px;color: #636262'><h3>修改联系方式</h3></div>
      <el-form :inline='true' ref='ruleForm' label-width='100px'>
        <el-form-item label='序号' prop='name'>
          <el-input v-model='form.id' placeholder='请输入编号' disabled></el-input>
        </el-form-item>
        <br>
        <el-form-item label='姓名' prop='name'>
          <el-input v-model='form.name' placeholder='请输入姓名'></el-input>
        </el-form-item>
        <br>
        <el-form-item label='职责' prop='name'>
          <el-input v-model='form.duty' placeholder='请输入职责'></el-input>
        </el-form-item>
        <br>
        <el-form-item label='手机号' prop='name'>
          <el-input v-model='form.phone' placeholder='请输入手机号'></el-input>
        </el-form-item>
        <br>
        <el-form-item label='邮箱' prop='name'>
          <el-input v-model='form.email' placeholder='请输入邮箱'></el-input>
        </el-form-item>
        <br>
      </el-form>

      <div style='text-align: center; margin-top: 30px'>
        <el-button type='primary' size='medium' style='margin-right: 40px'
                   @click='HandlerUpdate'>
          更新
        </el-button>
        <el-button type='primary' size='medium' @click='reset()'>重置</el-button>
      </div>
    </el-card>
  </div>
</template>

<script>
import request from '@/utils/request'

export default {
  name: 'EditInformation',
  data() {
    return {
      form: {}
    }
  },
  created() {
    request.get('Information/' + this.$route.query.id).then(
      res => {
        this.form = res.data
      }
    )
  },
  methods: {
    HandlerUpdate() {
      request.post('Information', this.form).then(
        this.$notify.success('更新成功！')
      )
      this.$router.push('/administrator/PhoneManager')
    },
    reset() {
      this.form = {}
    }
  }
}
</script>

<style scoped>

</style>
