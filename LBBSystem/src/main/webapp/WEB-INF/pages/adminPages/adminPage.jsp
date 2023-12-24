<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:adminTemplate pageTitle="AdminPage">
    <h1 class="title-books">Dashboard</h1>
    <jsp:include page="/WEB-INF/components/AdminPageComponents/booksList.jsp"/>
</t:adminTemplate>