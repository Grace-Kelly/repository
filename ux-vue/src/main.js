import Vue from 'vue';
import VueRouter from 'vue-router';
import VueResource from 'vue-resource';

import App from './modules/App.vue'
import appRouter from './modules/AppRouter'
import store from './vuex';

Vue.use(VueRouter);
Vue.use(VueResource);

new Vue({
	router: appRouter,
	store,
	el: '#app',
	components: {
	}
	
});
