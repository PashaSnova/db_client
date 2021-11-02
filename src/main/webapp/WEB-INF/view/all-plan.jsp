<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>
<h2>Production Plan</h2>

<br>

<table>
    <tr>
        <th>Номер детали</th><th>Номер цеха</th><th>Номер участка</th><th>Год выпуска</th><th>Месяц выпуска</th><th>План выпуска</th>
    </tr>
    <c:forEach var="plan" items="${plan}">
        <%--        <c:url var="updateButton" value="/updateInfo">--%>
        <%--            <c:param name="empId" value="${emp.id}"/>--%>
        <%--        </c:url>--%>

        <%--        <c:url var="deleteButton" value="/deleteEmployee">--%>
        <%--            <c:param name="empId" value="${emp.id}"/>--%>
        <%--        </c:url>--%>

        <tr>
            <td>${plan.ppId.detail.id}</td>
            <td>${plan.ppId.wd.wdId.workshopNumber}</td>
            <td>${plan.ppId.wd.wdId.sectionNumber}</td>
            <td>${plan.ppId.releaseYear}</td>
            <td>${plan.ppId.releaseMonth}</td>
            <td>${plan.releasePlan}</td>
        <%--            <td><input type="button" value="Update"--%>
                <%--                       onclick="window.location.href = '${updateButton}'">--%>
                <%--                <input type="button" value="Delete"--%>
                <%--                       onclick="window.location.href = '${deleteButton}'"></td>--%>
        </tr>
    </c:forEach>
</table>

<br>

<input type="button" value="Add" onclick="window.location.href = 'addPlan'"/>


</body>
</html>