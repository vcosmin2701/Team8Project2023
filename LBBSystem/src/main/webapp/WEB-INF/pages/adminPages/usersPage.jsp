<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:adminTemplate pageTitle="UsersPage">
  <div class="fixed-header">
    <h1 class="title-books">Users Page</h1>
    <jsp:include page="/WEB-INF/components/AdminPageComponents/searchBar.jsp">
      <jsp:param name="url" value="AddUser"/>
      <jsp:param name="entity" value="User"/>
    </jsp:include>
  </div>
  <jsp:include page="/WEB-INF/components/AdminPageComponents/userItemsTable.jsp"/>
</t:adminTemplate>