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
<a href="${pageContext.request.contextPath}/taskOneVariantOne">Решение задачи 1 первым способом</a>
<br>
<br>
<a href="${pageContext.request.contextPath}/taskOneVariantTwo">Решение задачи 1 вторым способом</a>
<br>
<br>
<a href="${pageContext.request.contextPath}/taskOneVariantThree">Решение задачи 1 третьим способом</a>



</body>
</html>
