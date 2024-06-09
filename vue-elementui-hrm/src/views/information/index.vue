<template>
  <div class="staff">
    <div class="staffNav">
      <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
        <el-menu-item index="1">
          <router-link to="/information/detail">基本信息</router-link>
        </el-menu-item>
        <el-menu-item index="2">
          <router-link to="/information/worked">工作经历</router-link>
        </el-menu-item>
        <el-menu-item index="3">
          <router-link to="/information/working">在司经历</router-link>
        </el-menu-item>
        <el-menu-item index="4">
          <router-link to="/information/education">教育经历</router-link>
        </el-menu-item>
        <el-menu-item index="5">
          <router-link to="/information/award">奖惩经历</router-link>
        </el-menu-item>
        <el-menu-item index="6">
          <router-link to="/information/appoint">任命经历</router-link>
        </el-menu-item>
        <el-menu-item index="7">
          <router-link to="/information/family">家庭成员</router-link>
        </el-menu-item>
      </el-menu>
    </div>

    <div style="margin-top:30px">
      <router-view/>
      <!-- 路由视图 -->
    </div>
  </div>
</template>

<style scoped lang="less">

</style>

<script>
export default {
  name: 'Staff',
  data () {
    return {
      activeIndex: '1',
      activeIndex2: '1'
    }
  },
  methods: {
    handleSelect (key, keyPath) {
      console.log(key, keyPath)
    }
  }
}
</script>
