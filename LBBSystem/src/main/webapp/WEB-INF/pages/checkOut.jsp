<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:libraryTemplate pageTitle="MainPage">
    <div class="container mt-4">
        <div class="row">
            <jsp:include page="/WEB-INF/components/BookCheckOutComponents/AboutBook.jsp"/>
            <jsp:include page="/WEB-INF/components/BookCheckOutComponents/CheckOutForm.jsp"/>
        </div>
    </div>
</t:libraryTemplate>
