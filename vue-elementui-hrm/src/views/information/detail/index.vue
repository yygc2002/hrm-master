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
                  <input/>
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-mobile-phone"></i>
                    合同工作地点
                  </template>
                  <input/>
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-location-outline"></i>
                    员工编号
                  </template>
                  <input/>
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-tickets"></i>
                    员工性质
                  </template>
                  <input>
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    员工ID
                  </template>
                  <input>
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    性别
                  </template>
                  <input>
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    户籍
                  </template>
                  <input>
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    实习生类别
                  </template>
                  <input>
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    部门
                  </template>
                  <input>
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    民族
                  </template>
                  <input>
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    政治面貌
                  </template>
                  <input>
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    财务类别
                  </template>
                  <input>
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    身份证号
                  </template>
                  <input>
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    出生年月
                  </template>
                  <input>
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    联系电话
                  </template>
                  <input>
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    RTX账号
                  </template>
                  <input>
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    紧急联系人
                  </template>
                  <input>
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    住宅电话
                  </template>
                  <input>
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    学历
                  </template>
                  <input>
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    婚姻状况
                  </template>
                  <input>
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    毕业院校
                  </template>
                  <input>
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    专业
                  </template>
                  <input>
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    职位名称
                  </template>
                  <input>
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    员工状态
                  </template>
                  <input>
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    工龄（年）
                  </template>
                  <input>
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    兴趣爱好
                  </template>
                  <input>
                </el-descriptions-item>
                <el-descriptions-item>
                  <template slot="label">
                    <i class="el-icon-office-building"></i>
                    备注
                  </template>
                  <input style="width: 300px">
                </el-descriptions-item>
              </el-descriptions>

            </div>
          </div>
        </el-col>
      </el-row>
    </div>
    <div style="text-align: center;">
      <el-button type="danger">保存</el-button>
    </div>
  </div>
</template>

<style scoped lang="less">
  input{
    width: 100px;
  }
</style>

<script>
export default {
  name: 'detail',
  methods: {
    errorHandler () {
      return true
    }
  }
}
</script>
