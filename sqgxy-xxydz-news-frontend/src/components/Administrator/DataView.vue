<template>
  <div>


    <el-row :gutter='10' style='margin-bottom: 60px'>
      <el-col :span='6'>
        <el-card style='color: #409EFF'>
          <div><i class='el-icon-user'></i>&emsp;用户总数</div>
          <div style='padding: 10px 0;text-align: center; font-weight: bold'>
            {{this.usernums}}
          </div>
        </el-card>
      </el-col>
      <el-col :span='6'>
        <el-card style='color: #67C23A'>
          <div><i class='el-icon-s-data'></i>&emsp;新闻总数</div>
          <div style='padding: 10px 0;text-align: center; font-weight: bold'>
            {{this.newsnums}}
          </div>
        </el-card>
      </el-col>
      <el-col :span='6'>
        <el-card style='color: #E6A23C'>
          <div><i class='el-icon-postcard'></i>&emsp;一级标题</div>
          <div style='padding: 10px 0;text-align: center; font-weight: bold'>
            {{this.h1nums}}
          </div>
        </el-card>
      </el-col>
      <el-col :span='6'>
        <el-card style='color: #909399'>
          <div><i class='el-icon-postcard'></i>&emsp;二级标题</div>
          <div style='padding: 10px 0;text-align: center; font-weight: bold'>
            {{this.h2nums}}
          </div>
        </el-card>
      </el-col>
    </el-row>

    <el-row>
      <!--    左边内容区域 折线表-->
      <el-col :span="12" style="padding-right:10px">
        <div id="line" style="width: 100%;height: 400px"></div>
      </el-col>
      <!--    右边内容区域 饼图表-->
      <el-col :span="12" >
        <div id="cake" style="width: 100%;height: 400px"></div>
      </el-col>
    </el-row>

  </div>
</template>

<script>

import * as echarts from "echarts"

import { getUserNums, getNewsNums,getH1Nums, getH2Nums,getLine } from '../../api/api'

const option1 = {
  title: {
    text: '发布与阅读'
  },
  tooltip: {
    trigger: 'axis'
  },
  legend: {
    data: ['Announce', 'Read']
  },
  grid: {
    left: '3%',
    right: '4%',
    bottom: '3%',
    containLabel: true
  },
  toolbox: {
    feature: {
      saveAsImage: {}
    }
  },
  xAxis: {
    type: 'category',
    boundaryGap: false,
    data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
  },
  yAxis: {
    type: 'value'
  },
  series: [
    {
      name: 'Announce',
      type: 'line',
      stack: 'Total',
      data: []
    },
    {
      name: 'Read',
      type: 'line',
      stack: 'Total',
      data: [10,6,2,12,5,1,6]
    }


  ]
};
const option2 = {
  title: {
    text: '类型与数量'
  },
  tooltip: {
    trigger: 'item'
  },
  legend: {
    top: '10%',
    left: 'center'
  },
  toolbox: {
    feature: {
      saveAsImage: {}
    }
  },
  series: [
    {
      name: '新闻类别与数量',
      type: 'pie',
      radius: ['55%', '70%'],
      center:['50%','65%'],
      avoidLabelOverlap: false,
      label: {
        show: false,
        position: 'center'
      },
      emphasis: {
        label: {
          show: true,
          fontSize: '25',
          fontWeight: 'bold'
        }
      },
      labelLine: {
        show: false
      },
      data: [
        { value: 1, name: '简介' },
        { value: 1, name: '章程' },
        { value: 7, name: '专业介绍' },
        { value: 6, name: '学院领导' },
        { value: 1, name: '学院风纪' },
        { value: 1, name: '学习建设' },
        { value: 1, name: '考风考纪' },
        { value: 2, name: '竞赛项目一览' },
        { value: 3, name: '往期竞赛项目' },
        { value: 5, name: '书院简介' },
        { value: 3, name: '归德讲堂' },
        { value: 30, name: '通知公告' },
        { value: 30, name: '工作动态' }
      ]
    }
  ]
};

export default {
  name: 'DataView',
  data() {
    return {
      lineBox:null,
      cakeBox:null,
      cylinderBox:null,
      usernums:"",
      newsnums:"",
      h1nums:"",
      h2nums:"",
    }
  },
  //钩子函数 一般用于页面元素完全初始化完成后 调用
  mounted() {
    this.load();
  },
  created() {

  },
  methods:{
    load(){
      if (!this.lineBox){
        this.lineBox=echarts.init(document.getElementById("line"))
      }
      if (!this.cakeBox){
        this.cakeBox=echarts.init(document.getElementById("cake"))
      }
      getUserNums().then(res=>{
        if (res.code==200){
          this.usernums=res.data
        }
      })
      getNewsNums().then(res=>{
        if (res.code==200){
          this.newsnums=res.data
        }
      })
      getH1Nums().then(res=>{
        if (res.code==200){
          this.h1nums=res.data
        }
      })
      getH2Nums().then(res=>{
        if (res.code==200){
          this.h2nums=res.data
        }
      })
      var chartDom = document.getElementById('line');
      var myChart = echarts.init(chartDom);
      getLine().then(res=>{
        if (res.code==200){
          option1.series[0].data = res.data
          this.lineBox.setOption(option1)
          myChart.setOption(option1)
        }
      })
      this.lineBox.setOption(option1)
      this.cakeBox.setOption(option2)
    },

  }
}

</script>

<style scoped>

</style>
