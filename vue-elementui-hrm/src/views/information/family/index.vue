<template>
  <div>
    <div><h1 style="font-weight:bold;">家庭成员</h1></div>
    <div style="margin: 20px;display: flex;flex-wrap: wrap">
      <el-card style="margin: 10px"  class="box-card">
        <div slot="header" class="clearfix">
          <span>父亲</span>
          <el-button style="float: right; padding: 3px 0" type="text" @click="handleEdit(item)">编辑</el-button>
        </div>
        <div style="margin: 5px">
          <span>姓名：张三</span>
        </div>
        <div style="margin: 5px">
          <span>年龄：56岁</span>
        </div>
        <div style="margin: 5px">
          <span>工作：杭州文化出版社记者</span>
        </div>
        <div style="margin: 5px">
          <span>备注：无</span>
        </div>
      </el-card>
      <el-card style="margin: 10px"  class="box-card">
        <div slot="header" class="clearfix">
          <span>母亲</span>
          <el-button style="float: right; padding: 3px 0" type="text" @click="handleEdit(item)">编辑</el-button>
        </div>
        <div style="margin: 5px">
          <span>姓名：张丽</span>
        </div>
        <div style="margin: 5px">
          <span>年龄：53岁</span>
        </div>
        <div style="margin: 5px">
          <span>工作：教师</span>
        </div>
        <div style="margin: 5px">
          <span>备注：无</span>
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
  name: 'family'
}
</script>
