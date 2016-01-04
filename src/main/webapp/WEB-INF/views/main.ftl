<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<!DOCTYPE html>
<html>
<head>
    <#--<title">-->
    <#--Зоопарк-->
    <#--</title>-->
    <link href="<@c.url value="/resources/css/main.css" />" rel="stylesheet" media="screen"/>
    <link href="<@c.url value="/resources/css/lib/bootstrap.min.css" />" rel="stylesheet" media="screen"/>
    <link href="<@c.url value="/resources/css/lib/font-awesome.css" />" rel="stylesheet" media="screen"/>
    <script type="text/javascript" src="<@c.url value="/resources/js/jquery-1.11.1.js"/>"></script>
    <script type="text/javascript" src="<@c.url value="/resources/js/main.js"/>"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        var $applicationRoot = "<@s.url value="/" />";
        var $host = document.location.protocol + '//' + document.location.host;
        var $hostRoot = document.location.protocol + '//' + document.location.host + $applicationRoot;
    </script>
</head>

<body id="mainbody">
<div class="container">
    <div class="page-header" style="background-color: #2b542c" align="static" position="absolute">
        <img src="/resources/image/head.jpg" alt="ZOO" align="top" width="100%">
        <h1 align="center" valign="top" style="color: white">Зоопарк</h1>
    </div>
    <div class="col-lg-12">
        <table id="animals-table" class="table table-striped">
            <thead>
            <tr>
                <td>Имя</td>
                <td>Возраст</td>
                <td>Пол</td>
                <td>Тип</td>
                <td align="right"">Действие</td>
            </tr>
            </thead>
            <tbody></tbody>
            <div id="image_sourse">
                <img id="cat" src="/resources/image/cat.jpg">
                <img id="dog" src="/resources/image/dog.jpg">
                <img id="elephant" src="/resources/image/elephant.jpg">
                <img id="phyton" src="/resources/image/phyton.jpg">
                <img id="pig" src="/resources/image/pig.jpg">
            </div>
        </table>
        <button id="add-animal" class="btn btn-success pull-right">Добавить</button>
        <button id="delete-animal" class="btn btn-success pull-right">Удалить</button>
        <button id="save-animal" class="btn btn-success pull-right">Сохранить</button>
        <div id="animals-pre-loader" class="text-center">
            <i class="fa fa-refresh fa-spin fa-2x"></i>
        </div>
    </div>
    <div id="message-block">
    </div>
    <div class="topmodal">
        <form id="modaltest"></form>
    </div>

</div>
</body>
</html>