<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String name = (String) request.getAttribute("studentName");
    int marks = (int) request.getAttribute("marks");
%>

<h2>Congratulations, <%= name %>!</h2>
<p>You passed with <%= marks %> marks.</p>

<jsp:include page="Footer.jsp" />
