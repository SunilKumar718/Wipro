<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <jsp:useBean id="product" class="jsp4.Product" scope="request" />
<jsp:setProperty name="product" property="*" />

<h2>Product Details</h2>
<table border="1">
    <tr><td>Product ID:</td><td><jsp:getProperty name="product" property="id" /></td></tr>
    <tr><td>Name:</td><td><jsp:getProperty name="product" property="name" /></td></tr>
    <tr><td>Price:</td><td><jsp:getProperty name="product" property="price" /></td></tr>
    <tr><td>Quantity:</td><td><jsp:getProperty name="product" property="quantity" /></td></tr>
</table>
