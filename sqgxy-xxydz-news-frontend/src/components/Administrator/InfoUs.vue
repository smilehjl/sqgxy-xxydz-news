<template>
  <el-descriptions class='margin-top' title='关于我们'
                   :column='2'
                   :size='size' border
                   style='margin: 30px'>
    <el-descriptions-item>
      <template slot='label'>
        <i class='el-icon-user'></i>
        组名
      </template>
      xmp
    </el-descriptions-item>
    <el-descriptions-item>
      <template slot='label'>
        <i class='el-icon-mobile-phone'></i>
        联系方式
      </template>
      3050608872@qq.com
    </el-descriptions-item>
    <el-descriptions-item>
      <template slot='label'>
        队员幸福指数
      </template>
      <i class='el-icon-star-on' style='color: red'></i>
      <i class='el-icon-star-on' style='color: red'></i>
      <i class='el-icon-star-on' style='color: red'></i>
      <i class='el-icon-star-on' style='color: red'></i>
      <i class='el-icon-star-on' style='color: red'></i>
    </el-descriptions-item>
    <el-descriptions-item>
      <template slot='label'>
        <i class='el-icon-tickets'></i>
        技术选型
      </template>
      后端：
      <el-tag class='tag' size='small'>SpringBoot</el-tag>
      <el-tag class='tag' size='small'>Shiro</el-tag>
      <el-tag class='tag' size='small'>MyBatis-Plus</el-tag>
      <br>
      前端：
      <el-tag class='tag' size='small'>Vue</el-tag>
      <el-tag class='tag' size='small'>Element-Ui</el-tag>
      <el-tag class='tag' size='small'>vue-quill-editor</el-tag>

    </el-descriptions-item>
    <el-descriptions-item>
      <template slot='label'>
        <i class='el-icon-date'></i>
        备注
      </template>
      &emsp;&emsp;本系统由熊民普、霍文妍无、张强、李嘉哲、马紫薇共同开发，数据库设计统一按照阿里巴巴数据库开发规范；后端采用SpringBoot+MyBatisPlus框架快速搭建,并封装接口返回数据的统一结构；前端采用Vue+ElementUi来编写
      前端页面，其中还是用到了富文本编辑器等等插件；UI设计风格统一，严格统一大小色彩；文章内容确保真实爬取。虽然开发过程艰难，在我们的不懈努力下，也有很多不足，不过最后也算完成了，
      送给我们自己一句话，论失败多少次，都要积极面对生活，满怀希望。
    </el-descriptions-item>
  </el-descriptions>

</template>

<script>
export default {
  name: 'InfoUs'
}
</script>

<style scoped>

.tag {
  margin: 2px;
}

</style>
