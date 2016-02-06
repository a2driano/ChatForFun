/**
 * @version 1.0
 * @autor a2driano
 * @project: ChatForFun
 * @since 05.01.2016
 */
$(document).ready(function () {
    onStart();
    addEvents();
});

var onStart = function () {
    $.ajax({
        url: $hostRoot + "getallmessages",
        type: 'get',
        dataType: 'json',
        contentType: 'application/json',
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                var index = data[i].id;
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
                $('.chat').append('<div class="messageBlock" index="' + index + '"><span class="messageName">' + name +
                    '</span><span class="messageDate">' + time +
                    '</span><br><span class="messageText">' + textForm + '</span><div class="delete">X</div></div>');

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


var addEvents = function () {
    $(".chat").on('click', ".delete", function () {
        var data = {
            id: $(this).parent().attr('index')
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
                    console.log(index);
                    $('.messageBlock').filter('[index="' + index + '"]').hide(200).remove(200);
                }
            },
            error: function (error) {
                console.log("ERROR---NO DATA RETURN");
            }
        });
    });
};

function AjaxFormRequest() {
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
                var index = messageHistoryDTO.id;
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
                $('.chat').append('<div class="messageBlock" index="' + index + '"><span class="messageName">' + name +
                    '</span><span class="messageDate">' + time +
                    '</span><br><span class="messageText">' + textForm + '</span><div class="delete">X</div></div>');

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
};







