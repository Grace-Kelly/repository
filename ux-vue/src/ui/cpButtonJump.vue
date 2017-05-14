
<template>
    <div  @click.stop.prevent='goPage'>
       {{this.ButtonjumpText}}
    </div>
</template>
<script>
//                  主需要替换首字标签
  export default {
    name: 'cpButtonJump',
    data(){
      return {

      };
    },
    components: {

    },
    props: {
      ButtonjumpText: {
        type: String,
        default: 'cpButtonJump'
      },
      jumpPage: {
        type: String,
        default: "page2"
      },
    },
    methods: {  
      goPage(){
 
        this.$router.push(this.jumpPage)
      }
    },
    watch: {

    },
    mounted() {


 console.log("加载完成cpButtonJump")

    }
    
  };
</script>
<style lang="scss">

</style>