<template>
  <div class="login-form">
    <div class="g-form">
      <div class="g-form-line">
        <span class="g-form-label">用户名：</span>
        <div class="g-form-input">
          <input type="text" 
          v-model="usernameModel" placeholder="请输入用户名">
        </div>
        <div class="g-form-error">{{ userErrors.errorText }}</div>
      </div>

      <div class="g-form-line">
        <span class="g-form-label">密 &nbsp; 码：</span>
        <div class="g-form-input">
          <input type="password" 
          v-model="passwordModel" placeholder="请输入密码">
        </div>
        <div class="g-form-error">{{ passwordErrors.errorText }}</div>
      </div>

      <div class="g-form-line">
        <div class="g-form-btn">
          <a class="button" @click="onLogin">登录</a>
        </div>
      </div>

      <p class="errorText">{{ errorText }}</p>
      
    </div>
  </div>
</template>

<script>
var uxLogForm ={
  name: 'uxLogForm',
  data () {
    return {
      usernameModel: '',
      passwordModel: '',
      errorText: ''
    }
  },
  computed: {
    userErrors () {
      let errorText, status
      if (!/@/g.test(this.usernameModel)) {
        status = false
        errorText = '请填写用户名'
      }
      else {
        status = true
        errorText = ''
      }
      if (!this.userFlag) {
        errorText = ''
        this.userFlag = true
      }
      return {
        status,
        errorText
      }
    },
    passwordErrors () {
      let errorText, status
      if (!/^\w{1,6}$/g.test(this.passwordModel)) {
        status = false
        errorText = '密码不是1-6位'
      }
      else {
        status = true
        errorText = ''
      }
      if (!this.passwordFlag) {
        errorText = ''
        this.passwordFlag = true
      }
      return {
        status,
        errorText
      }
    }
  },
  methods: {
    onLogin () {
      if (!this.userErrors.status || !this.passwordErrors.status) {
        this.errorText = '用户名或密码错误'
      }
      else {
      //   this.errorText = ''
      //   this.$http.get('api/login')
      //  .then((res) => {
          this.$store.commit("isCloseLogDialog");
          this.$store.commit("changeUsername","shs");
        // }, (error) => {
        //   console.log(error)
        // })
      }
    }
  },
  mounted() {
               console.log("加载完成uxLogForm")
  }
}
 export default uxLogForm;
</script>

<style lang='scss' scoped>

.login-form{

  .g-form{
    padding-top: 30px;
    .g-form-line{
        width: 100%;
        white-space: nowrap;
        .g-form-btn{
          color: #fff;
          height: 40px;
          .button{
            line-height: 40px;
            display: inline-block;
            height: 40px;
            width: 60px;
            border-radius: 8px;
          }
          .button:hover{
            background-color:#3484F5;
          }
        }
      .g-form-label{
       display: inline-block;
       width:30%;
       font-size: 16px;
       text-align: right;
       color: #fff;
      }
      .g-form-input{
         display: inline-block;
         width: 65%;

        input{
          font-size: 16px;
          padding-left: 5px;
          border-radius: 2px;
        }
        input::-webkit-input-placeholder{
          font-size: 14px;
        }
      }
      .g-form-error{
        line-height: 30px;
        height: 30px;
        font-size: 12px;
        color: #C15B00;
      }
    }
  }
  .errorText{
     font-size: 14px;
     color: #C15B00;
  }
}
</style>
