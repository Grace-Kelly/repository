import Vue from 'vue';
import VueRouter from 'vue-router';
import VueResource from 'vue-resource';

// import $ from 'zepto'
// require('../node_modules/zepto/src/touch.js')

import MintUI from 'mint-ui';

Vue.use(MintUI);

import App from './modules/App.vue'
import appRouter from './modules/AppRouter'
import store from './vuex';

Vue.use(VueRouter);
Vue.use(VueResource);
Vue.http.options.xhr = { withCredentials: true }

new Vue({
	router: appRouter,
	store,
	el: '#app',
	components: {
	}
	
});
