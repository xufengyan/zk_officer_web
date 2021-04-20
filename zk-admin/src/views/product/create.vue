<template>
  <div class="app-container">

    <el-card class="box-card">
      <h3>展示产品添加</h3>
      <el-form ref="product" :rules="rules" :model="product" label-width="150px">
        <el-form-item label="语言" prop="id">
          <el-input v-model="luaName" disabled />
        </el-form-item>
        <el-form-item label="产品类型" prop="id">
          <el-input v-model="typeName" disabled />
        </el-form-item>
        <el-form-item label="产品名称" prop="pName">
          <el-input v-model="product.pName" />
        </el-form-item>
        <el-form-item label="产品所属系列" prop="categoryIds">
          <el-cascader v-model="categoryIds" :options="categoryList" expand-trigger="hover" @change="handleCategoryChange" />
        </el-form-item>
        <el-form-item label="产品型号" prop="pModel">
          <el-input v-model="product.pModel" />
        </el-form-item>
        <el-form-item label="展示图片">
          <el-upload
            :headers="headers"
            :action="uploadPath"
            :show-file-list="false"
            :on-success="uploadPicUrl"
            class="avatar-uploader"
            accept=".jpg,.jpeg,.png,.gif"
          >
            <img v-if="product.pImagePath" :src="product.pImagePath" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon" />
          </el-upload>
        </el-form-item>

        <el-form-item label="产品介绍">
          <editor v-model="product.pIntroduce" :init="editorInit" />
        </el-form-item>
      </el-form>
    </el-card>

    <div class="op-container">
      <el-button @click="handleCancel">取消</el-button>
      <el-button type="primary" @click="handleCreate">添加产品展示</el-button>
    </div>

  </div>
</template>

<style>
  .el-card {
    margin-bottom: 10px;
  }
  .el-tag + .el-tag {
    margin-left: 10px;
  }
  .input-new-keyword {
    width: 90px;
    margin-left: 10px;
    vertical-align: bottom;
  }
  .avatar-uploader .el-upload {
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
  .op-container {
    display: flex;
    justify-content: center;
  }
</style>

<script>
import { createProduct } from '@/api/product'
import { createStorage, uploadPath } from '@/api/storage'
import { listCategory } from '@/api/category'
import Editor from '@tinymce/tinymce-vue'
import { MessageBox } from 'element-ui'
import { getToken } from '@/utils/auth'

export default {
  name: 'ProductCreate',
  components: { Editor },
  data() {
    return {
      uploadPath,
      categoryList: [],
      categoryIds: 1,
      product: {},
      type: 1,
      typeName: '喷码机',
      lan: 'zh-CN',
      luaName: '中文',
      attributes: [],
      rules: {
        name: [{ required: true, message: '商品名称不能为空', trigger: 'blur' }]
      },
      editorInit: {
        language: 'zh_CN',
        height: '400px',
        convert_urls: false,
        plugins: [
          'advlist anchor autolink autosave code codesample colorpicker colorpicker contextmenu directionality emoticons fullscreen hr image imagetools importcss insertdatetime link lists media nonbreaking noneditable pagebreak paste preview print save searchreplace spellchecker tabfocus table template textcolor textpattern visualblocks visualchars wordcount'
        ],
        toolbar: [
          'searchreplace bold italic underline strikethrough alignleft aligncenter alignright outdent indent  blockquote undo redo removeformat subscript superscript code codesample',
          'hr bullist numlist link image charmap preview anchor pagebreak insertdatetime media table emoticons forecolor backcolor fullscreen'
        ],
        images_upload_handler: function(blobInfo, success, failure) {
          const formData = new FormData()
          formData.append('file', blobInfo.blob())
          createStorage(formData)
            .then(res => {
              success(res.data.data.url)
            })
            .catch(() => {
              failure('上传失败，请重新上传')
            })
        }
      }
    }
  },
  computed: {
    headers() {
      return {
        'X-ZK-Admin-Token': getToken()
      }
    },
    attributesData() {
      var attributesData = []
      for (var i = 0; i < this.attributes.length; i++) {
        if (this.attributes[i].deleted) {
          continue
        }
        attributesData.push(this.attributes[i])
      }
      return attributesData
    }
  },
  created() {
    this.init()
  },
  methods: {
    init: function() {
      if (this.$route.query.type == null) {
        return
      }
      if (this.$route.query.lan == null) {
        return
      }
      const type = this.$route.query.type
      const lan = this.$route.query.lan
      console.log(lan)
      console.log(type)

      this.type = type
      type === 1 ? this.typeName = '测亩仪' : this.typeName = '喷码机'
      lan === 'zh-CN' ? this.luaName = '中文' : this.luaName = '英文'
      this.product.lan = lan
      const category = {
        lan: lan,
        type: type
      }
      listCategory(category).then(response => {
        this.categoryList = response.data.data.list
        this.categoryIds = response.data.data.list[0].value
        this.product.pType = this.categoryIds
      })
    },
    // 选择不同的系列
    handleCategoryChange(value) {
      console.log(value[value.length - 1])
      this.product.pType = value[value.length - 1]
    },
    handleCancel: function() {
      this.$store.dispatch('tagsView/delView', this.$route)
      this.$router.push({ path: '/basic/productList' })
    },
    // 添加方法
    handleCreate: function() {
      createProduct(this.product)
        .then(response => {
          this.$notify.success({
            title: '成功',
            message: '添加成功'
          })
          this.$store.dispatch('tagsView/delView', this.$route)
          this.$router.push({ path: '/basic/productList' })
        })
        .catch(response => {
          MessageBox.alert('业务错误：' + response.data.errmsg, '警告', {
            confirmButtonText: '确定',
            type: 'error'
          })
        })
    },
    // 图片上传方法
    uploadPicUrl: function(response) {
      this.$set(this.product, 'pImagePath', response.data.url)
    }
  }
}
</script>
