<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>
<h2>Детали</h2>

<br>

<table>
    <tr>
        <th>Номер</th><th>Название</th><th>Тип</th><th>Ед. измерения</th><th>Цена</th><th>Операции</th>
    </tr>
    <c:forEach var="detail" items="${allDetails}">
        <c:url var="updateButton" value="/updateDetail">
            <c:param name="detailId" value="${detail.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deleteDetail">
            <c:param name="detailId" value="${detail.id}"/>
        </c:url>

        <c:url var="planPutton" value="/planByDetail">
            <c:param name="detailId" value="${detail.id}"/>
        </c:url>

        <tr>
            <td>${detail.id}</td>
            <td>${detail.detailName}</td>
            <td>${detail.detailType}</td>
            <td>${detail.measure}</td>
            <td>${detail.price}</td>
            <td><input type="button" value="Обновить"
                       onclick="window.location.href = '${updateButton}'">
                <input type="button" value="Удалить"
                       onclick="window.location.href = '${deleteButton}'">
                <input type="button" value="Посмотреть связанный план"
                       onclick="window.location.href = '${planPutton}'"></td>

        </tr>
   </c:forEach>
</table>

<br>

<input type="button" value="Добавить" onclick="window.location.href = 'addDetail'"/>


<br><br>
<a href="${pageContext.request.contextPath}/">Вернуться назад</a>


</body>
</html>