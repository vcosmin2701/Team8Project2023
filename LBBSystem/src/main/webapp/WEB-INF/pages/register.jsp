<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Register">
  <div class="container-fluid h-100">
    <div class="row no-gutters h-100">
      <div class="col-md-5 d-none d-md-flex"
           style="background: url('${pageContext.request.contextPath}/images/library.png') lightgray 50% / cover no-repeat;">
      </div>
      <div class="col-md-7 d-flex align-items-center justify-content-center">
        <div class="register-container">
          <h2 class="text-center mb-4 register-text">Sign in</h2>
          <div class="text-left info-container">
            <p>Please fill your information below</p>
          </div>
          <form method="POST" class="form-register" action="${pageContext.request.contextPath}/Register">
            <div class="input-group mb-3">
              <span class="input-group-text"><i class="fa fa-envelope"></i></span>
              <label for="email"></label>
              <input type="email" name="email" id="email" class="form-control" placeholder="E-mail" required>
            </div>

            <div class="input-group mb-3">
              <span class="input-group-text"><i class="fa fa-user"></i></span>
              <label for="firstName"></label>
              <input type="text" name="firstName" id="firstName" class="form-control" placeholder="FirstName" required>
            </div>

            <div class="input-group mb-3">
              <span class="input-group-text"><i class="fa fa-user"></i></span>
              <label for="lastName"></label>
              <input type="text" name="lastName" id="lastName" class="form-control" placeholder="LastName" required>
            </div>

            <div class="input-group mb-3">
              <span class="input-group-text"><i class="fa fa-lock"></i></span>
              <label for="password"></label>
              <input type="password" name="password" id="password" class="form-control" placeholder="Password" required>
            </div>

            <div class="input-group mb-3">
              <span class="input-group-text"><i class="fa fa-lock"></i></span>
              <label for="confirmPassword"></label>
              <input type="password" name="confirmPassword" id="confirmPassword" class="form-control"
                     placeholder="Confirm Password" required>
            </div>
            <c:if test="${not empty errors}">
              <script>
                let errorMessages = "";
                <c:forEach items="${errors}" var="error">
                errorMessages += "<c:out value='${error}'/>" + "<br>";
                </c:forEach>

                Swal.fire({
                  icon: 'error',
                  title: 'Oops...',
                  html: errorMessages,
                  didOpen: () => {
                    document.body.classList.remove('swal2-height-auto');
                  },
                  willClose: () => {
                    document.body.classList.remove('swal2-height-auto');
                  }
                });
              </script>
            </c:if>

            <c:if test="${empty errors and validUser==true}">
              <script>
                Swal.fire({
                  icon: 'success',
                  title: 'Success!',
                  text: 'Please check your inbox for a confirmation email.',
                  didOpen: () => {
                    document.body.classList.remove('swal2-height-auto');
                  },
                  willClose: () => {
                    document.body.classList.remove('swal2-height-auto');
                  }
                });
              </script>
            </c:if>

            <div class="form-group mb-4 d-flex align-items-center justify-content-center">
              <button type="submit" class="btn btn-primary">Register</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</t:pageTemplate>
