<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<html>
<head>
    <link href="<@c.url value="/resources/css/chat.css"/>" rel="stylesheet" media="screen"/>
    <meta charset="UTF-8">
    <title>ChatForFun</title>
    <script type="text/javascript" src="/js/lib/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="/js/lib/jquery.countdown.min.js"></script>
    <script type="text/javascript" src="/js/onstart_chat.js"></script>
    <script src="/js/lib/sockjs-0.3.4.js"></script>
    <script src="/js/lib/stomp.js"></script>

    <link rel="shortcut icon" href="/img/favicon.png" type="image/png">
    <script type="text/javascript">
        var $applicationRoot = '/';
        var $host = document.location.protocol + '//' + document.location.host;
        var $hostRoot = document.location.protocol + '//' + document.location.host + $applicationRoot;
    </script>
</head>
<body class="container">
<div>
    <div id="central">
        <div id="centralContainer">
            <a href="/chat">
                <div class="logo">
                    <div class="logoTypesImage" id="image_1"></div>
                    <div class="logoTypesImage" id="image_2"></div>
                    <div class="logoTypesImage" id="image_3"></div>
                    <div class="logoTypesImage" id="image_4"></div>
                    <div class="logoTypesImage" id="image_5"></div>
                    <div class="logoTypesImage" id="image_6"></div>
                </div>
            </a>
            <div class="chat" id="chatScroll">
            </div>
            <div id="answerZone">
                <div id="formtext">
                    <textarea id="cform" class="textForm" name="textForm" cols="30" rows="5" maxlength="350"></textarea>
                </div>
                <div id="buttondrop">
                    <button type="button" id="dropMessage" onclick="SendMessage()">Отправить</button>
                </div>
            </div>
            <div id="basement">
                <div id="basementText">Copyright a2driano ©, 2016.</div>
                <a class=ref href="/logout">
                    <button type="button" id="logout">Выйти из чата</button>
                </a>
            </div>
        </div>
    </div>
</div>
</body>
</html>