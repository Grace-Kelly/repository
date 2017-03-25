<template>
   
<div class="backhome-btn frc1">
     <span class="pic-cup fa fa-heart">
         <img src="assets/img/pic-cup.png" alt=""/>
     </span> 
     <p>继续签到</p>

 </div>
</template>

<script>
  
    let muiBackTop = {
       
        data() {
            return {
               
            };
        },
        methods: {
            
        },
        props: [

        ],
        components: {
         
        },
        mounted() {
            console.log("加载完成muiBackTop")
        }
    };


    export default muiBackTop;
</script>
<style lang='scss' scoped>
 .backhome-btn {
            position: fixed;
            bottom: 60px;
            right: 20px;
            z-index: 5;
            border-radius: 35px;
            background-color: #FC5453;
            border: 3px solid #ffffff;
            padding-top:0;
            width: 62px;
            height: 62px;
            text-align: center;
            box-shadow: 0 0 2px #d3d3d3,0 0 2px #d3d3d3,0 0 1px #d3d3d3,0 0 1px #d3d3d3,0 0 1px #d3d3d3;
        }
        .backhome-btn p{
            text-align: center;
            font-size: 10px;
            line-height: 20px;
            color: #FFFFFF;
            margin-top: -10px;
        }

        .pic-cup{
            display: inline-block;
            width: 35px;
            height: 35px;
            margin-bottom: 1px;
        }
        .pic-cup img{
            width: 100%;
        }  


</style>