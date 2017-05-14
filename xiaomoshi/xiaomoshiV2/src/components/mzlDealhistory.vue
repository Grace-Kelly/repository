<template>
    <div class="mzlDealhistory">
      <div class="buy-title row-box">
        <div class="border-line"></div>
        <div class="title-text">交易历史</div>
      </div>
      <div class="row-box" >
            <div class="row-box mask" >
                <div class="mask-text col1">资产代码</div>
                <div class="mask-text col2">资产名称</div>
                <div class="mask-text col3">交易单价(元)</div>
                <div class="mask-text col4">交易份额（份）</div>
                <div class="mask-text col5">手续费(元)</div>
                <div class="mask-text col6">合计(元)</div>
                <div class="mask-text col7">交易状态</div>
                <div class="mask-text col8">买方</div>           
                <div class="mask-text col9">卖方</div>           
                <div class="mask-text col10">区块生成时间</div>           
            </div>  
           <div class="row-box mask row2" v-for="item in 10">
                <div class="mask-text col1">123456</div>
                <div class="mask-text col2">前海东融有限公司受益转让</div>
                <div class="mask-text col3">20.05</div>
                <div class="mask-text col4">10,500</div>
                <div class="mask-text col5">10,500</div>
                <div class="mask-text col6">987,654,312,00</div>
                <div class="mask-text col7">成功</div>
                <div class="mask-text col8">Crazysoul</div>
                <div class="mask-text col9">卢小鱼</div>           
                <div class="mask-text col10">2016-12-91 10:00</div>           
            </div>    
      </div>
       <div class="pages-box row-box">
            <img src="../../static/img/pages.png">
       </div>
    </div>
</template>
<script>
    let mzlDealhistory = {
        name: 'mzlDealhistory',
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
            console.log("加载完成mzlDealhistory")
        }
    };
    export default mzlDealhistory;
</script>
<style lang='scss' scoped>

//                           --start-mzlDealhistory--- 
.mzlDealhistory{
    margin-left: 6%;
    width: 87.3%;
    height: 580px;
    opacity: 1;
    background-color: #000;
    .buy-title{
        width: 99%;
        margin-left: 1%;
        margin-top: 10px;
        height: 40px;
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
    .mask:nth-child(odd){
        background:#000000;
    }
    .mask:nth-child(even){
        background:#111111;
    }
    .mask{
        margin-top: 0px;
        margin-left: 1%;
        width: 99%;
        height: 40px;
        background-color: #111111;
         
            .mask-text{
                color: #fff;
                height: 40px;
                font-size: 12px;
                line-height: 40px;
                text-align: center;
                
            }
            .col1{
                width: 7%;
                text-align: left;
            }
            .col2{
                width: 15%;
                text-align: left;
            }
            .col3{
                width: 8%;
                text-align: right;
            }
            .col4{
                width: 8%;
                text-align: right;
            }
            .col5{
                width: 8%;
                text-align: right;
            }
            .col6{
                width: 12%;
                text-align: right;
            }
            .col7{
                width: 12%;
                text-align: center;
            }
            .col8{
                width: 7%;
                text-align: left;
            }
            .col9{
                width: 7%;
                text-align: left;
            }
            .col10{
                width: 12%;
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
//                           --end-mask--- 
 .pages-box{
                width: 30%;
                height: 63px;
                margin-left: 34%;
                margin-top: 2%;
  }

}
//                           --end-mzlDealhistory--- 
</style>