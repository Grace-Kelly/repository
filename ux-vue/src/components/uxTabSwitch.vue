<template>

        <div class="ux-tabSwitchParent">
            <!--选项卡-->
            <div id='uxTabSwitch'>
                <div @click="switch1" :class="{'on':isA}">页面</div>
                <div @click="switch3" :class="{'on':isC}">组件</div>
                <div @click="switch2" :class="{'on':isB}">模块</div>          
            </div>
        </div>
       

</template>
<script>
    let uxTabSwitch = {
        name: 'uxTabSwitch',
        data() {
            return {
                isA:1,
                isB:0,
                isC:0
            };
        },
        computed:{
     
        },
        methods:{
           switch1(){
            this.isA=1,
            this.isB=0,
            this.isC=0,
            this.$store.commit("switch1Status");
            
           },
            switch2(){
            this.isA=0,
            this.isB=1,
            this.isC=0,
            this.$store.commit("switch2Status")
           },
            switch3(){
            this.isA=0,
            this.isB=0,
            this.isC=1,
            this.$store.commit("switch3Status")
           }
          
        },
        components: {
        },
        mounted() {
               console.log("加载完成uxTabSwitch")
        }
    };
    export default uxTabSwitch;
</script>
<style lang='scss' scoped>

.ux-tabSwitchParent{
    height: 43px;
    width: 250px;
   display: inline-block;
   white-space: nowrap;
   font-size: 0px;
    #uxTabSwitch{
    display: inline-block;
    font-size: 15px;
    text-align: center;
    cursor: pointer;
    font-size: 0px;
     border-bottom: 1px solid #000;
        div{
        height: 43px;
        line-height: 43px;
        font-size: 14px;
        background-color:#000;
        display: inline-block;
        cursor: pointer;
        color: #56595A;
        width: 83px; 
        }
        .on{
            background-color: #292C2E;
            color: #fff;
           
        }
    }


}

</style>