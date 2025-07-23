<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!Doctype html>
<html>
<head>
    <title>Enter details</title>
</head>
<body>
    <p>Please, enter your details</p>
    <form:form action="showDetails" modelAttribute="employee">
        Name <form:input path="name"/>
        <form:errors path="name"/>
        <br>
        Surname <form:input path="surname"/>
        <form:errors path="surname"/>
        <br>
        Salary <form:input path="salary"/>
        <br>
        Department <form:select path="department">
        <form:options items="${employee.departments}"/>
        </form:select>
        <br>
        Which car do you want? <form:radiobuttons path="carBrand" items="${employee.carBrands}"/>
        <br>
        Foreign languages?
        EN <form:checkbox path="languages" value="English"/>
        DE <form:checkbox path="languages" value="Deutch"/>
        FR <form:checkbox path="languages" value="French"/>

        <br>

        <input type="submit" value="OK">

    </form:form>
</body>
</html>
