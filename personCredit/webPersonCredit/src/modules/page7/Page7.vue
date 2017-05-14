<template>


              <!--<authentication v-if="false"></authentication> -->

              <!--<resetPassword v-if="false"></resetPassword> -->
              <!--<changePassword v-if="false"></changePassword>-->
              <changePhoneNumber v-if="true"></changePhoneNumber> 


</template>
<script>

 import authentication from '../../components/authentication.vue';
 import resetPassword from '../../components/resetPassword.vue';
 import changePassword from '../../components/changePassword.vue';
 import changePhoneNumber from '../../components/changePhoneNumber.vue';
export default {
  name: 'page7',
  data() {
    return {
      
    };
  },
 components: {
authentication,resetPassword,changePassword,changePhoneNumber
 },
  methods: {
   
  },
  watch: {

  },
  mounted () {
console.log("加载完成page7")
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