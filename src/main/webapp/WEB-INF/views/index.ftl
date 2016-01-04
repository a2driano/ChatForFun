<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<!DOCTYPE html>
<html>
<head>
    <link href="<@c.url value="/resources/css/main.css" />" rel="stylesheet" media="screen"/>
    <script type="text/javascript" src="<@c.url value="/resources/js/jquery-1.11.1.js"/>"></script>
    <script type="text/javascript" src="<@c.url value="/resources/js/main.js"/>"></script>
    <script type="text/javascript">
        var $applicationRoot = "<@s.url value="/" />";
        var $host = document.location.protocol + '//' + document.location.host;
        var $hostRoot = document.location.protocol + '//' + document.location.host + $applicationRoot;
    </script>
</head>

<body id="mainbody">
<div class="container">

    <div id="central">
        <div id="centralMenu">
            <div id="enterReg" class="buttonStart">Sign in</div>
            <div id="enter" class="buttonStart">Enter without registration</div>
            <div id="registration" class="buttonStart">Registration</div>
        </div>
    </div>
</div>
</body>
</html>