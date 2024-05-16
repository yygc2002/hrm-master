<template>
  <div>
    <div>
      <el-row class="demo-avatar demo-basic">
        <el-col :span="42">
          <div><h1 style="font-weight:bold;">基本信息</h1></div>
          <div class="demo-basic--circle" style="display: flex;margin: 40px">
            <div class="block" style="margin-right: 20px;margin-left: 20px;width: 200px;">
              <el-avatar shape="square" :size="140" src="https://empty" @error="errorHandler">
                <img src="https://cube.elemecdn.com/e/fd/0fc7d20532fdaf769a25683617711png.png"/>
              </el-avatar>
            </div>
            <div>
              <el-descriptions  :column="4" :size="50" border>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-user"></i>
                    员工姓名
                  </template>
                  <input type="text" v-model="formData.name">
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-mobile-phone"></i>
                    合同工作地点
                  </template>
                  <input type="text" v-model="formData.location">
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-location-outline"></i>
                    员工编号
                  </template>
                  <input type="text" v-model="formData.number">
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-tickets"></i>
                    员工性质
                  </template>
                  <input type="text" v-model="formData.type">
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    员工ID
                  </template>
                  <input type="text" v-model="formData.staffId">
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    性别
                  </template>
                  <input type="text" v-model="formData.sex">
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    户籍
                  </template>
                  <input type="text" v-model="formData.domicile">
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    实习生类别
                  </template>
                  <input type="text" v-model="formData.internship">
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    部门
                  </template>
                  <input type="text" v-model="formData.department">
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    民族
                  </template>
                  <input type="text" v-model="formData.ethnic">
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    政治面貌
                  </template>
                  <input type="text" v-model="formData.political">
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    财务类别
                  </template>
                  <input type="text" v-model="formData.finance">
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    身份证号
                  </template>
                  <input type="text" v-model="formData.idcard">
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    出生年月
                  </template>
                  <input type="text" v-model="formData.birthday">
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    联系电话
                  </template>
                  <input type="text" v-model="formData.phone">
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    微信账号
                  </template>
                  <input type="text" v-model="formData.weixin">
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    紧急联系人
                  </template>
                  <input type="text" v-model="formData.emergency">
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    住宅电话
                  </template>
                  <input type="text" v-model="formData.residence">
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    学历
                  </template>
                  <input type="text" v-model="formData.degree">
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    婚姻状况
                  </template>
                  <input type="text" v-model="formData.marry">
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    毕业院校
                  </template>
                  <input type="text" v-model="formData.school">
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    专业
                  </template>
                  <input type="text" v-model="formData.major">
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    职位名称
                  </template>
                  <input type="text" v-model="formData.post">
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    员工状态
                  </template>
                  <input type="text" v-model="formData.status">
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    工龄（年）
                  </template>
                  <input type="text" v-model="formData.age">
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    兴趣爱好
                  </template>
                  <input type="text" v-model="formData.hobby">
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    备注
                  </template>
                  <input type="text" v-model="formData.remark" style="width: 300px">
                </el-descriptions-item>
              </el-descriptions>

            </div>
          </div>
        </el-col>
      </el-row>
    </div>
    <div style="text-align: center;">
      <el-button type="danger" @click="handleSave">保存</el-button>
    </div>
  </div>
</template>

<style scoped lang="less">
  input{
    width: 100px;
  }
</style>

<script>
import { getOne, save } from '../../../api/information'
import { mapState } from 'vuex'

export default {
  name: 'detail',
  data () {
    return {
      formData: {
        name: '',
        location: '',
        number: '',
        type: '',
        id: '',
        staffId: '',
        sex: '',
        domicile: '',
        internship: '',
        department: '',
        ethnic: '',
        political: '',
        finance: '',
        idcard: '',
        birthday: '',
        phone: '',
        weixin: '',
        emergency: '',
        residence: '',
        degree: '',
        marry: '',
        school: '',
        major: '',
        post: '',
        status: '',
        age: '',
        hobby: '',
        remark: ''
      }
    }
  },
  computed: {
    ...mapState('staff', ['staff']),
    ...mapState('token', ['token'])
  },
  methods: {
    errorHandler () {
      return true
    },

    loading () {
      getOne(this.staff.id).then(response => {
        if (response.code === 200) {
          this.name = response.data.name
        } else {
          this.$message.error('获取数据失败！')
        }
      })
    },

    handleSave () {
      save(this.formData).then(response => {
        if (response.code === 200) {
          this.$message.success('保存成功！')
          this.loading()
        } else {
          this.$message.error('保存失败！')
        }
      })
    }
  },
  mounted () {
    getOne(this.staff.id).then(response => {
      if (response.code === 200) {
        this.formData.name = response.data.name
        this.formData.location = response.data.location
        this.formData.number = response.data.number
        this.formData.type = response.data.type
        this.formData.id = response.data.id
        this.formData.staffId = response.data.staffId
        this.formData.sex = response.data.sex
        this.formData.domicile = response.data.domicile
        this.formData.internship = response.data.internship
        this.formData.department = response.data.department
        this.formData.ethnic = response.data.ethnic
        this.formData.political = response.data.political
        this.formData.finance = response.data.finance
        this.formData.idcard = response.data.idcard
        this.formData.birthday = response.data.birthday
        this.formData.phone = response.data.phone
        this.formData.weixin = response.data.weixin
        this.formData.emergency = response.data.emergency
        this.formData.residence = response.data.residence
        this.formData.degree = response.data.degree
        this.formData.marry = response.data.marry
        this.formData.school = response.data.school
        this.formData.major = response.data.major
        this.formData.post = response.data.post
        this.formData.status = response.data.status
        this.formData.age = response.data.age
        this.formData.hobby = response.data.hobby
        this.formData.remark = response.data.remark
      } else {
        this.$message.error('获取数据失败！')
      }
    })
  }
}
</script>
