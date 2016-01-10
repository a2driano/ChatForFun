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

    $('#enterConfirm').on('click', function(){
        $('#centralMenu').fadeOut(500);
        $('#centralContainer').append('<form class="cabinetFormText">'+
            '<input class="formText" id="name" type="text" maxlength="25" size="40" required placeholder="ВВЕДИТЕ СВОЙ ЛОГИН / ИМЯ">'+
            '<input class="formText" id="password" type="password" maxlength="25" size="40" required placeholder="ВВЕДИТЕ ПАРОЛЬ">'+
            '<div class="buttonForm" id="submit" onclick="addEventsConfirm()">Войти</div></form>');
        $('.cabinetFormText').hide();
        $('.cabinetFormText').fadeIn(400);

    });

    $('#registration').on('click', function(){
        $('#centralMenu').fadeOut(500);
            $('#centralContainer').append('<form class="cabinetFormText">'+
                '<input class="formText" id="name" type="text" maxlength="25" size="40" required placeholder="ВВЕДИТЕ СВОЙ ЛОГИН / ИМЯ">'+
                '<input class="formText" id="password" type="password" maxlength="25" size="40" required placeholder="ВВЕДИТЕ ПАРОЛЬ">'+
                '<div class="buttonForm" id="submit" onclick="addEventsRegistration()">Войти</div></form>');
            $('.cabinetFormText').hide();
            $('.cabinetFormText').fadeIn(400);
    });



    $('#enter').on('click', function(){
        $('#centralMenu').fadeOut(500);
        $('#centralContainer').append('<form class="cabinetFormText">'+
            '<input class="formText" id="name" type="text" maxlength="25" size="40" required placeholder="ВВЕДИТЕ СВОЙ ЛОГИН / ИМЯ">'+
            '<div class="buttonForm" id="submit" onclick="addEventsEnter()">Войти</div></form>');
        $('.cabinetFormText').hide();
        $('.cabinetFormText').fadeIn(400);
    });
};


