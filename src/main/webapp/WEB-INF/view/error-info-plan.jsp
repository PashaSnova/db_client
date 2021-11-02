<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ksu
  Date: 02.11.2021
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ошибка</title>
</head>
<body>
Некорректный ввод данных
<br><br>
<a href="${pageContext.request.contextPath}/addPlan">Попробовать снова</a>
</body>
</html>
