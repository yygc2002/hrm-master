<template>
  <div>
    <el-dialog :title="dialogForm.type === 'add' ? '新增在职经历' : '编辑在职经历'"
               :visible.sync="dialogForm.isShow">
      <el-form ref="form" label-width="100px" :model="dialogForm.formData" size="mini">
        <el-form-item label-width="40px" style="margin-bottom:4px ">
          <el-form-item label="标题" style="display:inline-block;width:300px" prop="title">
            <el-input placeholder="请输入标题" v-model.trim="dialogForm.formData.title"/>
          </el-form-item>
        </el-form-item>

        <el-form-item label-width="40px" style="margin-bottom:4px ">
          <el-form-item el-form-item label="活动内容" style="display:inline-block;width:600px" prop="content">
            <el-input placeholder="请描述活动内容" maxlength="100" show-word-limit type="textarea" v-model.trim="dialogForm.formData.content"/>
          </el-form-item>
        </el-form-item>

        <el-form-item label-width="40px" style="margin-bottom:4px ">
          <el-form-item label="开始时间" style="display:inline-block;width:300px" prop="startTime">
            <el-input v-model.trim="dialogForm.formData.startTime"/>
          </el-form-item>
          <el-form-item label="结束时间" style="display:inline-block;width:300px" prop="endTime">
            <el-input v-model.trim="dialogForm.formData.endTime"/>
          </el-form-item>
        </el-form-item>
      </el-form>
      <div style="text-align: center;">
        <span style="margin-right: 30px">
          <el-button type="primary" @click="saveOrAdd()">保存</el-button>
        </span>
        <span style="margin-right: 30px">
          <el-button type="info" @click="cancel()">取消</el-button>
        </span>
        <span v-if="this.dialogForm.type ==='edit'">
          <el-button type="danger" @click="deleteInfo()">删除</el-button>
        </span>

      </div>
    </el-dialog>

    <div><h1 style="font-weight:bold;">在司经历</h1></div>
    <div style="margin: 20px;display: flex;flex-wrap: wrap">
      <el-card  style="margin: 10px" v-for="item in this.experienceList" :key="item.id"  class="box-card">
        <div slot="header" class="clearfix">
          <span>{{item.title}}</span>
          <el-button style="float: right; padding: 3px 0" type="text" @click="handleEdit(item)">编辑</el-button>
        </div>
        <div style="margin: 5px">
          <span>内容：</span>
          <span>{{item.content}}</span>
        </div>
        <div style="margin: 5px">
          <span>活动时间：{{item.startTime}} - {{item.endTime}}</span>
        </div>
      </el-card>
      <el-card style="margin: 10px">
        <div style="width: 437px;height: 120px;text-align: center;padding-top: 45px">
          <el-button type="text" size="80px" @click="handleAdd()" circle>添加</el-button>
        </div>
      </el-card>
    </div>
  </div>
</template>

<style scoped lang="less">
.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both
}

.box-card {
  width: 480px;
}
</style>

<script>
import { mapState } from 'vuex'
import { addWorkingExperience, getWorkingExperience, saveWorkingExperience, deleteWorkingExperience } from '../../../api/information'

export default {
  name: 'working',
  data () {
    return {
      experienceList: [{
        id: '',
        staffId: '',
        startTime: '',
        endTime: '',
        title: '',
        content: ''
      }],
      dialogForm: {
        type: 'add', // add为新增，edit为编辑
        isShow: false,
        deptList: [],
        formData: {}
      }
    }
  },
  methods: {
    loading () {
      getWorkingExperience(this.staff.id).then(response => {
        if (response.code === 200) {
          this.experienceList = response.data
        } else {
          this.$message.error('获取数据失败！')
        }
      })
    },
    handleAdd () {
      this.dialogForm.type = 'add'
      this.dialogForm.formData = {}
      this.dialogForm.isShow = true
    },
    handleEdit (item) {
      this.dialogForm.type = 'edit'
      this.dialogForm.formData = item
      this.dialogForm.isShow = true
    },
    cancel () {
      this.dialogForm.isShow = false
    },
    deleteInfo () {
      deleteWorkingExperience(this.dialogForm.formData.id).then(response => {
        if (response.code === 200) {
          this.dialogForm.isShow = false
          this.loading()
        } else {
          this.$message.error('删除失败！')
        }
      })
    },
    saveOrAdd () {
      this.dialogForm.formData.staffId = this.staff.id
      if (this.dialogForm.type === 'add') {
        addWorkingExperience(this.dialogForm.formData).then(response => {
          if (response.code === 200) {
            this.dialogForm.isShow = false
            this.loading()
          } else {
            this.$message.error('添加失败！')
          }
        })
      } else {
        saveWorkingExperience(this.dialogForm.formData).then(response => {
          if (response.code === 200) {
            this.dialogForm.isShow = false
            this.loading()
          } else {
            this.$message.error('保存失败！')
          }
        })
      }
    }
  },
  computed: {
    ...mapState('staff', ['staff']),
    ...mapState('token', ['token'])
  },
  mounted () {
    this.loading()
  }
}
</script>
