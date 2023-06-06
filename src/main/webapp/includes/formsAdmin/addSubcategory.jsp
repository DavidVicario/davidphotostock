<section class="section-add" id="add-subcategory">
    <form class="content-add ani-add" action="/UsersAdminServlet?action=addSubcategory" method="post">
        <div class="image-form">
            <span onclick="closeForm('subcategory')" class="close-x">&times;</span>
        </div>
        <div class="container-add">
            <label for="name"><b>Name *</b></label>
            <input id="name" type="text" placeholder="Enter Name" name="name" required>
            <label for="id-category"><b>Id Category *</b></label>
            <input id="id-category" type="number" placeholder="Enter Id Category" name="idCategory" required>
            <button class="btn-add" type="submit">ADD</button>            
        </div>
    </form>
</section>
