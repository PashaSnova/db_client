<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Всё</title>
</head>
<body>

<h2>Все таблицы</h2>

<table style="border: inset black; border-collapse: collapse">
    <tr style="background-color: lightskyblue">
    <th>ДЕТАЛИ</th><th>ЦЕХИ И УЧАСТКИ</th><th>ПЛАН ВЫПУСКА</th>
    </tr>
    <tr>
        <td style="border: inset black">
        <table>
            <tr>
                <th>Номер</th><th>Название</th><th>Тип</th><th>Ед. измерения</th><th>Цена</th>
            </tr>
        <c:forEach var="detail" items="${details}">
        <tr>
            <td>${detail.id}</td>
            <td>${detail.detailName}</td>
            <td>${detail.detailType}</td>
            <td>${detail.measure}</td>
            <td>${detail.price}</td>
        </tr>
    </c:forEach>
    </table>

    </td>
        <td style="border: inset black">
            <table>
                <tr>
                    <th>Номер цеха</th><th>Номер участка</th><th>Имя участка</th><th>Айди ответственного</th>
                </tr>
                <c:forEach var="workshop" items="${workshops}">

                    <tr>
                        <td>${workshop.wdId.workshopNumber}</td>
                        <td>${workshop.wdId.sectionNumber}</td>
                        <td>${workshop.sectionName}</td>
                        <td>${workshop.masterId}</td>
                    </tr>
                </c:forEach>
            </table>
        </td>

        <td style="border: inset black">
            <table >
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

        </td>
    </tr>
</table>

<a href="${pageContext.request.contextPath}/">Вернуться назад</a>

</body>
</html>
