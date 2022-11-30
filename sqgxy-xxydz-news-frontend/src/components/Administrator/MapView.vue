<template>

  <el-tabs v-model='activeName' type='card' @tab-click='handleClick' style='margin: 2px;margin-top: -13px;'>
    <el-tab-pane label='平面地图' name='first'>
      <div id='container' style='width: 100% ;height: calc(100vh - 145px)'></div>
    </el-tab-pane>
    <el-tab-pane label='3D地图' name='second'>
      <div id='allmap' style='width: 100% ;height: calc(100vh - 145px)'></div>
    </el-tab-pane>
  </el-tabs>


</template>

<script>
var content = [
  '<div style=\'font-size: 14px; color: red; width: 200px; height: 70px\'>商丘工学院老校区，位于河南省商丘市，是经教育部批准的一所地方性、应用型省属民办普通本科高校。</div>'
]
export default {
  name: 'Map',
  data() {
    return {
      activeName: 'first'
    }
  },
  created() {
  },
  mounted() {

    // 百度地图
    var baidumap = new BMapGL.Map('allmap')
    baidumap.centerAndZoom(new BMapGL.Point(115.695358, 34.425565), 19)
    baidumap.enableScrollWheelZoom(true)
    baidumap.setHeading(64.5)
    baidumap.setTilt(73)

    // 创建地图实例 -- 高德地图
    var map = new AMap.Map('container', {
      zoom: 16,
      center: [115.688379, 34.420832]
    })

    var infoWindow = new AMap.InfoWindow({
      anchor: 'top-left',
      content: content.join('<br>')  //传入 dom 对象，或者 html 字符串
    })

    var clickHandler = function(e) {
      //alert('您在[ '+e.lnglat.getLng()+','+e.lnglat.getLat()+' ]的位置点击了地图！');
      console.log('您在[ ' + e.lnglat.getLng() + ',' + e.lnglat.getLat() + ' ]的位置点击了地图！')

      infoWindow.open(map, [115.688379, 34.420832])  //打开窗体
    }

    //map.on('click', clickHandler); // 坐标 绑定事件

    var marker = new AMap.Marker({  // marker 实例
      position: new AMap.LngLat(115.688379, 34.420832),
      title: '商丘工学院',
      icon: '//vdata.amap.com/icons/b18/1/2.png'
    })

    marker.on('click', clickHandler) // marker绑定事件

    map.add(marker) // 将创建的点标记添加到已有的地图实例

  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event)
    }
  }
}
</script>

<style scoped>

</style>
