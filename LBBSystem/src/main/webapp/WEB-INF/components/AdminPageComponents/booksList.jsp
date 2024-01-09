<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="column-margin list-position">
    <div class="card">
        <div class="card-header title-list-align list-fixed-item">Books</div>
        <ul class="list-group list-group-flush">
            <c:forEach var="book" items="${books}">
                <li class="list-group-item">
                    <div class="row align-items-center">
                        <div class="col">
                            <h5 class="mb-0">${book.title}</h5>
                        </div>
                        <div class="col-auto padding-icons">
                            <span class="text-muted">Author: ${book.author}</span>
                        </div>
                        <div class="col-auto">
                            <button class="btn btn-link btn-sm"><i class="bi bi-pencil-square "></i></button>
                            <button class="btn btn-link btn-sm"><i class="fa fa-trash red-icon"></i></button>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>