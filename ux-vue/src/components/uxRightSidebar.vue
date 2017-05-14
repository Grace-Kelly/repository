<template>
<div class="ux-right-sidebar">
    

 <uxTabSwitch></uxTabSwitch>

<uxRightSwitch1></uxRightSwitch1>
<uxRightSwitch2></uxRightSwitch2>
<uxRightSwitch3></uxRightSwitch3>
</div>
</template>
<script>
import uxRightSwitch3 from '../components/uxRightSwitch3.vue';
import uxRightSwitch1 from '../components/uxRightSwitch1.vue';
import uxRightSwitch2 from '../components/uxRightSwitch2.vue';
import uxTabSwitch from '../components/uxTabSwitch.vue';
  let uxRightSidebar = {
        name: 'uxRightSidebar',
        data(){
                return {

            };
        },
        methods :{

            vnBlur(){
            },
            vnFocus(){
                 this.styleTop=sessionStorage.styleTop;
                  this.styleLeft=sessionStorage.styleLeft;
                  this.styleWidth=sessionStorage.styleWidth;
                  this.styleHeight=sessionStorage.styleHeight;
            }

            
        },
        components: {
           uxRightSwitch1,uxRightSwitch2, uxRightSwitch3,uxTabSwitch
        },
        mounted() {
            console.log("加载完成uxRightSidebar")
        }   
    };
    export default uxRightSidebar;
</script>
<style lang='scss' scoped>


/*                     --start-ux-right-sidebar--               */

.ux-right-sidebar{
    height: 100%;
    width: 250px;
    background-color: #292C2E;
    position: fixed;
    right: 0;
    top: 60px;
      
}






</style>