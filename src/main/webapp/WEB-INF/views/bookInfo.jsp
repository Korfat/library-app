<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Book info</title>
</head>
<body>
<h2>Book info</h2>
<table border="2">
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Year</th>
        <th>Price</th>
        <th>Authors</th>
    </tr>
    <tr>
        <td>${book.bookId}</td>
        <td>${book.title}</td>
        <td>${book.year}</td>
        <td>${book.price}</td>
        <td>
            <c:forEach var="author" items="${book.authors}">
                ${author.name} ${author.surname}
                <br>
            </c:forEach>
        </td>
    </tr>
</table>
</body>
</html>
