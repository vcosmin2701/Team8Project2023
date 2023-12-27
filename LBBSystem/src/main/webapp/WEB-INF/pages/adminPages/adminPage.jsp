<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:adminTemplate pageTitle="AdminPage">
    <h1 class="title-books">Dashboard</h1>
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <jsp:include page="/WEB-INF/components/AdminPageComponents/booksList.jsp"/>
            </div>

            <div class="col-md-6 ">
                <div class="mb-3">
                    <jsp:include page="/WEB-INF/components/AdminPageComponents/bookOrders.jsp"/>
                </div>
                <div class="mb-3">
                    <jsp:include page="/WEB-INF/components/AdminPageComponents/minimalUsers.jsp"/>
                </div>
            </div>
        </div>
    </div>
</t:adminTemplate>