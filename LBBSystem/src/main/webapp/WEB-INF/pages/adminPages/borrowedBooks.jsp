<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:adminTemplate pageTitle="BorrowedBooks">
    <div class="fixed-header">
        <h1 class="title-books">Borrowed Books</h1>
        <jsp:include page="/WEB-INF/components/AdminPageComponents/searchBar.jsp"/>
    </div>
    <jsp:include page="/WEB-INF/components/AdminPageComponents/loanItemsTable.jsp"/>
</t:adminTemplate>