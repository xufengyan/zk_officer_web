<template>
  <div class="app-container">
    <!-- 查询和其他操作 -->
    <div class="filter-container">
      <el-form ref="download" label-width="150px">
        <el-form ref="download" label-width="150px">
          <el-cascader :value="luaIds" :options="luaList" expand-trigger="hover" @change="handleLuaChange" />
          <el-cascader :value="typeId" :options="typeList" expand-trigger="hover" @change="handleTypeChange" />
        </el-form>
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
      <el-table-column align="center" label="value" prop="value" />
      <el-table-column align="center" min-width="100" label="产品" prop="type">
        <template slot-scope="scope">
          <span>{{ scope.row.type === 1 ? '测亩仪' : '喷码机' }}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" min-width="100" label="系列名称" prop="label" />
      <el-table-column align="center" min-width="100" label="语言" prop="lan" />

      <!--      <el-table-column align="center" property="iconUrl" label="产品图片">-->
      <!--        <template slot-scope="scope">-->
      <!--          <img :src="scope.row.pImagePath" width="100">-->
      <!--        </template>-->
      <!--      </el-table-column>-->

      <!--      <el-table-column align="center" min-width="100" label="产品展示内容" prop="pIntroduce" />-->
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
    <!-- 添加对话框 -->
    <el-dialog :title="textMap[dialogStatus]" :visible.sync="createDialogVisible">
      <el-form ref="dataForm" :rules="rules" :model="dataForm" status-icon label-position="left" label-width="100px" style="width: 400px; margin-left:50px;">
        <el-form-item label="语言" prop="id">
          <el-cascader :value="luaIds" :options="luaList" expand-trigger="hover" @change="handleLuaChange" />
        </el-form-item>
        <el-form-item label="产品类型" prop="id">
          <el-cascader :value="typeId" :options="typeList" expand-trigger="hover" @change="handleTypeChange" />
        </el-form-item>
        <el-form-item label="系列名称" prop="name">
          <el-input v-model="dataForm.label" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="createDialogVisible = false">取消</el-button>
        <el-button v-if="dialogStatus=='create'" type="primary" @click="createData">确定</el-button>
        <el-button v-else type="primary" @click="updateData">确定</el-button>
      </div>
    </el-dialog>
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
import { listCategory, createCategory, editCategory } from '@/api/category'
import BackToTop from '@/components/BackToTop'
import Pagination from '@/components/Pagination' // Secondary package based on el-pagination
import { MessageBox } from 'element-ui'

export default {
  name: 'GoodsList',
  components: { BackToTop, Pagination },
  data() {
    return {
      dataForm: {
        label: ''
      },
      createDialogVisible: false,
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
      typeName: '喷码机',
      luaName: '中文',
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
      typeId: 1,
      typeList: [
        {
          value: 1,
          label: '测亩仪'
        },
        {
          value: 2,
          label: '喷码机'
        }
      ],
      goodsDetail: '',
      detailDialogVisible: false,
      downloadLoading: false,
      rules: {
        label: [
          { required: true, message: '角色名称不能为空', trigger: 'blur' }
        ]
      },
      textMap: {
        update: '编辑',
        create: '创建'
      },
      dialogStatus: 'create',
      category: {
        id: null,
        value: null,
        label: ''
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    getList() {
      this.listLoading = true
      listCategory(this.listQuery).then(response => {
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
    resetForm() {
      this.dataForm = {
        value: undefined,
        label: undefined,
        type: 1,
        lan: 'zh-CN'
      }
    },
    handleUpdate(row) {
      this.dataForm = Object.assign({}, row)
      this.typeId = row.type
      this.luaIds = row.lan
      // this.$router.push({ path: '/basic/categoryEdit', query: { id: row.id }})
      this.dialogStatus = 'update'
      this.createDialogVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    handleCreate() {
      // this.typeId === 1 ? this.typeName = '测亩仪' : this.typeName = '喷码机'
      // this.lua === 'zh-CN' ? this.luaName = '中文' : this.luaName = '英文'
      this.resetForm()
      this.dataForm.type = this.typeId
      this.dataForm.lan = this.luaIds
      this.dialogStatus = 'create'
      this.createDialogVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    createData() {
      this.$refs['dataForm'].validate(valid => {
        if (valid) {
          createCategory(this.dataForm).then(response => {
            // this.list.unshift(response.data.data)
            this.$notify.success({
              title: '成功',
              message: '添加成功'
            })
            this.createDialogVisible = false
            this.getList()
          }).catch(response => {
            MessageBox.alert('业务错误：' + response.data.errmsg, '警告', {
              confirmButtonText: '确定',
              type: 'error'
            })
          })
        }
      })
    },
    updateData() {
      this.$refs['dataForm'].validate(valid => {
        if (valid) {
          editCategory(this.dataForm).then(response => {
            this.$notify.success({
              title: '成功',
              message: '修改成功'
            })
            this.getList()
            this.createDialogVisible = false
          }).catch(response => {
            MessageBox.alert('业务错误：' + response.data.errmsg, '警告', {
              confirmButtonText: '确定',
              type: 'error'
            })
          })
        }
      })
    },
    handleLuaChange(value) {
      this.luaIds = value[value.length - 1]
      this.dataForm.lan = value[value.length - 1]
      this.listQuery.lan = value[value.length - 1]
      this.getList()
    },
    handleTypeChange(value) {
      this.typeId = value[value.length - 1]
      this.dataForm.type = value[value.length - 1]
      this.listQuery.type = value[value.length - 1]
      if (!this.createDialogVisible) {
        this.getList()
      }
    }
    // showDetail(detail) {
    //   this.goodsDetail = detail
    //   this.detailDialogVisible = true
    // },
  }
}
</script>
