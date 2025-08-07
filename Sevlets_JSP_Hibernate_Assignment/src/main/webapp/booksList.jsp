<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ page import="java.util.*,bookStore.Book" %>
<html><body>
<h2>Books Management</h2>
<a href="new">Add New Book</a> | <a href="list">List All Books</a>
<br><br>
<table border="1">
<tr><th>ID</th><th>Title</th><th>Author</th><th>Price</th><th>Actions</th></tr>
<%
  List<Book> books = (List<Book>) request.getAttribute("bookList");
  for (Book b : books) {
%>
<tr>
  <td><%= b.getId() %></td>
  <td><%= b.getTitle() %></td>
  <td><%= b.getAuthor() %></td>
  <td><%= b.getPrice() %></td>
  <td>
    <a href="edit?id=<%= b.getId() %>">Edit</a> |
    <a href="delete?id=<%= b.getId() %>">Delete</a>
  </td>
</tr>
<% } %>
</table>
</body></html>
