//触发状态改变
//调用 @click='$store.commit("jia")'

function updateProvinceList(state, list) {
  state.provinceList = list;
}
function yy(){
        console.log("mutations")
}


var mutations = {
  yy: yy
};



export default mutations;
