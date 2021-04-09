<template>
  <div class="app-container">

    <el-card class="box-card">
      <h3>公司基本信息</h3>
      <el-form ref="goods" :rules="rules" :model="goods" label-width="150px">
        <el-form-item label="编辑ID" prop="id">
          <el-input v-model="goods.id" disabled />
        </el-form-item>
        <el-form-item label="公司名称" prop="owName">
          <el-input v-model="goods.owName" />
        </el-form-item>
        <el-form-item label="公司logo">
          <el-upload
            :headers="headers"
            :action="uploadPath"
            :show-file-list="false"
            :on-success="uploadPicUrl"
            class="avatar-uploader"
            accept=".jpg,.jpeg,.png,.gif"
          >
            <img v-if="goods.owLogo" :src="goods.owLogo" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon" />
          </el-upload>
        </el-form-item>

        <el-form-item label="二维码">
          <el-upload
            :headers="headers"
            :action="uploadPath"
            :show-file-list="false"
            :on-success="uploadPicUrl"
            class="avatar-uploader"
            accept=".jpg,.jpeg,.png,.gif"
          >
            <img v-if="goods.owQrcodePath" :src="goods.owQrcodePath" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon" />
          </el-upload>
        </el-form-item>

        <el-form-item label="电话" prop="owPhone">
          <el-input v-model="goods.owPhone" />
        </el-form-item>
        <el-form-item label="手机号" prop="owTel">
          <el-input v-model="goods.owTel" />
        </el-form-item>
        <el-form-item label="工作时间" prop="owWoekTime">
          <el-input v-model="goods.owWoekTime" />
        </el-form-item>

        <el-form-item label="备案" prop="owInternetcp">
          <el-input v-model="goods.owInternetcp" />
        </el-form-item>
        <el-form-item label="公司网址" prop="owUrl">
          <el-input v-model="goods.owUrl" />
        </el-form-item>
        <el-form-item label="公司地址" prop="owAddress">
          <el-input v-model="goods.owAddress" />
        </el-form-item>
        <el-form-item label="公司邮箱" prop="owMail">
          <el-input v-model="goods.owMail" />
        </el-form-item>

        <el-form-item label="公司简介">
          <editor v-model="goods.detail" :init="editorInit" />
        </el-form-item>
        <!--        <el-form-item label="是否新品" prop="isNew">-->
        <!--          <el-radio-group v-model="goods.isNew">-->
        <!--            <el-radio :label="true">新品</el-radio>-->
        <!--            <el-radio :label="false">非新品</el-radio>-->
        <!--          </el-radio-group>-->
        <!--        </el-form-item>-->

        <!--        <el-form-item label="宣传画廊">-->
        <!--          <el-upload-->
        <!--            :action="uploadPath"-->
        <!--            :headers="headers"-->
        <!--            :limit="5"-->
        <!--            :file-list="galleryFileList"-->
        <!--            :on-exceed="uploadOverrun"-->
        <!--            :on-success="handleGalleryUrl"-->
        <!--            :on-remove="handleRemove"-->
        <!--            multiple-->
        <!--            accept=".jpg,.jpeg,.png,.gif"-->
        <!--            list-type="picture-card"-->
        <!--          >-->
        <!--            <i class="el-icon-plus" />-->
        <!--          </el-upload>-->
        <!--        </el-form-item>-->

      </el-form>
    </el-card>

    <div class="op-container">
      <el-button @click="handleCancel">取消</el-button>
      <el-button type="primary" @click="handleEdit">更新商品</el-button>
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
import { detailGoods, editGoods, listCatAndBrand } from '@/api/goods'
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
      newKeywordVisible: false,
      newKeyword: '',
      keywords: [],
      galleryFileList: [],
      categoryList: [],
      brandList: [],
      categoryIds: [],
      goods: { id: '1',
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
        owUrl: ' www.chikytech.com' },
      specVisiable: false,
      specForm: { specification: '', value: '', picUrl: '' },
      specifications: [{ specification: '规格', value: '标准', picUrl: '' }],
      productVisiable: false,
      productForm: {
        id: 0,
        specifications: [],
        price: 0.0,
        number: 0,
        url: ''
      },
      products: [
        { id: 0, specifications: ['标准'], price: 0.0, number: 0, url: '' }
      ],
      attributeVisiable: false,
      attributeAdd: true,
      attributeForm: { attribute: '', value: '' },
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

      // const goodsId = this.$route.query.id
      // detailGoods(goodsId).then(response => {
      //   this.goods = response.data.data.goods
      //   // 稍微调整一下前后端不一致
      //   if (this.goods.brandId === 0) {
      //     this.goods.brandId = null
      //   }
      //   if (this.goods.keywords === '') {
      //     this.goods.keywords = null
      //   }
      //   this.specifications = response.data.data.specifications
      //   this.products = response.data.data.products
      //   this.attributes = response.data.data.attributes
      //   this.categoryIds = response.data.data.categoryIds
      //
      //   // this.galleryFileList = []
      //   // for (var i = 0; i < this.goods.gallery.length; i++) {
      //   //   this.galleryFileList.push({
      //   //     url: this.goods.gallery[i]
      //   //   })
      //   // }
      //   const keywords = response.data.data.goods.keywords
      //   if (keywords !== null) {
      //     this.keywords = keywords.split(',')
      //   }
      // })
      //
      // listCatAndBrand().then(response => {
      //   this.categoryList = response.data.data.categoryList
      //   this.brandList = response.data.data.brandList
      // })
    },
    handleCancel: function() {
      this.$store.dispatch('tagsView/delView', this.$route)
      this.$router.push({ path: '/basic/list' })
    },
    // 修改方法
    handleEdit: function() {
      const finalGoods = {
        goods: this.goods,
        specifications: this.specifications,
        products: this.products,
        attributes: this.attributes
      }
      editGoods(finalGoods)
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
    uploadPicUrl: function(response) {
      this.goods.picUrl = response.data.url
    }
  }
}
</script>
