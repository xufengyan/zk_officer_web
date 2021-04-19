<template>
  <div class="app-container">
    <!-- 查询和其他操作 -->
    <div class="filter-container">
      <el-form ref="paragraph" label-width="150px">
<!--        <el-form-item label="" prop="typeIds">-->
          <el-cascader :value="luaIds" :options="luaList" expand-trigger="hover" @change="handleLuaChange" />
          <el-cascader :value="typeIds" :options="typeList" expand-trigger="hover" @change="handleCategoryChange" />
<!--        </el-form-item>-->
      </el-form>
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

      <!--      <el-table-column align="center" label="类型" prop="cTypeName" />-->
      <el-table-column align="center" label="类型" prop="cTypeName">
        <template slot-scope="scope">
          <el-tag :key="scope.row.cTypeName" type="primary" style="margin-right: 20px;"> {{ scope.row.cTypeName }} </el-tag>
        </template>
      </el-table-column>
      <el-table-column align="center" label="名称" prop="name" />

      <el-table-column align="center" min-width="100" label="内容" prop="content" />

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
    <el-dialog :title="textMap[dialogStatus] + '（' +typeList[typeIds-1].label +'）'" :visible.sync="createDialogVisible">
      <el-form ref="dataForm" :rules="rules" :model="dataForm" status-icon label-position="left" label-width="100px" style="width: 400px; margin-left:50px;">
        <el-form-item label="名称" prop="name">
          <el-input v-model="dataForm.name" />
        </el-form-item>
        <el-form-item label="内容">
          <el-input
            v-model="dataForm.content"
            type="textarea"
            :rows="2"
            placeholder="请输入内容"
          />
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
import { listParagraph, createParagraph, editParagraph } from '@/api/paragraph'
import BackToTop from '@/components/BackToTop'
import Pagination from '@/components/Pagination'
import { MessageBox } from 'element-ui'

export default {
  name: 'GoodsList',
  components: { BackToTop, Pagination },
  data() {
    return {
      dataForm: {
        name: '',
        content: ''
      },
      createDialogVisible: false,
      list: [],
      paragraph: {},
      total: 0,
      listLoading: false,
      listQuery: {
        page: 1,
        limit: 20,
        cType: 1,
        lua: 'zh-CN',
        sort: 'add_time',
        order: 'desc'
      },
      goodsDetail: '',
      detailDialogVisible: false,
      downloadLoading: false,
      rules: {
        name: [
          { required: true, message: '角色名称不能为空', trigger: 'blur' }
        ]
      },
      textMap: {
        update: '编辑',
        create: '创建'
      },
      dialogStatus: 'create',
      type: {
        id: null,
        value: null,
        lable: ''
      },
      typeIds: 1,
      typeList: [{
        value: 1,
        label: '技术领域'
      }, {
        value: 2,
        label: '我们的优势'
      }],
      luaIds: 'zh-CN',
      luaList: [{
        value: 'zh-CN',
        label: '中文'
      },
      {
        value: 'en',
        label: '英文'
      }]
    }
  },
  created() {
    this.getList()
  },
  methods: {
    getList() {
      this.listLoading = true
      listParagraph(this.listQuery).then(response => {
        this.list = response.data.data.list
        this.list.forEach(function(item, index) {
          item.cType === 1 ? item.cTypeName = '技术领域' : item.cTypeName = '我们的优势'
        })

        this.total = response.data.data.total
        this.listLoading = false
      }).catch(() => {
        this.list = []
        this.total = 0
        this.listLoading = false
      })
    },
    handleUpdate(row) {
      this.dataForm = Object.assign({}, row)
      this.dialogStatus = 'update'
      this.createDialogVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    handleCreate() {
      // this.$router.push({ path: '/basic/categoryCreate' })
      this.resetForm()
      this.dialogStatus = 'create'
      this.createDialogVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    resetForm() {
      this.dataForm = {
        name: undefined,
        content: undefined,
        cType: this.typeIds
      }
    },
    createData() {
      this.$refs['dataForm'].validate(valid => {
        if (valid) {
          createParagraph(this.dataForm).then(response => {
            response.data.data.cType === 1 ? response.data.data.cTypeName = '技术领域' : response.data.data.cTypeName = '我们的优势'
            this.list.unshift(response.data.data)
            this.$notify.success({
              title: '成功',
              message: '添加成功'
            })
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
    updateData() {
      this.$refs['dataForm'].validate(valid => {
        if (valid) {
          editParagraph(this.dataForm).then(response => {
            response.data.data.cType === 1 ? response.data.data.cTypeName = '技术领域' : response.data.data.cTypeName = '我们的优势'
            this.$notify.success({
              title: '成功',
              message: '添加成功'
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
    // 选择不同的系列
    handleCategoryChange(value) {
      // this.paragraph.cType = value[value.length - 1]
      this.typeIds = value[value.length - 1]
      this.listQuery.cType = value[value.length - 1]
      this.getList()
    },
    handleLuaChange(value) {
      this.luaIds = value[value.length - 1]
      this.listQuery.lua = value[value.length - 1]
      this.getList()
    }
    // showDetail(detail) {
    //   this.goodsDetail = detail
    //   this.detailDialogVisible = true
    // },
  }
}
</script>
