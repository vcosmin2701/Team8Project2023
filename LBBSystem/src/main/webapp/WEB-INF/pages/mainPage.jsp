<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:libraryTemplate pageTitle="MainPage">
    <jsp:include page="/WEB-INF/components/MainPageComponents/searchBook.jsp"/>
    <jsp:include page="/WEB-INF/components/MainPageComponents/categoriesBook.jsp"/>
    <jsp:include page="/WEB-INF/components/MainPageComponents/showBooks.jsp"/>
</t:libraryTemplate>