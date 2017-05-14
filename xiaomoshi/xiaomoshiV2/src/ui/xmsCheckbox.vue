<template>
    <label :class="[inputClass,checkboxClass,custom?'custom-checkbox':null]">
        <input
                type="checkbox"
                :id="id"
                :name="name"
                :value="value"
                :disabled="disabled"
                :class="[custom?'custom-control-input':null]"
                :checked="checked===value"
                @change="$emit('change',$event.target.checked?value:uncheckedValue)"
        >
        <span class="custom-control-indicator" v-if="custom"></span>
        <span :class="[custom?'custom-control-description':null]"><slot></slot></span>
    </label>
</template>

<script>

    let xmsCheckbox =  {
        name: 'xmsCheckbox',
        data() {
            return {
            };
        },
        props: {
            value: {
                default: true
            },
            uncheckedValue: {
                default: false
            },
            checked: {
                default: true
            }
        },
        methods   : {
            onAnimationEnd() {
            }
        },
        components: {
        },
        mounted() {
            console.log("加载完成xmsCheckbox")
        }
        // model: {
        //     prop: 'checked',
        //     event: 'change'
        // }
    };
    export default xmsCheckbox;
</script>
<style lang='scss' scoped>



</style>