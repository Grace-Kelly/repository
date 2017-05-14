<template>
 <div v-if="$store.state.inputAttribute.uxRadio" class="visible">
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
                <div class="ux-attribute">关联labal</div>
                <div class="ux-pageinformation">
                   <p class="ux-InfoRow">   
                      <select class="cpSelect" v-model="inputAttribute.Verification">
                      <option value="labal1">labal1</option>
                      <option value="labal2">labal2</option>
                      </select>
                  </p>
                </div>
                   </li>
               <li>
                <div class="ux-attribute">默认状态</div>
                <div class="ux-pageinformation">
                   <p class="ux-InfoRow">   
                      <select class="cpSelect" v-model="inputAttribute.wordCoun">
                      <option value="选中">选中</option>
                      <option value="未选中">未选中</option>
                      </select>
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
                   <div class="ux-save" @click="save()">保存</div> 
               </li>
   
            
     </div>
</template>
<script>
  let vm;
  export default {
    name: 'uxRadio',
    data() {
      return {
        // inputData 
            inputAttribute:{    
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

     },
      methods:{     
          save(){ 
              console.log(sessionStorage.objectID)
            // this.inputAttribute.objectID=sessionStorage.objectID;
            // var str = JSON.stringify(this.inputAttribute);
            // console.log(JSON.parse(str));
          }
        },
     created: function () {
     },
    components: {
      
    },
    mounted () {
    //    console.log("加载完成uxRadio");
     
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