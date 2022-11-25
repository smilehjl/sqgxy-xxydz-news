<template>
  <div>

    <div style='margin:  0'>

      <el-button type='primary' @click='AddExstar()' style='margin-right: 48%'>
        <i class='el-icon-circle-plus'></i>添加
      </el-button>

      <el-input style='width: 300px;margin-right: 15px'
                placeholder='按姓名查询' v-model='name'
      >
      </el-input>

      <el-button type='primary' style='margin-right:15px' @click='findname()'>
        <i class='el-icon-search'></i>
        搜索
      </el-button>

      <el-button type='warning' style='margin-left:5px' @click='reset'>
        <i class='el-icon-refresh-right'></i>重置
      </el-button>
    </div>
    <el-table :data='tableData'>
      <el-table-column prop='id' label='编号' min-width='20%'></el-table-column>
      <el-table-column prop='xueno' label='学号' min-width='30%'></el-table-column>
      <el-table-column prop='name' label='姓名' min-width='30%'></el-table-column>
      <el-table-column prop='starname' label='荣誉' min-width='30%'></el-table-column>
      <el-table-column prop='example' label='事例' min-width='130%'>
        <template slot-scope="scope">
          <div  @click="dialogVisible = true" style='cursor: pointer'>{{scope.row.example}}</div>
        </template>
      </el-table-column>

      <el-table-column prop='opera' label='操作'>
        <template v-slot='scope'>
          <el-button style='width: 66px;text-align: center' @click="$router.push('EditXdstar?id='+scope.row.id)"
                     type='info'>
            编辑
          </el-button>
          <el-button style='width: 66px;text-align: center' type='danger' @click='HandleDel(scope.row.id)'>
            删除
          </el-button>
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

    <el-dialog
      title='事例详情'
      :visible.sync='dialogVisible'
      width='65%'
      :before-close='handleClose'>
      <div v-html="content" class="ql-editor"></div>
      <span slot='footer' class='dialog-footer'>
    <el-button @click='dialogVisible = false'>取 消</el-button>
    <el-button type='primary' @click='dialogVisible = false'>确 定</el-button>
  </span>
    </el-dialog>
  </div>

</template>

<script>

import request from '../../../utils/request'

export default {

  name: 'XdStarManager',
  data() {
    return {
      dialogVisible: false,
      tableData: [],
      currentpage: 1,
      pagesize: 5,
      total: 0,
      name: '',
    }
  },
  created() {
    this.load()
  },
  methods: {
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done()
        })
        .catch(_ => {
        })
    },
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
    },
    /*load() {
      //发送请求
      request.get('/XdStar/all'
      ).then(res => {
        if (res.code === 200) {
          this.tableData = res.data
        }

      })
    }*/
    //重置表单
    reset() {
      this.name = ''
    },
    //删除用户
    HandleDel(id) {
      request.delete('/XdStar/' + id).then(
        this.$message('删除成功')
      )
    },
    AddExstar() {
      this.$router.push('/administrator/addXdstarView')
    },
    //模糊查询
    findname() {
      request.get('/XdStar/like/?name=' + this.name).then(res => {
        if (res.code === 200) {
          this.tableData = res.data
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
