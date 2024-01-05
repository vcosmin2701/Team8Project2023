<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:libraryTemplate pageTitle="Check-In">
    <div class="container mt-4">
        <div class="row">
            <jsp:include page="/WEB-INF/components/BookCheckInComponents/bookInfo.jsp"/>
            <jsp:include page="/WEB-INF/components/BookCheckInComponents/checkInForm.jsp"/>
        </div>
    </div>
</t:libraryTemplate>
