<template>
    <div class="mzlBuying">
      <div class="buy-title row-box">
        <div class="border-line"></div>
        <div class="title-text">买入</div>
      </div>
      <div class="row-box list-box">
      <div class="buy-list row-box" v-for="item in 4">
        <div class="buy-number">
           买入单价：
        </div>
        <div class="buy-price">
            <div class="price-number">10,666,000,00</div>
            <div class="price-unit">元</div>
        </div>
      </div>
      </div>
      <div class="buy-total row-box">
          <div class="total-number">合计:12,123,123.00元</div>
          <div class="buy-affirm">买入</div>
      </div>
    </div>
</template>
<script>
    let mzlBuying = {
        name: 'mzlBuying',
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
            console.log("加载完成mzlBuying")
        }
    };
    export default mzlBuying;
</script>
<style lang='scss' scoped>

//                           --start-mzlBuying--- 
.mzlBuying{  
  margin-top: 10px;  
  margin-left: 6%;
  width: 29%;
  height: 360px;
  background-color: #000;
  opacity: 1;
//                           --start-buy-title---  
  .buy-title{
   width: 90%;  
   margin-top: 10px;
   height: 40px;
   margin-left: 5%;
   border-radius: 1px;
   
//                           --start-border-line--- 
    .border-line{
        background: #FF6600;
        width: 2px;
        height: 14px;
        margin-top: 11px;
    }
//                           --end-border-line--- 

//                           --start-title-text--- 
    .title-text{
        width:28px;
        height: 20px;   
        margin-left: 10px;
        margin-top: 10px;
        color: #FF6600;
    }
//                           --end-title-text---
 }
//                           --end-buy-title--- 

//                           --start-buy-list--- 
.list-box{
    margin-top: 20px;
 .buy-list{
     margin-top: 20px;
//                           --start-buy-title--- 
    .buy-number{
        width:35%;
        height: 30px;
        margin-left: 0;
        text-align: right;
        color: #ffffff;
        line-height: 30px;
        font-size: 12px;
    }
//                           --end-buy-title--- 
//                           --start-buy-price--- 
    .buy-price{
        width: 50%;
        height: 30px;
        margin-left: 3%;
        text-align: left;
        background: #222222;
        .price-number{
            width: 37%;
            margin-left: 4%;
            text-align: left;
            color: #ffffff;
            line-height: 30px;
            font-size: 12px;
        }
        .price-unit{
            margin-left: 45%;
            width: 12px;
            text-align: right;
            color: #ffffff;
            line-height: 30px;
            font-size: 12px;
        }
    }
//                           --end-buy-price--- 
 }
//                           --end-buy-list--- 
}
//                           --start-buy-total--- 
    .buy-total{
        margin-top: 14%;
        margin-left: 0;
        .total-number{
            width: 50%;
            line-height: 40px;
            line-height: 40px;
            text-align: center;
            color: #fff;
            font-size: 12px;
        }
        .buy-affirm{
            width: 50%;
            line-height: 40px;
            opacity: 0.7;
            background: #ff6600;
            line-height: 40px;
            text-align: center;
            color: #fff;
            font-size: 16px;
        }
    }
//                           --end-buy-total--- 
 }
 //                           --end-mzlBuying--- 

</style>