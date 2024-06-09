<template>
  <div>
    <div><h1 style="font-weight:bold;">奖惩经历</h1></div>
    <div style="margin: 20px;display: flex;flex-wrap: wrap">
      <el-card style="margin: 10px"  class="box-card">
        <div slot="header" class="clearfix">
          <span>年度优秀员工</span>
          <el-button style="float: right; padding: 3px 0" type="text" @click="handleEdit(item)">编辑</el-button>
        </div>
        <div style="margin: 5px">
          <span>类型：奖励</span>
        </div>
        <div style="margin: 5px">
          <span>单位：</span>
          <span>杭州谷米有限公司</span>
        </div>
        <div style="margin: 5px">
          <span>时间：2023-12-19</span>
        </div>
        <div style="margin: 5px">
          <span>备注：2023年度优秀员工</span>
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

<style>
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
export default {
  name: 'award'
}
</script>
