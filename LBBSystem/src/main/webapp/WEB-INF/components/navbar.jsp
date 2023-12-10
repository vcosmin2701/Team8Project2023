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
                    <a class="nav-link active fs-5" href="#"><i class="fas fa-home"></i> First Item</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fs-5" href="#"><i class="fas fa-globe"></i> Second Item</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fs-5" href="#"><i class="fas fa-bell"></i> Third Item</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fs-5" href="#"><i class="fas fa-bell"></i> Notifications
                        <span class="badge bg-danger">3</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link fs-5" href="#"><i class="fas fa-envelope"></i> Messages
                        <span class="badge bg-info">5</span>
                    </a>
                </li>
            </ul>

            <div class="dropdown">
                <button id="userDropdown" class="btn btn-primary ms-md-2 dropdown-toggle" type="button"
                        data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-user"></i>
                    User
                </button>
                <div class="dropdown-menu" aria-labelledby="userDropdown">
                    <a class="dropdown-item" href="#">Profile</a>
                    <a class="dropdown-item" href="#">Settings</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Logout</a>
                </div>
            </div>
        </div>
    </div>
</nav>