<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head><title>Bank Form</title></head>
<body>
    <h2>Enter Bank Account Details</h2>
    <form action="displayBankDetails.jsp" method="post">
        Account No: <input type="text" name="accountNo"><br><br>
        Name: <input type="text" name="name"><br><br>
        Balance: <input type="text" name="balance"><br><br>

        Account Type:
        <select name="accountType">
            <option>Savings</option>
            <option>Current</option>
            <option>Fixed Deposit</option>
        </select><br><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
