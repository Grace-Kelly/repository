<template>
<div>
           <div  class="visible " @click="xmsOutIn('uxbase')">
                <li>
                    <div class="xu-headLine" >更改信息</div>
                </li>
            </div>
            <div v-if="$store.state.baseAttribute.baseVisible" class="visible uxCp uxbase xms-close">

            <li>
                <div class="ux-attribute">位置：</div>
                <div class="ux-pageinformation">
                   <p class="ux-ifmrow1"><input id="styleLeft" v-model="styleLeft" v-on:focus="vnFocus" v-on:blur="vnBlur" class="ux-elmSetting ux-elmx"><input  v-model="styleTop" id="styleTop" class="ux-elmSetting ux-elmy"></p>  
                   <p class="ux-ifmrow2"><span class="ux-elmTitle">X</span> <span class="ux-elmTitle">Y</span></p>
                </div>
              </li>
              <li>
                <div class="ux-attribute">大小：</div>
                <div class="ux-pageinformation">
                   <p class="ux-ifmrow1"><input id="styleWidth" v-model="styleWidth" class="ux-elmSetting ux-elmx"><input id="styleHeight" v-model="styleHeight" class="ux-elmSetting ux-elmy"></p>  
                   <p class="ux-ifmrow2"><span class="ux-elmTitle">Width</span> <span class="ux-elmTitle">Height</span></p>
                </div>
              </li>
           </div>  
           </div>    
</template>
<script>
  let vm;
  export default {
    name: 'uxBase',
    data() {
      return {
       // baseData  
                  styleName:'div',
                  styleTop:'0',
                  styleLeft:'0',
                  styleWidth:'0',
                  styleHeight:'0'
       };
     },
    computed:{

     },
        watch:{
// watchBaseData           
            styleTop (newval,oldval){
                if(newval!=oldval){  
                this.styleTop = newval.replace(/[^\d]/g,''); 
                this.changeTop()
                }
            },
                styleLeft (newval,oldval){
                if(newval!=oldval){   
                this.styleLeft = newval.replace(/[^\d]/g,''); 
                this.changeLeft()
                }
            },
                styleWidth (newval,oldval){
                if(newval!=oldval){ 
                this.styleWidth = newval.replace(/[^\d]/g,'');   
                this.changeWidth()
                }
            },
                styleHeight (newval,oldval){
                if(newval!=oldval){
                this.styleHeight = newval.replace(/[^\d]/g,'');    
                this.changeHeight()
                }
            }
            

        },
      methods:{            
          // basechange
            changeWidth(){
                let styleWidth = this.styleWidth.replace(/[^0-9]/ig,""); 
                 $("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`).css("width",`${styleWidth}px`);
            },
            changeHeight(){
                let styleHeight = this.styleHeight.replace(/[^0-9]/ig,""); 
                 $("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`).css("height",`${styleHeight}px`);
            },
            changeLeft(){
                let styleLeft = this.styleLeft.replace(/[^0-9]/ig,""); 
                 $("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`).css("left",`${styleLeft}px`);
            },
            changeTop(){
                let styleTop = this.styleTop.replace(/[^0-9]/ig,""); 
                 $("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`).css("top",`${styleTop}px`);
            },
            vnBlur(){
            },
            vnFocus(){
                 this.styleTop=sessionStorage.styleTop;
                  this.styleLeft=sessionStorage.styleLeft;
                  this.styleWidth=sessionStorage.styleWidth;
                  this.styleHeight=sessionStorage.styleHeight;
            },
             xmsOutIn(e){
                 var el = event.currentTarget;
                if($(el).next().hasClass("xms-close")){

                    $(el).next().removeClass("xms-close").addClass("xms-open").addClass("fadeTopIn");
                }
                else{

                    $(el).next().removeClass("xms-open").addClass("xms-close");
              
                }
            },
        
        },
     created: function () {
     },
    components: {
    },
    mounted () {
        console.log("加载完成uxBase")
    }
  };
</script>

<style lang="scss" scoped>
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
</style>