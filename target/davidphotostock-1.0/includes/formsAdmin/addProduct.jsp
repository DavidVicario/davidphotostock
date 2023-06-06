<section class="section-add" id="add-product">
    <form class="content-add ani-add" action="/UsersAdminServlet?action=addProduct" method="post">
        <div class="image-form">
            <span onclick="closeForm('product')" class="close-x">&times;</span>
        </div>
        <div class="container-add">
            <label for="name-product"><b>Product Name *</b></label>
            <input id="name-product" type="text" placeholder="Enter Product Name" name="name-product" required>                    
            <div class="contain-product">
                <div>
                    <label for="stock"><b>Stock</b></label>
                    <input id="stock" type="number" placeholder="Enter Stock" name="stock">
                </div>
                <div>
                    <label for="price"><b>Price *</b></label>
                    <input id="price" type="number" placeholder="Enter Price" name="price" required>
                </div>
            </div>                                    
            <label for="id-subcategory"><b>Id Subcategory *</b></label>
            <input id="id-subcategory" type="number" placeholder="Enter Id Subcategory" name="id-subcategory" required>
            <button class="btn-add" type="submit">ADD</button>            
        </div>
    </form>
</section>