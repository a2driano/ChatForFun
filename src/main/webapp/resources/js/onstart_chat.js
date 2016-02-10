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
    document.getElementById(image_now).style.opacity = opacity / 100;
    document.getElementById(image_now).style.filter = 'alpha(opacity=' + opacity + ')';
    document.getElementById(image_next).style.opacity = (100 - opacity) / 100;
    document.getElementById(image_next).style.filter = 'alpha(opacity=' + (100 - opacity) + ')';
    timeout = setTimeout("fade_to_next()", time_out);
    if (opacity == 1) {
        opacity = 100;
        clearTimeout(timeout);
    }
}
setInterval(
    function () {
        i++;
        if (i > total_pics_num) i = 1;
        fade_to_next();
    }, interval
);


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
                var name = data[i].name;

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
                $('.chat').append('<div class="messageBlock"><span class="messageName">' + name +
                    '</span><span class="messageDate">' + time +
                    '</span><br><span class="messageText">' + textForm + '</span></div>');

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
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/messagenew', function (addMessage) {
            showMessage(JSON.parse(addMessage.body).content);
        });
    });
}

function disconnect() {
    stompClient.disconnect();
    //setConnected(false);
    console.log("Disconnected");
}


function showMessage(messageHistoryDTO) {
    //var response = document.getElementById('response');
    //var p = document.createElement('p');
    //p.style.wordWrap = 'break-word';
    //p.appendChild(document.createTextNode(message));
    //response.appendChild(p);
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
        var name = messageHistoryDTO.name;
        var textForm = messageHistoryDTO.textForm;
        $('.chat').append('<div class="messageBlock"><span class="messageName">' + name +
            '</span><span class="messageDate">' + time +
            '</span><br><span class="messageText">' + textForm + '</span></div>');

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
        stompClient.send("/app/messageadd", {}, JSON.stringify({'messageUser': textarea, 'datatime': time}));
    } else {
        console.log('empty textarea, need text');
    }
}

function AjaxFormRequest() {
    //inspection empty textarea or not
    var textarea = document.getElementById('cform').value;
    if (textarea != '') {
        var data = {
            textForm: $(".textForm").val(),
            datatime: new Date()
        };
        $.ajax({
            url: $hostRoot + "messageadd",
            type: 'post',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (messageHistoryDTO) {
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
                    var name = messageHistoryDTO.name;
                    var textForm = messageHistoryDTO.textForm;
                    $('.chat').append('<div class="messageBlock"><span class="messageName">' + name +
                        '</span><span class="messageDate">' + time +
                        '</span><br><span class="messageText">' + textForm + '</span></div>');

                    //scroll chat window in bottom
                    var objDiv = document.getElementById("chatScroll");
                    objDiv.scrollTop = objDiv.scrollHeight;
                } else {
                    console.log("EMPTY DATA");
                }
            },
            error: function (error) {
                console.log("ERROR");
            }
        });
    } else {
        console.log('empty textarea, need text');
    }
};







