<%@ page language="java" %>
<%
    String fullname = request.getParameter("fullname");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String birthday = request.getParameter("birthday");
    String gender = request.getParameter("gender");
    String profession = request.getParameter("profession");
    String married = request.getParameter("married") != null ? "Yes" : "No";
    String note = request.getParameter("note");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Registration Result</title>
</head>
<body>
    <h2>User Registration Details</h2>
    <table border="1" cellpadding="5">
        <tr><td>Full Name</td><td><%= fullname %></td></tr>
        <tr><td>Email</td><td><%= email %></td></tr>
        <tr><td>Password</td><td><%= password %></td></tr>
        <tr><td>Birthday</td><td><%= birthday %></td></tr>
        <tr><td>Gender</td><td><%= gender %></td></tr>
        <tr><td>Profession</td><td><%= profession %></td></tr>
        <tr><td>Married</td><td><%= married %></td></tr>
        <tr><td>Note</td><td><%= note %></td></tr>
    </table>
</body>
</html>
