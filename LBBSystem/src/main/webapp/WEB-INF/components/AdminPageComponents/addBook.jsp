<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="bookForm" method="POST" action="${pageContext.request.contextPath}/AddBook">
    <label for="title">Title:</label><br>
    <input type="text" id="title" name="title" required><br>
    <label for="author">Author:</label><br>
    <input type="text" id="author" name="author" required><br>
    <label for="category">Category:</label><br>
    <input type="text" id="category" name="category" required><br>
    <label for="stock">Stock:</label><br>
    <input type="number" id="stock" name="stock" required><br>
    <label for="isbn">ISBN:</label><br>
    <input type="text" id="isbn" name="isbn" required><br>
    <input type="submit" value="Submit">
</form>