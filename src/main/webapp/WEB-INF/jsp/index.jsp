<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="ru">
<head>
</head>
<body>
<hr/>
<spring:url value="/result" var="actionUrl"/>
<form:form method="post" modelAttribute="myForm" action="${actionUrl}">
    <label for="types">Тип статьи</label>
    <form:select name="types" path="typeId">
        <form:options items="${types}" itemLabel="name" itemValue="id"></form:options>
    </form:select>
    <br/>
    <input type="submit" id="search" name="search" value="Поиск"/>
</form:form>
</body>
</html>
