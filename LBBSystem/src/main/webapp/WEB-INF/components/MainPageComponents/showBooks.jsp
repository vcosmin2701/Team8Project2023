<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String currentSort = request.getParameter("sort"); %>
<div class="container mt-4">
    <div class="row">
        <div class="col-md-10"></div>
        <form action="${pageContext.request.contextPath}/MainPage" method="GET">
            <div class="mb-3 col-md-2">
                <label for="sortDropdown" class="form-label text-right d-block">Sort:</label>
                <select id="sortDropdown" name="sort" class="form-control" onchange="this.form.submit()">
                    <option value="all" ${'all'.equals(currentSort) ? 'selected' : ''}>All Categories</option>
                    <option value="author-a-z" ${'author-a-z'.equals(currentSort) ? 'selected' : ''}>Author A-Z</option>
                    <option value="author-z-a" ${'author-z-a'.equals(currentSort) ? 'selected' : ''}>Author Z-A</option>
                    <option value="title-a-z" ${'title-a-z'.equals(currentSort) ? 'selected' : ''}>Title A-Z</option>
                    <option value="title-z-a" ${'title-z-a'.equals(currentSort) ? 'selected' : ''}>Title Z-A</option>
                </select>
            </div>
        </form>
    </div>

    <div class="row">
        <c:forEach var="book" items="${books}">
            <div class="col-lg-3 col-md-4 col-sm-6 mb-3">
                <div class="card"><img class="card-img-top"
                                       src="${pageContext.request.contextPath}/BookPhotos?id=${book.id}"  alt="Book 2"/>
                    <div class="card-body">
                        <h5 class="card-title">${book.title}</h5>
                        <p class="card-text">${book.author}</p>
                        <div class="d-flex justify-content-center">
                            <a class="btn btn-primary" href="${pageContext.request.contextPath}/CheckOut">CheckOut</a>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

