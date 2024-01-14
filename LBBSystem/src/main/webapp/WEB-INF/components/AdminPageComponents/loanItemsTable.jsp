<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container margin-top">
    <div class="row justify-content-center">
        <div class="col-10">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">Book ID</th>
                        <th scope="col">User ID</th>
                        <th scope="col">Period Loan(months)</th>
                        <th scope="col">Borrow Date</th>
                        <th scope="col">Return Date</th>
                        <th scope="col">Status</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="loan" items="${loans}">
                        <tr>
                            <td>${loan.bookId}</td>
                            <td>${loan.userId}</td>
                            <td>${loan.periodLoanInMonths}</td>
                            <td>${loan.borrowDate}</td>
                            <td>${loan.returnDate}</td>
                            <td>${loan.status}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>