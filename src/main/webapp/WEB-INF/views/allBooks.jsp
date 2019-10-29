<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All books</title>
</head>
<body>
<jsp:include page="../views/header.jsp"/>

<div align="center">
    <h2> Select what you want to buy</h2>
    <table border="2">
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Year</th>
            <th>Price</th>
            <th>Authors</th>
            <th>Info</th>
            <th>Rent</th>
        </tr>
        <c:forEach var="book" items="${allBooks}">
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
                <td>
                    <a href="${pageContext.request.contextPath}/book/${book.bookId}">Info</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/rent/rentBook?book_id=${book.bookId}">Rent</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
