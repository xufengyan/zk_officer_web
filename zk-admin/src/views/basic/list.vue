<template>
  <div class="app-container">
    <!-- 查询结果 -->
    <el-table v-loading="listLoading" :data="list" element-loading-text="正在查询中。。。" border fit highlight-current-row>

      <el-table-column type="expand">
        <template slot-scope="props">
          <el-form label-position="left" class="table-expand">
            <el-form-item label="编号">
              <span>{{ props.row.id }}</span>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>

      <el-table-column align="center" label="ID" prop="id" />

      <el-table-column align="center" min-width="100" label="名称" prop="owName" />

      <el-table-column align="center" property="iconUrl" label="logo">
        <template slot-scope="scope">
          <img :src="scope.row.owLogo" width="100">
        </template>
      </el-table-column>
      <el-table-column align="center" property="iconUrl" label="公司二维码">
        <template slot-scope="scope">
          <img :src="scope.row.owQrcodePath" width="100">
        </template>
      </el-table-column>
      <el-table-column align="center" min-width="100" label="电话" prop="owPhone" />
      <el-table-column align="center" min-width="100" label="手机" prop="owTel" />
      <el-table-column align="center" min-width="100" label="工作时间" prop="owWoekTime" />
      <el-table-column align="center" min-width="100" label="备案" prop="owInternetcp" />
      <el-table-column align="center" min-width="100" label="公司网址" prop="owUrl" />
      <el-table-column align="center" min-width="100" label="公司地址" prop="owAddress" />
      <el-table-column align="center" min-width="100" label="公司邮箱" prop="owMail" />
      <el-table-column align="center" min-width="100" label="语言类型" prop="lan" />

      <el-table-column align="center" label="操作" width="100" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="" />

    <el-tooltip placement="top" content="返回顶部">
      <back-to-top :visibility-height="100" />
    </el-tooltip>

  </div>
</template>

<style>
  .table-expand {
    font-size: 0;
  }
  .table-expand label {
    width: 100px;
    color: #99a9bf;
  }
  .table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
  }
  .gallery {
    width: 80px;
    margin-right: 10px;
  }
  .goods-detail-box img {
    width: 100%;
  }
</style>

<script>
import { listBasic, readBasic } from '@/api/basic'
import BackToTop from '@/components/BackToTop'
import Pagination from '@/components/Pagination' // Secondary package based on el-pagination

export default {
  name: 'BasicList',
  components: { BackToTop, Pagination },
  data() {
    return {
      list: [],
      total: 0,
      listLoading: false,
      listQuery: {
        page: 1,
        limit: 20,
        goodsSn: undefined,
        name: undefined,
        sort: 'add_time',
        order: 'desc'
      },
    }
  },
  created() {
    this.getList()
  },
  methods: {
    getList() {
      this.listLoading = true
      listBasic(this.listQuery).then(response => {
        this.list = response.data.data.list
        this.total = response.data.data.total
        this.listLoading = false
      }).catch(() => {
        this.list = []
        this.total = 0
        this.listLoading = false
      })
    },
    handleFilter() {
      this.listQuery.page = 1
      this.getList()
    },
    handleUpdate(row) {
      this.$router.push({ path: '/basic/update', query: { id: row.id }})
    }
  }
}
</script>
