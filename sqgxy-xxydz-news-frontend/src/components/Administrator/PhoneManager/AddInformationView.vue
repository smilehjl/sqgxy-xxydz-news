<template>
  <div style='width: 60%;margin-top: 20px;margin-left: 15px'>
    <el-card class='box-card'>
      <div style='margin-bottom: 30px;margin-left: 48px;margin-top: 30px;color: #636262'><h3>添加联系方式</h3></div>
      <el-form :inline='true' ref='ruleForm' label-width='100px'>
        <el-form-item label='职责' prop='name'>
          <el-input v-model='form.duty' placeholder='请输入职责'></el-input>
        </el-form-item>
        <br>
        <el-form-item label='姓名' prop='name'>
          <el-input v-model='form.name' placeholder='请输入姓名'></el-input>
        </el-form-item>
        <br>
        <el-form-item label='电话' prop='name'>
          <el-input v-model='form.phone' placeholder='请输入电话'></el-input>
        </el-form-item>
        <el-form-item label='邮箱' prop='name'>
          <el-input v-model='form.email' placeholder='请输入邮箱'></el-input>
        </el-form-item>
      </el-form>

      <div style='text-align: center; margin-top: 30px'>
        <el-button type='primary' size='medium' style='margin-right: 40px'
                   @click='HandlerAdd()'>
          添加
        </el-button>
        <el-button type='primary' size='medium' @click='reset()'>重置</el-button>
      </div>
    </el-card>
  </div>
</template>

<script>
import request from '@/utils/request'

export default {
  name: 'addInformationView',
  data() {
    return {
      form: {}
    }
  },
  methods: {
    HandlerAdd() {
      request.put('/Information', this.form).then(
        this.$notify.success('添加成功！'),
          // todo 强制刷新

          location. reload(),
          this.$router.go(0)
// 这两种都可以刷新当前页面的，缺点就是相当于按ctrl+F5 强制刷新那种，整个页面重新加载，会出现一个瞬间的空白页面，体验不好。


    )
      this.$router.push('/administrator/PhoneManager')
    }, reset() {
      this.form = {}
    }
  }
}
</script>

<style scoped>

</style>
