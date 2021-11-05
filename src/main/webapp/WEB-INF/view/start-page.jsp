<%--
  Created by IntelliJ IDEA.
  User: ksu
  Date: 05.11.2021
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добро пожаловать!</title>
</head>
<body>
<h2>Какую таблицу вы хотите посмотреть?</h2>
<br>
При выборе одной из таблиц вы будете иметь возможность изменить её
<br>
<br>
<a href="${pageContext.request.contextPath}/details">Информация о деталях</a>
<br>
<br>
<a href="${pageContext.request.contextPath}/workshops">Информация о цехах и участках</a>
<br>
<br>
<a href="${pageContext.request.contextPath}/productionPlan">Информация о плане выпуска</a>
<br>
<br>
<a href="${pageContext.request.contextPath}/all">Всё сразу</a>
<br>
<br>

</body>
</html>
