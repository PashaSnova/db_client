<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>
<h2>Цеха и участки</h2>

<br>

<table>
    <tr>
        <th>Номер цеха</th><th>Номер участка</th><th>Имя участка</th><th>Айди ответственного</th>
    </tr>
    <c:forEach var="workshop" items="${workshops}">
                <c:url var="updateButton" value="/updateWorkshop">
                    <c:param name="wNumber" value="${workshop.wdId.workshopNumber}"/>
                    <c:param name="sNumber" value="${workshop.wdId.sectionNumber}"/>
                </c:url>

                <c:url var="deleteButton" value="/deleteWorkshop">
                    <c:param name="wNumber" value="${workshop.wdId.workshopNumber}"/>
                    <c:param name="sNumber" value="${workshop.wdId.sectionNumber}"/>
                </c:url>

        <tr>
            <td>${workshop.wdId.workshopNumber}</td>
            <td>${workshop.wdId.sectionNumber}</td>
            <td>${workshop.sectionName}</td>
            <td>${workshop.masterId}</td>
                            <td><input type="button" value="Update"
                                       onclick="window.location.href = '${updateButton}'">
                                <input type="button" value="Delete"
                                       onclick="window.location.href = '${deleteButton}'"></td>
        </tr>
    </c:forEach>
</table>

<br>

<input type="button" value="Add" onclick="window.location.href = 'addWorkshopSection'"/>

<br><br>
<a href="${pageContext.request.contextPath}/">Вернуться назад</a>


</body>
</html>