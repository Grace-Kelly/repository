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


<style lang='scss'>
$colorBlue:#3484F5;
$colorGrey:#56595A;
$colorFont:#56595A;
* {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font:inherit;
	vertical-align: baseline;
}
ul,li{
   list-style: none;
}
@font-face {
  font-family: 'iconfont';  /* project id 238247 */
  src: url('//at.alicdn.com/t/font_sevewamkg0dg3nmi.eot');
  src: url('//at.alicdn.com/t/font_sevewamkg0dg3nmi.eot?#iefix') format('embedded-opentype'),
  url('//at.alicdn.com/t/font_sevewamkg0dg3nmi.woff') format('woff'),
  url('//at.alicdn.com/t/font_sevewamkg0dg3nmi.ttf') format('truetype'),
  url('//at.alicdn.com/t/font_sevewamkg0dg3nmi.svg#iconfont') format('svg');
}
.indexPage{
  width              : 100%;
  height             : 100%;
  background-color   : #fff;
}
.child-view {
 transition          : all 0.3s cubic-bezier(0,1,.4,1);
    height           : 100%;
}
 
.slide-left-enter,
.slide-right-leave-active {
    opacity          : 0.25;
    -webkit-transform: translate(100%, 0);
    transform        : translate(100%, 0);
}
.slide-left-leave-active,
.slide-right-enter {
    opacity          : 0.25;
    -webkit-transform: translate(-100%, 0);
    transform        : translate(-100%, 0);
}
.xms-open{
      height: auto;
      // display: block;
      -webkit-transform: translate(0, 0);
      transform        : translate(0, 0);
  }
  .xms-close{
      // display: none;
      -webkit-transform: translate(200%, 0);
      transform        : translate(200%, 0);
  }
  .on{
    background-color: #292C2E;
    color: #fff;
    }
</style>