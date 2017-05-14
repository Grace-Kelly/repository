<template>
<div class="pagePersonal">
     <mt-header class="mint-header " title="简历录入">

<!--<router-link to="/page2" slot="left">

<mt-button icon="back"></mt-button>

</router-link>-->

</mt-header>
<main>
         <div class="mui-content bgc0">
              <educationExperience class="showList" v-for="(index, item) in $store.state.educationList" ></educationExperience> 
         </div>
</main>
   




</div>
</template>
<script>
 import educationExperience from '../../components/educationExperience';


export default {
  name: 'page4',
  data() {
    return {
        title:'简历录入',

      
    };
  },
 components: {
educationExperience
 },
  methods: {
   
  },
  watch: {

  },
  mounted () {
console.log("加载完成page4")
  },

};
</script>

<style lang="scss" scoped>
main {
display: block;
width: 100%;
position: absolute;
top: 40px;
bottom: 0;
overflow-y: scroll;
-webkit-overflow-scrolling: touch;
}
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