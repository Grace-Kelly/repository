<template>
    <div>
      <input
                type="checkbox"
                :value="1"
        >
        {{cpCheckboxes.value}}
    </div>
</template>
<script>
    let cpCheckboxes = {
        name: 'cpCheckboxes',
        data() {
            return {
                cpCheckboxes:{
                    value:"11"
                }
            };
        },
        computed:{

        },
        methods:{
            
        },
        components: {
        },
        mounted() {
               console.log("加载完成cpCheckboxes")
          
        }
    };
    export default cpCheckboxes;
</script>
<style lang='scss' scoped>




</style>