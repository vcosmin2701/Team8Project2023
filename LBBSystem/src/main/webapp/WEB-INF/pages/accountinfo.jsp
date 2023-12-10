    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
    <t:libraryTemplate pageTitle="AccountInfo">

        <head>
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">

        </head>


        <section class="sectionClass">
            <jsp:include page="/WEB-INF/components/MainPageComponents/accountPageTitle.jsp"/>
            <jsp:include page="/WEB-INF/components/MainPageComponents/personInfo.jsp"/>
            <jsp:include page="/WEB-INF/components/MainPageComponents/borrowedBooks.jsp"/>

        </section>


    </t:libraryTemplate>
