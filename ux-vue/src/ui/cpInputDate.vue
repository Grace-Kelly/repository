<template>
   <input id="meeting" type="date" value="2014-01-13"/>
</template>
<script>
                  // 需要判断浏览器Firefox兼容性有问题
    let cpInputDate = {
        name: 'cpInputDate',
        data() {
            return {
            };
        },
        computed:{
        },
        methods:{
        },
        components: {
        },
        mounted() {
               console.log("加载完成cpInputDate")
        }
    };
    export default cpInputDate;
</script>
<style lang='scss' scoped>

</style>