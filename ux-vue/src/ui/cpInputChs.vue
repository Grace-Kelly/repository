<template>
<div>
    <div class="xms-input">
     
        <input v-on:focus="vnFocus" v-on:blur="vnBlurChs" class="chs"  v-bind:placeholder="cpInputChs.placeholder" v-model="cpInputValue">
    </div>
    
</div>
</template>
<script>
    let cpInputChs = {
        name: 'cpInputChs',
        data() {
            return {
                cpInputValue:"",
              
            };
        },
       props: {
            cpInputChsPlaceholder: {
                type: String,
                default:"文本输入框"
            },
            jumpPage: {
                type: String,
                default: "page2"
            },
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
                        this.cpInputChs.placeholder="请输入正确的文本"
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
               console.log("加载完成cpInputChs")
          
        }
    };
    export default cpInputChs;
</script>
<style lang='scss' scoped>
        
</style>