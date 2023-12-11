<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:libraryTemplate pageTitle="AccountInfo">
    <jsp:include page="/WEB-INF/components/AccountInfoComponents/accountPageTitle.jsp"/>
    <div class="container-id">
    <div class="component-id">
        <jsp:include page="/WEB-INF/components/AccountInfoComponents/personInfo.jsp"/>
    </div>
    <div class="component-id">
        <jsp:include page="/WEB-INF/components/AccountInfoComponents/borrowedBooks.jsp"/>
    </div>
    </div>
</t:libraryTemplate>