<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container mt-4">
  <div class="row">
    <div class="col-md-10"></div>
    <div class="mb-3 col-md-2">
      <label for="sortDropdown" class="form-label text-right d-block">Sort:</label>
      <select id="sortDropdown" class="form-control" onchange="">
        <option value="all">All Categories</option>
        <option value="author-a-z">Author A-z</option>
        <option value="author-z-a">Author Z-a</option>
        <option value="date-ascending">Date Ascending</option>
        <option value="date-descending">Date Descending</option>
        <option value="title-a-z">Title A-z</option>
        <option value="title-z-a">Title Z-a</option>
        <option value="publisher-a-z">Publisher A-z</option>
        <option value="publisher-z-a">Publisher Z-a</option>
      </select>
    </div>
  </div>

  <div class="row">
    <c:forEach var="book" items="${books}">
      <div class="col-lg-3 col-md-4 col-sm-6 mb-3">
        <div class="card"><img class="card-img-top"
                               src="https://images.unsplash.com/photo-1543002588-bfa74002ed7e?q=80&w=2574&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                               alt="Book 2"/>
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

