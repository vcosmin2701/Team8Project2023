<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:adminTemplate pageTitle="BooksPage">
   <div class="white-box-div">
      <form class="d-flex">
         <input class="form-control me-2 w-25 search-margin" type="search" placeholder="Search" aria-label="Search">
         <button class="btn btn-outline-primary " type="submit">Search</button>
         <a href="#" class="btn btn-primary create-margin">Add ${createEntity}</a>
      </form>
   </div>
</t:adminTemplate>

