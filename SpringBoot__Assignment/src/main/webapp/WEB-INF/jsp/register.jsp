<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Spring MVC Form Demo - Registration</title>
</head>
<body>
    <h2>Spring MVC Form Demo - Registration</h2>
    <form action="/submit" method="post">
        User Name: <input type="text" name="username"/><br/>
        Password: <input type="password" name="password"/><br/>
        E-mail: <input type="email" name="email"/><br/>
        Birthday (mm/dd/yyyy): <input type="text" name="birthday"/><br/>
        Profession:
        <select name="profession">
            <option value="Developer">Developer</option>
            <option value="Tester">Tester</option>
        </select><br/><br/>
        <input type="submit" value="Register"/>
    </form>
</body>
</html>
