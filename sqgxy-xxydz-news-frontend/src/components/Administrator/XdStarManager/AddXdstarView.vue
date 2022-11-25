<template>
  <div style='width: 60%;margin-top: 20px;margin-left: 15px'>
    <el-card class='box-card'>
      <div style='margin-bottom: 30px;margin-left: 48px;margin-top: 30px;color: #636262'><h3>新增信电之星</h3></div>
      <el-form :inline='true' ref='ruleForm' label-width='100px'>
        <el-form-item label='编号' prop='name'>
          <el-input v-model='form.id' placeholder='请输入编号'></el-input>
        </el-form-item>
        <br>
        <el-form-item label='学号' prop='name'>
          <el-input v-model='form.xueno' placeholder='请输入学号'></el-input>
        </el-form-item>
        <br>
        <el-form-item label='姓名' prop='name'>
          <el-input v-model='form.name' placeholder='请输入姓名'></el-input>
        </el-form-item>
        <br>
        <el-form-item label='荣誉' prop='name'>
          <el-input v-model='form.starname' placeholder='请输入姓名'></el-input>
        </el-form-item>
        <br>
        <el-form-item label='事例' prop='example'>
          <el-input type='textarea' v-model='form.example'
                    style='min-width: 300px' placeholder='请输入示例'></el-input>
        </el-form-item>
      </el-form>
      <div style='text-align: center; margin-top: 30px'>
        <el-button type='primary' size='medium' style='margin-right: 40px' @click='HandlerAdd()'>添加</el-button>
        <el-button type='primary' size='medium' @click='reset()'>重置</el-button>
      </div>
    </el-card>
  </div>
</template>

<script>
import request from '../../../utils/request'

export default {
  name: 'AddXdstarView',
  data() {
    return {
      form: {}
    }
  },
  methods: {
    HandlerAdd() {
      request.put('/XdStar', this.form).then(
        this.$notify.success('添加成功！')
      )
      this.$router.push('/administrator/XdStarManager')
    }, reset() {
      this.form = {}
    }
  }
}
</script>

<style scoped>
</style>
