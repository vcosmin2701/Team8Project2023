<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="popupDialog" class="modal popup-dialog" tabindex="-1">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Add new book</h5>
        <button type="button" class="btn-close" onclick="closePopup()"></button>
      </div>
      <div class="modal-body">
        <form id="bookForm" method="POST" action="${pageContext.request.contextPath}/AddBook">
          <div class="mb-3">
            <label for="title" class="form-label">Book name:</label>
            <input type="text" class="form-control" id="title" name="title" required>
          </div>
          <div class="mb-3">
            <label for="author" class="form-label">Author:</label>
            <input type="text" class="form-control" id="author" name="author" required>
          </div>
          <div class="mb-3">
            <label for="category" class="form-label">Category:</label>
            <input type="text" class="form-control" id="category" name="category" required>
          </div>
          <div class="mb-3">
            <label for="stock" class="form-label">Stock:</label>
            <input type="number" class="form-control" id="stock" name="stock" required>
          </div>
          <div class="mb-3">
            <label for="category" class="form-label">ISBN:</label>
            <input type="text" class="form-control" id="isbn" name="isbn" required>
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



