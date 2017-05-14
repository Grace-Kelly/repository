<template>
        <div id="ux-zoom" class="ux-zoom-widget">
            <button class="ux-zoom-in" @click="uxZoomIn"></button>
                <div class="ux-zoom-text">{{zoom}}</div>
            <button class="ux-zoom-out" @click="uxZoomOut"></button>
        </div>

</template>
<script>
    let uxZoom = {
        name: 'uxZoom',
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
        },
        mounted() {
               console.log("加载完成uxZoom")
          }
    };
    export default uxZoom;
</script>
<style lang='scss' scoped>

.ux-zoom-widget{
    width: 160px;
    height: 60px;
    text-align: center;
    display: inline-block;
    vertical-align: top;
    .ux-zoom-in{
        display: inline-block;
        position: relative;
        width: 20px;
        height: 20px;
        border-radius: 10px;
        border: 0;
        background: #3484F5;
        vertical-align: middle;
        cursor: pointer;
    }
        .ux-zoom-in:before {
        position: absolute;
        top: 9px;
        left: 5px;
        content: "";
        display: block;
        width: 10px;
        height: 2px;
        background: #FFF;
    }
        .ux-zoom-text{
        display: inline-block;
        text-align: center;
        line-height: 60px;
        font-size: 12px;
        vertical-align: middle;
        height: 60px;
        color: #fff;
    }

.ux-zoom-out{
    display: inline-block;
    position: relative;
    width: 20px;
    height: 20px;
    border-radius: 10px;
    border: 0;
    background: #3484F5;
    vertical-align: middle;
    cursor: pointer;
}
.ux-zoom-out:before{
    position: absolute;
    top: 9px;
    left: 5px;
    content: "";
    display: block;
    width: 10px;
    height: 2px;
    background: #FFF;
}
.ux-zoom-out:after {
   top: 5px;
    left: 9px;
    width: 2px;
    height: 10px;
    content: "";
    position: absolute;
    display: block;
    background-color: #fff;
}
}



</style>