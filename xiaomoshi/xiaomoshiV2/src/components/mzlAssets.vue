<template>
    <div class="Assets">
     <div class="Assets-title row-box">
            <div class="title1">资产代码</div>
            <div class="title2">资产名称</div>
            <div class="title3">价格(万元)</div>
     </div>
     <div class="Assets-input row-box">
          <div class="ico_search">
              <img src="../../static/img/ico_search.png">
          </div>
     </div>
     <div class="Assets-variety row-box"  v-for="item in 7">
            <div class="title1">123456</div>
            <div class="title2">前海乐融有限公司</div>
            <div class="title3">1.233.00</div>    
     </div>
    </div>
</template>
<script>
    let mzlAssets = {
        name: 'mzlAssets',
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
            console.log("加载完成mzlAssets")
        }
    };
    export default mzlAssets;
</script>
<style lang='scss' scoped>

//                           --start-Assets--- 
.Assets{  
  margin-top: 10px;  
  margin-left: 0;
  width: 29%;
  height: 360px;
  background-color: #000;
  opacity: 1;
//                           --start-Assets-variety--- 
    .Assets-variety:nth-child(odd){
      background:#000000;
    }
    .Assets-variety:nth-child(even){
      background:#111111;
    }
    .Assets-variety{
   width: 90.4%;
   height: 40px;
   margin-left: 2%;

   border-radius: 1px;
   
//                           --variety-title--- 
   .title1{
    white-space: nowrap;
    margin-top: 11.5px;
    margin-left: 10px;
    line-height: 17px;     
    color: #ffffff; 
    font-size: 12px;
    width: 18%;
   }
   .title2{
    white-space: nowrap;
    margin-top: 11.5px;
    margin-left: 7%;
    line-height: 17px;     
    color: #ffffff; 
    font-size: 12px;
    width: 18%;
   }
   .title3{
    white-space: nowrap;
    margin-top: 11.5px;
    margin-left: 34%;
    line-height: 17px;     
    color: #FF6600; 
    font-size: 12px;
    width: 14%;
   }
 }
//                           --end-variety-variety--- 

//                           --start-Assets-title--- 
  
  .Assets-title{
   width: 90.4%;
   height: 40px;
   margin-left: 2%;

   border-radius: 1px;
   
//                           --start-title--- 
   .title1{
    white-space: nowrap;
    margin-top: 11.5px;
    margin-left: 10px;
    line-height: 17px;     
    color: #FF6600; 
    font-size: 12px;
    width: 18%;
   }
   .title2{
    white-space: nowrap;
    margin-top: 11.5px;
    margin-left: 7%;
    line-height: 17px;     
    color: #FF6600; 
    font-size: 12px;
    width: 18%;
   }
   .title3{
    white-space: nowrap;
    margin-top: 11.5px;
    margin-left: 34%;
    line-height: 17px;     
    color: #FF6600; 
    font-size: 12px;
    width: 14%;
   }
//                           --end-title--- 
 }
//                           --start-input--- 
    .Assets-input{
     width: 100%;
     height: 40px;
     margin-top: 0;
     margin-left: 0;
     background: #000000;
     border-radius: 1px;
     border-top: 1px solid #222222;
     .ico_search{
         width: 16px;
         height: 16px;
         margin-top: 11.5px;
         margin-left: 89%;  
     }
    }


 //                           --end-imgbox--- 
}
 //                           --end-Assets--- 
</style>