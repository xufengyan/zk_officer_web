<template>
  <div class="app-container">
    <el-card class="box-card">
      <h3>轮播图片管理</h3>
      <el-form ref="goods" :rules="rules" :model="goods" label-width="150px">
        <el-form-item label="宣传画廊">
          <el-upload
            :action="uploadPath"
            :limit="4"
            :headers="headers"
            :file-list="galleryFileList"
            :on-exceed="uploadOverrun"
            :on-success="handleGalleryUrl"
            :on-remove="handleRemove"
            multiple
            accept=".jpg,.jpeg,.png,.gif"
            list-type="picture-card"
          >
            <i class="el-icon-plus" />
          </el-upload>
        </el-form-item>

        <div class="block" style="height: 385px;width: 600px">
          <span class="demonstration">轮播图预览</span>
          <el-carousel height="385px">
            <el-carousel-item v-for="item in galleryFileList" :key="item">
              <el-image :src="item.url" />
            </el-carousel-item>
          </el-carousel>
        </div>
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
      <el-button type="primary" @click="handleEdit">添加产品展示</el-button>
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
  .el-carousel__item h3 {
     color: #475669;
     font-size: 18px;
     opacity: 0.75;
     line-height: 300px;
     margin: 0;
   }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
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
        galleryFileList: [
          {name: 'food.jpg', url: 'http://localhost:8089/admin/storage/fetch/lurdfr7w7wo2itgimhgu.jpg'},
          {name: 'food.jpg', url: 'http://localhost:8089/admin/storage/fetch/lurdfr7w7wo2itgimhgu.jpg'},
          {name: 'food.jpg', url: 'http://localhost:8089/admin/storage/fetch/lurdfr7w7wo2itgimhgu.jpg'},
          {name: 'food.jpg', url: 'http://localhost:8089/admin/storage/fetch/lurdfr7w7wo2itgimhgu.jpg'},
        ],
        categoryList: [{
          value: '1',
          label: '上海'
        }, {
          value: '2',
          label: '北京'
        }],
        brandList: [],
        categoryIds: [],
        goods: {
          id: '1',
          pType: 1,
          pName: '定位测量方案',
          pModel: '',
          pIntroduce: ''
        },
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
      //选择不同的系列
      handleCategoryChange(value) {
        console.log(value[value.length - 1])
        this.goods.categoryId = value[value.length - 1]
      },
      handleCancel: function() {
        this.$store.dispatch('tagsView/delView', this.$route)
        this.$router.push({ path: '/basic/productList' })
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
        this.goods.picUrl = response.data.url
      },
      uploadOverrun: function() {
        this.$message({
          type: 'error',
          message: '上传文件个数超出限制!最多上传5张图片!'
        })
      },
      handleGalleryUrl(response, file, fileList) {
        if (response.errno === 0) {
          this.goods.gallery.push(response.data.url)
        }
      },
      handleRemove: function(file, fileList) {
        for (var i = 0; i < this.galleryFileList.length; i++) {
          // 这里存在两种情况
          // 1. 如果所删除图片是刚刚上传的图片，那么图片地址是file.response.data.url
          //    此时的file.url虽然存在，但是是本机地址，而不是远程地址。
          // 2. 如果所删除图片是后台返回的已有图片，那么图片地址是file.url
          var url
          if (file.response === undefined) {
            url = file.url
          } else {
            url = file.response.data.url
          }

          if (this.galleryFileList[i].url === url) {
            this.galleryFileList.splice(i, 1)
            break
          }
        }
      },
    }
  }
</script>
