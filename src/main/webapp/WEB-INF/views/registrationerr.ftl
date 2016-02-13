<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"] />
<#import "/spring.ftl" as spring/>


<html>
<head>
    <link href="<@c.url value="/resources/css/main.css"/>" rel="stylesheet" media="screen"/>
    <meta charset="UTF-8">
    <title>ChatForFun</title>
    <script type="text/javascript" src="/js/lib/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="/js/lib/jquery.countdown.min.js"></script>
    <script type="text/javascript" src="/js/onstart.js"></script>
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
            <a href="/">
                <div class="logo">
                    <div class="logoTypesImage" id="image_1"></div>
                    <div class="logoTypesImage" id="image_2"></div>
                    <div class="logoTypesImage" id="image_3"></div>
                    <div class="logoTypesImage" id="image_4"></div>
                    <div class="logoTypesImage" id="image_5"></div>
                    <div class="logoTypesImage" id="image_6"></div>
                </div>
            </a>

            <div class="responceFail">Этот логин уже занят, выберите другой</div>
            <form class="cabinetFormText" id="userDTO" action="save" method="post">
                <input class="formText" name="name" type="text" maxlength="25" size="40" required
                       placeholder="ВВЕДИТЕ СВОЙ ЛОГИН / ИМЯ" required pattern="^[a-zA-Zа-яіїєґ0-9,А-ЯІЇЄҐ][а-яіїєґ,А-ЯІЇЄҐa-zA-Z0-9-_\.]{2,20}$">
                <input class="formText" name="password" type="password" maxlength="25" size="40" required
                       placeholder="ВВЕДИТЕ ПАРОЛЬ">
                <input type="submit" class="buttonForm" id="submit">
            </form>
            <div id="basementTextlogin">Copyright a2driano ©, 2016.</div>
        </div>
    </div>
</div>
</body>
</html>