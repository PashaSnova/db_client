<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<h2>${section}</h2>

<br><br>

Введите имя интересующего участка <br><br>
<form action="${pageContext.request.contextPath}/countPlan" method="get">
    <input type="text" name="section">
    <input type="submit" value="Вычислить">
</form>

Ожидаемая выручка: ${sum.intValue()}
</body>
</html>
