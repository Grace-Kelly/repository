<template>
<div class="bg">
  <p style="fontSize:8px;color">跳转按钮</p>
    <cpButtonJump :jumpPage="jumpPage" :ButtonjumpText="ButtonjumpText"></cpButtonJump>
  <p style="fontSize:8px;">下拉按钮</p>
     <cpPullDown :list="list" :defaultText="defaultText"></cpPullDown>
   <p style="fontSize:8px;">导航按钮</p>
     <cpButtonNav :buttonNavList="buttonNavList" :buttonNavNub="buttonNavNub"></cpButtonNav>
<!--cpImage-->
     <cpImage :cpImageSrc="cpImageSrc" ></cpImage>
<!--cpInputChs-->
     <!--<cpInputChs :cpImageSrc="cpImageSrc"></cpInputChs>-->
     <xmsDatepicker ></xmsDatepicker>

<xmsRadio></xmsRadio>

</div>
</template>
<script>
import cpButtonJump from '../../ui/cpButtonJump';
import cpPullDown from '../../ui/cpPullDown';
import cpButtonNav from '../../ui/cpButtonNav';
import cpImage from '../../ui/cpImage';
// import cpInputChs from '../../ui/cpInputChs';
import xmsDatepicker from '../../ui/xmsDatepicker';
// import regForm from '../../ui/regForm';
import uxDialog from '../../components/uxDialog';
import xmsRadio from '../../ui/xmsRadio';
//cpPullDown
let list=[{
            text: 'item11'
          }, {
            text: 'item22'
          }]
let defaultText="haha"
 //cpButtonJump
let ButtonjumpText="测试按钮"
let jumpPage="page1"
//cpButtonNav
let buttonNavNub=4;
let buttonNavList=[{
            text: 'item11'
          }, {
            text: 'item22'
          }, {
            text: 'item33'
          }]
//cpImage
let cpImageSrc="../../static/img/chart.png"
//cpInputChs


  let vm;
  export default {
    name: 'page2',
    data() {
      return {
//cpPullDown
        list:list,
        defaultText:defaultText,
// cpButtonJump   
ButtonjumpText:ButtonjumpText,
jumpPage:jumpPage,
//cpButtonNav
buttonNavNub:buttonNavNub,
buttonNavList:buttonNavList,
//cpImage
cpImageSrc:cpImageSrc
       };
     },
    computed:{
      // provinceList: changeDataction () {
      //   return this.$store.state.provinceList;
      // }
      
     },
      methods:{            
            divselect(divselectid,inputselectid){ 
              var el = event.currentTarget;
               var ul = $(el).next();
                  if(ul.css("display")=="none"){
                     $(el).next("ul").slideDown("fast");
                      console.log(2)
                  }else{
                      // ul.slideUp("fast");
                       $(el).next("ul").slideUp("fast");
                  }  
          }
        },
     created: function () {
       console.log(this)
      vm = this;
      console.log(vm)
      // get请求
          // this.$http.get("getlist")
          // .then(function(data){
          //       console.log(data)
          // },function(err){
          //       console.log(err)
          // })
      //post请求
           this.$http.post("getlist",{userId:123})
          .then(function(data){
                console.log(data)
          },function(err){
                console.log(err)
          })
     },
    components: {
       xmsRadio,cpButtonJump,cpPullDown,cpButtonNav,cpImage,xmsDatepicker,uxDialog
    },
    mounted () {
       console.log("加载完成page2")
    }
  };
</script>

<style lang="scss" scoped>
.ux-none{
  display: none;

}
.ux-block{
  display:block;
}
.xms-divselect{
    p{
      width: 150px;
      height: 24px;
      line-height: 24px;
      display: block;
      color: #000;
      cursor: pointer;
      font-size: 12px;
      padding-left: 4px;
      padding-right: 30px;
      border: 1px solid #333333;
      background: url(../../../static/img/xjt.png) no-repeat right center;

    }
    ul {
        width: 184px;
        border: 1px solid #333333;
        background-color: #ffffff;
        position: absolute;
        z-index: 20000;
        margin-top: -1px;
        display: none;
        li {
        height: 24px;
        line-height: 24px;
        a {
            display: block;
            height: 24px;
            color: #000;
            cursor: pointer;
            font-size: 12px;
            text-decoration: none;
            padding-left: 10px;
            padding-right: 10px;
        }
      }
    }
   }

</style>