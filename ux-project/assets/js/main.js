
(function($){


//                                   --水印--

  $.fn.watermark = function(options){
    options = $.extend({watermarkClass:"watermark"},options||{});
    return this.focus(function(){
        var field = $(this);
        if(field.val() == field.attr('title')){
            field.val('').removeClass(options.watermarkClass);
        }
    }).blur(function(){
        var field = $(this);
        if(field.val=''){
            field.val(field.attr('title')).addClass(options.watermarkClass);
        }
    }).blur();
}
$.fn.clearWatermark = function(){
    return this.each(function(){
        var field=$(this);
        if(field.val()==field.attr('title')){
            field.val('');
        }
    })
}

 $('input.wmark').watermark();
$('#submit').on("click",function(){
    $('input.wmark').clearWatermark();
    console.log('Welcome' + $('#first').val()+''+$('#last').val());
    $('input.wmark').blur();
});

//                                   --选项卡调用--
        function getTypeElement(es, type){//获取指定类型的节点
            var esLen = es.length,
                i = 0,
                    eArr = [],
                    esI = null;
            for(; i < esLen ; i++){
                esI = es[i];
                if(esI.nodeName.replace("#", "").toLocaleLowerCase() == type){
                    eArr.push(esI);
                }
            }
            return eArr;
        }

        function uxTabSwitch(e){
            var divs = getTypeElement(e.childNodes, "div"),
                    l = divs.length,
                    i = 0;
            for(; i < l;i++){
                divs[i].onclick = function(){//单击切换按钮
                    for(var ii = 0; ii < l; ii++){//改为未被选中状态
                        divs[ii].className = "";//删除选项卡的边框
                        //隐藏内容
                        document.getElementById(`uxTabSwitch${ii+1}`).style.display = "none";
                        document.getElementById(`uxTabSwitch${ii+1}right`).style.display = "none";
                    }
                    this.className = "on";//设置当前元素的选中样式
                    //获取指定内容的对象，并显示
                    document.getElementById(this.getAttribute("data-targent")).style.display = "block";
                    document.getElementById(`${this.getAttribute("data-targent")}right`).style.display = "block";
                }
            }
        }

        uxTabSwitch(document.getElementById("uxTabSwitch"));//Tab选项卡切换


//                                   --缩小元素--

  let  scaleX=1; scaleY=1;
    $.fn.extend({
        alertWhileClick: function() {
            $(this).click(function() {
                alert($(this).val());
            });
        },
        uxZoomIn:function(){ 
          
          if( Number(scaleX.toFixed(1))===0.5){
            scaleX=0.5;
          }else{
             scaleX-=0.1;
            $("#iframe").contents().find("body").css("transform",`scale(${scaleX.toFixed(1)})`);
          }
         
        },
        uxZoomOut:function(){
            scaleX+=0.1;
            $("#iframe").contents().find("body").css("transform",`scale(${scaleX.toFixed(1)})`);
            // $("#iframe").contents().find("body").css("margin-top","10%");
            //  $("#iframe").contents().find("body").css("margin-left","10%");
          },
//                                     跳转iframe
        goToPage:function(page){
            console.log(`${page}.html`);
            document.getElementById("iframe").src=`${page}.html`; 
        }    

    });

    $(".ux-zoom-in").on("click",function(){
        $(this).uxZoomIn();
    })
    $(".ux-zoom-out").on("click",function(){
        $(this).uxZoomOut();
    })
//                                     跳转iframe
    $('.ux-tabbox>li').on("click",function(){
         $(this).goToPage($(this).find('p:nth-of-type(1)').text());
    })


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
    $('.try1').on("click",function () {
    console.log(1);
    // $(".try1",document.frames('iframe').document).css("background-color","grey")
    // $(window.frames["iframe"].document).find(".try1").css("background-color","grey");
    //   console.log($(document.getElementById('iframe').contentWindow.document.body).html())
    //   $("#iframe").contents().find(".try1").css("background-color","grey");
    $("#iframe").contents().find("body ").css("transform","scale3d(.5,.5,.5)");
    //       $("#iframe").contents().find(".try1").css("background-color","grey");
    //     $(window.frames["iframe"].document).find(".try1").css("background-color","grey");
    //   $(window.frames["iframe"].document).find(".try1").css("background-color","grey");
    //   $("#iframe").contents().find("body").css("zoom:","70%");
    //
    console.log(2);
    })

    //                                控制iframe外层缩放比例；
    function bigit()
    {
    var w=Number(document.all.iframe.width)+100;
    var h=Number(document.all.iframe.height)+100;
    //alert(w+','+h);
    document.all.iframe.width=w;
    document.all.iframe.height=h;
    }
    function smait()
    {
    var w=Number(document.all.iframe.width)-100;
    var h=Number(document.all.iframe.height)-100;
    //alert(w+','+h);
    document.all.iframe.width=w;
    document.all.iframe.height=h;
    }


})(jQuery);


