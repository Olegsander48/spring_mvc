<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!Doctype html>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    <p>You're welcome</p>
    <p>Your name is ${employee.name}</p>
    <p>Your surname is ${employee.surname}</p>
    <p>Your salary is ${employee.salary}</p>
    <p>Your department is ${employee.department}</p>
    <p>Your car is ${employee.carBrand}</p>
    <p>You know: </p>
    <ul>
        <c:forEach var="lang" items="${employee.languages}">
            <li>${lang}</li>
        </c:forEach>
    </ul>
    <p>Phone number ${employee.phoneNumber}</p>
    <p>email ${employee.email}</p>
</body>
</html>
