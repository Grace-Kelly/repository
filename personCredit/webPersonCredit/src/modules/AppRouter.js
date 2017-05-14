import IndexPage from './App';
import VueRouter from 'vue-router';

import Page1Router from './page1/Page1Router.js';
import Page2Router from './page2/Page2Router.js';
import Page3Router from './page3/Page3Router.js';
import Page4Router from './page4/Page4Router.js';
import Page5Router from './page5/Page5Router.js';
import Page6Router from './page6/Page6Router.js';
import Page7Router from './page7/Page7Router.js';
import Page8Router from './page8/Page8Router.js';
import Page9Router from './page9/Page9Router.js';
import Page10Router from './page10/Page10Router.js';
import Page11Router from './page11/Page11Router.js';
import Page12Router from './page12/Page12Router.js';
import Page13Router from './page13/Page13Router.js';
import Page14Router from './page14/Page14Router.js';
import Page15Router from './page15/Page15Router.js';
import Page16Router from './page16/Page16Router.js';
import Page17Router from './page17/Page17Router.js';
import Page18Router from './page18/Page18Router.js';
import Page19Router from './page19/Page19Router.js';
import Page20Router from './page20/Page20Router.js';
import Page21Router from './page21/Page21Router.js';
import Page22Router from './page22/Page22Router.js';
import Page23Router from './page23/Page23Router.js';
import Page24Router from './page24/Page24Router.js';

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
      Page5Router,
      Page6Router,
      Page7Router,
      Page8Router,
      Page9Router,
      Page10Router,
      Page11Router,
      Page12Router,
      Page13Router,
      Page14Router,
      Page15Router,
      Page16Router,
      Page17Router,
      Page18Router,
      Page19Router,
      Page20Router,
      Page21Router,
      Page22Router,
      Page23Router,
      Page24Router
    ]
  }]
});

export default router;
