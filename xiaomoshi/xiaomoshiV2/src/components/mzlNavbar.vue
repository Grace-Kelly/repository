<template>
    <div class="Rectangle">
     <div class="box-row">
      <div class="logo-box">
        <img src="../../static/img/logo.png" class="logo">
      </div>
      <div class="nav-tabs">
        <div class="nav-item">交易</div>
        <div class="nav-item">账户</div>
        <div class="nav-item">签证</div>
        <div class="nav-item">区块链</div>
      </div>
      <div class="avatars-box">
        <img src="../../static/img/avatars.png" class="avatars">
      </div> 
      <div class="rectangle14"></div>
      <div class="exit">安全退出</div>
    </div>  
      <div class="line">
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


//                           --start-navbar--- 
.Rectangle{
  width: 100%;
  height: 100px;
  opacity: 1;
  .box-row{
   display: block;  
   width: 100%;
   white-space: nowrap;
   position: relative;
//                           --start-logo--- 
  .logo-box{
    width       : 14%;
    margin-left: 6%;
    max-height  : 56px;
    vertical-align: middle;
    .logo{
        width: 100%;
        height: auto;
    }
  }
//                           --end-logo--- 

//                           --start-nav-tabs--- 
  .nav-tabs{
    .nav-item{
        width: 25%;
        margin-left: 1%;
        line-height: 100px;
    }
    overflow: hidden;
    vertical-align: middle;
    display: inline-block;
    margin-left :5.6%;
    width: 17%;
    height: 100px;
    opacity     : 1;
    font-family  : PingFangSC-Light;
    font-size     : 16px;
    color         : #FFFFFF;
    letter-spacing: 0;
  }

 //                           --end-nav-tabs--- 

 //                           --start-avatars--- 
  .avatars-box{
    margin-left: 38%;
    vertical-align: middle;
    width: 40px;
    max-height:40px;
    border-radius: 20px;
    .avatars{
        width:100%;
        height: auto;
    }
  }
 //                           --end-avatars--- 

 //                           --start-rectangle14--- 
  .rectangle14{
      vertical-align: middle;
      margin-left: 10px;
      width:1px;
      min-height:12px;
      background-color: #fff;
  }
 //                           --end-rectangle14--- 

 //                           --start-rectangle14--- 
  .exit{
      vertical-align: middle;
      margin-left: 10px;
      width:48px;
      overflow: hidden;
      color: #fff;
      height:17px;
      font-size: 12px;
      line-height: 17px;
  }
//                           --end-rectangle14--- 
 }
 .line{
     position: absolute;
     color: #FF7C00;
     width:87%;
     height: 1px;
     border-top: 2px solid #FF7C00 ;   
     box-shadow: #000 0px 2px 4px 0px;
     left: 6%;
     top:100px;
 }
}
//                           --start-navbar--- 
</style>