<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:pageTemplate pageTitle="LBB System">
    <section lc-helper="background" class="min-vh-100 overflow-hidden d-flex justify-content-center align-items-center" style="background:url(https://via.placeholder.com/1920x1080.png/f4f6fa/f4f6fa)  center / cover no-repeat;">
        <div class="row g-0">
            <div class="col-md-12 text-center">
                <div class="lc-block mb-5">
                    <div editable="rich">
                        <h1 class="display-1 fw-bold">Library Management<br>System</h1>
                        <p class="lead">
                            In the dynamic landscape of academia, the conventional process of borrowing books
                            from university libraries often grapples with <br><i><strong>inefficiencies, manual intricacies, and untimely
                            delays</strong></i>
                        </p>
                        <p class="lead">
                            Our solution includes <br><strong> Seamless User Registration, Intelligent Book Search and Reservation,
                                Automated Check-Out and Check-In, and many more features to discover.</strong>
                        </p>
                    </div>
                </div>
                <div class="lc-block">
                    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/Login" role="button">Getting started</a>
                </div>
            </div>
        </div>
    </section>
</t:pageTemplate>