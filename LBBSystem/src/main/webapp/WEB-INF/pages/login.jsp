<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:pageTemplate pageTitle="Login">
  <div class="container-fluid h-100">
    <div class="row no-gutters h-100">
      <div class="col-md-5 d-none d-md-flex"
           style="background: url('${pageContext.request.contextPath}/images/library.png') lightgray 50% / cover no-repeat;">
      </div>
      <div class="col-md-7 d-flex align-items-center justify-content-center">
        <div class="login-container">
          <h2 class="text-center mb-4 login-text">LOGIN</h2>
          <form action="/login" method="post" class="form-login">

            <div class="input-group mb-3">
              <span class="input-group-text"><i class="fa fa-envelope"></i></span>
              <input type="email" class="form-control" placeholder="E-mail" required>
            </div>

            <div class="input-group mb-3">
              <span class="input-group-text"><i class="fa fa-lock"></i></span>
              <input type="password" class="form-control" placeholder="Password" required>
            </div>

            <div class="form-group mb-4 d-flex align-items-center justify-content-center">
              <button type="submit" class="btn btn-primary">Login</button>
            </div>

            <div class="text-center links-container">
              <p class="sign-up-link">Don’t have an account? <a href="${pageContext.request.contextPath}/Register" class="sign-up">Sign up</a></p>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</t:pageTemplate>
