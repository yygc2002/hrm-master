<template>
  <div>
    <el-dialog :title="dialogForm.type === 'add' ? '新增工作经历' : '编辑工作经历'"
               :visible.sync="dialogForm.isShow">
      <el-form ref="form" label-width="100px" :model="dialogForm.formData" size="mini">
        <el-form-item label-width="40px" style="margin-bottom:4px ">
          <el-form-item label="公司名称" style="display:inline-block;width:300px" prop="company">
            <el-input placeholder="请输入公司名称" v-model.trim="dialogForm.formData.company"/>
          </el-form-item>
          <el-form-item label="公司地点" style="display:inline-block;width:300px" prop="location">
            <el-input placeholder="请输入公司地点" v-model.trim="dialogForm.formData.location"/>
          </el-form-item>
        </el-form-item>

        <el-form-item label-width="40px" style="margin-bottom:4px ">
          <el-form-item label="入职时间" style="display:inline-block;width:300px" prop="starttime">
            <el-input v-model.trim="dialogForm.formData.starttime"/>
          </el-form-item>
          <el-form-item label="离职时间" style="display:inline-block;width:300px" prop="endtime">
            <el-input v-model.trim="dialogForm.formData.endtime"/>
          </el-form-item>
        </el-form-item>

        <el-form-item label-width="40px" style="margin-bottom:4px ">
          <el-form-item el-form-item label="类型" style="display:inline-block;width:300px" prop="type">
            <el-input placeholder="请选择类型" v-model.trim="dialogForm.formData.type"/>
          </el-form-item>
          <el-form-item el-form-item label="职位" style="display:inline-block;width:300px" prop="post">
            <el-input placeholder="请输入职位"  v-model.trim="dialogForm.formData.post"/>
          </el-form-item>
        </el-form-item>

        <el-form-item label-width="40px" style="margin-bottom:4px ">
          <el-form-item el-form-item label="工作内容" style="display:inline-block;width:600px" prop="content">
            <el-input placeholder="请描述工作内容" type="textarea" v-model.trim="dialogForm.formData.content"/>
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

    <div><h1 style="font-weight:bold;">工作经历</h1></div>
    <div style="margin: 20px;display: flex;flex-wrap: wrap">
      <el-card style="margin: 10px" v-for="item in this.experienceList" :key="item.id"  class="box-card">
        <div slot="header" class="clearfix">
          <span>{{item.post}}</span>
          <el-button style="float: right; padding: 3px 0" type="text" @click="handleEdit(item)">编辑</el-button>
        </div>
        <div style="margin: 5px">
          <span>类型：{{item.type}}</span>
        </div>
        <div style="margin: 5px">
          <span>工作单位：{{item.company}}</span>
          <span>工作地点：{{item.location}}</span>
        </div>
        <div style="margin: 5px">
          <span>工作内容：{{item.content}}</span>
        </div>
        <div style="margin: 5px">
          <span>工作时间：{{item.starttime}} - {{item.endtime}}</span>
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
import { getWorkExperience, saveWorkExperience, addWorkExperience, deleteWorkExperience } from '../../../api/information'
import dialog from "element-ui/packages/dialog";
export default {
  name: 'worked',
  data () {
    return {
      experienceList: [{
        id: '',
        staffId: '',
        company: '',
        starttime: '',
        endtime: '',
        type: '',
        content: '',
        location: '',
        post: ''
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
      getWorkExperience(this.staff.id).then(response => {
        if (response.code === 200) {
          this.experienceList = response.data
        } else {
          this.$message.error('获取数据失败！')
        }
      })
    },
    deleteInfo () {
      deleteWorkExperience(this.dialogForm.formData.id).then(response => {
        if (response.code === 200) {
          this.dialogForm.isShow = false
          this.loading()
        } else {
          this.$message.error('删除失败！')
        }
      })
    },
    handleEdit (item) {
      this.dialogForm.isShow = true
      this.dialogForm.type = 'edit'
      this.dialogForm.formData = item
    },
    handleAdd () {
      this.dialogForm.isShow = true
      this.dialogForm.type = 'add'
      this.dialogForm.formData = {}
    },
    cancel () {
      this.dialogForm.isShow = false
      this.loading()
    },
    saveOrAdd () {
      this.dialogForm.formData.staffId = this.staff.id
      if (this.dialogForm.type === 'add') {
        addWorkExperience(this.dialogForm.formData).then(response => {
          if (response.code === 200) {
            this.dialogForm.isShow = false
            this.loading()
          } else {
            this.$message.error('添加失败！')
          }
        })
      } else {
        saveWorkExperience(this.dialogForm.formData).then(response => {
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
