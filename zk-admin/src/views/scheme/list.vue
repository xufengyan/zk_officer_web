<template>
  <div class="app-container">
    <!-- 查询和其他操作 -->
    <div class="filter-container">
      <el-form ref="download" label-width="150px">
        <el-form-item label="语言类型" prop="luaIds">
          <el-cascader :value="luaIds" :options="luaList" expand-trigger="hover" @change="handleLuaChange" />
        </el-form-item>
      </el-form>
      <!--      <el-input v-model="listQuery.goodsId" clearable class="filter-item" style="width: 160px;" placeholder="请输入商品ID" />-->
      <!--      <el-input v-model="listQuery.goodsSn" clearable class="filter-item" style="width: 160px;" placeholder="请输入商品编号" />-->
      <!--      <el-input v-model="listQuery.name" clearable class="filter-item" style="width: 160px;" placeholder="请输入商品名称" />-->
      <!--      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查找</el-button>-->
      <el-button class="filter-item" type="primary" icon="el-icon-edit" @click="handleCreate">添加</el-button>
      <!--      <el-button :loading="downloadLoading" class="filter-item" type="primary" icon="el-icon-download" @click="handleDownload">导出</el-button>-->
    </div>
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

      <el-table-column align="center" min-width="100" label="方案名称" prop="sName" />

      <el-table-column align="center" property="iconUrl" label="方案图">
        <template slot-scope="scope">
          <img :src="scope.row.sImagePath" width="100">
        </template>
      </el-table-column>

      <!--      <el-table-column align="center" min-width="100" label="方案内容" prop="sContent" />-->
      <!--      <el-table-column align="center" min-width="100" label="手机" prop="owTel" />-->
      <!--      <el-table-column align="center" min-width="100" label="工作时间" prop="owWoekTime" />-->
      <!--      <el-table-column align="center" min-width="100" label="备案" prop="owInternetcp" />-->
      <!--      <el-table-column align="center" min-width="100" label="公司网址" prop="owUrl" />-->
      <!--      <el-table-column align="center" min-width="100" label="公司地址" prop="owAddress" />-->
      <!--      <el-table-column align="center" min-width="100" label="公司邮箱" prop="owMail" />-->

      <el-table-column align="center" label="操作" width="200" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
          <el-button type="danger" size="mini" @click="handleDelete(scope.row)">删除</el-button>
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
import { listScheme } from '@/api/scheme'
import BackToTop from '@/components/BackToTop'
import Pagination from '@/components/Pagination' // Secondary package based on el-pagination

export default {
  name: 'GoodsList',
  components: { BackToTop, Pagination },
  data() {
    return {
      list: [],
      total: 0,
      listLoading: false,
      listQuery: {
        page: 1,
        limit: 20,
        lan: 'zh-CN',
        sort: 'add_time',
        order: 'desc'
      },
      luaIds: 'zh-CN',
      luaList: [{
        value: 'zh-CN',
        label: '中文'
      },
      {
        value: 'en',
        label: '英文'
      }],
      goodsDetail: '',
      detailDialogVisible: false,
      downloadLoading: false
    }
  },
  created() {
    this.getList()
  },
  methods: {
    getList() {
      this.listLoading = true
      listScheme(this.listQuery).then(response => {
        this.list = response.data.data.list
        this.total = response.data.data.total
        this.listLoading = false
      }).catch(() => {
        this.list = []
        this.total = 0
        this.listLoading = false
      })
    },
    // handleFilter() {
    //   this.listQuery.page = 1
    //   this.getList()
    // },
    // handleCreate() {
    //   this.$router.push({ path: '/goods/create' })
    // },
    handleUpdate(row) {
      this.$router.push({ path: '/basic/schemeEdit', query: { id: row.id }})
    },
    handleCreate() {
      this.$router.push({ path: '/basic/schemeCreate', query: { lan: this.luaIds }})
    },
    handleLuaChange(value) {
      this.luaIds = value[value.length - 1]
      this.listQuery.lan = value[value.length - 1]
      this.getList()
    }
  }
}
</script>
