<div id="popupDialog" class="modal popup-dialog" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Add new user</h5>
        <button type="button" class="btn-close"></button>
      </div>
      <div class="modal-body">
        <form id="userForm">
          <div class="mb-3">
            <label for="name" class="form-label">Full name:</label>
            <input type="text" class="form-control" id="name" name="name" required>
          </div>
          <div class="mb-3">
            <label for="ssn" class="form-label">SSN:</label>
            <input type="text" class="form-control" id="ssn" name="role" required>
          </div>
          <div class="mb-3 ">
            <label for="email" class="form-label">Email:</label>
            <input type="email" class="form-control" id="email" name="email" required>
          </div>
          <div class="mb-3">
            <label for="password" class="form-label">Password:</label>
            <input type="password" class="form-control" id="password" name="password" required>
          </div>
          <div class="mb-3">
            <label for="role" class="form-label">Role:</label>
            <input type="text" class="form-control" id="role" name="role" required>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary">Close</button>
            <input type="submit" class="btn btn-primary" value="Submit">
          </div>
        </form>
      </div>
    </div>
  </div>
</div>