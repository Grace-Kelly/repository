<template>
<div>
    <div class="xms-input">
     
        <input v-on:focus="vnFocus" v-on:blur="vnBlurChs" class="chs"  v-bind:placeholder="cpInputChs.placeholder" v-model="cpInputChs.value">
    </div>
    <!--<div class="xms-input">
    
        <input v-on:focus="vnFocus" v-on:blur="vnBlurEn" class="en" placeholder="{{cpInputEn.placeholder}}">
    </div>
     <div class="xms-input">
       
        <input v-on:focus="vnFocus" v-on:blur="vnBlurPassword" class="password" placeholder="{{cpInputPassword.placeholder}}">
    </div>
    <div class="xms-input"> 
        <input v-on:focus="vnFocus" v-on:blur="vnBlurCpInputFileUpLoad" class="cpInputFileUpLoad" placeholder="{{cpInputFileUpLoad.placeholder}}">
    </div>
    <div class="xms-input"> 
        <input v-on:focus="vnFocus" v-on:blur="vnBlurCpInputPicUpload" class="cpInputPicUpload" placeholder="{{cpInputPicUpload.placeholder}}">
    </div>
    <div class="xms-textarea">
        <textarea class="cptextarea" placeholder="{{cptextarea.placeholder}}">
    </div>-->
</div>
</template>
<script>
    let cpInputEn = {
        name: 'cpInputEn',
        data() {
            return {
                cpInputChs:{
                    placeholder:"中文输入框",
                    value:""
                },
                cpInputEn:{
                    placeholder:"英文输入框",
                    value:""    
                },
                
                cpInputPassword:{
                    placeholder:"密码输入框",
                    value:""      
                },
                 cpInputFileUpLoad:{
                    placeholder:"文件上传框",
                    value:""      
                },
                 cpInputPicUpload:{
                    placeholder:"图片上传",
                    value:""      
                },
                 cptextarea:{
                    placeholder:"文本域输入框",
                    value:""      
                }
            };
        },
        
        methods:{
                vnBlurChs(){
                    console.log(2)
                 var reg =/[\u4e00-\u9fa5]/;
                let cpInputChs = this.cpInputChs.value
                    if (!cpInputChs) {
                        this.cpInputChs.placeholder="输入内容不能为空"
                        return false;
                    }
                    if (!reg.test(cpInputChs)) {
                        this.cpInputChs.placeholder="请输入正确的中文字符"
                        return false;
                    }
                },
                vnFocus(){
                    console.log("已获取焦点")
                }
                    
        },
        computed:{
           
        },
        mounted() {
               console.log("加载完成cpInputEn")
          
        }
    };
    export default cpInputEn;
</script>
<style lang='scss' scoped>
        
</style>