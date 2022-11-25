<template>
  <div>
    <el-table
      :data='tableData'>
      <el-table-column prop='id' label='编号'></el-table-column>
      <el-table-column prop='xueno' label='学号'></el-table-column>
      <el-table-column prop='name' label='姓名'></el-table-column>
      <el-table-column prop='starname' label='荣誉'></el-table-column>
      <el-table-column prop='example' label='事例'></el-table-column>
      <el-table-column
        prop='opera'
        label='操作'>
        <template v-slot='scope'>
          <a style='color: #0f99e9;cursor: pointer' @click="$router.push('StarDetail?id='+scope.row.id)">详&emsp;情</a>
        </template>
      </el-table-column>
    </el-table>
    <!--  分页-->
    <div>
      <el-pagination
        background
        layout='prev, pager, next'
        :current-page='this.currentpage'
        :page-size='this.pagesize'
        :total=this.total
        @current-change='CurrentChange'
      >
      </el-pagination>
    </div>
  </div>
</template>

<script>
import globalTitle from '../GlobalTitle.vue'
import request from '@/utils/request'

export default {
  components: { globalTitle },
  name: 'Star',
  data() {
    return {
      tableData: [],
      currentpage: 1,
      pagesize: 6,
      total: 0
    }
  },
  created() {
    this.load()
  },
  methods: {
    //加载数据
    load() {
      //发送请求
      request.get('/XdStar/querypage?currentpage=' + this.currentpage + '&pagesize=' + this.pagesize
      ).then(res => {
        if (res.code === 200) {
          console.log(res.data)
          this.tableData = res.data.xdstarList
          this.total = res.data.datalength
        }
      })
    },
    CurrentChange(pageNum) {
      this.currentpage = pageNum
      this.load()
    }
    /*  //加载数据
      load() {
        //发送请求
        request.get('/XdStar/all'
        ).then(res => {
          if (res.code === 200) {
            this.tableData = res.data
          }

        })
      },*/
  }
}
</script>

<style lang='less' scoped>
h4 {
  text-align: center;
  margin-top: 0;
}

.mart10 {
  margin-top: 10px;
}
</style>
