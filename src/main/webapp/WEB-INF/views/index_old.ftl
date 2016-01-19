<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<html>
<head>
    <link href="<@c.url value="/resources/css/main.css"/>" rel="stylesheet" media="screen"/>
    <meta charset="UTF-8">
    <title>ChatForFun</title>
    <script type="text/javascript" src="/js/lib/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="/js/lib/jquery.countdown.min.js"></script>
    <script type="text/javascript" src="/js/onstart.js"></script>
    <script type="text/javascript" src="/js/function.js"></script>
    <#--<link rel="shortcut icon" href="/img/favicon.png" type="image/png">-->
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
            <div class="logo">
                <div class="logoTypesImage" id="image_1"></div>
                <div class="logoTypesImage" id="image_2"></div>
                <div class="logoTypesImage" id="image_3"></div>
                <div class="logoTypesImage" id="image_4"></div>
                <div class="logoTypesImage" id="image_5"></div>
                <div class="logoTypesImage" id="image_6"></div>
                <#--<div class="logoInside"></div>-->
            </div>
            <div id="centralMenu">
                <div class="buttonContainer"><div id="enterConfirm" class="buttonStart">Войти</div></div>
                <div class="buttonContainer"><div id="enter" class="buttonStart">Войти без регистрации</div></div>
                <div class="buttonContainer"><div id="registration" class="buttonStart">Зарегистрироваться</div></div>
            </div>
            <div class="bottomImage">
            </div>
        </div>
    </div>
</div>
</body>
</html>