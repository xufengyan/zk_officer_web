<template>
  <div class="app-container">
    <!-- 查询和其他操作 -->
    <div class="filter-container">
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

      <el-table-column align="center" min-width="100" label="系列名称" prop="lable" />

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
      <el-form ref="dataForm" :rules="rules" :model="category" status-icon label-position="left" label-width="100px" style="width: 400px; margin-left:50px;">
        <el-form-item label="系列名称" prop="name">
          <el-input v-model="category.lable" />
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
  // import { listGoods, deleteGoods } from '@/api/basic'
  import BackToTop from '@/components/BackToTop'
  import Pagination from '@/components/Pagination' // Secondary package based on el-pagination

  export default {
    name: 'GoodsList',
    components: { BackToTop, Pagination },
    data() {
      return {
        dataForm:{
          lable:'',
        },
        createDialogVisible: false,
        list: [{
          id: '1',
          // pName: 'zk1524测亩仪',
          // pImagePath: 'http://localhost:8089/admin/storage/fetch/sl9q336i0u1ew2p7kv8m.jpg',
          // pIntroduce: ''
          value:1,
          lable:'zk1000系列'
        }],
        total: 0,
        listLoading: false,
        listQuery: {
          page: 1,
          limit: 20,
          goodsSn: undefined,
          name: undefined,
          sort: 'add_time',
          order: 'desc'
        },
        goodsDetail: '',
        detailDialogVisible: false,
        downloadLoading: false,
        rules: {
          lable: [
            { required: true, message: '角色名称不能为空', trigger: 'blur' }
          ]
        },
        textMap: {
          update: '编辑',
          create: '创建'
        },
        dialogStatus:'create',
        category:{
          id:null,
          value:null,
          lable:''
        }
      }
    },
    created() {
      // this.getList()
    },
    methods: {
      // getList() {
      //   this.listLoading = true
      //   listGoods(this.listQuery).then(response => {
      //     this.list = response.data.data.list
      //     this.total = response.data.data.total
      //     this.listLoading = false
      //   }).catch(() => {
      //     this.list = []
      //     this.total = 0
      //     this.listLoading = false
      //   })
      // },
      // handleFilter() {
      //   this.listQuery.page = 1
      //   this.getList()
      // },
      // handleCreate() {
      //   this.$router.push({ path: '/goods/create' })
      // },
      handleUpdate(row) {
        // this.$router.push({ path: '/basic/categoryEdit', query: { id: row.id }})
        this.dialogStatus = 'update'
        this.createDialogVisible = true
        //
        this.category.id = row.id
        this.category.value = row.value
        this.category.lable = row.lable
      },
      handleCreate() {
        // this.$router.push({ path: '/basic/categoryCreate' })
        this.dialogStatus = 'create'
        this.createDialogVisible = true
      },
      createData(){
        console.log(this.category)
      },
      updateData(){
        console.log(this.category)
      }
      // showDetail(detail) {
      //   this.goodsDetail = detail
      //   this.detailDialogVisible = true
      // },
    }
  }
</script>
