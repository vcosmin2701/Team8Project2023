`<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:libraryTemplate pageTitle="AccountInfo">
    <div class="container account-info-container">
        <jsp:include page="/WEB-INF/components/AccountInfoComponents/accountPageTitle.jsp"/>
        <div class="row">
            <jsp:include page="/WEB-INF/components/AccountInfoComponents/personInfo.jsp"/>
            <jsp:include page="/WEB-INF/components/AccountInfoComponents/borrowedBooks.jsp"/>
        </div>
    </div>
</t:libraryTemplate>`