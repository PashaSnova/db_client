<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<body>
<h2>Информауия о плане выпуска</h2>
<form:form action="savePlan" modelAttribute="plan">


    Номер детали   <form:input path="ppId.detail_id"/>
    <form:errors path="ppId.detail_id"/>
    <br><br>
    Номер цеха   <form:input path="ppId.wdId.workshopNumber"/>
    <form:errors path="ppId.wdId.workshopNumber"/>
    <br><br>
    Номер участка   <form:input path="ppId.wdId.sectionNumber"/>
    <form:errors path="ppId.wdId.sectionNumber"/>
    <br><br>
    Год выпуска   <form:input path="ppId.releaseYear"/>
    <form:errors path="ppId.releaseYear"/>
    <br><br>
    Месяц выпуска   <form:select path="ppId.releaseMonth">
    <form:option value="январь" label="январь"/>
    <form:option value="февраль" label="февраль"/>
    <form:option value="март" label="март"/>
    <form:option value="апрель" label="апрель"/>
    <form:option value="май" label="май"/>
    <form:option value="июнь" label="июнь"/>
    <form:option value="июль" label="июль"/>
    <form:option value="август" label="август"/>
    <form:option value="сентябрь" label="сентябрь"/>
    <form:option value="октябрь" label="октябрь"/>
    <form:option value="ноябрь" label="ноябрь"/>
    <form:option value="декабрь" label="декабрь"/>

</form:select>
    <br><br>
    План выпуска   <form:input path="releasePlan"/>
    <form:errors path="releasePlan"/>
    <br><br>
    <input type="submit" value="OK">
</form:form>


<br><br>
<a href="${pageContext.request.contextPath}/productionPlan">Вернуться назад</a>

</body>
</html>
