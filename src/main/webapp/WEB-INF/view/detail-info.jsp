<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<body>
<h2>Detail Info</h2>
<form:form action="saveDetail" modelAttribute="detail">


    Номер детали   <form:input path="id"/>
    <br><br>
    Наименование   <form:input path="detailName"/>
    <br><br>
    Тип   <form:select path="detailType">
            <form:option value="покупная" label="Покупная"/>
            <form:option value="собственного производства" label="Собственного производства"/>
    </form:select>
    <br><br>
    Единица измерения   <form:input path="measure"/>

    <br><br>
    Цена   <form:input path="price"/>
    <form:errors path="price"/>
    <input type="submit" value="OK">
</form:form>
</body>
</html>
