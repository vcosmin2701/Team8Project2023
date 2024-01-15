<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-12 col-lg-6" id="form-checkout">
    <div class="card shadow mt-3">
        <div class="card-body">
            <h4 class="card-title">Check Out</h4>
            <hr>
            <form action="${pageContext.request.contextPath}/AddBorrowedBook" method="POST">
                <div class="form-group">
                    <label for="datepicker">Please enter the return date</label>
                    <input type="date" id="datepicker" name="returnDate" class="form-control">
                </div>
                <div class="form-group">
                    <label for="loanPeriod">Please select the loan period</label>
                    <select id="loanPeriod" name="loanPeriodOption" class="form-control">
                        <c:choose>
                            <c:when test="${userRole eq 'ADMIN'}">
                                <option value="1">1 month</option>
                                <option value="2">2 months</option>
                                <option value="3">3 months</option>
                                <option value="4">4 months</option>
                                <option value="5">5 months</option>
                                <option value="6">6 months</option>
                            </c:when>
                            <c:when test="${userRole eq 'ASSISTANT'}">
                                <option value="1">1 month</option>
                                <option value="2">2 months</option>
                                <option value="3">3 months</option>
                                <option value="4">4 months</option>
                                <option value="5">5 months</option>
                                <option value="6">6 months</option>
                                <option value="7">7 months</option>
                                <option value="8">8 months</option>
                            </c:when>
                            <c:when test="${userRole eq 'DEPARTAMENT_HEAD'}">
                                <option value="1">1 month</option>
                                <option value="2">2 months</option>
                                <option value="3">3 months</option>
                                <option value="4">4 months</option>
                                <option value="5">5 months</option>
                                <option value="6">6 months</option>
                                <option value="7">7 months</option>
                                <option value="8">8 months</option>
                                <option value="9">9 months</option>
                                <option value="10">10 months</option>
                                <option value="11">11 months</option>
                                <option value="12">12 months</option>
                            </c:when>
                            <c:when test="${userRole eq 'STUDENT'}">
                                <option value="1">1 month</option>
                                <option value="2">2 months</option>
                                <option value="3">3 months</option>
                                <option value="4">4 months</option>
                            </c:when>
                            <c:otherwise>
                                <option value="1">99 months</option>
                            </c:otherwise>
                        </c:choose>
                    </select>
                </div>
                <hr>

                <div class="row">
                    <div class="col mt-2">
                        <button class="btn btn-primary d-block w-100" type="subbmit">Finish Checkout</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>