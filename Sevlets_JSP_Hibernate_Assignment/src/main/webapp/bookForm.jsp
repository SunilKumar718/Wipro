<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ page import="bookStore.Book" %>
<%
  Book b = (Book) request.getAttribute("book");
  boolean isEdit = (b != null);
%>
<html><body>
<h3><%= isEdit ? "Edit Book" : "Add New Book" %></h3>
<form action="<%= isEdit ? "update" : "insert" %>" method="post">
  <%
    if (isEdit) {
  %>
    <input type="hidden" name="id" value="<%= b.getId() %>" />
  <%
    }
  %>
  Title: <input type="text" name="title" value="<%= isEdit ? b.getTitle() : "" %>" /><br><br>
  Author: <input type="text" name="author" value="<%= isEdit ? b.getAuthor() : "" %>" /><br><br>
  Price: <input type="text" name="price" value="<%= isEdit ? b.getPrice() : "" %>" /><br><br>
  <input type="submit" value="Save" />
</form>
</body></html>
