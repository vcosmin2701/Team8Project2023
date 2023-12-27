document.getElementById('addUserButton').addEventListener('click', function() {
    // Show the pop-up
    document.getElementById('popupDialog').style.display = 'block';
    // Optional: Show the overlay
    document.getElementById('overlay').style.display = 'block';
});

// If you have a form submission, prevent default submission and add your logic
document.getElementById('userForm').addEventListener('submit', function(event) {
    event.preventDefault();
    // Add your logic to handle the form data
    // For example, send data to a server or validate input
});
