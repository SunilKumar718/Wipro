<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <!DOCTYPE html>
<html>
<head>
    <title>User Information</title>
</head>
<body>
<legend >
<fieldset>
    <h2 >User Information</h2>
    <form action="EL_Form2.jsp" method="post">
        User Name: <input type="text" name="username" value=""><br><br>
        Password: <input type="password" name="password"><br><br>
        Address: <br>
        <textarea name="address" rows="4" cols="30"></textarea><br><br>

        Subscribe Newsletter:
        <input type="checkbox" name="newsletter" value="yes"><br><br>

        Favorite Web Frameworks:<br>
        <input type="checkbox" name="frameworks" value="Spring MVC"> Spring MVC
        <input type="checkbox" name="frameworks" value="Struts 1"> Struts 1
        <input type="checkbox" name="frameworks" value="Struts 2"> Struts 2
        <input type="checkbox" name="frameworks" value="Apache Wicket"> Apache Wicket<br><br>

        Gender:
        <input type="radio" name="gender" value="Male" checked> Male
        <input type="radio" name="gender" value="Female"> Female<br><br>

         Favorite Number:<br>
        <input type="radio" name="favNumber" value="1"> 1
        <input type="radio" name="favNumber" value="2"> 2
        <input type="radio" name="favNumber" value="3"> 3
        <input type="radio" name="favNumber" value="4"> 4<br><br>

        <input type="submit" value="Submit">
    </form>
    </fieldset>
    </legend>
</body>
</html>
    