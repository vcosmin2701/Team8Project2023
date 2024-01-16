<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:libraryTemplate pageTitle="Check-In">
    <div class="container mt-4">
        <div class="row">
            <jsp:include page="/WEB-INF/components/BookCheckInComponents/bookInfo.jsp"/>
            <form action="${pageContext.request.contextPath}/CheckIn" method="POST">
                <input type="hidden" name="bookId" value="${book.id}"/>
                <input type="submit" value="Hand In"/>
            </form>
        </div>
    </div>
</t:libraryTemplate>