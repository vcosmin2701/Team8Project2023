<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-12 col-lg-6" id="form-checkout">
    <div class="card shadow mt-3">
        <div class="card-body">
            <h4 class="card-title">Check Out</h4>
            <hr>
            <div class="form-group">
                <label for="datepicker">Please enter the return date</label>
                <input type="date" id="datepicker" name="datepicker" class="form-control">
            </div>
            <div class="form-group">
                <label for="loanPeriod">Please select the loan period</label>
                <select id="loanPeriod" name="loanPeriod" class="form-control">
                    <c:choose>
                        <c:when test="${userRole eq 'ADMIN'}">
                            <option value="1">1 month</option>
                            <option value="2">2 months</option>
                            <option value="3">3 months</option>
                        </c:when>
                        <c:when test="${userRole eq 'ASSISTANT'}">
                            <option value="1">1 month</option>
                            <option value="2">2 months</option>
                        </c:when>
                        <c:when test="${userRole eq 'DEPARTAMENT_HEAD'}">
                            <option value="1">1 month</option>
                        </c:when>
                        <c:when test="${userRole eq 'STUDENT'}">
                            <option value="1">1 month</option>
                            <option value="1">3 months</option>
                        </c:when>
                        <c:otherwise>
                            <option value="1">99 months</option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </div>
            <hr>
            <div class="form-group">
                <p>
                    Students must return books promptly to avoid sanctions, such as fines or restricted borrowing. Your
                    cooperation ensures fair access to library resources. Please check the box to acknowledge and accept
                    our terms regarding timely book returns.
                </p>
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="acknowledgeCheckbox">
                    <label class="form-check-label" for="acknowledgeCheckbox">I acknowledge and accept the
                        terms.</label>
                </div>
            </div>
            <hr>
            <div class="row">
                <div class="col mt-2">
                    <button class="btn btn-primary d-block w-100" type="button">Finish Checkout</button>
                </div>
            </div>
        </div>
    </div>
</div>