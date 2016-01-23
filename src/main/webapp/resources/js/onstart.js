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
    //$('#enterConfirm').on('click', function(){
    //    $('#centralMenu').fadeOut(500);
    //    $('#centralContainer').append('<form class="cabinetFormText" action="login" method="post">'+
    //        '<input class="formText" id="j_username" type="text" maxlength="25" size="40" required placeholder="ВВЕДИТЕ СВОЙ ЛОГИН / ИМЯ">'+
    //        '<input class="formText" id="j_password" type="password" maxlength="25" size="40" required placeholder="ВВЕДИТЕ ПАРОЛЬ">'+
    //        '<input type="submit" class="buttonForm" id="submit"></form>');
    //    $('.cabinetFormText').hide();
    //    $('.cabinetFormText').fadeIn(400);
    //});
    //$('#registration').on('click', function(){
    //    $('#centralMenu').fadeOut(500);
    //        $('#centralContainer').append('<form class="cabinetFormText" action="login" method="post">'+
    //            '<input class="formText" id="j_username" name="username" type="text" maxlength="25" size="40" required placeholder="ВВЕДИТЕ СВОЙ ЛОГИН / ИМЯ">'+
    //            '<input class="formText" id="j_password" name="password" type="password" maxlength="25" size="40" required placeholder="ВВЕДИТЕ ПАРОЛЬ">'+
    //            '<input type="submit" class="buttonForm" id="submit"></form>');
    //        $('.cabinetFormText').hide();
    //        $('.cabinetFormText').fadeIn(400);
    //});
};


