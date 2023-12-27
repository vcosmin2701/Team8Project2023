<%@tag description="base admin template" pageEncoding="UTF-8" %>
<%@attribute name="pageTitle" %>
<!DOCTYPE html>
<html>
<head>
    <title>${pageTitle}</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/${pageTitle}.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="path/to/bootstrap.bundle.min.js"></script>
    <meta name="theme-color" content="#712cf9">
</head>
<header>
    <jsp:include page="/WEB-INF/components/AdminPageComponents/adminNavbar.jsp"/>
</header>
<body>
<jsp:doBody/>
<script src="${pageContext.request.contextPath}/scripts/searchBar.js"></script>
</body>
</html>
