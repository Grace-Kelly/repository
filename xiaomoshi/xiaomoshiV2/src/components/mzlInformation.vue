<template>
    <div class="information">
        <div class="information-title row-box">
            <div class="information-item">基本信息</div>
            <div class="information-item">归属信息</div>
            <div class="information-item">附件信息</div>
            <div class="information-item">担保信息</div>
        <div class="item-line"></div>
        </div>
        <div class="Assets-code">
            <div class="row-box" v-for="item in 4">
                <div class="code-title">资产代码</div>
                <div class="code-information">123456</div>
            </div>
        </div>
        <div class="img-information">
            <img src="../../static/img/information.png">
        </div>
    </div>
</template>
<script>
    let mzlInformation = {
        name: 'mzlInformation',
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
            console.log("加载完成mzlInformation")
        }
    };
    export default mzlInformation;
</script>
<style lang='scss' scoped>

//                           --start-information--- 
.information{
    margin-top: 10px;
    width:58%;
    height:360px;
    background: #000000;
    opacity: 1;
    position: relative;
//                           --start-information-title--- 
    .information-title{
        width:100%;
        height: 40px;
        border-radius: 1px;
        .information-item{
            line-height: 40px;
            width:10%;
            font-size: 12px;
            font-family:"PingFangSC-Medium";
            color: #fff;
            text-align: center
        }
        .item-line{
            width: 91px;
            height: 1px;
            background-color: #ff6600;
            position: absolute;
            top:40px;
            left: 0;
            
        }
        
    }
//                           --end-Assets-code--- 

//                           --start-Assets-code--- 
    .Assets-code{
        width: 19%;
        height: 110px;
        margin-left: 14%;
        margin-top: 4%;
        .code-title{
            width: 35%;
            height: 27px;
            line-height: 27px;
            font-size: 12px;
            color: #fff;
        }
        .code-information{
            margin-left: 5%;
            width:60%;
            height: 27px;
            line-height: 27px;
            font-size: 12px;
            color: #fff;
        }
    }
//                           --end-img-information--- 

//                           --start-img-information--- 
    .img-information{
        width: 47%;
        height: 280px;
        margin-left: 16%;
        margin-top: 20px;
    }
//                           --end-img-information--- 
}
 //                           --end-information--- 
</style>