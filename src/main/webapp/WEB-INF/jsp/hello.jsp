<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
            <div id="centralMenu">
                <div class="buttonContainer">
                    <a class=ref href="chat">
                        <div type="submit" id="enterConfirm" class="buttonStart">Войти</div>
                    </a>
                </div>
                <div class="buttonContainer">
                    <div id="registration" class="buttonStart">Зарегистрироваться</div>
                </div>
            </div>
            <div class="bottomImage">
            </div>
        </div>
    </div>
</div>
</body>
</html>