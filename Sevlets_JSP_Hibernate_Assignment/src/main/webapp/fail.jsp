<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String name = (String) request.getAttribute("studentName");
    int marks = (int) request.getAttribute("marks");
%>

<h2>Sorry, <%= name %>.</h2>
<p>You <b>failed</b> with <%= marks %> marks.<br>
  Better Luck Next Time!
</p>

<jsp:include page="Footer.jsp" />
    