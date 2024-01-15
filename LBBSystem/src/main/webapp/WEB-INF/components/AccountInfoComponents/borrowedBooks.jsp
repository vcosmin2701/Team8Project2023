<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-6">
    <div class="book-list">
        <h5 class=" fixed-title mb-3">Borrowed Books</h5>
        <ul class="list-group">
            <c:forEach var="books" items="${books}">
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Book ${books.title}
                    <div class="btn-group">
                        <button type="button" class="btn btn-success btn-sm">Hand In</button>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
    <div class="text-center mt-3">
        <a href="${pageContext.request.contextPath}/BooksHistory" class="btn btn-primary">Books History</a>
    </div>
</div>