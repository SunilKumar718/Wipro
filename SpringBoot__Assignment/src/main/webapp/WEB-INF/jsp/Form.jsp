<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Enrollment Form</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h2>Enrollment Form</h2>

<form:form method="post" action="/enroll" modelAttribute="student">
    First Name: 
    <form:input path="firstName" />
    <form:errors path="firstName" cssClass="error" /><br><br>

    Last Name: 
    <form:input path="lastName" />
    <form:errors path="lastName" cssClass="error" /><br><br>

    Gender:
    <form:radiobutton path="gender" value="Male" /> Male
    <form:radiobutton path="gender" value="Female" /> Female
    <form:errors path="gender" cssClass="error" /><br><br>

    DOB: 
    <form:input path="dob" type="date" />
    <form:errors path="dob" cssClass="error" /><br><br>

    Email: 
    <form:input path="email" />
    <form:errors path="email" cssClass="error" /><br><br>

    Section:
    <form:select path="section">
        <form:option value="">--Select--</form:option>
        <form:option value="A">A</form:option>
        <form:option value="B">B</form:option>
        <form:option value="C">C</form:option>
    </form:select>
    <form:errors path="section" cssClass="error" /><br><br>

    Country:
    <form:select path="country">
        <form:option value="">--Select--</form:option>
        <form:option value="India">India</form:option>
        <form:option value="USA">USA</form:option>
    </form:select>
    <form:errors path="country" cssClass="error" /><br><br>

    Subjects:<br>
    <form:checkbox path="subjects" value="Maths" /> Maths<br>
    <form:checkbox path="subjects" value="Science" /> Science<br>
    <form:checkbox path="subjects" value="English" /> English<br>
    <form:errors path="subjects" cssClass="error" /><br><br>

    <input type="submit" value="Enroll" />
</form:form>

</body>
</html>
