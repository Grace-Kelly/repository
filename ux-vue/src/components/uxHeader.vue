<template>
    <header>
       <uxZoom></uxZoom>
       <uxHeaderLog></uxHeaderLog>
    </header>
</template>
<script>
import uxZoom from '../components/uxZoom.vue';
import uxHeaderLog from '../components/uxHeaderLog.vue';

    let uxHeader = {
        name: 'uxHeader',
        data() {
            return {
                scaleX:1
            };
        },
        computed:{
          zoom:function(){
                return this.zomm = Number((this.scaleX *100).toFixed(1));
          }
        },
        methods:{
            getTypeElement(es, type){
                 var esLen = es.length,
                i = 0,
                    eArr = [],
                    esI = null;
            for(; i < esLen ; i++){
                esI = es[i];
                if(esI.nodeName.replace("#", "").toLocaleLowerCase() == type){
                    eArr.push(esI);
                }
            }
            return eArr;
           },
        
            uxZoomIn(){    
                if(Number(this.scaleX.toFixed(1))===0.5){
                    this.scaleX=0.5;
                }else{
                    this.scaleX= Number((this.scaleX-0.1).toFixed(1));
                    $("#iframe").contents().find("body").css("transform",`scale(${this.scaleX.toFixed(1)})`);
                }
            },
            uxZoomOut(){
                this.scaleX= Number((this.scaleX+0.1).toFixed(1));
                $("#iframe").contents().find("body").css("transform",`scale(${this.scaleX.toFixed(1)})`);
                $("#iframe").contents().find("body").css("margin-top","10%");
                $("#iframe").contents().find("body").css("margin-left","10%");
            },
        },
        components: {
            uxZoom,uxHeaderLog
        },
        mounted() {
               console.log("加载完成uxHeader")
      }
    };
    export default uxHeader;
</script>
<style lang='scss' scoped>

header {
    position: fixed;
    width: 100%;
    top:0;
    left:0;
    height: 60px;
    background: #000;
}

</style>