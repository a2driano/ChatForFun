/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 05.01.2016
 */
$(document).ready(function(){
    onStart();
});

var onStart=function(){

    $('#enterReg').on('click', function(){
        $('#centralMenu').hide(400);
        $('#centralContainer').append('<form class="cabinetFormText" action="/login" method="post">'+
            '<input class="formText" id="j_username" name="username" type="text" maxlength="25" size="40" placeholder="ENTER YOUR LOGIN">'+
            '<input class="formText" id="j_password" name="password" type="password" maxlength="25" size="40" placeholder="ENTER YOUR PASSWORD">'+
            '<input class="buttonForm" type="submit" name="submit" value="Submit"></form>');
    });

    $('#HotDishesInside').on('click', '.basketAcceptButton', function () {
        //$('.dishesBasket').html('');
        $('#HotDeals h1').text('YOUR ORDER IS ACCEPTED');

        alert("Ваш заказ принят! Менеджер свяжется с вами в ближайшее время");

    });


}

