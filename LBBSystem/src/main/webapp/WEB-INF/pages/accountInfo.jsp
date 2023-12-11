<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:libraryTemplate pageTitle="AccountInfo">
<div class="row2">
    <jsp:include page="/WEB-INF/components/AccountInfoComponents/accountPageTitle.jsp"/>
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <div class="component-id">
                    <jsp:include page="/WEB-INF/components/AccountInfoComponents/personInfo.jsp"/>
                </div>
            </div>
            <div class="col-md-6">
                <div class="component-id">
                    <jsp:include page="/WEB-INF/components/AccountInfoComponents/borrowedBooks.jsp"/>
                </div>
            </div>
        </div>
    </div>
    </div>

</t:libraryTemplate>