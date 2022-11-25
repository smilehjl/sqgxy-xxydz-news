<template>
  <div>
    <globalTitle />
    <el-card class='card'>
      <div class='max'>
        <div class='left'>
          <el-card style='' class='img'>
            <p>微信公众号</p>
            <img src='../../assets/weixin-lanse.png' alt='' />
          </el-card>
          <el-card style='' class='img'>
            <p>新浪微博</p>
            <img src='../../assets/weibo-lanse.png' alt='' />
          </el-card>
        </div>
        <div class='right'>
          <el-table
            :data='tableData'>
            <!--        <el-table-column
                            prop='id'
                            label='序号'>
                          </el-table-column>-->
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
              label='手机号码'>
            </el-table-column>
            <el-table-column
              prop='email'
              label='邮箱'>
            </el-table-column>
          </el-table>
        </div>
      </div>
    </el-card>
  </div>
</template>

<script>
import globalTitle from '../GlobalTitle.vue'
import request from '@/utils/request'

export default {
  components: { globalTitle },
  name: 'Info',
  data() {
    return {
      tableData: []
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
    }
  }
}
</script>

<style lang='less' scoped>
.card {
  margin-top: 10px;
}

.max {
  display: flex;
  justify-content: space-between;
}

p {
  text-align: center;
}

.right {
  width: 800px;
  margin-right: 50px;
}

.left {
  width: 200px;
}

.img {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}
</style>
