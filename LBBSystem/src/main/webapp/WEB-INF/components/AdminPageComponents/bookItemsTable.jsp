<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container margin-top">
  <div class="row justify-content-center">
    <div class="col-10">
      <div class="table-responsive">
        <table class="table table-striped">
          <thead>
          <tr>
            <th scope="col">${firstColumn}</th>
            <th scope="col">${secondColumn}</th>
            <th scope="col">${thirdColumn}</th>
            <th scope="col">${fourColumn}</th>
            <th></th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="book" items="${books}">
            <tr>
              <td><img class="image-padding-right"
                       src="${pageContext.request.contextPath}/images/books-emoji.png"/>${book.title}</td>
              <td>${book.stock}</td>
              <td>
                <button type="button" class="btn btn-info me-2">${book.category}</button>
              </td>
              <td>${book.author}</td>
              <td class="text-right">
                <a href="${pageContext.request.contextPath}/EditBook?id=${book.id}" class="btn btn-sm btn-primary"><i class="bi bi-pencil-square"></i></a>
                <form action="${pageContext.request.contextPath}/DeleteBook" method="post">
                  <input type="hidden" name="bookId" value="${book.id}">
                  <button type="submit" class="btn btn-sm btn-danger"><i class="fa fa-trash"></i></button>
                </form>
              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>


