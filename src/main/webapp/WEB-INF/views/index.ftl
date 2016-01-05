<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<html>
<head>
    <link href="<@c.url value="/resources/css/main.css" />" rel="stylesheet" media="screen"/>
    <meta charset="UTF-8">
    <title>ChatForFun</title>
    <link href="/css/index.css" media="screen" rel="stylesheet">
    <script type="text/javascript" src="/js/lib/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="/js/lib/jquery.countdown.min.js"></script>
    <script type="text/javascript" src="/js/index_functions.js"></script>
    <script type="text/javascript" src="/js/onstart.js"></script>
    <script type="text/javascript" src="/js/index_addevents.js"></script>
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
        </div>
    </div>
</div>
</body>
</html>