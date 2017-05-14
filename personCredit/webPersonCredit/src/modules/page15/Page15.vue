<template>
<div class="pagePersonal">
     <mt-header class="mint-header is-fixed" title="简历录入">

<!--<router-link to="/page2" slot="left">

<mt-button icon="back"></mt-button>

</router-link>-->

</mt-header>
<main>
         <div class="mui-content bgc0">

              <specialty class="showList" v-for="(index, item) in $store.state.educationList" ></specialty> 
         </div>
</main>
   
</div>
</template>
<script>
 import specialty from '../../components/specialty.vue';
export default {
  name: 'page15',
  data() {
    return {

        educationList:2,
      
    };
  },
 components: {
      specialty
 },
  methods: {
   
  },
  watch: {

  },
  mounted () {
console.log("加载完成page15")
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
main {
display: block;
width: 100%;
position: absolute;
top: 40px;
bottom: 0;
overflow-y: scroll;
-webkit-overflow-scrolling: touch;
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