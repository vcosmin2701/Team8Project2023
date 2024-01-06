<div class="col-12 col-lg-6" id="form-checkin">
    <div class="card shadow mt-3">
        <div class="card-body">
            <h4 class="card-title">Check In</h4>
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
                <div class="col-md-6 mt-2">
                    <button class="btn btn-primary w-100" type="button">Finish Check in</button>
                </div>
                <div class="col-md-6 mt-2">
                    <a href="${pageContext.request.contextPath}/CheckOut" class="btn btn-primary w-100">Renew your
                        book</a>
                </div>
            </div>
        </div>
    </div>
</div>
