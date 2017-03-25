<template>
  <div class="bg">
    <div class="Rectangle">
      <img src="../../../static/img/logo.png" class="logo">
      <div class="noname1">
        交易 &nbsp;&nbsp;&nbsp;账户&nbsp;&nbsp;&nbsp;鉴证&nbsp;&nbsp;&nbsp;区块链
      </div>
    </div>
    <div class="Rectangle2"> 
      <div class="add-div">
        <div class="Rectangle5 Rectangle5_1">        
          <img src="../../../static/img/ico_ block.png" class="ico_block ico_block_1">
          <div class="noname2 noname2_1">区块信息</div>
        </div>
        <div class="Rectangle5 Rectangle5_2">
         <img src="../../../static/img/ico_node.png" class="ico_block ico_block_2">
          <div class="noname2 noname2_2">节点信息</div>
        </div>
         <div class="Rectangle5 Rectangle5_3">
          <img src="../../../static/img/ico_ block.png" class="ico_block ico_block_3">
          <div class="noname2 noname2_3">交易日志</div>
        </div>
          <div class="Rectangle5 Rectangle5_4">
          <img src="../../../static/img/ico_node.png" class="ico_block ico_block_3">
          <div class="noname2 noname2_4">区块总数量(个)</div>
        </div>
        <div class="Rectangle6">
          <div class="Rectangle6_noname">987,654,321</div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
//  import bootstrapNavbar from '../../components/bootstrapNavbar.vue';

  let vm;
  
  export default {
    name: 'page1',
    data() {
      return {
            // Navbar:Navbar,
       };
     },
    computed:{
      // provinceList: function () {
      //   return this.$store.state.provinceList;
      // }
     },
    created: function () {
      // vm = this;
     },
    components: {
      // bootstrapNavbar,
     },
    methods: {
      
    },
    mounted () {


    }
  };
</script>

<style lang="scss" scoped>
.bg{
  width:1440px;
  height: 820px;
  opacity: 1;
  background-color: #222222;
  margin: 0 0;
}
//                    --start-frist-Rectangle---
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
  .noname1{
    display: inline-block;
    margin-left :400px-208px-110px;
    margin-top  : 22px;
    opacity     : 1;
    font-family  : PingFangSC-Light;
    font-size     : 16px;
    color         : #FFFFFF;
    letter-spacing: 0;
    line-height: 22px;
  }
}
//                    --end-frist-Rectangle---

//                    --start-second-Rectangle---
.Rectangle2{
  margin-left: 90px;
  margin-top: 111-100px;
  width:1260px;
  height: 600px;
  opacity: 1;
//                    --start-侧边栏---
  .add-div{
    overflow: hidden;
    display: inline-block;
    width:170px;
    height: auto;
    .Rectangle5_1{
        margin-top: 111px-100px;
        background-color: #FF6600;
      }
      .Rectangle5_2{
 
        margin-top: 152px-111px-40px;
        background-color: #000000;
      }
      .Rectangle5_3{

        margin-top: 193px-152px-40px;
        background-color: #000000;
      }
      .Rectangle5_4{
       
        margin-top: 243px-193px-40px;
        background-color: #000000;
      }
      .Rectangle5{   
        margin-left: 90px-90px;
        display: inline-block;
        opacity: 1;
        width:170px;
        height: 40px;
          .ico_block{
            width:16px;
            height: 16px;
            vertical-align: top;
            margin-left: 110px-90px;
          }
          .ico_block_1{
            margin-top: 123px-111px;
          }
          .ico_block_2{
            margin-top: 162px-152px;
          }
          .ico_block_3{
            
            margin-top: 203.3px-193px;
          }
          .ico_block_4{
            margin-top: 255px-243px;
          }
        .noname2{
            display: inline-block;
            width:56px;
            height: 20px;
            opacity: 1;
            font-family: PingFangSC-Regular;
            color: #FFFFFF;
            letter-spacing: 0;
            margin-left: 136px-110px-16px;
          }
          .noname2_1{
           margin-top: 121px-111px;
            font-size: 14px;
            }
          .noname2_2{
            margin-top: 162px-152px;
            font-size: 14px;
          }
          .noname2_3{
            margin-top: 203.3px-193px;
            font-size: 14px;
          }
          .noname2_4{
            margin-top: 255px-243px;
            font-size: 14px;
            line-height: 12px;
            font-size: 12px;
            width:84px;
          }
      }
      .Rectangle6{
        margin-left: 90px-90px;
        margin-top: 282-243-40px; 
        background-color: #111111;
        widh:170px;
        height: 80px;
        opacity: 0.5;
        .Rectangle6_noname{
          width: 136px;
          height: 33px;
          margin-left: 109-90px;
          margin-top: 305.5-282px;
          font-family: PingFangSC-Thin;
          opacity: 1;
          line-height: 33px;
          font-size: 24px;
          color: #FF6600;
          letter-spacing: 0;
          text-shadow: 0 2px 4px rgba(0,0,0,0.50);
        }
      }
  
  }
  //                    --end-侧边栏---
}
</style>