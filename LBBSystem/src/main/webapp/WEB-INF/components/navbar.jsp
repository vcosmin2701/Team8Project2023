<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
  <c:when test="${pageContext.request.getRemoteUser() != null}">
    <nav class="navbar navbar-expand-md bg-body py-3">
      <div class="container">
        <span>
            <a class="navbar-brand d-flex align-items-center" href="#">
                <img width="30"
                     height="30"
                     src="${pageContext.request.contextPath}/images/books-emoji.png"
                     alt="books-emoji"
                     class="me-2"/>
                <span>Library System</span>
            </a>
        </span>

        <button class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navcol-2">
          <span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span>
        </button>

        <div id="navcol-2" class="collapse navbar-collapse">
          <ul class="navbar-nav ms-auto">
            <li class="nav-item">
              <a class="nav-link active fs-5" href="${pageContext.request.contextPath}/MainPage"><i class="fas fa-home"></i>Home</a>
            </li>
          </ul>

          <div class="dropdown">
            <button id="userDropdown" class="btn btn-primary ms-md-2 dropdown-toggle" type="button"
                    data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <i class="fas fa-user"></i>
                ${pageContext.request.getRemoteUser()}
            </button>
            <div class="dropdown-menu" aria-labelledby="userDropdown">
              <a class="dropdown-item" href="${pageContext.request.contextPath}/AccountInfo">Profile </a>
              <a class="dropdown-item" href="${pageContext.request.contextPath}/ContactSupport">Contact Support</a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="${pageContext.request.contextPath}/Logout">Logout</a>
            </div>
            </div>
        </div>
      </div>
    </nav>
  </c:when>
</c:choose>
