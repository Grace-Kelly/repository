import Vue from 'vue';
import Vuex from 'vuex';
import actions from './actions';
import getters from './getters';
import mutations from './mutations';

Vue.use(Vuex);
//state 状态对象
let mainStore = new Vuex.Store({
  state: {
    status:1,
    companyNo:'',
    personNo:'',
    status_auth:0,
    factList: {},
    educationList:1,
    id:'',
    formsState:false
    ,
  },
  mutations: mutations,
  actions: actions,
  getters: getters
});


export default mainStore;
