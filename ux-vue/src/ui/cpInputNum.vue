<template>
 <div v-if="$store.state.inputAttribute.cpInputNum" class="visible">
               <li>
                    <div class="xu-headLine">交互信息</div>
                </li>
               <li>
                <div class="ux-attribute">默认提示</div>
                <div class="ux-pageinformation">
                   <p class="ux-InfoRow">   
                    <input  v-model="inputAttribute.inputPlaceholder" id="inputPlaceholder" class="ux-elmSetting ux-elmy ux-inputHint">
                    </p>
                </div>
               </li>
               <li>
                <div class="ux-attribute">验证信息</div>
                <div class="ux-pageinformation">
                   <p class="ux-InfoRow">   
                      <select class="cpSelect">
                      <option value="">QQ号</option>
                      <option value="">邮政编码</option>
                      <option value="">身份证</option>
                      <option value="">邮政编码</option>
                      <option value="">邮政编码</option>
                      </select>
                  </p>
                </div>
               </li>
               
                 <li>
                <div class="ux-attribute">错误提示</div>
                <div class="ux-pageinformation">
                   <p class="ux-InfoRow">   
                    <input   id="inputPlaceholder" class="ux-elmSetting ux-elmy ux-inputHint">
                    </p>
                </div>
               </li>
       
    
                 <li>
                <div class="ux-attribute">字数限制</div>
                <div class="ux-pageinformation">
                   <p class="ux-InfoRow">   
                      <select class="cpSelect">
                      <option value="">10</option>
                      <option value="">15</option>
                      <option value="">20</option>
                      </select>
                  </p>
                </div>
               </li>
   
              <!--<li>
                <div class="ux-attribute">错误提示</div>
                <div class="ux-pageinformation">
                   <p class="ux-InfoRow">
                   <input  v-model="styleRoute" id="styleRoute" class="ux-elmSetting ux-elmy">
                   </p>  
                </div>
              </li>-->
              <!--<li>
                <div class="ux-attribute">验证内容</div>
                <div class="ux-pageinformation">
                   <p class="ux-InfoRow">
                   <input  v-model="styleRoute" id="styleRoute" class="ux-elmSetting ux-elmy">
                   </p>  
                </div>
              </li>-->
     </div>
</template>
<script>
  let vm;
  export default {
    name: 'cpInputNum',
    data() {
      return {
        // inputData 
            inputAttribute:{    
                    inputTop:'0',
                    inputLeft:'0',
                    inputWidth:'0',
                    inputHeight:'0',
                    inputLength:'10', //最大字数限制
                    inputPlaceholder:"请输入内容",
                    inputPlaceholderColor:"#EBEBEB",
                    inputSize:"12px",
                    inputColor:"#DDDDDD"
                  }
       };
     },
    computed:{

     },
     watch:{
// watchInput    
            inputAttribute(newval,oldval){
                if(newval!=oldval){
                    console.log('watchchange');
                this.inputAttribute.inputLength = newval.replace(/[^\d]/g,'');    
                this.changeLength()
                }
            }
     },
      methods:{            
          // inputChange
            changeLength(){
                console.log('changeLength');
                let inputLength = this.inputAttribute.inputLength.replace(/[^0-9]/ig,""); 
                console.log(this.inputAttribute.inputLength);
                 $("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`).attr("maxlength",`${inputLength}`);
            },
             changePlaceholder(){
                let inputPlaceholder = this.inputAttribute.inputPlaceholder;
                 $("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`).styleSheets[0].insertRule('input::-webkit-input-placeholder{ color: ${inputPlaceholder} }', 0);

            },
             changeSize(){
                let inputSize = this.inputAttribute.inputSize.replace(/[^0-9]/ig,""); 
                 $("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`).css("fontSize",`${inputSize}px`);
            },
            changeColor(){
                let inputColor =  this.inputAttribute.inputColor;
                 $("#iframe").contents().find(`[objectID='${sessionStorage.objectID}']`).css("color",`${inputColor}`);
            }
            
        
        },
     created: function () {
     },
    components: {
      
    },
    mounted () {
       console.log("加载完成cpInputNum")
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
                       
                        .ux-InfoRow{
                            height: 24px;
                            display: inline-block;
                            line-height: 24px;
                            width: 130px;
                            text-align: left;
                            color: #fff;
                            font-size: 12px;
                            vertical-align: top;
                             select {
                              width: 100px;
                              height: 24px;
                              border: none;
                              margin-left: 6px;
                              border-radius: 2px;
                              line-height: 24px;
                              /*将默认的select选择框样式清除*/
                              appearance:none;
                              -moz-appearance:none;
                              -webkit-appearance:none;
                              background:  url(../../static/img/xjt.png) no-repeat scroll right center transparent;
                              background-color: #fff;

                            }
                        }
                         
                        .ux-inputHint{
                            width:100px;
                            margin-left: 6px;
                            border-radius: 2px;
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