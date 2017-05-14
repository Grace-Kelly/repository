<template>
 <div v-if="$store.state.inputAttribute.uxInputChs" class="visible">
               <li>
                    <div class="xu-headLine">交互信息</div>
                </li>
          
               <li>
                <li>
                <div class="ux-attribute">表单状态</div>
                <div class="ux-pageinformation">
                   <p class="ux-InfoRow">   
                      <select class="cpSelect" v-model="inputAttribute.revisability">
                      <option value="可修改">可修改</option>
                      <option value="不可修改">不可修改</option>
                      </select>
                  </p>
                </div>
               </li>
               <li>
                <div class="ux-attribute">验证信息</div>
                <div class="ux-pageinformation">
                   <p class="ux-InfoRow">   
                      <select class="cpSelect" v-model="inputAttribute.Verification">
                      <option value="任意字符">任意字符</option>
                      <option value="电话号码">电话号码</option>
                      <option value="手机号码">手机号码</option>
                      <option value="身份证">身份证</option>
                      <option value="邮箱">邮箱</option>
                      <option value="QQ号码">QQ号码</option>
                      <option value="邮箱">邮箱</option>
                      <option value="IP地址">IP地址</option>
                      <option value="日期">日期</option>
                      </select>
                  </p>
                </div>
                   </li>
               <li>
                <div class="ux-attribute">字数限制</div>
                <div class="ux-pageinformation">
                   <p class="ux-InfoRow">   
                      <select class="cpSelect" v-model="inputAttribute.wordCoun">
                      <option value="10">10</option>
                      <option value="15">15</option>
                      <option value="20">20</option>
                      </select>
                  </p>
                </div>
               </li>
               </li>
                    <li class="textarea">
                <div class="ux-attribute">默认提示</div>
                <div class="ux-pageinformation ">
                   <p class="ux-InfoRow textarea">   
                    <textarea v-model="inputAttribute.inputPlaceholder" id="inputPlaceholder" class="ux-elmSetting ux-elmy ux-inputHint"></textarea>
                    </p>
                </div>
               </li>
<!--
                 <li>
                <div class="ux-attribute">错误提示</div>
                <div class="ux-pageinformation">
                   <p class="ux-InfoRow">   
                    <input   id="inputPlaceholder" class="ux-elmSetting ux-elmy ux-inputHint">
                    </p>
                </div>
               </li>
       -->
    
         

               <li>
                   <div class="ux-save" @click="save('this.inputAttribute')">保存</div> 
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
    name: 'uxInputChs',
    data() {
      return {
        // inputData 
            inputAttribute:{    
                // 基础样式的绑定
                    // inputTop:'0',
                    // inputLeft:'0',
                    // inputWidth:'0',
                    // inputHeight:'0',
                    // inputPlaceholderColor:"#EBEBEB",
                    objectID:'',
                    revisability:'',
                    Verification:'',
                    wordCoun:'',
                    inputLength:'10', //最大字数限制
                    inputPlaceholder:"",
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
          save(){ 
            var str = JSON.stringify(this.inputAttribute);
            console.log(JSON.parse(str));
          },    
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
    //    console.log("加载完成uxInputChs");
       this.inputAttribute.objectID=sessionStorage.objectID;
    }
  };
</script>

<style lang="scss" scoped>
 .visible{
                overflow: hidden;
                height: auto;
                width: 100%;
                 li:last-child{
                     height: auto;
                     overflow: hidden;
                     padding-bottom: 15px;
                     border-bottom: 5px solid #222222;
                 }
                 .textarea{
                            height:60px!important;
                 }        
                 li{
                   .ux-mb10{
                       margin-bottom: 10px;
                   }
                   .ux-save{
                      float: left;
                      margin-left: 83px;
                       width: 100px;
                       height: 24px;
                       line-height: 24px;
                       color: #fff;
                       font-size: 12px;
                       text-align: center;
                       border-radius: 3px;
                       background-color: #3484F5;
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
                        height: 38px;
                        display: inline-block;
                        line-height: 38px;
                        vertical-align: top;
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
                        textarea 
                        {
                            width:100px;height:48px;overflow:scroll;resize:none;
                            line-height: 23px!important;
                        } 
                        .textarea{
                            height:60px!important;
                        }
                         
                        
                    }
                }
            }
</style>