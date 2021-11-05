<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>
<h2>План выпуска</h2>

<br>

<table>
    <tr>
        <th>Номер детали</th><th>Номер цеха</th><th>Номер участка</th><th>Год выпуска</th><th>Месяц выпуска</th><th>План выпуска</th>
    </tr>
    <c:forEach var="plan" items="${plan}">
                <c:url var="updateButton" value="/updatePlan">
                    <c:param name="det_id" value="${plan.ppId.detail_id}"/>
                    <c:param name="wNumber" value="${plan.ppId.wdId.workshopNumber}"/>
                    <c:param name="sNumber" value="${plan.ppId.wdId.sectionNumber}"/>
                    <c:param name="year" value="${plan.ppId.releaseYear}"/>
                    <c:param name="month" value="${plan.ppId.releaseMonth}"/>
                </c:url>

                <c:url var="deleteButton" value="/deletePlan">
                    <c:param name="det_id" value="${plan.ppId.detail_id}"/>
                    <c:param name="wNumber" value="${plan.ppId.wdId.workshopNumber}"/>
                    <c:param name="sNumber" value="${plan.ppId.wdId.sectionNumber}"/>
                    <c:param name="year" value="${plan.ppId.releaseYear}"/>
                    <c:param name="month" value="${plan.ppId.releaseMonth}"/>                </c:url>

        <tr>
            <td>${plan.ppId.detail_id}</td>
            <td>${plan.ppId.wdId.workshopNumber}</td>
            <td>${plan.ppId.wdId.sectionNumber}</td>
            <td>${plan.ppId.releaseYear}</td>
            <td>${plan.ppId.releaseMonth}</td>
            <td>${plan.releasePlan}</td>
                    <td><input type="button" value="Update"
                                       onclick="window.location.href = '${updateButton}'">
                                <input type="button" value="Delete"
                                       onclick="window.location.href = '${deleteButton}'"></td>
        </tr>
    </c:forEach>
</table>

<br>

<input type="button" value="Add" onclick="window.location.href = 'addPlan'"/>

<br><br>
<a href="${pageContext.request.contextPath}/">Вернуться назад</a>



</body>
</html>