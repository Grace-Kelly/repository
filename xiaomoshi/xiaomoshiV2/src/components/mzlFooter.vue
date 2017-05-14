<template>
<div class="footer">
    <div class="row-box footer-box">
        <img  src="../../static/img/footer.png" >
    </div>
</div>
</template>
   
<script>
    let mzlFooter = {
        name: 'mzlFooter',
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
            console.log("加载完成mzlFooter")
        }
    };
    export default mzlFooter;
</script>
<style lang='scss' scoped>
.footer{
    margin-left: 6%;
    width: 87%;
    background:#1F1F1F;
    height: 340px;
    .footer-box{
        margin-top: 20px;
    }
}
</style>