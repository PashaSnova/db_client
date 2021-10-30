<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<body>
<h2>Workshop and Section Info</h2>
<form:form action="saveWorkshopSection" modelAttribute="workshopDirectory">


    Номер цеха   <form:input path="wdId.workshopNumber"/>
    <br><br>
    Номер участка   <form:input path="wdId.sectionNumber"/>
    <br><br>
    Имя участка   <form:input path="sectionName"/>
    <br><br>
    Id ответственного   <form:input path="masterId"/>
    <br><br>
    <input type="submit" value="OK">
</form:form>
</body>
</html>
