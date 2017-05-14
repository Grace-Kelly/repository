//触发状态改变
//调用 @click='$store.commit("jia")'

function updateFactList(state, list) {
  state.factList = list;
}
function changeId(state, list) {
  state.id = list;
}

function updateCompanyNo(state, list) {
  state.companyNo = list;
}
function updatePersonNo(state, list) {
  state.personNo = list;
}
function updateStatus_auth(state) {
  state.status_auth = 1;
}
function updateStatus(state,list) {
  state.status = list;
}

function addEducation(state) {
  state.educationList += 1;
}
function formsStateChange(state) {
  state.formsState = false;
}
function formsStateOpen(state) {
  state.formsState = true;
}
var mutations = {
  addEducation: addEducation,
  formsStateChange:formsStateChange,
  formsStateOpen:formsStateOpen,
  updateStatus:updateStatus,
  changeId:changeId,
  updateFactList:updateFactList,
  updateCompanyNo:updateCompanyNo,
  updatePersonNo:updatePersonNo
};



export default mutations;
