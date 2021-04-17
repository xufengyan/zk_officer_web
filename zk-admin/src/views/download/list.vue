<template>
  <div class="app-container">
    <h2>下载文件管理</h2>
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

      <el-table-column align="center" label="文件名" prop="dName" />

      <el-table-column align="center" label="文件描述" prop="dDescibe" />

      <el-table-column align="center" label="文件语言" prop="dLanType" />

      <el-table-column align="center" property="iconUrl" label="图片">
        <template slot-scope="scope">
          <img :src="scope.row.dImagePath" width="100">
        </template>
      </el-table-column>
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
        <el-form-item label="文件名" prop="dname">
          <el-input v-model="dataForm.dName" />
        </el-form-item>
        <el-form-item label="文件描述" prop="content">
          <el-input v-model="dataForm.dDescibe" />
        </el-form-item>
        <el-form-item label="图片">
          <el-upload
            :headers="headers"
            :action="uploadPath"
            :show-file-list="false"
            :on-success="uploadPicUrl"
            class="avatar-uploader"
            accept=".jpg,.jpeg,.png,.gif"
          >
            <img v-if="dataForm.dImagePath" :src="dataForm.dImagePath" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon" />
          </el-upload>
        </el-form-item>

        <el-form-item label="文件" prop="dPath">
          <el-upload
            ref="upload"
            :limit="1"
            :http-request="handleUpload"
            :on-remove="handelRemove"
            action="#"
            list-type="text"
            :file-list="fileList"
            :on-exceed="handleExceed"
          >
            <el-button type="primary">点击上传</el-button>
          </el-upload>
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

  .avatar-uploader .el-upload {
    width: 145px;
    height: 145px;
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }

  .avatar-uploader .el-upload:hover {
    border-color: #20a0ff;
  }

  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 120px;
    height: 120px;
    line-height: 120px;
    text-align: center;
  }
  .avatar {
    width: 145px;
    height: 145px;
    display: block;
  }
</style>

<script>
import { listDownload, createDownload, editDownload } from '@/api/download'
import BackToTop from '@/components/BackToTop'
import Pagination from '@/components/Pagination' // Secondary package based on el-pagination
import { createStorage, uploadPath, readStorageBykey } from '@/api/storage'
import { getToken } from '@/utils/auth'

export default {
  name: 'GoodsList',
  components: { BackToTop, Pagination },
  data() {
    return {
      uploadPath,
      dataForm: {
        dName: undefined,
        dDescibe: undefined,
        dImagePath: undefined,
        dPath: undefined,
        dLanType: undefined
      },
      createDialogVisible: false,
      list: [],
      collaborate: {
        id: null,
        visitUrl: null,
        imageUrl: null,
        image_type: 1
      },
      fileList: [],
      total: 1,
      listLoading: false,
      listQuery: {
        page: 1,
        limit: 20,
        dLanType: 'zh-CN',
        sort: 'add_time',
        order: 'desc'
      },
      goodsDetail: '',
      detailDialogVisible: false,
      downloadLoading: false,
      rules: {
        dPath: [
          { required: true, message: '角色名称不能为空', trigger: 'blur' }
        ]
      },
      textMap: {
        update: '编辑',
        create: '创建'
      },
      dialogStatus: 'create',
      download: {},
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
      category: {
        id: null,
        value: null,
        lable: ''
      }
    }
  },
  computed: {
    headers() {
      return {
        'X-ZK-Admin-Token': getToken()
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    getList() {
      this.listLoading = true
      listDownload(this.listQuery).then(response => {
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
    uploadPicUrl: function(response) {
      this.dataForm.dImagePath = response.data.url
    },
    handleUpdate(row) {
      this.fileList = []
      this.dataForm = Object.assign({}, row)
      // this.fileList[0].name = row.dName
      // this.fileList[0].url = row.dPath
      // this.fileList.push({name: row.dName,url: row.dPath})
      readStorageBykey(row.dPath).then(response => {
        this.fileList.push({ name: response.data.data.name, url: response.data.data.url })
      })

      this.dialogStatus = 'update'
      this.createDialogVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    resetForm() {
      this.fileList = []
      this.dataForm = {
        dName: undefined,
        dDescibe: undefined,
        dImagePath: undefined,
        dPath: undefined,
        dLanType: this.luaIds
      }
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
    createData() {
      if (this.fileList.length != 1) {
        return this.$message.error('请上传文件，或者文件上传数量大于1')
      }
      this.$refs['dataForm'].validate(valid => {
        if (valid) {
          createDownload(this.dataForm).then(response => {
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
      console.log(this.dataForm)
    },
    updateData() {
      if (this.fileList.length != 1) {
        return this.$message.error('请上传文件，或者文件上传数量大于1')
      }
      this.$refs['dataForm'].validate(valid => {
        if (valid) {
          editDownload(this.dataForm).then(response => {
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
    handleUpload(item) {
      this.$refs.upload.clearFiles()
      const formData = new FormData()
      formData.append('file', item.file)
      createStorage(formData).then(response => {
        // this.list.unshift(response.data.data)
        // this.createDialogVisible = false
        this.fileList.push({ name: response.data.data.name, url: response.data.data.name.url })
        this.dataForm.dPath = response.data.data.key
        this.$notify.success({
          title: '成功',
          message: '上传成功'
        })
      }).catch(() => {
        this.$message.error('上传失败，请重新上传')
      })
    },
    handleExceed() {
      this.$notify.error('上传失败！ 超出最大文件上传数，最大文件上传数为1')
    },
    handleLuaChange(value) {
      this.luaIds = value[value.length - 1]
      this.listQuery.dLanType = value[value.length - 1]
      this.getList()
    },
    handelRemove() {
      this.fileList = []
    }
    // showDetail(detail) {
    //   this.goodsDetail = detail
    //   this.detailDialogVisible = true
    // },
  }

}
</script>
