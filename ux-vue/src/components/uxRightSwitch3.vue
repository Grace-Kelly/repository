<template>

<div  v-if="$store.state.switch.switch3"  class="ux-tabSwitchTarget" id="uxTabSwitch3right" >

 <!--uxCpPullDown-->
       <ul class="ux-tabbox">
            
        <div  class="visible">
                <li>
                   <input class="ux-styleName" disabled :value="$store.state.className">  
                </li>
                <li>
                    <div class="xu-headLine">组件选择</div>
                </li>
                <li>
                    <div class="ux-attribute ux-mb10">组件：</div>
                    <div class="ux-pageinformation">
                        <uxCpPullDown></uxCpPullDown>
                    </div>
                </li>
             
            </div>      

<!--input-->
          
        <uxInputChs></uxInputChs>       
             
<!--radio-->       
             <div v-if="$store.state.inputAttribute.radioVisible" class="visible">
              <li>
                <div class="ux-attribute">位置：</div>
                <div class="ux-pageinformation">
                   <p class="ux-ifmrow1"><input id="styleLeft" v-model="styleLeft" v-on:focus="vnFocus" v-on:blur="vnBlur" class="ux-elmSetting ux-elmx"><input  v-model="styleTop" id="styleTop" class="ux-elmSetting ux-elmy"></p>  
                   <p class="ux-ifmrow2"><span class="ux-elmTitle">X</span> <span class="ux-elmTitle">Y</span></p>
                </div>
              </li>

               <li>
                <div class="ux-attribute">分组</div>
                <div class="ux-pageinformation">
                  <p class="ux-ifmrow1">
                   <input   id="styleRoute" class="ux-elmSetting ux-elmy">
                   </p>  
                 </div>
              </li>
              <li>
                <div class="ux-attribute"></div>
                <div class="ux-pageinformation">
                   <p class="ux-ifmrow1">
                   <input   id="styleRoute" class="ux-elmSetting ux-elmy">
                   </p>  
                </div>
              </li>
              </div>
<!--check-->   
            <div v-if="$store.state.inputAttribute.checkVisible" class="visible">
          
               <li>
                <div class="ux-attribute">默认提示</div>
                <div class="ux-pageinformation">
                   <p class="ux-ifmrow1">   
                    <input  v-model="inputAttribute.inputPlaceholder" id="inputPlaceholder" class="ux-elmSetting ux-elmy">
                    <!--<input id="styleHeight" v-model="inputAttribute.inputHeight" class="ux-elmSetting ux-elmy"></p>  -->
                   <p class="ux-ifmrow2"><span class="ux-elmTitle">Width</span> <span class="ux-elmTitle">Height</span></p>
                </div>

                
              </li>
                <li>
                <div class="ux-attribute">最大字数限制</div>
                <div class="ux-pageinformation">
                   <p class="ux-ifmrow1">
                   <input  v-model="inputAttribute.inputLength" id="inputLength" class="ux-elmSetting ux-elmy">
                   </p>  
                </div>
              </li>
              <li>
                <div class="ux-attribute">字体颜色大小</div>
                <div class="ux-pageinformation">
                   <p class="ux-ifmrow1">
                   <input  v-model="styleRoute" id="styleRoute" class="ux-elmSetting ux-elmy">
                   </p>  
                </div>
              </li>
              <!--<li>
                <div class="ux-attribute">错误提示</div>
                <div class="ux-pageinformation">
                   <p class="ux-ifmrow1">
                   <input  v-model="styleRoute" id="styleRoute" class="ux-elmSetting ux-elmy">
                   </p>  
                </div>
              </li>-->
              <!--<li>
                <div class="ux-attribute">验证内容</div>
                <div class="ux-pageinformation">
                   <p class="ux-ifmrow1">
                   <input  v-model="styleRoute" id="styleRoute" class="ux-elmSetting ux-elmy">
                   </p>  
                </div>
              </li>-->
              
              </div>

<!--base--> 

           <!--<uxBase></uxBase>-->
  
          </ul>
      
   </div>

</template>
<script>
import uxCpPullDown from '../components/uxCpPullDown.vue';
import uxInputChs from '../components/uxInputChs.vue';
// import uxBase from '../components/uxBase.vue';
import uxTabSwitch from '../components/uxTabSwitch.vue';
 
    let uxRightSwitch3 = {
        name: 'uxRightSwitch3',
        data(){
                return {

            };
        },


        methods :{
//base基础样式input获取
            // vnBlur(){
            // },
            // vnFocus(){
            //      this.styleTop=sessionStorage.styleTop;
            //       this.styleLeft=sessionStorage.styleLeft;
            //       this.styleWidth=sessionStorage.styleWidth;
            //       this.styleHeight=sessionStorage.styleHeight;
            // }

            
        },
        components: {
            uxCpPullDown,uxInputChs,uxTabSwitch
            // uxBase
        },
        mounted() {
            console.log("加载完成uxRightSwitch3")

        }   
    };
    export default uxRightSwitch3;
</script>
<style lang='scss' scoped>


/*                     --start-ux-right-sidebar--               */

    .ux-tabSwitchTarget{
     margin-top: 2px;
    height: 100%;
    width: 250px;
    overflow: auto;
        .ux-tabbox{
            width: 100%;
            height: 100%;
            overflow: auto;
            .uxCp{
              transition: all 0.3s cubic-bezier(0,1,.4,1);    
            }
            .visible{
                overflow: hidden;
                height: auto;
                width: 100%;
                 li{
                   .ux-mb10{
                       margin-bottom: 10px;
                   }
                    height: auto;
                    text-align: left;
                    cursor: pointer;
                     .ux-styleName{
                        width: 100%;
                        height: 48px;
                        text-align: center;
                        background-color: #2E3133;
                        color: #A8AAAC;
                        
                    }
                    .xu-headLine{
                        height: 32px;
                        background-color: #202121;
                        color:  #A8AAAC;
                        font-size: 12px;
                        line-height: 32px;
                        margin: 0 0 20px;
                        padding: 0 16px;
                    }
                    .ux-attribute{
                        display: inline-block;
                        width: 72px;
                        color: #fff;
                        font-size: 12px;
                        vertical-align: top;
                        height: 24px;
                        line-height: 24px;
                        text-align: center;  
                    }
                    .ux-pageinformation{
                        height: auto;
                        display: inline-block;
                        line-height: 38px;
                        vertical-align: top;
                        width:65px;
                        text-align: left;
                        margin-left: 0;
                        .ux-ifmrow1{
                            height: 24px;
                            display: inline-block;
                            line-height: 24px;
                            width: 130px;
                            text-align: left;
                            color: #fff;
                            font-size: 12px;
                            vertical-align: top;
                        }
                        .ux-ifmrow2{
                            height: 14px;
                            display: inline-block;
                            line-height: 14px;
                            width: 130px;
                            text-align: left;
                            color: #fff;
                            vertical-align: top;
                            font-size: 0px;
                            .ux-inputHint{
                                width:126px;
                            }
                            span{
                                width:61px;
                                font-size: 12px;
                                display: inline-block;
                                height: 14px;
                                line-height: 14px;
                                vertical-align: top;
                                color: #fff;
                                margin-left: 4px;
                            }

                        }
                        .ux-inputHint{
                            width:126px;
                        }
                        input{
                            width:61px;
                            height: 24px;
                            margin-left: 4px;
                        }
                        
                    }
                }
            }
  
        }
        
    }







</style>