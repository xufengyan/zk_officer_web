<template>
  <div class="app-container">

    <el-card class="box-card">
      <h3>公司基本信息({{ basics.lan }})</h3>
      <el-form ref="basics" :rules="rules" :model="basics" label-width="150px">
        <el-form-item label="编辑ID" prop="id">
          <el-input v-model="basics.id" disabled />
        </el-form-item>
        <el-form-item label="公司名称" prop="owName">
          <el-input v-model="basics.owName" />
        </el-form-item>
        <el-form-item label="公司logo">
          <el-upload
            :headers="headers"
            :action="uploadPath"
            :show-file-list="false"
            :on-success="uploadLogoUrl"
            class="avatar-uploader"
            accept=".jpg,.jpeg,.png,.gif"
          >
            <img v-if="basics.owLogo" :src="basics.owLogo" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon" />
          </el-upload>
        </el-form-item>

        <el-form-item label="二维码">
          <el-upload
            :headers="headers"
            :action="uploadPath"
            :show-file-list="false"
            :on-success="uploadQrcodeUrl"
            class="avatar-uploader"
            accept=".jpg,.jpeg,.png,.gif"
          >
            <img v-if="basics.owQrcodePath" :src="basics.owQrcodePath" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon" />
          </el-upload>
        </el-form-item>

        <el-form-item label="电话" prop="owPhone">
          <el-input v-model="basics.owPhone" />
        </el-form-item>
        <el-form-item label="手机号" prop="owTel">
          <el-input v-model="basics.owTel" />
        </el-form-item>
        <el-form-item label="工作时间" prop="owWoekTime">
          <el-input v-model="basics.owWoekTime" />
        </el-form-item>

        <el-form-item label="备案" prop="owInternetcp">
          <el-input v-model="basics.owInternetcp" />
        </el-form-item>
        <el-form-item label="公司网址" prop="owUrl">
          <el-input v-model="basics.owUrl" />
        </el-form-item>
        <el-form-item label="公司地址" prop="owAddress">
          <el-input v-model="basics.owAddress" />
        </el-form-item>
        <el-form-item label="公司邮箱" prop="owMail">
          <el-input v-model="basics.owMail" />
        </el-form-item>

        <el-form-item label="公司简介">
          <editor v-model="basics.owBriefIntroduction" :init="editorInit" />
        </el-form-item>
      </el-form>
    </el-card>

    <div class="op-container">
      <el-button @click="handleCancel">取消</el-button>
      <el-button type="primary" @click="handleEdit">更新信息</el-button>
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
import { readBasic, editBasic } from '@/api/basic'
import { createStorage, uploadPath } from '@/api/storage'
import Editor from '@tinymce/tinymce-vue'
import { MessageBox } from 'element-ui'
import { getToken } from '@/utils/auth'

export default {
  name: 'GoodsEdit',
  components: { Editor },
  data() {
    return {
      uploadPath,
      basics: {},
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
      if (this.$route.query.id == null) {
        return
      }

      const id = this.$route.query.id
      readBasic(id).then(response => {
        this.basics = response.data.data
      })
    },
    handleCancel: function() {
      this.$store.dispatch('tagsView/delView', this.$route)
      this.$router.push({ path: '/basic/list' })
    },
    // 修改方法
    handleEdit: function() {
      const finalGoods = {
        zkBasics: this.basics
      }
      editBasic(this.basics)
        .then(response => {
          this.$notify.success({
            title: '成功',
            message: '编辑成功'
          })
          this.$store.dispatch('tagsView/delView', this.$route)
          this.$router.push({ path: '/basic/list' })
        })
        .catch(response => {
          MessageBox.alert('业务错误：' + response.data.errmsg, '警告', {
            confirmButtonText: '确定',
            type: 'error'
          })
        })
    },
    // 图片上传方法
    uploadLogoUrl: function(response) {
      this.basics.owLogo = response.data.url
    },
    uploadQrcodeUrl: function(response) {
      this.basics.owQrcodePath = response.data.url
    }
  }
}
</script>
