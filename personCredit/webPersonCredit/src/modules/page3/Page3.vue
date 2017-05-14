<template>
<div class="pagePersonal">
   

<mt-header class="mint-header " title="简历录入">

<!--<router-link to="/page2" slot="left">

<mt-button icon="back" class="f20"></mt-button>

</router-link>-->

</mt-header>
<main>
         <div class="mui-content bgc0">
              <personalExperience class="showList" ></personalExperience> 
         </div>

</main> 




</div>
</template>
<script>

 import personalExperience from '../../components/personalExperience';


export default {
  name: 'page3',
  data() {
    return {
        title:'简历录入',
        educationList:2,
      
    };
  },
 components: {
personalExperience
 },
  methods: {
   
  },
  watch: {
      income (newval,oldval){
      if(newval!=oldval){
      this.income = newval.replace(/[^\d]/g,'');
      }
      },
  },
  mounted () {
console.log("加载完成page3")
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