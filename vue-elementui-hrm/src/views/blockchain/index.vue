<template>
  <div>
    <el-dialog :title="'add' === 'add' ? '区块记录详情' : ''"
               :visible.sync="dialogForm.isShow">
      <el-form ref="form" label-width="100px" :model="dialogForm.formData" size="mini">
        <div>
          区块：{{dialogForm.formData.index}}
        </div>
        <json-viewer :value="dialogForm.formData"></json-viewer>
      </el-form>
    </el-dialog>

    <div style="margin: 20px;display: flex;flex-wrap: wrap">
      <el-card style="margin: 10px" v-for="item in this.blockList" :key="item.id"  class="box-card">
        <div >
          <span style="margin-right: 20px">区块索引：{{item.index}}</span>
          <span style="margin-right: 20px">哈希值：{{item.hash}}</span>
          <span>时间戳：{{item.timestamp}}</span>
          <el-button style="float: right; padding: 3px 0" type="text" @click="handleEdit(item)">详情</el-button>
        </div>
      </el-card>
    </div>
  </div>
</template>

<style>
.box-card {
  width: 1080px;
}
</style>

<script>
import { getAll } from '../../api/blockchain'

import Vue from 'vue'
import JsonViewer from 'vue-json-viewer'

// Import JsonViewer as a Vue.js plugin
Vue.use(JsonViewer)

export default {
  name: 'blockchain',
  data () {
    return {
      blockList: [
        {
          index: '',
          hash: '',
          previousHash: '',
          timestamp: '',
          nonce: '',
          transactions: [
            {
              id: '',
              businessInfo: '',
              type: '',
              data: ''
            }
          ]
        }
      ],
      dialogForm: {
        isShow: false,
        deptList: [],
        formData: {}
      },
    }
  },
  methods: {
    loading () {
      getAll().then(response => {
        if (response.code === 200) {
          this.blockList = response.data
        } else {
          this.$message.error('获取区块链失败！')
        }
      })
    },
    handleEdit (item) {
      this.dialogForm.isShow = true
      this.dialogForm.formData = item
    }
  },
  created () {
    this.loading()
  }

}
</script>
