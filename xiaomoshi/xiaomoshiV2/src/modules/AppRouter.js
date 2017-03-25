import IndexPage from './App';
import VueRouter from 'vue-router';

import Page1Router from './page1/Page1Router.js';
import Page2Router from './page2/Page2Router.js';
import Page3Router from './page3/Page3Router.js';
import Page4Router from './page4/Page4Router.js';
import Page5Router from './page5/Page5Router.js';

const router = new VueRouter({
  routes: [{
    path: '/',
    component: IndexPage,
    redirect: '/page1',
    children: [
      Page1Router,
      Page2Router,
      Page3Router,
      Page4Router,
      Page5Router
    ]
  }]
});

export default router;
