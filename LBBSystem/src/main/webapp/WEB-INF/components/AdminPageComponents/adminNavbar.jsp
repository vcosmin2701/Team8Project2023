<div class="bg-body shadow d-flex flex-column flex-shrink-0 position-fixed top-0 bottom-0" style="width: 4.5rem; z-index: 100;">
    <a class="text-center link-body-emphasis d-block p-3 text-decoration-none border-bottom" href="${pageContext.request.contextPath}/AdminPage" title data-bs-toggle="tooltip" data-bs-placement="right" data-bs-original-title="Icon-only">
        <img width="30"
             height="30"
             src="${pageContext.request.contextPath}/images/books-emoji.png"
             alt="books-emoji"
             class="me-2"/>
    </a>

    <ul class="nav nav-pills flex-column text-center nav-flush mb-auto">
        <li class="nav-item">
            <a class="nav-link py-3 border-bottom rounded-0 ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf
("/")) eq '/adminPage.jsp' ? ' active' : ''}" href="${pageContext.request.contextPath}/AdminPage" >
                <i class="bi bi-house"></i>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link py-3 border-bottom rounded-0 ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf
("/")) eq '/booksPage.jsp' ? ' active' : ''}" href="${pageContext.request.contextPath}/BooksPage">
                <i class="bi bi-book"></i>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link py-3 border-bottom rounded-0 ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf
("/")) eq '/usersPage.jsp' ? ' active' : ''}" href="${pageContext.request.contextPath}/AdminUsers">
                <i class="bi bi-people"></i>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link py-3 border-bottom rounded-0 ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf
("/")) eq '/borrowedBooks.jsp' ? ' active' : ''}" href="${pageContext.request.contextPath}/BorrowedBooks">
                <i class="bi bi-bookmark-check"></i>
            </a>
        </li>
    </ul>



    <div class="dropdown p-3 border-top">
        <a class="dropdown-toggle link-body-emphasis d-flex align-items-center text-decoration-none" aria-expanded="false" data-bs-toggle="dropdown" role="button">
            <img class="rounded-circle" alt width="32" height="32" src="https://cdn.bootstrapstudio.io/placeholders/1400x800.png" style="object-fit: cover;" />
        </a>
        <div class="dropdown-menu shadow text-small" data-popper-placement="top-start">
            <a class="dropdown-item" href="${pageContext.request.contextPath}/Login">Sign out</a>
        </div>
    </div>
</div>
