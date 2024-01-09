<div class="white-box-div">
   <form class="d-flex">
      <input class="form-control me-2 w-25 search-margin" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-primary " type="submit">Search</button>
      <a id="addUserButton" class="btn btn-primary create-margin" href="${pageContext.request.contextPath}/AddBook">Add ${createEntity}</a>
      <jsp:include page="/WEB-INF/components/AdminPageComponents/${popupName}.jsp"/>
   </form>
</div>

