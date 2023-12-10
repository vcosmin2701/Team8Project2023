<div class="container mt-4">
    <div class="row">
        <div class="col-md-10"></div>
        <div class="mb-3 col-md-2">
            <label for="sortDropdown" class="form-label text-right d-block">Sort:</label>
            <select id="sortDropdown" class="form-control" onchange="">
                <option value="all">All Categories</option>
                <option value="author-a-z">Author A-z</option>
                <option value="author-z-a">Author Z-a</option>
                <option value="date-ascending">Date Ascending</option>
                <option value="date-descending">Date Descending</option>
                <option value="title-a-z">Title A-z</option>
                <option value="title-z-a">Title Z-a</option>
                <option value="publisher-a-z">Publisher A-z</option>
                <option value="publisher-z-a">Publisher Z-a</option>
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