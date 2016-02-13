/**
 * Created by Администратор on 09.01.2016.
 */

function registration_func(){
    //$('.responce').html("");
    //$('.responceFail').html("");
    var name=$("#name").val();
    var password=$("#password").val();
    var data={
        name: $("#name").val(),
        password: $("#password").val()
    };
    $.ajax({
        url: $hostRoot + "save",
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (data) {
            //top.location.href="/chat";
            //console.log(data);
            //if(data.message=="Регистрация прошла успешно"){
            //    $("#name").val(name);
            //    $("#password").val(password);
            //    document.getElementById('userDTO').submit();
            //    top.location.href="/chat";
            //}

            ////var userstatus="${status}";
            ////console.log(userstatus);
            //if (modelAndView.status == "SUCCESS") {
            //
            //
            //    var address =$hostRoot+userResponce.message;
            //    console.log(address);
            //    document.location.href = address;
            //
            //    //$('.cabinetFormText').append('<div class="responce">'+ userResponce.message +'</div>');
            //    //setTimeout(function () {
            //    //    $('.responce').html("");
            //    //}, 5000);
            //} else {
            //    $('.cabinetFormText').append('<div class="responceFail">'+ userResponce.message +'</div>');
            //    setTimeout(function () {
            //        $('.responceFail').html("");
            //    }, 5000);
            //}
        },
        error: function (error) {
            //$('.cabinetFormText').append('<div class="responceFail">'+ userResponce.message +'</div>');
            //setTimeout(function () {
            //    $('.responceFail').html("");
            //}, 5000);
        }
    });
};


function addEventsEnter(){
    $('.responce').html("");
    $('.responceFail').html("");
    var data={
        name: $("#name").val(),
        password: ""
    };
    $.ajax({
        url: $hostRoot + "enterUser",
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (userResponce) {
            if (userResponce && userResponce.status == "SUCCESS") {
                $('.cabinetFormText').append('<div class="responce">'+ userResponce.message +'</div>');
                setTimeout(function () {
                    $('.responce').html("");
                }, 5000);
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

