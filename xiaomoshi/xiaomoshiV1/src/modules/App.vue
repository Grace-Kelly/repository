<template>
  <div class="indexPage">
    <transition :name="transitionName" mode="out-in">
      <keep-alive>
        <router-view class="child-view"></router-view>
        </keep-alive>
    </transition>
  </div>
</template>
<script>

  export default {
    name: 'app',
    data() {
      return {
        transitionName: 'slide-left',
       
      };
    },
    computed: {
      title() {
        return this.$store.state.title;
      }
    },
    components: {
    

    },
    watch: {
      $route: function (to, from) {
        this.transitionName = from.meta.backRouter === to.name ? 'slide-right' : 'slide-left';
      }
    },
    methods: {
      // startHacking() {
      //   this.$toast('It Works!');
      // }
    },
    mounted() {
      console.log("加载完成App.vue");
  
  
    }
  };
</script>


<style lang='scss' scoped>

.indexPage{
  height                                   : 100%;
  background-color                         : #fff;
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