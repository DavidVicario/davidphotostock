<section class="section-add" id="add-category">
    <form class="content-add ani-add" action="/UsersAdminServlet?action=addCategory" method="post">
        <div class="image-form">
            <span onclick="closeForm('category')" class="close-x">&times;</span>
        </div>
        <div class="container-add">
            <label for="name"><b>Name *</b></label>
            <input id="name" type="text" placeholder="Enter Name" name="name" required>
            <button class="btn-add" type="submit">ADD</button>            
        </div>
    </form>
</section>