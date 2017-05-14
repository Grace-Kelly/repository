<template>
 <div v-if="$store.state.switch.switch1" class="ux-tabSwitchTarget"  id="uxTabSwitch1right" style="display: block">
       <p class="ux-leftTabtitle">全部页面 <span>(3)</span> </p>

        <ul class="ux-tabbox">
              <li @click="goToPage">
                <div class="ux-pageimg" style=" background-image: url('../../static/img/page1.png');">
                </div>
                <div class="ux-pageinformation">
                    <p>page1</p>
                   <p>第一页</p>
                </div>
              </li>
              <li @click="goToPage">
                <div class="ux-pageimg"  style=" background-image: url('../../static/img/page2.png');"></div>
                <div class="ux-pageinformation">
                   <p>page2</p>
                   <p>第二页</p>
                </div>
              </li>
              <li @click="goToPage">
                <div class="ux-pageimg"  style=" background-image: url('../../static/img/page3.png');"></div>
                <div class="ux-pageinformation">
                   <p>登录</p>
                   <p>第三页</p>
                </div>
              </li>
          </ul>
  </div>

</template>
<script>
import uxTabSwitch from '../components/uxTabSwitch.vue';
  
 
 
    let uxRightSwitch1 = {
        name: 'uxRightSwitch1',
        data(){
                return {

            };
        },


        methods :{

           goToPage(){
                var el = event.currentTarget;
                var page = $(el).find('p:nth-of-type(1)').text();
                document.getElementById("iframe").src=`./../../../static/html/${page}.html`; 
            },  
            
        },
        components: {
           uxTabSwitch
        },
        mounted() {
            console.log("加载完成uxRightSwitch1");   
        }   
    };
    export default uxRightSwitch1;
</script>
<style lang='scss' scoped>
/*                     --start-ux-left-sidebar1--               */
        #uxTabSwitch1right{
        margin-top: 2px;
        left: 0;
        top: 0px;
        z-index: 1;
        width: 100%;
        height: 100%;
        color: #56595A;
            .ux-leftTabtitle{
                font-size: 12px;
                width: 100%;
                color: #fff;
                height: 65px;
                text-align: center;
                line-height: 65px;
                    span{
                    font-size: 12px;
                    color: #989A9C;
                    margin-left: 5px;
                    height: 65px;
                    line-height: 65px;
                    }
            }
        .ux-tabbox{
        width: 100%;
        height: 100%;
        overflow: auto;
        li{
            height: 55px;
            text-align: left;
            cursor: pointer;
            padding-top: 10px;
            padding-left: 10px;
                .ux-pageimg{
                    display: inline-block;
                    width: 44px;
                    height: 44px;
                   
                    background-repeat: no-repeat;
                    background-size: 100% 100%;
                    background-position: center top;
                }
                .ux-pageinformation{
                    display: inline-block;
                    height: 44px;
                    margin-left: 10px;
                    vertical-align: top;
                        p{
                        height: 22px;
                        line-height: 22px;
                        text-align: left;
                        color: #fff;
                        font-size: 12px;
                        vertical-align: top;
                    }
                }
            }
        }

   }




</style>