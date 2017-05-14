<template>
  <div class="bg">
    <mzlNavbar></mzlNavbar>
    <div class="row-box">
      <mzlChart></mzlChart>
      <mzlAssets></mzlAssets>
    </div>
    <div class="row-box">
       <mzlBuying></mzlBuying>
       <mzlInformation></mzlInformation>
    </div>
    <div class="row-box">
       <mzlPay></mzlPay>
    </div>
    <div class="row-box">
       <mzlDealhistory></mzlDealhistory>
    </div>
    <div class="row-box">
      <mzlFooter></mzlFooter>
    </div>
  </div>
</template>
<script>
import mzlNavbar from '../../components/mzlNavbar.vue';
import mzlFooter from '../../components/mzlFooter.vue';
import mzlChart from '../../components/mzlChart.vue';
import mzlAssets from '../../components/mzlAssets.vue';
import mzlBuying from '../../components/mzlBuying.vue';
import mzlInformation from '../../components/mzlInformation.vue';
import mzlPay from '../../components/mzlPay.vue';
import mzlDealhistory from '../../components/mzlDealhistory.vue';
  let vm;
  export default {
    name: 'page1',
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
      mzlNavbar,mzlFooter,mzlChart,mzlAssets,mzlBuying,mzlInformation,mzlPay,mzlDealhistory
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