<template>

    <div class="head-nav">
        <ul class="nav-list">
        <li> {{ $store.state.username }}</li>
        <li v-if="$store.state.username=== ''" @click="logClick" class="nav-title">登录</li>
        <li class="nav-pile">|</li>
        <li v-if="$store.state.username=== ''" @click="regClick" class="nav-title">注册</li>
        <li v-if="$store.state.username!== ''" @click="quit" class="nav-title">退出</li>
        </ul>
    </div>  
</template>
<script>

    let uxHeaderLog = {
        name: 'uxHeaderLog',
        data () {

        },
        computed:{
          zoom:function(){
                return this.zomm = Number((this.scaleX *100).toFixed(1));
          }
        },
        methods:{
           quit () {
                this.$store.commit("deleteUsername")
            },
            logClick () {
                this.$store.commit("isShowLogDialog");
            },
            regClick () {
               this.$store.commit("isShowRegDialog");
            },

        },
        components: {
   
        },
        mounted() {
               console.log("加载完成uxHeaderLog")
          }
    };
    export default uxHeaderLog;
</script>
<style lang='scss' scoped>

.head-nav {
    background-color: transparent;
    width: auto;
    float: right;
    height: 30px;
    margin-top: 15px;
    margin-right: 20px;
    text-align: center
}
.head-nav ul {
  overflow: hidden;
}
.head-nav li {
  cursor: pointer;
  float: left;
  font-size: 14px;
  line-height: 30px;
  color: #fff;
  text-align: center;
}
.head-nav .nav-title{
  cursor: pointer;
  background: transparent;
  width: 50px;
  border-radius: 3px;
}
.head-nav .nav-title:hover{
  cursor: pointer;
  background: #3484F5;
}
.nav-pile {
  padding: 0 5px;
}
.app-foot {
  text-align: center;
  height: 80px;
  width: 100%;
  line-height: 80px;
  background: #e3e4e8;
  clear: both;
  margin-top: 30px;
}
.container {
  width: 1200px;
  margin: 0 auto;
}
.hr {
  height: 1px;
  width: 100%;
  background: #ddd;
}
.button {
  background: #4fc08d;
  color: #fff;
  display: inline-block;
  padding: 10px 20px;
  cursor: pointer;
}
.button:hover {
  background: #4fc08d;
}

.g-form-line {
  padding: 15px 0;
}
.g-form-label {
  width: 100px;
  font-size: 16px;
  display: inline-block;
}
.g-form-input {
  display: inline-block;
}
.g-form-input input {
  height: 30px;
  width: 200px;
  line-height: 30px;
  vertical-align: middle;
  padding: 0 10px;
  border: 1px solid #ccc;
}
.g-form-btn {
  padding-left: 100px;
}
.g-form-error {
  color: red;
  padding-left: 15px;
}


</style>