<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ChatForFun</title>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <script type="text/javascript" src="/resources/js/lib/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="/resources//js/lib/jquery.countdown.min.js"></script>
    <script type="text/javascript" src="/resources//js/onstart.js"></script>
    <script type="text/javascript" src="/resources//js/function.js"></script>

    <%--<script src="<c:url value="/resources/js/onstart.js" />"></script>--%>

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
            </div>
            <form class="cabinetFormText" action="/j_spring_security_check" method="post">
                <input class="formText" name="j_username" type="text" maxlength="25" size="40" required placeholder="ВВЕДИТЕ СВОЙ ЛОГИН / ИМЯ">
                <input class="formText" name="j_password" type="password" maxlength="25" size="40" required placeholder="ВВЕДИТЕ ПАРОЛЬ">
                <input id="remember_me" name="_spring_security_remember_me" type="checkbox" value="Запомнить меня"/>
                <input type="submit" class="buttonForm" id="submit">
            </form>
            <div class="bottomImage">
            </div>
        </div>
    </div>
</div>
</body>
</html>