<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<body>

<h2>${label}</h2>

<br><br>

<form action="${pageContext.request.contextPath}/taskOneVariantOne" method="get">
    Месяц <input type="text" name="month">
    <br>
    <br>
    Год <input type="text" name="year">
    <input type="submit" value="Вывести">
</form>


<table>
    <tr>
        <th>Номер цеха</th><th>Название участка</th><th>Код детали</th><th>План выпуска</th>
    </tr>
    <c:forEach var="row" items="${plan}">
        <tr>
            <td>${row.ppId.wdId.workshopNumber}</td>
            <td>${row.wd.sectionName}</td>
            <td>${row.ppId.detail_id}</td>
            <td>${row.releasePlan}</td>
        </tr>
    </c:forEach>
</table>

<br><br>
<a href="${pageContext.request.contextPath}/">Вернуться назад</a>

</body>
</html>
