<template>

<div>

<!--<xmsCheckbox v-model="state" value="accepted" unchecked-value="not_accepted">
  I accept terms and use
  </xmsCheckbox>-->
<!--<div>State: <strong>{{state}}</strong></div>-->

</div>
</template>
<script>
import xmsCheckbox from '../../ui/xmsCheckbox.vue';
  let vm;
  export default {
    name: 'page2',
    data() {
      return {
            // mzlNavbar:mzlNavbar,
       };
     },
    computed:{
      // provinceList: function () {
      //   return this.$store.state.provinceList;
      // }
     },
    created: function () {
      // vm = this;
     },
    components: {
      xmsCheckbox
    },
    methods: {
      
    },
    mounted () {
    }
  };
</script>

<style lang="scss" scoped>
.bg{
  // text-align: center;
  width: 100%;
  display: block;
  min-height:820px;
  opacity: 1;
  background:#222222;
  margin: 0 0;
}   
//                           --start-margin scss计算公式--- 
// @mixin common($valueX1,$valueX2,$valueY1,$valueY2,$defaultWidthX:0px,$defaultWidthY:0px)  {
//         display:inline-block;
//         margin-left: valueX1-valueX2-$defaultWidthX;
//         margin-top:valueY1-valueY2-$defaultWidthY;      
// }
// .class1{
//         font-size:16px;
//         @include common(12px,13px,15px,1px);
// }
// }

//                           --end-mixin--- 


</style>