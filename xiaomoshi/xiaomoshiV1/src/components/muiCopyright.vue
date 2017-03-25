<template>
    <div class="copy-right">
            <div class="cont-bot">版权所有&copy;
                <a href=" ">罗湖城事</a>&nbsp;&nbsp;&nbsp;&nbsp;技术支持&copy;
                <a href="javascript:;" >深传互动</a>
            </div>
        </div>
</template>


<script>
  
    let muiCopyright = {
       
        data() {
            return {
               
            };
        },
        methods: {
            
        },
        props: [

        ],
        components: {
         
        },
        mounted() {
            console.log("加载完成muiCopyright")
        }
    };



    export default muiCopyright;
</script>
<style lang='scss' scoped>
.copy-right .cont-bot{
            display:block;
            padding:10px 0;
            margin:0 auto;
            line-height: 2.2rem;
            text-align: center;
            font-size:1rem;
            color:#888;
        }
        .copy-right .cont-bot a {
            color: #888;
        }

</style>