<template>
  <div>

    <div style='margin:  0'>

      <el-button type='primary' @click='AddExstar()' style='margin-right: 55%'>
        <i class='el-icon-circle-plus'></i>添加
      </el-button>

      <el-input style='width: 300px;margin-right: 35px'
                placeholder='按姓名查询' v-model='name'>
      </el-input>

      <el-button type='warning' style='margin-left:5px' @click='reset'>
        <i class='el-icon-refresh-right'></i>重置
      </el-button>
    </div>

    <el-table
      :data='tableData'>
      <el-table-column
        prop='id'
        label='学号' style='width: 50px'>
      </el-table-column>
      <el-table-column
        prop='duty'
        label='职责'>
      </el-table-column>
      <el-table-column
        prop='name'
        label='姓名'>
      </el-table-column>
      <el-table-column
        prop='phone'
        label='手机号'>
      </el-table-column>
      <el-table-column
        prop='email'
        label='邮箱'>
      </el-table-column>
      <el-table-column
        prop='opera'
        label='操作'>
        <template v-slot='scope'>
          <el-button style='width: 66px;text-align: center'
                     @click="$router.push('EditInformation?id='+scope.row.id)"
                     type='info'>
            编辑
          </el-button>
          <el-button style='width: 66px;text-align: center' type='danger'
                     @click='HandleDel(scope.row.id)'
          >
            删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

  </div>
</template>

<script>
import request from '@/utils/request'

export default {
  name: 'PhoneManager',
  data() {
    return {
      tableData: [],
      name: ''
    }
  },
  created() {
    this.load()
  },
  methods: {
    //加载数据
    load() {
      //发送请求
      request.get('/Information/all'
      ).then(res => {
        if (res.code === 200) {
          this.tableData = res.data
        }

      })
    },
    //重置表单
    reset() {
      this.name = ''
    },
    //删除用户
    HandleDel(id) {
      request.delete('/Information/' + id).then(
        this.$message('删除成功')
      )
    },
    AddExstar() {
      this.$router.push('/administrator/addInformationView')
    }
  }
}
</script>

<style scoped>

</style>
