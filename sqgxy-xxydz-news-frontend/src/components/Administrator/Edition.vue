<template>
<div>
  <div></div>
  <div class="block">
    <el-timeline>
      <el-timeline-item timestamp="2023/11/30" placement="top">
        <el-card>
          <h4>
            <el-link type="success" @click="drawer = true">
            提交最终版 模板(v1.0.3)
          </el-link>
          </h4>
          <p>xmp 提交于 2023/11/30 16:46</p>
        </el-card>
      </el-timeline-item>

      <el-drawer
        title="我是标题"
        :visible.sync="drawer"
        :with-header="false">
        <span>
          <el-card class='li-c'>
            <i class='el-icon-sunny'></i>&emsp;优化部分UI设计
          </el-card>
          <el-card class='li-c'>
            <i class='el-icon-s-flag'></i>&emsp;添加校园地图浏览功能以及定位功能
          </el-card>
          <el-card class='li-c'>
           <i class='el-icon-s-data'></i>&emsp;添加管理员数据分析模块
          </el-card>
        </span>
      </el-drawer>

      <el-timeline-item timestamp="2023/11/28" placement="top">
        <el-card>
          <h4>更新 Github 模板 (v1.0.2)</h4>
          <p>xmp 提交于  2023/11/28 23:03</p>
        </el-card>
      </el-timeline-item>
      <el-timeline-item timestamp="2023/11/26" placement="top">
      <el-card>
        <h4>更新 Github 模板 (v1.0.1)</h4>
        <p>ljz 提交于  2023/11/26 20:46</p>
      </el-card>
    </el-timeline-item>
      <el-timeline-item timestamp="2023/11/22" placement="top">
        <el-card>
          <h4>更新 Github (v1.0.0)</h4>
          <p>xmp 提交于  2023/11/22 17:32</p>
        </el-card>
      </el-timeline-item>
      <el-timeline-item>
        <el-card>
          <h4>初始化 Github 模板</h4>
          <p>xmp 提交于  2023/11/19 23:50</p>
        </el-card>
      </el-timeline-item>
      <el-timeline-item timestamp="2023/11/19" placement="top">
        <el-card>
          <h4>需求分析，任务分配</h4>
          <p>xmp 提交于  2023/11/16 11:00</p>
        </el-card>
      </el-timeline-item>
    </el-timeline>
  </div>
</div>
</template>

<script>
export default {
  name: 'Edition',
  data() {
    return {
      drawer: false,

    };
  },
}
</script>

<style scoped>

.li-c{
  margin: 2px;
}

</style>
