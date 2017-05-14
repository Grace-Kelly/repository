<template>
<div id="example-4" class="demo">
  <input type="radio" id="one" value="One" v-model="picked">
  <label for="one">One</label>
  <br>
  <input type="radio" id="two" value="Two" v-model="picked">
  <label for="two">Two</label>
  <br>
  <span>Picked: {{ picked }}</span>
</div>
</template>
<script>
    let xmsRadio = {
        name: 'xmsRadio',
        data() {
            return {
                 picked: ''
            };
        },
        computed:{

        },
        methods:{
           
        },
        components: {
        },
        mounted() {
               console.log("加载完成xmsRadio")
          
        }
    };
    export default xmsRadio;
</script>
<style lang='scss' scoped>









</style>