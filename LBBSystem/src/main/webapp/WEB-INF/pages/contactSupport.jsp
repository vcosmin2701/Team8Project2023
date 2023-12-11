<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:libraryTemplate pageTitle="ContactSupport">
    <jsp:include page="/WEB-INF/components/ContactSupportComponents/Form.jsp"/>
    <c:if test="${not empty successMessage}">
        <div id="success-message" class="success-message" style="color: green;">${successMessage}</div>
        <script>
            setTimeout(function () {
                var successMessageDiv = document.getElementById('success-message');
                if (successMessageDiv) {
                    successMessageDiv.style.display = 'none';
                }
            }, 3000);
        </script>
    </c:if>
</t:libraryTemplate>

