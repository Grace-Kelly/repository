<template>
    <div class="chart">
        <div class="tittle row-box">
            <div class="new-price">
                <span class="color-style1">最新成交价格</span> <span class="color-style2">33.434.00</span> <span class="color-style1">万元</span>
                <span class="color-style1">日成交量</span> <span class="color-style2">100笔</span> 
                <span class="color-style1">日涨幅</span> <span class="color-style2">12%</span> 
                <span class="color-style1">时间间隔</span> <span class="color-style1">10m</span> <span>|</span> <span class="color-style1">20m</span> <span>|</span> <span class="color-style2">30m</span> 
            </div>
        </div>
        <div class="row-box img-box">
            <img class="line-chart" src="../../static/img/chart.png">
        </div>
     
    </div>
</template>
<script>
    let mzlChart = {
        name: 'mzlChart',
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
            console.log("加载完成mzlChart")
        }
    };
    export default mzlChart;
</script>
<style lang='scss' scoped>

//                           --start-chart--- 
.chart{
  position: relative;
  margin-top: 10px;
  margin-left: 6%;
  background-color: #000;
  width: 58%;
  height: 361px;
  border-right: 1px solid #222222;
  opacity: 1;
//                           --start-tittle--- 
  .tittle{
   width: 74%;
   height: 17px;
   line-height: 17px;
   margin-left: 10px;
   margin-top: 13px;
   font-family: pingFangSc;
   font-size: 12px;
//                           --start-text--- 
  .color-style1{
   line-height: 17px;
   color: #fff;
   font-size: 12px;
  }
   .color-style2{
   line-height: 17px;     
   color: #FF7C00;
   font-size: 12px;
  }
//                           --end-text--- 
 }
//                           --start-imgbox--- 
  .img-box{
    width: 100%;
    height: 320px;
  }

 //                           --end-imgbox--- 

}
 //                           --end-chart--- 
</style>