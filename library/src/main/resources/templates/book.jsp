<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Books</title>
    <link rel="stylesheet" type="text/css" href="/static/css/style.css">
</head>
<body>
    <h2>Books</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <a href="/books/add">Add a Book</a>
    <br>
    <a href="/">Back to Home</a>
</body>
</html>
