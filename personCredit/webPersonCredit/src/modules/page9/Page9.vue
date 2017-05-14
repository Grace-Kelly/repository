<template>


              <authentication></authentication> 



</template>
<script>

 import authentication from '../../components/authentication.vue';
export default {
  name: 'page9',
  data() {
    return {
      
    };
  },
 components: {
authentication
 },
  methods: {
   
  },
  watch: {

  },
  mounted () {
console.log("加载完成page9")
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