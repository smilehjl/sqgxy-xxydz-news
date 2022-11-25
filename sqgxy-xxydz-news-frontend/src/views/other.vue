<template>
  <div>
    <div>
      <el-row class="underline marb5">
        <span class="color"><b>友情链接</b></span>
      </el-row>
      <div>
        <div class="aLianJ marb10">
          <a href="http://www.sqgxy.edu.cn/Html/jiaoxuejigou/gongchengguanlixi/" class="anone" target="_block">机械工程学院</a>
        </div>
        <div class="aLianJ marb10">
          <a href="http://www.sqgxy.edu.cn/Html/jiaoxuejigou/jianzhugongchengxi/" class="anone" target="_block">土木工程学院</a>
        </div>
        <div class="aLianJ marb10">
          <a href="http://www.sqgxy.edu.cn/Html/jiaoxuejigou/jingjimaoyiguanlixi/" class="anone" target="_block">经济与管理学院</a>
        </div>
        <div class="aLianJ marb10">
          <a href="http://www.sqgxy.edu.cn/Html/jiaoxuejigou/wenhuachuanboxi/" class="anone" target="_block">教育与现代艺术学院</a>
        </div>
        <div class="aLianJ marb10">
          <a href="http://www.sqgxy.edu.cn/Html/jiaoxuejigou/nursing/" class="anone" target="_block">医学院</a>
        </div>
        <div class="aLianJ marb10">
          <a href="http://www.sqgxy.edu.cn/Html/jiaoxuejigou/wunianzhidazhuanbu/" class="anone" target="_block">基础教育部</a>
        </div>
        <div class="aLianJ marb10">
          <a href="http://www.sqgxy.edu.cn/Html/jiaoxuejigou/sxzzjxb/" class="anone" target="_block">马克思主义学院</a>
        </div>
        <div class="aLianJ marb10">
          <a href="http://www.sqgxy.edu.cn/index.html" class="anone" target="_block">体育教学部</a>
        </div>
        <div class="aLianJ marb10">
          <a href="https://blog.csdn.net/qq_53463544?spm=1000.2115.3001.5343" class="anone" target="_block">sqgxy-xxydz-news</a>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: 'other',
  data() {
    return {
      lianJieList: [{ name: '链接1' }, { name: '链接2' }]
    }
  }
}
</script>
<style lang="less" scoped>
.underline {
  border-bottom: 1px solid rgb(1, 72, 153);
}
.aLianJ {
  height: 30px;
  background-color: rgb(242, 243, 244);
  text-align: center;
  line-height: 30px;
}
.bg {
  background-color: rgb(1, 72, 153) !important;
  background: url('../assets/wxbg.png') no-repeat 20px 50px;
  width: 90%;
  color: white;
}
.bg2 {
  background: url('../assets/wbbg.png') no-repeat 20px 50px;
}
.bg,
.bg2 {
  position: relative;
  height: 120px;
}
.bg img {
  position: absolute;
  top: 12px;
  right: 26px;
}
.bg span {
  position: absolute;
  top: 20px;
  left: 25px;
}
</style>
