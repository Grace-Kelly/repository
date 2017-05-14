<template>
  <div class="indexPage">
    <transition :name="transitionName" mode="out-in">
      <!--<keep-alive>-->
        <router-view class="child-view"></router-view>
        <!--</keep-alive>-->
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
        // const toDepth = to.path.split('/').length;
        // const fromDepth = from.path.split('/').length;
        this.transitionName = from.meta.backRouter === to.name ? 'slide-right' : 'slide-left';

        // console.log(to);
        // console.log(from);
        // console.log(from.meta.backRouter);
        // console.log(this.transitionName);
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
// @mixin common($value1,$value2,$defaultValue: 12px){
//         display                            : block;
//         margin-left                        : $value1;
//         margin-right                       : $value2;
//         padding                            : $defaultValue;
// }
// .class1{
//         font-size                          : 16px;
//         @include common(12px,13px,15px);
// }
// span {
//     @include left;
// }
// @mixin left { float                        : right; margin-left: 10px; }

$ThemeColors                               : #FF6600;
$ThemeRed                              : #FF0000;
$Themegrey                               : #999999;
$Themeblack                           : #444444;



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