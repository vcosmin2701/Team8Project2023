document.getElementById('addUserButton').addEventListener('click', function(event) {
    event.preventDefault();

    document.getElementById('popupDialog').style.display = 'block';
    document.getElementById('overlay').style.display = 'block';
});

document.getElementById('userForm').addEventListener('submit', function(event) {

    event.preventDefault();

});
function showPopup() {
    document.getElementById('popupDialog').style.display = 'block';
}

function closePopup() {

    document.getElementById('popupDialog').style.display = 'none';
}
function showEditPopup(bookId) {
    document.getElementById('editPopupDialog').style.display = 'block';
}
function closeEditPopup(bookId) {
    document.getElementById('editPopupDialog').style.display = 'none';
}
