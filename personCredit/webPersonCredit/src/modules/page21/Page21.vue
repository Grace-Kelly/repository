<template>


              <companyAuthentication></companyAuthentication> 



</template>
<script>

 import companyAuthentication from '../../components/companyAuthentication.vue';
export default {
  name: 'page21',
  data() {
    return {
      
    };
  },
 components: {
companyAuthentication
 },
  methods: {
   
  },
  watch: {

  },
  mounted () {

  },
};
</script>

<style lang="scss" scoped>
.showList{ 
display: none;

}
.showList:last-child{
  display: block;

}


.child-view {
 transition                                : all 0.3s cubic-bezier(0,1,.4,1);
    height                                 : 100%;
}
 
.slide-left-enter,
.slide-right-leave-active {
    opacity                                : 0.25;
    -webkit-transform                      : translate(100%, 0);
    transform                              : translate(100%, 0);
}
.slide-left-leave-active,
.slide-right-enter {
    opacity                                : 0.25;
    -webkit-transform                      : translate(-100%, 0);
    transform                              : translate(-100%, 0);
}
</style>