<template>
    <div class="mzlPay">
      <div class="buy-title row-box">
        <div class="border-line"></div>
        <div class="title-text">买单</div>
      </div>
      <div class="mask" v-for="item in 5">
          <div class="mask-item row-box" >
            <div class="row-box" v-for="item in 7">
                <div class="mask-title">买入时间</div>
                <div class="mask-state">2016-12-01 10:00</div>
            </div>  
          </div>
          <div  class="pay-item row-box">  
            <div class="row-box" >
                <div class="pay-title">交易状态</div>
                <div class="pay-state">成功</div>  
            </div>
          </div>
      </div>
    </div>
</template>
<script>
    let mzlPay = {
        name: 'mzlPay',
        data() {
            return {
            };
        },
        methods  : {
            onAnimationEnd() {
            }
        },
        components: {
        },
        mounted() {
            console.log("加载完成mzlPay")
        }
    };
    export default mzlPay;
</script>
<style lang='scss' scoped>

//                           --start-mzlPay--- 
.mzlPay{
    margin-left: 6%;
    width: 87.3%;
    height: 360px;
    opacity: 1;
    background-color: #000;
    .buy-title{
        width: 26%;
        margin-top: 10px;
        height: 40px;
        margin-left: 1%;
        border-radius: 1px;
        .border-line{
            background: #FF6600;
            width: 2px;
            height: 14px;
            margin-top: 11px;
        }
        .title-text{
            width:28px;
            height: 20px;   
            margin-left: 10px;
            margin-top: 10px;
            color: #FF6600;
            font-size: 14px;
        }
    }
//                           --start-mask--- 
    .mask{
        margin-top: 20px;
        margin-left:1.6%;
        width: 18%;
        height: 280px;
        background-color: #111111;
        .mask-item{
            margin-left: 20px;
            margin-top: 11px;
            width: 80%;
            height: 210px;
            .mask-title{
                width:35%;
                color: #fff;
                height: 30px;
                font-size: 12px;
                line-height: 30px;
                text-align: left;
                
            }
            .mask-state{
                width:60%;
                color:#fff;
                height: 30px;
                line-height: 30px;
                font-size: 12px;
                margin-left: 5%;
                text-align: left;
            }
        }
        .pay-item{
            margin-top: 19px;
            margin-left: 20px;
            width: 80%;
            height:30px;
            .pay-title{
                width:35%;
                color: #fff;
                height: 30px;
                font-size: 12px;
                line-height: 30px;
                text-align: left;
                
            }
            .pay-state{
                width:60%;
                color:#fff;
                height: 30px;
                line-height: 30px;
                font-size: 12px;
                margin-left: 5%;
                text-align: left;
            }
        }
    }
//                           --end-mask--- 


}
//                           --end-mzlPay--- 
</style>