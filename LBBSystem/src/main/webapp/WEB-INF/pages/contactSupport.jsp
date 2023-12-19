<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:libraryTemplate pageTitle="ContactSupport">
    <jsp:include page="/WEB-INF/components/ContactSupportComponents/Form.jsp"/>
    <script src="${pageContext.request.contextPath}/scripts/ContactSupport.js"></script>
    <c:if test="${not empty successMessage}">
        <div id="success-message" class="success-message" style="color: green;">${successMessage}</div>
    </c:if>
</t:libraryTemplate>

