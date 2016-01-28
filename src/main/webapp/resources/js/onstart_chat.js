/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 05.01.2016
 */
$(document).ready(function () {
    onStart();
    //addEvents();
});

//change images on background
var total_pics_num = 6; // колличество изображений
var interval = 700;    // задержка между изображениями
var time_out = 4;       // задержка смены изображений
var i = 0;
var timeout;
var opacity = 100;
function fade_to_next() {
    opacity--;
    var k = i + 1;
    var image_now = 'image_' + i;
    if (i == total_pics_num) k = 1;
    var image_next = 'image_' + k;
    document.getElementById(image_now).style.opacity = opacity/100;
    document.getElementById(image_now).style.filter = 'alpha(opacity='+ opacity +')';
    document.getElementById(image_next).style.opacity = (100-opacity)/100;
    document.getElementById(image_next).style.filter = 'alpha(opacity='+ (100-opacity) +')';
    timeout = setTimeout("fade_to_next()",time_out);
    if (opacity==1) {
        opacity = 100;
        clearTimeout(timeout);
    }
}
setInterval (
    function() {
        i++;
        if (i > total_pics_num) i=1;
        fade_to_next();
    }, interval
);


var onStart=function(){

    $.ajax({
        url: $hostRoot + "getallmessages",
        type: 'get',
        dataType: 'json',
        contentType: 'application/json',
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                var name=data[i].name;
                var datatime=new Date(data[i].datatime);

                var time=datatime.getFullYear() + '/' + (datatime.getMonth() + 1) + '/' + datatime.getDate()+ ' ' + datatime.getHours() + ':' + datatime.getMinutes() + ':' + datatime.getSeconds();
                var textForm=data[i].textForm;
                $('.chat').append('<div class="messageBlock"><span class="messageName">'+name+
                                  '</span><span class="messageDate">'+time+
                                  '</span><br><span class="messageText">'+textForm+'</span></div>');
            }
        },
        error: function (error) {
            console.log(error)
        }

    });


};


function AjaxFormRequest(){
    //var time=new Date(Date.UTC());
    var data={
        //name: "",
        textForm: $(".textForm").val(),
        //datatime: new Date().getTime()
        datatime: new Date()
    };
    $.ajax({
        url: $hostRoot + "messageadd",
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (messageHistoryDTO) {

            //var userstatus="${status}";
            //console.log(userstatus);
            if (modelAndView.status == "SUCCESS") {


                var address =$hostRoot+userResponce.message;
                console.log(address);
                document.location.href = address;

                //$('.cabinetFormText').append('<div class="responce">'+ userResponce.message +'</div>');
                //setTimeout(function () {
                //    $('.responce').html("");
                //}, 5000);
            } else {
                $('.cabinetFormText').append('<div class="responceFail">'+ userResponce.message +'</div>');
                setTimeout(function () {
                    $('.responceFail').html("");
                }, 5000);
            }
        },
        error: function (error) {
            $('.cabinetFormText').append('<div class="responceFail">'+ userResponce.message +'</div>');
            setTimeout(function () {
                $('.responceFail').html("");
            }, 5000);
        }
    });
};







