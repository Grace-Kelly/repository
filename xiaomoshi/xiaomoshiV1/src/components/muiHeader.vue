
<template>
  <header class="mui-bar mui-bar-nav" >
      <router-link to="/" slot="left">
        <a class="mui-icon mui-icon-left-nav"> </a>
      </router-link >
        <h1 class="mui-title" 
            :class="computeClass(headerClass)"
            :style="{fontSize:headerClass[0].size+'px!important'}"
        >
            {{headerClass[0].size}}
        </h1>
    </header>
</template>
<script>

let muiHeader = {
    name: 'muiHeader',
    data() {
        return {
            
        };
    },
    methods: {
        computeClass:function(res){
            return "classA"
        }
    },
    props: [
      "headerClass"
    ],
    components: {
  
    },
    mounted () {
        console.log("加载完成muiHeader");
       
    }
};



export default muiHeader;
</script>
<style lang='scss' scoped>
.mui-bar-nav a , .mui-bar-nav h1{
    color: #F8884D;
}
.classA{
  color: #000!important;  
}
</style>
