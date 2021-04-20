<template>
  <div class="app-container">
    <h2>合作伙伴管理</h2>
    <!-- 查询和其他操作 -->
    <div class="filter-container">
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

      <el-table-column align="center" label="链接" prop="visitUrl" />

      <el-table-column align="center" property="iconUrl" label="图片">
        <template slot-scope="scope">
          <img :src="scope.row.imageUrl" width="100">
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
    <!-- 添加对话框 -->
    <el-dialog :title="textMap[dialogStatus]" :visible.sync="createDialogVisible">
      <el-form ref="dataForm" :rules="rules" :model="dataForm" status-icon label-position="left" label-width="100px" style="width: 400px; margin-left:50px;">
        <el-form-item label="链接" prop="visitUrl">
          <el-input v-model="dataForm.visitUrl" />
        </el-form-item>
        <el-form-item label="合作伙伴图片">
          <el-upload
            :action="uploadPath"
            :show-file-list="false"
            :headers="headers"
            :on-success="uploadPicUrl"
            class="avatar-uploader"
            accept=".jpg,.jpeg,.png,.gif"
          >
            <img v-if="dataForm.imageUrl" :src="dataForm.imageUrl" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon" />
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
import BackToTop from '@/components/BackToTop'
import Pagination from '@/components/Pagination' // Secondary package based on el-pagination
import { createStorage, uploadPath } from '@/api/storage'
import { getToken } from '@/utils/auth'
import { listImageManagement, createImageManagement, editImageManagement } from '@/api/imageManagement'

export default {
  name: 'CollaborateList',
  components: { BackToTop, Pagination },
  data() {
    return {
      uploadPath,
      dataForm: {
        lable: ''
      },
      createDialogVisible: false,
      list: [{
        id: '1',
        imageUrl: 'http://localhost:8089/admin/storage/fetch/lurdfr7w7wo2itgimhgu.jpg',
        visitUrl: 'ssssss',
        image_type: 1
      }],
      total: 1,
      listLoading: false,
      listQuery: {
        page: 1,
        limit: 20,
        imageType: 1
      },
      dataForm: {
        id: undefined,
        imageUrl: undefined,
        imageType: 0
      },
      rules: {
        visitUrl: [
          { required: true, message: '链接不能为空', trigger: 'blur' }
        ]
      },
      textMap: {
        update: '编辑',
        create: '创建'
      },
      dialogStatus: 'create',
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
      listImageManagement(this.listQuery).then(response => {
        this.list = response.data.data.list
        this.total = response.data.data.total
        this.listLoading = false
      }).catch(() => {
        this.list = []
        this.total = 0
        this.listLoading = false
      })
    },
    resetForm() {
      this.dataForm = {
        id: undefined,
        imageUrl: undefined,
        imageType: 1
      }
    },
    uploadPicUrl: function(response) {
      this.dataForm.imageUrl = response.data.url
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
      this.resetForm()
      this.dialogStatus = 'create'
      this.createDialogVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    createData() {
      this.$refs['dataForm'].validate(valid => {
        if (valid) {
          createImageManagement(this.dataForm).then(res => {
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
    updateData() {
      this.$refs['dataForm'].validate(valid => {
        if (valid) {
          editImageManagement(this.dataForm).then(res => {
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
    }

  }
}
</script>
