
   <div class="white-box-div">
      <form class="d-flex">
         <input class="form-control me-2 w-25 search-margin" type="search" placeholder="Search" aria-label="Search">
         <button class="btn btn-outline-primary " type="submit">Search</button>
         <button id="addUserButton" class=" btn btn-primary create-margin">Add ${createEntity}</button>
         <div id="popupDialog" style="display:none;">
            <form id="userForm">
               <!-- Add form fields here -->
               <label for="name">Full Name:</label>
               <input type="text" id="name" name="name">
               <label for="email">Email:</label>
               <input type="email" id="email" name="email">
               <label for="role">Role:</label>
               <input type="text" id="role" name="role">

               <input type="submit" value="Submit">
            </form>
         </div>
      </form>
   </div>


