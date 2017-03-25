import Vue from 'vue';
//异步动作
function getProvince(store) {
  // Vue.http.get('http://10.20.0.72/stuAdminWeixin/www/Api/getProvince/2').then((response) => {
    // success callback
    // store.commit('updateProvinceList', response.data.content);
    // store.state.provinceList = response.data.content;
  // }, (response) => {
    // error callback
    // console.log(response);
  // });
  console.log("22")
}

var actions = {
  getProvince: getProvince
};



export default actions;
