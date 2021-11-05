<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>
<h2>All details</h2>

<br>

<table>
    <tr>
        <th>Id</th><th>Detail name</th><th>Detail type</th><th>Measure</th><th>Price</th>
    </tr>
    <c:forEach var="detail" items="${allDetails}">
        <c:url var="updateButton" value="/updateDetail">
            <c:param name="detailId" value="${detail.id}"/>
        </c:url>

        <c:url var="deleteButton" value="/deleteDetail">
            <c:param name="detailId" value="${detail.id}"/>
        </c:url>

        <tr>
            <td>${detail.id}</td>
            <td>${detail.detailName}</td>
            <td>${detail.detailType}</td>
            <td>${detail.measure}</td>
            <td>${detail.price}</td>
            <td><input type="button" value="Update"
                       onclick="window.location.href = '${updateButton}'">
                <input type="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}'"></td>
        </tr>
   </c:forEach>
</table>

<br>

<input type="button" value="Add" onclick="window.location.href = 'addDetail'"/>


<br><br>
<a href="${pageContext.request.contextPath}/">Вернуться назад</a>


</body>
</html>