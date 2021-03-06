/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 05.01.2016
 */
$(document).ready(function () {
    onStart();
    getName();
    addEvents();
});
//name of user
var name;
function getName(){
    $.ajax({
        url: $hostRoot + "getName",
        type: 'get',
        dataType: 'json',
        contentType: 'application/json',
        //data: JSON.stringify(data),
        success: function (name_user) {
            if (JSON.parse.name != null) {
                name = name_user;
            }
        },
        error: function (error) {
            console.log("ERROR---NO NAME RETURN");
        }
    });
};

var stompClient = null;
//load messages from server on start page
var onStart = function () {
    connect();
    $.ajax({
        url: $hostRoot + "getallmessages",
        type: 'get',
        dataType: 'json',
        contentType: 'application/json',
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                var nameuser = data[i].name;
                var index = data[i].id;

                var today = new Date();
                var todaydd = today.getDate();
                var todaymm = today.getMonth() + 1;
                var todayyyyy = today.getFullYear();
                if (todaydd < 10) {
                    todaydd = '0' + todaydd;
                }
                if (todaymm < 10) {
                    todaymm = '0' + todaymm;
                }

                var datatime = new Date(data[i].datatime);
                var dd = datatime.getDate();
                var mm = datatime.getMonth() + 1;
                var yyyy = datatime.getFullYear();
                var hh = datatime.getHours();
                var min = datatime.getMinutes();
                if (dd < 10) {
                    dd = '0' + dd;
                }
                if (mm < 10) {
                    mm = '0' + mm;
                }
                if (hh < 10) {
                    hh = '0' + hh;
                }
                if (min < 10) {
                    min = '0' + min;
                }

                //If the message not today: user see just year/mm/day, if today: see time of message
                if ((todaydd + todaymm + todayyyyy) == (dd + mm + yyyy)) {
                    var time = hh + ':' + min;
                } else {
                    var time = dd + '/' + mm + '/' + yyyy;
                }

                var textForm = data[i].textForm;
                if(name===nameuser){
                    $('.chat').append('<div class="messageBlockPrincipal" index="'+index+'"><span class="messageName">' + nameuser +
                        '</span><span class="messageDate">' + time +
                        '</span><br><span class="messageText">' + textForm + '</span><div class="delete">X</div></div>');
                }else{
                    $('.chat').append('<div class="messageBlock" index="'+index+'"><span class="messageName">' + nameuser +
                        '</span><span class="messageDate">' + time +
                        '</span><br><span class="messageText">' + textForm + '</span><div class="delete">X</div></div>');
                }

            }
            //scroll chat window in bottom
            var objDiv = document.getElementById("chatScroll");
            objDiv.scrollTop = objDiv.scrollHeight;
        },
        error: function (error) {
            console.log(error)
        }
    });
};
//Drop message functional
function connect() {
    var socket = new SockJS('/messageadd');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe('/topic/messagenew', function (messageHistoryDTO) {
            showMessage(JSON.parse(messageHistoryDTO.body));
        });
    });
}

function disconnect() {
    stompClient.disconnect();
    console.log("Disconnected");
}


function showMessage(messageHistoryDTO) {

    if (messageHistoryDTO != null) {
        $(".textForm").val('');
        document.getElementById('cform').focus();
        var today = new Date();
        var todaydd = today.getDate();
        var todaymm = today.getMonth() + 1;
        var todayyyyy = today.getFullYear();
        if (todaydd < 10) {
            todaydd = '0' + todaydd
        }
        if (todaymm < 10) {
            todaymm = '0' + todaymm
        }

        var datatime = new Date(messageHistoryDTO.datatime);
        var dd = datatime.getDate();
        var mm = datatime.getMonth() + 1;
        var yyyy = datatime.getFullYear();
        var hh = datatime.getHours();
        var min = datatime.getMinutes();
        if (dd < 10) {
            dd = '0' + dd;
        }
        if (mm < 10) {
            mm = '0' + mm;
        }
        if (hh < 10) {
            hh = '0' + hh;
        }
        if (min < 10) {
            min = '0' + min;
        }

        if ((todaydd + todaymm + todayyyyy) == (dd + mm + yyyy)) {
            var time = hh + ':' + min;
        } else {
            var time = dd + '/' + mm + '/' + yyyy;
        }
        var nameuser = messageHistoryDTO.name;
        var textForm = messageHistoryDTO.textForm;
        if(name===nameuser){
            $('.chat').append('<div class="messageBlockPrincipal" index="'+index+'"><span class="messageName">' + nameuser +
                '</span><span class="messageDate">' + time +
                '</span><br><span class="messageText">' + textForm + '</span><div class="delete">X</div></div>');
        }else{
            $('.chat').append('<div class="messageBlock" index="'+index+'"><span class="messageName">' + nameuser +
                '</span><span class="messageDate">' + time +
                '</span><br><span class="messageText">' + textForm + '</span><div class="delete">X</div></div>');
        }

        //scroll chat window in bottom
        var objDiv = document.getElementById("chatScroll");
        objDiv.scrollTop = objDiv.scrollHeight;
    } else {
        console.log("EMPTY DATA");
    }
}

function SendMessage() {
    var textarea = document.getElementById('cform').value;
    var time = new Date();
    console.log(stompClient);
    if (textarea != '') {
        stompClient.send("/app/messageadd", {}, JSON.stringify({'textForm': textarea, 'datatime': time, 'name': name}));
    } else {
        console.log('empty textarea, need text');
    }
}

var addEvents = function () {
    $(".chat").on('click', ".delete", function () {
        var data = {
            id: $(this).parent().attr('index'),
            name:$(this).siblings('.messageName').text()
        };
        console.log(data);
        $.ajax({
            url: $hostRoot + "delete_message",
            type: 'post',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (messageHistoryDTO) {
                if (messageHistoryDTO != null) {
                    var index = messageHistoryDTO.id;
                    var nameuser=messageHistoryDTO.name;
                    if(name===nameuser){
                        $('.messageBlockPrincipal').filter('[index="' + index + '"]').hide(200).remove(200);
                    }else{
                        $('.messageBlock').filter('[index="' + index + '"]').hide(200).remove(200);
                    }
                }
            },
            error: function (error) {
                console.log("ERROR---NO DATA RETURN");
            }
        });
    });
};






