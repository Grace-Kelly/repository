import Vue from 'vue';
import Vuex from 'vuex';
import actions from './actions';
import getters from './getters';
import mutations from './mutations';

Vue.use(Vuex);
//state 状态对象
let mainStore = new Vuex.Store({
  state: {
    provinceList: [{
      MC: '123'
    }],
    //
    username:'',
    //log-dialog
    isShowLogDialog:false,
    //reg-dialog
    isShowRegDialog:false,
    className:"div",
    switch:{
      switch1:"1",
      switch2:"0",
      switch3:"0"
    },
    // input基础组件的显示开关
    // baseAttribute:{
    //   baseVisible:1
    // },
   // input下拉组件显示开关
    inputAttribute:{
     
      uxInputChs:0,
      radioVisible:0,
      checkVisible:0,
      uploadVisible:0,
      inputDataVisible:0,
      buttonJumpVisible:0,
      imageVisible:0,
      pullDownVisible:0,
    }    
  },
  mutations: mutations,
  actions: actions,
  getters: getters
});


export default mainStore;
