<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Book</title>
    <link rel="stylesheet" type="text/css" href="/static/css/style.css">
</head>
<body>
    <h2>Add a Book</h2>
    <form action="/books/add" method="post">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required>
        <br>
        <label for="author">Author:</label>
        <input type="text" id="author" name="author" required>
        <br>
        <button type="submit">Add Book</button>
    </form>
    <br>
    <a href="/books">Back to Books</a>
    <br>
    <a href="/">Back to Home</a>
</body>
</html>
