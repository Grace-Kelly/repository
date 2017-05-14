<template>
  <div class="bg">
   <uxHeader></uxHeader>
    <uxIframe></uxIframe>
    <uxLeftsidebar></uxLeftsidebar>
    <uxRightSidebar></uxRightSidebar>
    <!--<uxLogForm></uxLogForm>-->
    <uxDialog v-show="$store.state.isShowLogDialog">
      <uxLogForm></uxLogForm>
    </uxDialog>
    <uxDialog  v-show="$store.state.isShowRegDialog" >
      <uxRegForm></uxRegForm>
    </uxDialog>
 </div>
</template>
<script>
import uxHeader from '../../components/uxHeader.vue';
import uxLeftsidebar from '../../components/uxLeftsidebar.vue';
import uxRightSidebar from '../../components/uxRightSidebar.vue';
import uxIframe from '../../components/uxIframe.vue';
import uxLogForm from '../../components/uxLogForm.vue';
import uxRegForm from '../../components/uxRegForm.vue';
import uxDialog from '../../components/uxDialog.vue';
  let vm;
  export default {
    name: 'page1',
    data() {
      return {
        
       };
     },
    computed:{
      // provinceList: changeDataction () {
      //   return this.$store.state.provinceList;
      // }
     },
     created: function () {
      // vm = this;
     },
    components: {
      uxHeader,uxLeftsidebar,uxRightSidebar,uxIframe,uxLogForm,uxRegForm,uxDialog
    },
    methods: {
   
    },
    mounted () {
    }
  };
</script>

<style lang="scss" scoped>


</style>