<template>
    <div class="Rectangle">
      <img src="../../static/img/logo.png" class="logo">
      <div class="nav-tabs">
       <div class="nav-item">交易</div>
       <div class="nav-item">账户</div>
       <div class="nav-item">签证</div>
       <div class="nav-item">区块链</div>
      </div>
      <div class="Rectangle2">
          <div class="register">免费注册</div>
          <div class="login">快速登录</div>
      </div>
    </div>
</template>
<script>
    let mzlNavbar = {
        name: 'mzlNavbar',
        data() {
            return {
            };
        },
        methods   : {
            onAnimationEnd() {
            }
        },
        components: {
        },
        mounted() {
            console.log("加载完成mzlNavbar")
        }
    };



    export default mzlNavbar;
</script>
<style lang='scss' scoped>

.Rectangle{
  margin: 0 0;
  width: 1440px;
  height: 100px;
  opacity: 1;
  .logo{
    margin-top  : 20px;
    margin-left : 110px;
    width       : 208px;
    height      : 56px;
  }
  .nav-tabs{
    .nav-item{
        margin-top: 10px;
        margin-left: 20px;
        line-height: 22px;
    }
    display: inline-block;
    margin-left :400px-208px-110px;
    margin-top  : 22px;
    opacity     : 1;
    font-family  : PingFangSC-Light;
    font-size     : 16px;
    color         : #FFFFFF;
    letter-spacing: 0;
  }
  .Rectangle2{
      margin-top: 20px;
      margin-left: 200px;
      width: 200px;
      height: 60px;
      .register{
          margin-top: 12px;
          font-size: 14px;
         color: #fff;
         opacity: 1;
         width: 70px;
         height: 62px;
      }
      .login{
          margin-top: 12px;
          font-size: 14px;
         color: #fff;
         opacity: 1;
         width: 70px;
         height: 60px;
      }
  }
}
</style>