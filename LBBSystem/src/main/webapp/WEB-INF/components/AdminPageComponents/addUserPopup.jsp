<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/UsersPage.css">
<div id="popupDialog" class="modal popup-dialog" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Add new user</h5>
        <button type="button" class="btn-close"></button>
      </div>
      <div class="modal-body">
        <form id="userForm" action="${pageContext.request.contextPath}/AddUser" method="POST">
          <div class="mb-3">
            <label for="firstName" class="form-label">First name:</label>
            <input type="text" class="form-control" id="firstName" name="firstName" required>
          </div>
          <div class="mb-3">
            <label for="lastName" class="form-label">Last name:</label>
            <input type="text" class="form-control" id="lastName" name="lastName" required>
          </div>
          <div class="mb-3 ">
            <label for="email" class="form-label">Email:</label>
            <input type="email" class="form-control" id="email" name="email" required>
          </div>
          <div class="mb-3">
            <label for="role" class="form-label">Role:</label>
            <select class="form-control" id="role" name="role" required>
              <option value="ADMIN">Admin</option>
              <option value="ASSISTANT">Assistant</option>
              <option value="DEPARTAMENT_HEAD">Department Head</option>
              <option value="STUDENT">Student</option>
            </select>
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