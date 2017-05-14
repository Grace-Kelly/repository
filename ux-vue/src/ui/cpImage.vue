<template>
    <div class="img-box">
        <img v-bind:src="this.cpImageSrc">  
    </div>
</template>
<script>
    let cpImage = {
        name: 'cpImage',
        data() {
            return {
              
            };
        },
          props: {
            cpImageSrc: {
                type: String,
                default:"../../static/img/chart.png"
            }
        },
        computed:{
        },
        methods:{
           
        },
        components: {
        },
        mounted() {
               console.log("加载完成cpImage")
        }
    };
    export default cpImage;
</script>
<style lang='scss' scoped>
.img-box{
    width       : 100px;
    height  : auto;
    img{
        width: 100%;
        vertical-align: top;
        height: auto;
    }
  }

</style>