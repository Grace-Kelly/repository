<template>
    <div class="ux-content">
      <iframe id="iframe" src="./../../../static/html/page1.html" 
                frameborder="0" 
                align="center"
                scrolling="yes"
                marginheight="50"
                leftmargin="50"
                topmargin="50">
      </iframe>
    </div>
</template>
<script>
    let uxframe = {
        name: 'uxframe',
        data() {
            return {
            stylemessage:'11'
            };
        },
        computed:{

        
        },
        methods:{
           
        },
        components: {
        },
        mounted() {
               console.log("加载完成uxframe")
        
          
        }

    };
    export default uxframe;
</script>
<style lang='scss' scoped>

header~.ux-content {
    padding-top: 44px;
}
#iframe{
    /*text-align: center;
    margin: auto auto;
    vertical-align: middle;*/
    min-width: 2000px;;
    min-height:2000px;
    overflow: auto;
}
</style>