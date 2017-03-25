<template>
        <img class="footer_simple" src="../../static/img/footer.png" >
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
.mzlFooter{
    overflow: hidden
}
.footer_simple{

}
</style>