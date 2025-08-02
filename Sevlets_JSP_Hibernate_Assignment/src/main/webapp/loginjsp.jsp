<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
<legend>
<fieldset>

    <h2 style="text-align:center;">User Registration</h2>
    <form action="LoginNext.jsp" method="post" style="width: 400px; margin: auto;">
        <table>
            <tr>
                <td>Full name:</td>
                <td><input type="text" name="fullname" required></td>
            </tr>
            <tr>
                <td>E-mail:</td>
                <td><input type="email" name="email" required></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" required></td>
            </tr>
            <tr>
                <td>Birthday (yyyy-mm-dd):</td>
                <td><input type="date" name="birthday" required></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td>
                    <input type="radio" name="gender" value="Male" checked> Male
                    <input type="radio" name="gender" value="Female"> Female
                </td>
            </tr>
            <tr>
                <td>Profession:</td>
                <td>
                    <select name="profession">
                        <option>Developer</option>
                        <option>Tester</option>
                        <option>Manager</option>
                        <option>Designer</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Married?</td>
                <td><input type="checkbox" name="married" value="Yes"></td>
            </tr>
            <tr>
                <td>Note:</td>
                <td><textarea name="note" rows="4" cols="20"></textarea></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align:center;">
                    <input type="submit" value="Register">
                </td>
            </tr>
        </table>
    </form>
    </fieldset>
    </legend>
</body>
</html>
