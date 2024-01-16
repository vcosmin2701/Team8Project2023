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
          <c:forEach var="user" items="${users}">
            <tr>
              <td>${user.firstName} ${user.lastName}</td>
              <td>${user.legitimationNumber}</td>
              <td>${user.email}</td>
              <td>${user.role}</td>
              <td class="text-right">
                <form action="${pageContext.request.contextPath}/DeleteUser" method="post">
                  <input type="hidden" name="email" value="${user.email}">
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


