<template>
  <div>
    <el-row>
      <div class='fl'>
        <span><b>{{ getTitle(this.$route.query.title) }}</b></span>
      </div>
      <div class='fr'>
        <el-breadcrumb separator-class='el-icon-arrow-right'>
          <el-breadcrumb-item>首页</el-breadcrumb-item>
          <el-breadcrumb-item>{{ getTitle(this.$route.query.title) }}</el-breadcrumb-item>
        </el-breadcrumb>
      </div>
    </el-row>
  </div>
</template>
<script>
export default {
  name: 'globalTitle',
  data() {
    return {
      title: ''
    }
  },
  created() {
  },
  methods: {
    getTitle(v) {
      switch (v) {
        case 'introduce':
          return '走进信电'
        case 'XueFengBuild':
          return '学风建设'
        case 'Star':
          return '信电之星'
        case 'Competition':
          return '学科竞赛'
        case 'HistoryStudy':
          return '党史学习'
        case 'Academy':
          return '归德书院'
        case 'Sqgxy':
          return '学校首页'
        case 'Info':
          return '联系我们'
      }
    }
  }
}
</script>

<style scoped>
.el-row {
  /* background-color: rgb(83, 168, 125); */
  border-bottom: 1px solid #0f99e9;
}
</style>
