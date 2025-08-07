<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Customer Save Page</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h2>Customer Save Page</h2>

<form:form modelAttribute="customer" method="post">
    Name: <form:input path="name"/> <form:errors path="name" cssClass="error"/><br/><br/>
    
    Email: <form:input path="email"/> <form:errors path="email" cssClass="error"/><br/><br/>
    
    Gender: 
    <form:select path="gender">
        <form:option value="" label="--Select Gender--"/>
        <form:option value="Male"/>
        <form:option value="Female"/>
    </form:select> 
    <form:errors path="gender" cssClass="error"/><br/><br/>
    
    Age: <form:input path="age"/> <form:errors path="age" cssClass="error"/><br/><br/>
    
    Birthday: <form:input path="birthday" type="date"/> <form:errors path="birthday" cssClass="error"/><br/><br/>
    
    Phone: <form:input path="phone"/> <form:errors path="phone" cssClass="error"/><br/><br/>
    
    <input type="submit" value="Save Customer"/>
</form:form>
</body>
</html>
