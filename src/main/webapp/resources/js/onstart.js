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

var safeNull = function (value) {
    return value ? value : "-";
};


var onStart=function(){

    $('#enterReg').on('click', function(){
        $('#centralMenu').fadeOut(500);
        setTimeout(function () {
            $('#centralContainer').append('<form class="cabinetFormText" action="/login" method="post">'+
                '<input class="formText" name="nickName" type="text" maxlength="25" size="40" required placeholder="ENTER YOUR LOGIN / NAME">'+
                '<input class="formText" name="password" type="password" maxlength="25" size="40" required placeholder="ENTER YOUR PASSWORD">'+
                '<input class="buttonForm" type="submit" name="submit" value="Submit"></form>');
            $('.cabinetFormText').hide();
            $('.cabinetFormText').fadeIn(400);
        }, 200);

    });

    $('#registration').on('click', function(){
        $('#centralMenu').fadeOut(500);

            $('#centralContainer').append('<div class="cabinetFormText">'+
                '<input class="formText" id="name" type="text" maxlength="25" size="40" required placeholder="ENTER YOUR LOGIN / NAME">'+
                '<input class="formText" id="password" type="password" maxlength="25" size="40" required placeholder="ENTER YOUR PASSWORD">'+
                '<div class="buttonForm" id="submit" onclick="addEvents()">Submit</div></div>');
            $('.cabinetFormText').hide();
            $('.cabinetFormText').fadeIn(400);
    });



    $('#enter').on('click', function(){
        $('#centralMenu').fadeOut(500);
        setTimeout(function () {
            $('#centralContainer').append('<form class="cabinetFormText" action="/enter" method="post">'+
                '<input class="formText" name="nickName" type="text" maxlength="25" size="40" required placeholder="ENTER YOUR LOGIN / NAME">'+
                '<input class="buttonForm" type="submit" name="submit" value="Submit"></form>');
            $('.cabinetFormText').hide();
            $('.cabinetFormText').fadeIn(400);
        }, 200);
    });
};


