<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <h2>Returned Borrowed Books</h2>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">Book Title</th>
            <th scope="col">Borrow Date</th>
            <th scope="col">Return Date</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${borrowedBooksHistory}">
            <tr>
                <td>${book.bookTitle}</td>
                <td>${book.borrowDate}</td>
                <td>${book.returnDate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="btn-container">
        <a href="${pageContext.request.contextPath}/AccountInfo" class="btn btn-primary">Back to Account Information</a>
    </div>
</div>