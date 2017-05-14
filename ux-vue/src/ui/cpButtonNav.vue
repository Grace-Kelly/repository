
<template>
<ul class="xms-buttonNav">
  <li class="xms-navPills"  v-for="(item, index) of this.buttonNavList">
    <a >{{item.text}}</a>
   </li>
</ul>
</template>
<script>
//                  主需要替换首字标签
  export default {
    name: 'cpButtonNav',
    data(){
      return {

      };
    },
    components: {

    },
    props: {
      buttonNavNub: {
        type: Number,
        default: '3'
      },
      buttonNavList: {
        type: Array,
        default: function () {
          return [{
            text: 'item1'
          }, {
            text: 'item2'
          }]
      },
    },
    },
    methods: {  
      goPage(){
 
        this.$router.push(this.jumpPage)
      }
    },
    watch: {

    },
    mounted() {


 console.log("加载完成cpButtonNav")

    }
    }
  
</script>
<style lang="scss"scoped>

.xms-buttonNav{
  padding-left: 0;
    margin-bottom: 0;
    list-style: none;
    display: table;
    font-size: 0px;
    white-space: nowrap;
    height: 40px;
    width: 200px;
    text-align: center;
  .xms-navPills{
   display: table-cell;
   vertical-align: middle;
   border-radius: 3px;
    a{
      border-radius: 2px;
      color: #337ab7;
      font-size: 14px;
    }
  }
  .xms-navPills:hover{
    background-color: #F1F1F1;
  }
  .xms-active{
    color: #fff;
    background-color: #337ab7;
  }
}

</style>