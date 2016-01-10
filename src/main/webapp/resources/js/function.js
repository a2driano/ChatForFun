/**
 * Created by Администратор on 09.01.2016.
 */

function addEvents(){
    $('.responce').html("");
    $('.responceFail').html("");
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
