//触发状态改变
//调用 @click='$store.commit("jia")'

function updateProvinceList(state, list) {
  state.provinceList = list;
}
//写入用户名
function changeUsername(state,data){
  state.username=data
}
function deleteUsername(state){
  state.username=''
}
//切换弹出框
function isShowLogDialog(state){
  state.isShowLogDialog=true;
}
function isCloseLogDialog(state){
  state.isShowLogDialog=false;
}

function isShowRegDialog(state){
  state.isShowRegDialog=true;
}
function isCloseRegDialog(state){
  state.isCloseRegDialog=false;
}
// 切换选项卡
function switch1Status(state){
  state.switch.switch1=1;  
  state.switch.switch2=0;  
  state.switch.switch3=0;  

}
function switch2Status(state){
  state.switch.switch1=0;  
  state.switch.switch2=1;  
  state.switch.switch3=0;  

}
function switch3Status(state){
  state.switch.switch1=0;  
  state.switch.switch2=0;  
  state.switch.switch3=1; 

}
// 基础状态改变
function baseStatus(state){
  state.baseAttribute.baseVisible=0;  
}

//uxInputChs
function inputChsStatus(state){
  // state.baseAttribute.baseVisible=1; 
  // state.className=sessionStorage.className;

  state.inputAttribute.uxInputChs=1;
    
  // state.inputAttribute.uxInputChs=0;
  state.inputAttribute.radioVisible=0;     
  state.inputAttribute.checkVisible=0;  
  state.inputAttribute.uploadVisible=0;  
  state.inputAttribute.inputDataVisible=0;  
  state.inputAttribute.buttonJumpVisible=0;  
  state.inputAttribute.imageVisible=0;  
  state.inputAttribute.pullDownVisible=0;  
}

function radioStatus(state){
   state.inputAttribute.uxInputChs=0;
  state.inputAttribute.radioVisible=1;     
  state.inputAttribute.checkVisible=0;  
  state.inputAttribute.uploadVisible=0;  
  state.inputAttribute.inputDataVisible=0;  
  state.inputAttribute.buttonJumpVisible=0;  
  state.inputAttribute.imageVisible=0;  
  state.inputAttribute.pullDownVisible=0; 
}
function checkStatus(state){
   state.inputAttribute.uxInputChs=0;
  state.inputAttribute.radioVisible=0;     
  state.inputAttribute.checkVisible=1;  
  state.inputAttribute.uploadVisible=0;  
  state.inputAttribute.inputDataVisible=0;  
  state.inputAttribute.buttonJumpVisible=0;  
  state.inputAttribute.imageVisible=0;  
  state.inputAttribute.pullDownVisible=0; 
}
function uploadStatus(state){
   state.inputAttribute.uxInputChs=0;
  state.inputAttribute.radioVisible=0;     
  state.inputAttribute.checkVisible=0;  
  state.inputAttribute.uploadVisible=1;  
  state.inputAttribute.inputDataVisible=0;  
  state.inputAttribute.buttonJumpVisible=0;  
  state.inputAttribute.imageVisible=0;  
  state.inputAttribute.pullDownVisible=0;
}
function inputDataStatus(state){
   state.inputAttribute.uxInputChs=0;
  state.inputAttribute.radioVisible=0;     
  state.inputAttribute.checkVisible=0;  
  state.inputAttribute.uploadVisible=0;  
  state.inputAttribute.inputDataVisible=1;  
  state.inputAttribute.buttonJumpVisible=0;  
  state.inputAttribute.imageVisible=0;  
  state.inputAttribute.pullDownVisible=0; 
}
function buttonJumpStatus(state){
  state.inputAttribute.uxInputChs=0;
  state.inputAttribute.radioVisible=0;     
  state.inputAttribute.checkVisible=0;  
  state.inputAttribute.uploadVisible=0;  
  state.inputAttribute.inputDataVisible=0;  
  state.inputAttribute.buttonJumpVisible=1;  
  state.inputAttribute.imageVisible=0;  
  state.inputAttribute.pullDownVisible=0;  
}
function imageStatus(state){
   state.inputAttribute.uxInputChs=0;
  state.inputAttribute.radioVisible=0;     
  state.inputAttribute.checkVisible=0;  
  state.inputAttribute.uploadVisible=0;  
  state.inputAttribute.inputDataVisible=0;  
  state.inputAttribute.buttonJumpVisible=0;  
  state.inputAttribute.imageVisible=1;  
  state.inputAttribute.pullDownVisible=0;
}
function pullDownStatus(state){
  state.inputAttribute.uxInputChs=0;
  state.inputAttribute.radioVisible=0;     
  state.inputAttribute.checkVisible=0;  
  state.inputAttribute.uploadVisible=0;  
  state.inputAttribute.inputDataVisible=0;  
  state.inputAttribute.buttonJumpVisible=0;  
  state.inputAttribute.imageVisible=0;  
  state.inputAttribute.pullDownVisible=1;  
}


var mutations = {
  // baseStatus:baseStatus,
  //组件开关
inputChsStatus:inputChsStatus,
radioStatus:radioStatus,
checkStatus:checkStatus,
uploadStatus:uploadStatus,
inputDataStatus:inputDataStatus,
buttonJumpStatus:buttonJumpStatus,
imageStatus:imageStatus,
pullDownStatus:pullDownStatus,

  switch1Status:switch1Status,
  switch2Status:switch2Status,
  switch3Status:switch3Status,
  checkStatus:checkStatus,
  isShowLogDialog:isShowLogDialog,
  isCloseLogDialog:isCloseLogDialog,
  isShowRegDialog:isShowRegDialog,
  isCloseRegDialog:isCloseRegDialog,
  changeUsername:changeUsername,
  deleteUsername:deleteUsername
};



export default mutations;
