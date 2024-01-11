<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/CRUD.css">
<div>
    <title>Edit Book</title>
    <form id="bookFrom" method="POST" class="form" action="${pageContext.request.contextPath}/EditBook">
        <input type="hidden" name="id" value="${book.id}">
        <div class="title">Edit Book</div>
        <div class="input-container ic1">
            <input id="title" name="title" class="input" type="text" placeholder=" " value="${book.title}" required/>
            <div class="cut"></div>
            <label for="title" class="placeholder">Title of book</label>
        </div>
        <div class="input-container ic1">
            <input id="author" name="author" class="input" type="text" placeholder=" " value="${book.author}" required/>
            <div class="cut"></div>
            <label for="author" class="placeholder">Author of book</label>
        </div>
        <div class="input-container ic2">
            <input id="category" name="category" class="input" type="text" placeholder=" " value="${book.category}"/>
            <div class="cut"></div>
            <label for="category" class="placeholder">Category of book</label>
        </div>
        <div class="input-container ic2">
            <input id="stock" name="stock" class="input" type="number" placeholder=" " value="${book.stock}"/>
            <div class="cut"></div>
            <label for="stock" class="placeholder">Stock</label>
        </div>
        <div class="input-container ic2">
            <input id="isbn" name="isbn" class="input" type="text" placeholder=" " value="${book.isbn}"/>
            <div class="cut"></div>
            <label for="isbn" class="placeholder">ISBN</label>
        </div>
        <button type="text" class="submit">Update</button>
    </form>
</div>