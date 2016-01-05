<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<html>
<head>
    <link href="<@c.url value="/resources/css/main.css" />" rel="stylesheet" media="screen"/>
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
            <div class="logo"></div>
            <div id="centralMenu">
                <div class="buttonContainer"><div id="enterReg" class="buttonStart">Sign in</div></div>
                <div class="buttonContainer"><div id="enter" class="buttonStart">Enter without registration</div></div>
                <div class="buttonContainer"><div id="registration" class="buttonStart">Registration</div></div>
            </div>
            <#--<form class="cabinetFormText" action="/login" method="post">-->
                <#--<input class="formText" id="j_username" name="username" type="text" maxlength="25" size="40" placeholder="ENTER YOUR LOGIN">-->
                <#--<input class="formText" id="j_password" name="password" type="password" maxlength="25" size="40" placeholder="ENTER YOUR PASSWORD">-->
                <#--<input class="buttonForm" type="submit" name="submit" value="Submit">-->
            <#--</form>-->
        </div>
    </div>
</div>
</body>
</html>