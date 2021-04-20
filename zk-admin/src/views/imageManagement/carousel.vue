<template>
  <div class="app-container">
    <el-card class="box-card">
      <h3>轮播图片管理</h3>
      <el-form ref="carouseImages" :rules="rules" :model="carouseImage" label-width="150px">
        <el-form-item label="轮播图画廊">
          <el-upload
            :action="uploadPath"
            :limit="4"
            :headers="headers"
            :file-list="carouselFileList"
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
            <el-carousel-item v-for="item in carouseImages" :key="item.id">
              <el-image :src="item.url" />
            </el-carousel-item>
          </el-carousel>
        </div>
      </el-form>
    </el-card>

    <div class="op-container">
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
import { listImageManagement, createImageManagement, delImageManagement } from '@/api/imageManagement'
import { createStorage, uploadPath } from '@/api/storage'
import Editor from '@tinymce/tinymce-vue'
import { MessageBox } from 'element-ui'
import { getToken } from '@/utils/auth'

export default {
  name: 'CarouselEdit',
  components: { Editor },
  data() {
    return {
      uploadPath,
      carouselFileList: [],
      list: {},
      listQuery: {
        page: 1,
        limit: 20,
        imageType: 0

      },
      carouseImages: [],
      carouseImage: {
        id: undefined,
        imageUrl: undefined,
        imageType: 0
      },
      rules: {
        name: [{ required: true, message: '商品名称不能为空', trigger: 'blur' }]
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
      const that = this
      that.carouselFileList = []
      listImageManagement(that.listQuery).then(respone => {
        that.list = respone.data.data.list
        if (that.list.length > 0) {
          that.list.forEach(function(item, index) {
            that.carouseImages.push({ id: item.id, url: item.imageUrl })
            that.carouselFileList.push({ name: item.id, url: item.imageUrl })
          })
        }
      })
    },
    uploadOverrun: function() {
      this.$message({
        type: 'error',
        message: '上传文件个数超出限制!最多上传5张图片!'
      })
    },
    resetForm() {
      this.carouseImage = {
        id: undefined,
        imageUrl: undefined,
        imageType: 0
      }
    },
    handleGalleryUrl(response, file, fileList) {
      if (response.errno === 0) {
        // this.carouselFileList.push({name: response.data.name, url: response.data.url})
        this.resetForm()
        this.carouseImage.imageUrl = response.data.url
        createImageManagement(this.carouseImage).then(res => {
          this.carouseImages.push({ id: res.data.data.id, url: response.data.url })
        })
      }
    },
    handleRemove: function(file, fileList) {
      for (var i = 0; i < this.carouseImages.length; i++) {
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
        if (this.carouseImages[i].url === url) {
          delImageManagement(this.carouseImages[i].id).then(response => {
            this.$notify.success({
              title: '成功',
              message: '删除成功'
            })
          })
          this.carouseImages.splice(i, 1)
          break
        }
      }
    }
  }
}
</script>
