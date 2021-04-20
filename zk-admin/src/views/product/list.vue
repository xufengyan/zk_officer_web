<template>
  <div class="app-container">
    <!-- 查询和其他操作 -->
    <div class="filter-container">
      <el-form ref="download" label-width="150px">
        <el-cascader :value="luaIds" :options="luaList" expand-trigger="hover" @change="handleLuaChange" />
        <el-cascader :value="productTypeId" :options="productTypeList" expand-trigger="hover" @change="handleTypeChange" />
      </el-form>
      <el-button class="filter-item" type="primary" icon="el-icon-edit" @click="handleCreate">添加</el-button>
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

      <el-table-column align="center" min-width="100" label="产品名称" prop="pName" />
      <el-table-column align="center" min-width="100" label="产品所属系列" prop="pType" />
      <el-table-column align="center" min-width="100" label="产品型号" prop="pModel" />

      <el-table-column align="center" property="iconUrl" label="产品图片">
        <template slot-scope="scope">
          <img :src="scope.row.pImagePath" width="100">
        </template>
      </el-table-column>

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
import { listProduct } from '@/api/product'
import BackToTop from '@/components/BackToTop'
import Pagination from '@/components/Pagination' // Secondary package based on el-pagination

export default {
  name: 'ProductList',
  components: { BackToTop, Pagination },
  data() {
    return {
      list: [],
      total: 0,
      listLoading: false,
      listQuery: {
        page: 1,
        limit: 20,
        type: 1,
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
      }
      ],
      productTypeId: 1,
      productTypeList: [{
        value: 1,
        label: '测亩仪'
      },
      {
        value: 2,
        label: '喷码机'
      }
      ]
    }
  },
  created() {
    this.getList()
  },
  methods: {
    getList() {
      this.listLoading = true
      listProduct(this.listQuery).then(response => {
        this.list = response.data.data.list
        this.total = response.data.data.total
        this.listLoading = false
      }).catch(() => {
        this.list = []
        this.total = 0
        this.listLoading = false
      })
    },
    handleUpdate(row) {
      this.$router.push({ path: '/basic/productEdit', query: { id: row.id, type: this.productTypeId }})
    },
    handleCreate() {
      console.log(this.luaIds)
      this.$router.push({ path: '/basic/productCreate', query: { type: this.productTypeId, lan: this.luaIds }})
    },
    handleLuaChange(value) {
      this.luaIds = value[value.length - 1]
      this.listQuery.lan = value[value.length - 1]
      this.getList()
    },
    handleTypeChange(value) {
      this.productTypeId = value[value.length - 1]
      this.listQuery.type = value[value.length - 1]
      this.getList()
    }
  }
}
</script>
