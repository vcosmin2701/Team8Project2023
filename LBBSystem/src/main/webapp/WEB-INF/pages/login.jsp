<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="Login">
  <div class="container-fluid h-100">
    <div class="row no-gutters h-100">
      <div class="col-md-5 d-none d-md-flex"
           style="background: url('${pageContext.request.contextPath}/images/library.png') lightgray 50% / cover no-repeat;">
      </div>
      <div class="col-md-7 d-flex align-items-center justify-content-center">
        <div class="login-container">
          <h2 class="text-center mb-4 login-text">LOGIN</h2>
          <form method="POST" class="form-login" action="j_security_check">
            <div class="input-group mb-3">
              <span class="input-group-text"><i class="fa fa-envelope"></i></span>
              <label for="email"></label>
              <input type="email" name="j_username" id="email" class="form-control" placeholder="E-mail" required>
            </div>

            <div class="input-group mb-3">
              <span class="input-group-text"><i class="fa fa-lock"></i></span>
              <label for="password"></label>
              <input type="password" name="j_password" id="password" class="form-control" placeholder="Password"
                     required>
            </div>

            <div class="form-group mb-4 d-flex align-items-center justify-content-center">
              <button type="submit" class="btn btn-primary">Login</button>

            </div>
            <div class="text-center links-container">
              <p class="sign-up-link">Don’t have an account? <a href="${pageContext.request.contextPath}/Register"
                                                                class="sign-up">Sign up</a></p>
            </div>

            <c:if test="${activationMessage == 'Your account has been successfully activated.'}">
              <script>
                Swal.fire({
                  title: 'Success!',
                  text: 'Your account has been successfully activated.',
                  icon: 'success',
                  confirmButtonText: 'Ok',
                  didOpen: () => {
                    document.body.classList.remove('swal2-height-auto');
                  },
                  willClose: () => {
                    document.body.classList.remove('swal2-height-auto');
                  }
                });
              </script>
            </c:if>

            <c:if test="${activationMessage == 'Your account is already activated.' or
            activationMessage == 'The email address has not been registered. Please register.'}">
              <script>
                Swal.fire({
                  icon: 'error',
                  title: 'Oops...',
                  text: '${activationMessage}',

                  confirmButtonText: 'Ok',
                  didOpen: () => {
                    document.body.classList.remove('swal2-height-auto');
                  },
                  willClose: () => {
                    document.body.classList.remove('swal2-height-auto');
                  }
                });
              </script>
            </c:if>

            <c:if test="${message!=null}">
              <script>
                Swal.fire({
                  icon: 'error',
                  title: 'Oops...',
                  text: '${message}',

                  confirmButtonText: 'Ok',
                  didOpen: () => {
                    document.body.classList.remove('swal2-height-auto');
                  },
                  willClose: () => {
                    document.body.classList.remove('swal2-height-auto');
                  }
                });
              </script>
            </c:if>
          </form>
        </div>
      </div>
    </div>
  </div>
</t:pageTemplate>
