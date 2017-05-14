<template>
<div class="pagePersonal">
     <mt-header class="mint-header " title="简历录入">

<!--<router-link to="/page2" slot="left">

<mt-button icon="back"></mt-button>

</router-link>-->

</mt-header>
<main>
         <div class="mui-content bgc0">

              <workExperience class="showList" v-for="(index, item) in $store.state.educationList" ></workExperience> 
         </div>
</main>
   




</div>
</template>
<script>
 import workExperience from '../../components/workExperience';


export default {
  name: 'page5',
  data() {
    return {
        title:'简历录入',
        educationList:2,
      
    };
  },
 components: {
workExperience
 },
  methods: {
   
  },
  watch: {

  },
  mounted () {
console.log("加载完成page5")
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