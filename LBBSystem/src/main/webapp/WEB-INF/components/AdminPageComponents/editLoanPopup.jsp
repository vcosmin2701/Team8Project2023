<div id="editPopupDialog" class="modal popup-dialog" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Edit loan</h5>
                <button type="button" class="btn-close" onclick="closeEditPopup()"></button>
            </div>
            <div class="modal-body">
                <form id="userForm">
                    <div class="mb-3">
                        <label for="username" class="form-label">Username:</label>
                        <input type="text" class="form-control" id="username" name="username" required>
                    </div>
                    <div class="mb-3">
                        <label for="book" class="form-label">Book:</label>
                        <input type="text" class="form-control" id="book" name="book" required>
                    </div>
                    <div class="mb-3">
                        <label for="start-date" class="form-label">Start Date:</label>
                        <input type="date" class="form-control" id="start-date" name="start-date" required>

                        <label for="end-date" class="form-label">End Date:</label>
                        <input type="date" class="form-control" id="end-date" name="end-date" required>
                    </div>
                    <div class="mb-3">
                        <label for="status" class="form-label">Status:</label>
                        <input type="text" class="form-control" id="status" name="status" required>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" onclick="closeEditPopup()">Close</button>
                        <input type="submit" class="btn btn-primary" value="Submit">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>