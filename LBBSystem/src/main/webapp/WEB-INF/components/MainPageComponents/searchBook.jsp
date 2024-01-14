<div class="container text-center my-4 col-md-5">
    <form class="form-inline" action="${pageContext.request.contextPath}/MainPage" method="GET">
        <div class="input-group">
            <input id="searchInput" name="query" class="form-control" type="text" placeholder="Search for books"
                   aria-label="Search" aria-describedby="basic-addon2"/>
            <div class="input-group-append">
                <button class="btn btn-outline-primary" type="submit">Search</button>
            </div>
        </div>
    </form>
</div>