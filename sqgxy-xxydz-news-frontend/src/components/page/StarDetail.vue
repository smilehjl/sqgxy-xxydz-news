<template>
  <div>
    <el-descriptions class='margin-top' title='优秀事例详情'
                     :column='3' border
                     style='margin: 30px;color: #0f99e9;'>
      <el-descriptions-item>
        <template slot='label' style='min-width: 140px'>
          <i class='el-icon-user'></i>
          姓名
        </template>
        {{ name }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot='label'>
          学号
        </template>
        {{ xueno }}
      </el-descriptions-item>

      <el-descriptions-item>
        <template slot='label'>
          <i class='el-icon-tickets'></i>
          证书编号
        </template>
        {{ ida }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot='label' style='min-width: 140px'>
          <i class='el-icon-date'></i>
          优秀事例
        </template>
        {{ examplea }}
      </el-descriptions-item>
    </el-descriptions>
    <div>
    </div>
  </div>
</template>

<script>
import request from '@/utils/request'

export default {
  name: 'StarDetail',
  data() {
    return {
      ida: '',
      name: '',
      xueno: '',
      examplea: ''
    }
  },
  created() {
    this.load()
  },
  methods: {
    //加载数据
    load() {
      request.get('XdStar/' + this.$route.query.id).then(
        res => {
          this.ida = res.data.id
          this.name = res.data.name
          this.xueno = res.data.xueno
          this.examplea = res.data.example
        }
      )
    }
  }
}
</script>

<style scoped>

</style>
