
(function($){


//                                   --水印--

//   $.fn.watermark = function(options){
//     options = $.extend({watermarkClass:"watermark"},options||{});
//     return this.focus(function(){
//         var field = $(this);
//         if(field.val() == field.attr('title')){
//             field.val('').removeClass(options.watermarkClass);
//         }
//     }).blur(function(){
//         var field = $(this);
//         if(field.val=''){
//             field.val(field.attr('title')).addClass(options.watermarkClass);
//         }
//     }).blur();
// }
// $.fn.clearWatermark = function(){
//     return this.each(function(){
//         var field=$(this);
//         if(field.val()==field.attr('title')){
//             field.val('');
//         }
//     })
// }

//  $('input.wmark').watermark();
// $('#submit').on("click",function(){
//     $('input.wmark').clearWatermark();
//     console.log('Welcome' + $('#first').val()+''+$('#last').val());
//     $('input.wmark').blur();
// });


//                                   --缩小元素--

//   let  scaleX=1; scaleY=1;
//     $.fn.extend({
//         uxZoomIn:function(){    
//           if( Number(scaleX.toFixed(1))===0.5){
//             scaleX=0.5;
//           }else{
//              scaleX-=0.1;
//             $("#iframe").contents().find("body").css("transform",`scale(${scaleX.toFixed(1)})`);
//           }
//         },
//         uxZoomOut:function(){
//             scaleX+=0.1;
//             $("#iframe").contents().find("body").css("transform",`scale(${scaleX.toFixed(1)})`);
//             // $("#iframe").contents().find("body").css("margin-top","10%");
//             //  $("#iframe").contents().find("body").css("margin-left","10%");
//           },
// //                                     跳转iframe
//         goToPage:function(page){
//             console.log(`${page}.html`);
//             document.getElementById("iframe").src=`${page}.html`; 
//         }    

//     });

//     $(".ux-zoom-in").on("click",function(){
//         $(this).uxZoomIn();
//     })
//     $(".ux-zoom-out").on("click",function(){
//         $(this).uxZoomOut();
//     })
//                                     跳转iframe
 

    //                                    --刷新页面--
        $('#pdateIframeBtn').on("click",function () {
        console.log(1)
    //      方法1
        $("#haha ").loacation.href="./indexall2.html";
    //      方法2
        $("#haha ").reload;
        console.log(2)
        })



    //                                  控制ifrem的元素  缩小
    // $('.try1').on("click",function () {
    // console.log(1);
    // $(".try1",document.frames('iframe').document).css("background-color","grey")
    // $(window.frames["iframe"].document).find(".try1").css("background-color","grey");
    //   console.log($(document.getElementById('iframe').contentWindow.document.body).html())
    //   $("#iframe").contents().find(".try1").css("background-color","grey");
    // $("#iframe").contents().find("body ").css("transform","scale3d(.5,.5,.5)");
    //       $("#iframe").contents().find(".try1").css("background-color","grey");
    //     $(window.frames["iframe"].document).find(".try1").css("background-color","grey");
    //   $(window.frames["iframe"].document).find(".try1").css("background-color","grey");
    //   $("#iframe").contents().find("body").css("zoom:","70%");
    //
    // console.log(2);
    // })

    //                                控制iframe外层缩放比例；
    // function bigit()
    // {
    // var w=Number(document.all.iframe.width)+100;
    // var h=Number(document.all.iframe.height)+100;
    // //alert(w+','+h);
    // document.all.iframe.width=w;
    // document.all.iframe.height=h;
    // }
    // function smait()
    // {
    // var w=Number(document.all.iframe.width)-100;
    // var h=Number(document.all.iframe.height)-100;
    // //alert(w+','+h);
    // document.all.iframe.width=w;
    // document.all.iframe.height=h;
    // }


})(jQuery);


