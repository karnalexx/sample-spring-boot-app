<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<hr/>
<table style="border: 1px solid black;">
    <thead>
    <tr>
        <th>Название</th>
        <th>Количество официальных текстов</th>
        <th>Количество статей на английском</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${result}">
        <tr>
            <td><c:out value="${item.name}"/></td>
            <td><c:out value="${item.officialTextCount}"/></td>
            <td><c:out value="${item.englishTextCount}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
