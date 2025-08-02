<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Display User Info</title>
</head>
<body>
    <h2>Submitted User Information</h2>
    <p><strong>Username:</strong> ${param.username}</p>
    <p><strong>Password:</strong> ${param.password}</p>
    <p><strong>Address:</strong> ${param.address}</p>
    <p><strong>Subscribed to Newsletter:</strong> ${param.newsletter}</p>

    <p><strong>Favorite Frameworks:</strong></p>
    <ul>
        <c:forEach items="${paramValues.frameworks}" var="fw">
            <li>${fw}</li>
        </c:forEach>
    </ul>

    <p><strong>Gender:</strong> ${param.gender}</p>
    <p><strong>Favorite Number:</strong> ${param.favNumber}</p>
</body>
</html>
