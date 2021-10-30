<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>
<h2>All workshops</h2>

<br>

<table>
    <tr>
        <th>Номер цеха</th><th>Номер участка</th><th>Имя участка</th><th>Айди ответственного</th>
    </tr>
    <c:forEach var="workshop" items="${workshops}">
        <%--        <c:url var="updateButton" value="/updateInfo">--%>
        <%--            <c:param name="empId" value="${emp.id}"/>--%>
        <%--        </c:url>--%>

        <%--        <c:url var="deleteButton" value="/deleteEmployee">--%>
        <%--            <c:param name="empId" value="${emp.id}"/>--%>
        <%--        </c:url>--%>

        <tr>
            <td>${workshop.wdId.workshopNumber}</td>
            <td>${workshop.wdId.sectionNumber}</td>
            <td>${workshop.sectionName}</td>
            <td>${workshop.masterId}</td>
                <%--            <td><input type="button" value="Update"--%>
                <%--                       onclick="window.location.href = '${updateButton}'">--%>
                <%--                <input type="button" value="Delete"--%>
                <%--                       onclick="window.location.href = '${deleteButton}'"></td>--%>
        </tr>
    </c:forEach>
</table>

<br>

<input type="button" value="Add" onclick="window.location.href = 'addWorkshopSection'"/>


</body>
</html>