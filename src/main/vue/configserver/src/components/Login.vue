<template>
  <div>
    <el-button type="text" @click="centerDialogVisible = true">点击打开 Dialog</el-button>
    <el-dialog
      title="登录"
      :visible.sync="centerDialogVisible"
      width="600px"
      center>
      <el-form :model="form">
        <el-form-item label="用户" :label-width="formLabelWidth">
          <el-input v-model="form.username" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" :label-width="formLabelWidth">
          <el-input v-model="form.password" type="password" auto-complete="off"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
          <el-button @click="login()">取 消</el-button>
          <el-button type="primary" @click="centerDialogVisible = false">确 定</el-button>
        </span>
    </el-dialog>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        centerDialogVisible: false,
        form: {
          username: "",
          password: ""
        },
        formLabelWidth: '100px'
      };
    },
    methods: {
      login() {
        this.centerDialogVisible = false;
        this.$ajax.post('/login', this.form)
          .then(function (response) {
            console.log(response);
          })
          .catch(function (error) {
            console.log(error);
            this.centerDialogVisible = true;
          });
      }
    }
  }
</script>

<style scoped>

</style>
