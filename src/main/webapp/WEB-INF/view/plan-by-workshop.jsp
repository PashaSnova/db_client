<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

План выпуска участка с номером ${sNumber.intValue()} цеха с номером ${wNumber.intValue()}:
<br>
<br>

<table>
    <tr>
        <th>Номер детали</th><th>Номер цеха</th><th>Номер участка</th><th>Год выпуска</th><th>Месяц выпуска</th><th>План выпуска</th>
    </tr>
    <c:forEach var="plan" items="${plan}">
        <tr>
            <td>${plan.ppId.detail_id}</td>
            <td>${plan.ppId.wdId.workshopNumber}</td>
            <td>${plan.ppId.wdId.sectionNumber}</td>
            <td>${plan.ppId.releaseYear}</td>
            <td>${plan.ppId.releaseMonth}</td>
            <td>${plan.releasePlan}</td>
        </tr>
    </c:forEach>
</table>

<br><br>
<a href="${pageContext.request.contextPath}/workshops">Вернуться назад</a>

<br>

</body>
</html>
