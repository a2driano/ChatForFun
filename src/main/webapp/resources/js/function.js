/**
 * Created by Администратор on 09.01.2016.
 */

function addEvents(){
    var data={
        name: $("#name").val(),
        password: $("#password").val()
    };
    $.ajax({
        url: $hostRoot + "addUser",
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (userResponce) {
            if (userResponce && userResponce.status == "SUCCESS") {
                $('#centralContainer').append('<h3>Вы успешно зарегестрировались!</h3>');
                console.log("SUCCESS");
            } else {
                $('#centralContainer').append('<h3>'+ userResponce.message+'</h3>');
                setTimeout(function () {
                    console.log(userResponce.status);
                }, 5000);
            }
        },
        error: function (error) {
            console.log("FAIL, BUT WHY");
        }
    });
};

function doAjaxPost(){
    //var data= {
    //    nickName : $('#nickName').val(),
    //    password : $('#password').val()
    //}

    var nickName = $('#nickName').val();
    var password = $('#password').val();
    //var $input = $(".formText");
    //var data = new FormData;
    //data.append($input.val(),$input.val());
    //var data = {
    //    nickName: $("#nickName").val(),
    //    password: $("#password").val(),
    //};
    $.ajax({
        url: $hostRoot + "add",
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        data: "nickName=" + nickName + "& password=" + password,
        //data: JSON.stringify(data),
        success: function (userResponce) {
            if (userResponce && userResponce.userResponceStatus == "SUCCESS") {
                $('#centralContainer').append('<h4 Все сработало!/>');
                alert('SUCCESS');
            } else {
                setTimeout(function() {
                    alert(userResponce.message)
                }, 0);
            }
        },
        error: function (error) {
            console.log(data.nickName, data.password)
        }
    });

    //$('#registration').on('click', function(){
    //    $('#centralMenu').fadeOut(500);
    //
    //        $('#centralContainer').append('<div class="cabinetFormText">'+
    //            '<input class="formText" id="nickName" type="text" maxlength="25" size="40" required placeholder="ENTER YOUR LOGIN / NAME">'+
    //            '<input class="formText" id="password" type="password" maxlength="25" size="40" required placeholder="ENTER YOUR PASSWORD">'+
    //            '<input class="buttonForm" type="button" value="Submit" onclick="doAjaxPost()"></div>');
    //        $('.cabinetFormText').hide();
    //        $('.cabinetFormText').fadeIn(400);
    //});
};
