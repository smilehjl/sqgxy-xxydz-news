<template>
  <div>
    <el-row :gutter='20'>
      <el-col :span='10'>
        <el-card shadow='hover' style='width: 100%;'>
          <div slot='header' class='clearfix'>
            <span>文嘉《明日歌》</span>
            <el-button style='float: right; padding: 3px 0' type='text' @click='clickFn'>暂停</el-button>
          </div>
          <div style='font-size: 18px;text-align: center; '>明日复明日</div>
          <div style='font-size: 18px;text-align: center;'>明日何其多</div>
          <div style='font-size: 18px;text-align: center;'>我生待明日</div>
          <div style='font-size: 18px;text-align: center;'>万事成蹉跎</div>
          <div style='margin-top: 40px;'></div>
          <el-statistic ref='statistic' @finish='hilarity' format='HH:mm:ss' :value='deadline4' title='距离明日：'time-indices></el-statistic>
        </el-card>
      </el-col>
      <el-col :span='14'>
        <div style='margin: 16px'>
          <h4>代办事项</h4>
        </div>
        <el-empty description="暂无"></el-empty>
      </el-col>
    </el-row>

  </div>
</template>

<script>

export default {
  name: 'agency',
  data() {
    return {
      activeNames: ['1'],
      format:'HH小时:mm:ss:SSS',
      deadline: Date.now() + 1000 * 60 * 60 * 24 * 2,
      deadline4: Date.now() + (new Date().setHours(23,59,59)-Date.now()) ,
    }
  },
  created() {},
  methods:{
    handleChange(val) {
      console.log(val);
    },
    clickFn(){
      this.$refs.statistic.suspend( this.stop)
      this.stop=!this.stop
    },
    add(){
      this.deadline3= this.deadline3+ 1000 * 10
    }
  }
}
</script>

<style scoped>

</style>
