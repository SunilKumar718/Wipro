<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="account" class="jsp5.BankAcc" scope="request" />
<jsp:setProperty name="account" property="*" />

<%
    String accType = request.getParameter("accountType");
    session.setAttribute("accType", accType);
%>

<h2>Bank Account Details</h2>
<p><strong>Account No:</strong> ${account.accountNo}</p>
<p><strong>Name:</strong> ${account.name}</p>
<p><strong>Balance:</strong> ${account.balance}</p>
<p><strong>Account :</strong> ${sessionScope.accType}</p>

<c:choose>
    <c:when test="${account.balance >= 1000}">
        <p style="color:green;"><b>Balance Status: Sufficient</b></p>
    </c:when>
    <c:otherwise>
        <p style="color:red;"><b>Balance Status: Insufficient</b></p>
    </c:otherwise>
</c:choose>

