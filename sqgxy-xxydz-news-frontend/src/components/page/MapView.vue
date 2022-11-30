<template>
  <div>
    <el-button @click="$router.push('home/index')" style='position: absolute;right: 0;z-index: 99;'>返回主页</el-button>
    <el-tabs v-model='activeName' type='card' @tab-click='handleClick'>
      <el-tab-pane label='平面地图' name='first'>
        <div id='container' style='width: 100% ;height: calc(100vh - 60px)'></div>
      </el-tab-pane>
      <el-tab-pane label='3D地图' name='second'>
        <div id='allmap' style='width: 100% ;height: calc(100vh - 60px)'></div>
      </el-tab-pane>
      <el-tab-pane label='我的位置' name='third'>
        <div id='mymap' style='width: 100% ;height: calc(100vh - 60px)'></div>
      </el-tab-pane>
    </el-tabs>
  </div>

</template>

<script>
var content = [
  '<div style=\'font-size: 14px; color: red; width: 200px; height: 70px\'>商丘工学院老校区，位于河南省商丘市，' +
  '是经教育部批准的一所地方性、应用型省属民办普通本科高校。</div>'
]
export default {
  name: 'MapView',
  data() {
    return {
      activeName: 'third'
    }
  },
  created() {
  },
  mounted() {

    // 我的位置 Ip
    /* var mymap = new BMapGL.Map("mymap");
     var point = new BMapGL.Point(116.331398,39.897445);
     mymap.centerAndZoom(point,12);

     function myFun(result){
       var cityName = result.name;
       mymap.setCenter(cityName);
       alert("当前定位城市:" + cityName);
     }
     var myCity = new BMapGL.LocalCity();
     myCity.get(myFun);*/

    // 我的位置 浏览器
    var mymap = new BMapGL.Map('mymap')
    var point = new BMapGL.Point(116.331398, 39.897445)
    mymap.centerAndZoom(point, 12)

    var geolocation = new BMapGL.Geolocation()
    geolocation.getCurrentPosition(function(r) {
      if (this.getStatus() == BMAP_STATUS_SUCCESS) {
        var mk = new BMapGL.Marker(r.point)
        mymap.addOverlay(mk)
        mymap.panTo(r.point)
        alert('您的位置：' + r.point.lng + ',' + r.point.lat)
      } else {
        alert('failed' + this.getStatus())
      }
    })
    var scaleCtrl = new BMapGL.ScaleControl()  // 添加比例尺控件
    mymap.addControl(scaleCtrl)
    var zoomCtrl = new BMapGL.ZoomControl()  // 添加缩放控件
    mymap.addControl(zoomCtrl)


    // 百度3D地图
    var baidumap = new BMapGL.Map('allmap')
    baidumap.centerAndZoom(new BMapGL.Point(115.695358, 34.425565), 19)
    baidumap.enableScrollWheelZoom(true)
    baidumap.setHeading(64.5)
    baidumap.setTilt(73)
    var geolocation = new BMapGL.Geolocation()
    geolocation.getCurrentPosition(function(r) {
      if (this.getStatus() == BMAP_STATUS_SUCCESS) {
        var mk = new BMapGL.Marker(r.point)
        baidumap.addOverlay(mk)
        baidumap.panTo(r.point)
        alert('您的位置：' + r.point.lng + ',' + r.point.lat)
      } else {
        alert('failed' + this.getStatus())
      }
    })
    var scaleCtrl = new BMapGL.ScaleControl()  // 添加比例尺控件
    baidumap.addControl(scaleCtrl)
    var zoomCtrl = new BMapGL.ZoomControl()  // 添加缩放控件
    baidumap.addControl(zoomCtrl)


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

    //map.on('click', clickHandler) // 坐标 绑定事件

    var marker = new AMap.Marker({  // marker 实例
      position: new AMap.LngLat(115.688379, 34.420832),
      title: '商丘工学院',
      icon: '../../../favicon.ico'
    })

    marker.on('click', clickHandler) // marker绑定事件

    map.add(marker) // 将创建的点标记添加到已有的地图实例

  },
  methods: {
  handleClick(tab, event)
  {
    console.log(tab, event)
  }

}
}
</script>

<style scoped>

</style>
