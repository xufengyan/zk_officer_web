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

      <el-table-column align="center" label="操作" width="100" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
          <!--          <el-button type="danger" size="mini" @click="handleDelete(scope.row)">删除</el-button>-->
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
// import { listGoods, deleteGoods } from '@/api/basic'
import BackToTop from '@/components/BackToTop'
import Pagination from '@/components/Pagination' // Secondary package based on el-pagination

export default {
  name: 'GoodsList',
  components: { BackToTop, Pagination },
  data() {
    return {
      list: [{
        id: '1',
        owLogo: 'http://localhost:8089/admin/storage/fetch/sl9q336i0u1ew2p7kv8m.jpg',
        owName: '深圳致开科技有限公司',
        owQrcodePath: 'http://localhost:8089/admin/storage/fetch/sl9q336i0u1ew2p7kv8m.jpg',
        owPhoneName: '全国统一咨询热线',
        owPhone: '0755-2720-2606',
        owTel: '13530108906',
        owWoekTime: '周一至周日 9:00-18:00 (节假日除外)',
        owInternetcp: '深圳致开科技有限公司 版权所有 Copyright © 2015-2018 粤ICP备16004202号',
        owMail: 'allen.cao@chiky.cn',
        owAddress: '深圳宝安区盐田商务广场A座409、405、411、413',
        owUrl: ' www.chikytech.com'
      }],
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
      goodsDetail: '',
      detailDialogVisible: false,
      downloadLoading: false
    }
  },
  created() {
    // this.getList()
  },
  methods: {
    // getList() {
    //   this.listLoading = true
    //   listGoods(this.listQuery).then(response => {
    //     this.list = response.data.data.list
    //     this.total = response.data.data.total
    //     this.listLoading = false
    //   }).catch(() => {
    //     this.list = []
    //     this.total = 0
    //     this.listLoading = false
    //   })
    // },
    // handleFilter() {
    //   this.listQuery.page = 1
    //   this.getList()
    // },
    // handleCreate() {
    //   this.$router.push({ path: '/goods/create' })
    // },
    handleUpdate(row) {
      this.$router.push({ path: '/basic/update', query: { id: row.id }})
    }
    // showDetail(detail) {
    //   this.goodsDetail = detail
    //   this.detailDialogVisible = true
    // },
  }
}
</script>
