<div class="container mt-4">
    <div class="row">
        <div class="col-md-10"></div>
        <div class="mb-3 col-md-2">
            <label for="sortDropdown" class="form-label text-right d-block">Sort:</label>
            <select id="sortDropdown" class="form-control" onchange="">
                <option value="all">All Categories</option>
                <option value="category1">Category 1</option>
                <option value="category2">Category 2</option>
            </select>
        </div>
    </div>

    <div class="row">
        <jsp:include page="/WEB-INF/components/MainPageComponents/bookCard.jsp"/>
        <jsp:include page="/WEB-INF/components/MainPageComponents/bookCard.jsp"/>
        <jsp:include page="/WEB-INF/components/MainPageComponents/bookCard.jsp"/>
        <jsp:include page="/WEB-INF/components/MainPageComponents/bookCard.jsp"/>
        <jsp:include page="/WEB-INF/components/MainPageComponents/bookCard.jsp"/>
        <jsp:include page="/WEB-INF/components/MainPageComponents/bookCard.jsp"/>
    </div>
</div>