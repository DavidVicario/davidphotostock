<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Administrator</title>
    <link rel="shortcut icon" href="/assets/img/DV-logo-favicon2.svg" type="image/svg+xml">
    <link rel="shortcut icon" href="/assets/img/negro-2k.png" type="image/png">
    <link rel="stylesheet" href="/assets/icons/bootstrap-icons.css">
    <link rel="stylesheet" href="/assets/css/admin_style.css">
</head>
<body>
    <header class="header-admin">
        <div class="title-admin">
            <h1>ADMINISTRATOR</h1>
            <a class="logout-admin" href="#">LogOut</a>
        </div>
    </header>
    <main>
        <body>
            <div class="row-admin">
                <div class="row-menu">
                    <h2 class="title-menu">MENU</h2>
                    <input type="text" class="search-admin" id="search-admin" onkeyup="myFunction()" placeholder="Search.." title="Type in a category">
                    <ul class="menu-admin" id="menu-admin">
                        <li data-page="users-page"><a href="#">Users</a></li>
                        <li data-page="shipment-page"><a href="#">Shipment</a></li>
                        <li data-page="shipmentproduct-page"><a href="#">Shipment Product</a></li>
                        <li data-page="category-page"><a href="#">Category</a></li>
                        <li data-page="subcategory-page"><a href="#">Subcategory</a></li>
                        <li data-page="product-page"><a href="#">Product</a></li>
                        <li data-page="ccaa-page"><a href="#">CCAA</a></li>
                        <li data-page="province-page"><a href="#">Province</a></li>
                        <li data-page="municipality-page"><a href="#">Municipality</a></li>
                    </ul>
                </div>
                
                
                <div id="users-page" class="page-content">
                    <h2>Users</h2>
                    <div class="content-wrapper">
                        <div class="add-search">
                            <button class="add-new" onclick="">Add New</button>
                            <input type="type" class="search-data" name="name" placeholder="Search...">
                        </div>                                                                  
                        <div class="container-user">
                            <label for="name"><b>Name *</b></label>
                            <input id="name" type="text" placeholder="Enter Name" name="name" required>                    
                            <div class="surnames">
                                <div>
                                    <label for="fsurname"><b>First Surname *</b></label>
                                    <input id="fsurname" type="text" placeholder="Enter First Surname" name="fsurname" required>
                                </div>
                                <div>
                                    <label for="ssurname"><b>Second Surname</b></label>
                                    <input id="ssurname" type="text" placeholder="Enter Second Surname" name="ssurname">
                                </div>
                            </div>
                            <label for="mail"><b>Mail *</b></label>
                            <input id="mail" type="text" placeholder="Enter Mail" name="mail" required>
                            <label for="user"><b>Username *</b></label>
                            <input id="user" type="text" placeholder="Enter Username" name="user" required>                            
                            <label for="pass"><b>Password *</b></label>
                            <input id="pass" type="password" placeholder="Enter Password" name="pass" required>
                            <button class="button-ud" onclick="">Update</button>
                            <button class="button-ud" onclick="">Delete</button>
                        </div>
                    </div>                    
                    <div class="section-list">
                        <h3>List</h3>
                        <div class="button-list">                        
                            <button class="list" onclick="">All Users</button>
                        </div>                    
                        <div class="table-admin">
                            <table>
                               <tr>
                                   <th>ID</th>
                                   <th>Name</th>
                                   <th>Firt Surname</th>
                                   <th>Second Surname</th>
                                   <th>Mail</th>
                                   <th>Username</th>
                                   <th>Password</th>
                               </tr>
                               <tr>
                                   <td>#id</td>
                                   <td>#name</td>
                                   <td>#Surname1</td>
                                   <td>#Surname2</td>
                                   <td>lolito@gmail.com</td>
                                   <td>#Username</td>
                                   <td>#pass</td>
                               </tr>
                               <tr>
                                   <td>#id</td>
                                   <td>#name</td>
                                   <td>#Surname1</td>
                                   <td>#Surname2</td>
                                   <td>#Mail</td>
                                   <td>#Username</td>
                                   <td>#pass</td>
                               </tr>
                           </table>
                        </div>
                    </div>
                </div>
                
                
                <div id="shipment-page" class="page-content">
                    <h2>Shipment</h2>
                    <p>Content for Users page...</p>
                </div>
                <div id="shipmentproduct-page" class="page-content">
                    <h2>Shipment Product</h2>
                    <p>Content for Users page...</p>
                </div>               
                <div id="category-page" class="page-content">
                    <h2>Category</h2>
                    <p>Content for Users page...</p>
                </div>
                <div id="subcategory-page" class="page-content">
                    <h2>Subcategory</h2>
                    <p>Content for Users page...</p>
                </div>
                
                
                <div id="product-page" class="page-content">
                    <h2>Product</h2>
                    <div class="content-wrapper">
                        <div class="add-search">
                            <button class="add-new" onclick="">Add New</button>
                            <input type="type" class="search-data" name="name" placeholder="Search...">
                        </div>                                                                  
                        <div class="container-product">
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
                            <button class="button-ud" onclick="">Update</button>
                            <button class="button-ud" onclick="">Delete</button>
                        </div>
                    </div>
                    <div class="section-list">
                        <h3>Listar</h3>
                        <div class="button-list">                        
                            <button class="list" onclick="">All Products</button>
                            <button class="list" onclick="">Without Stock</button>
                            <button class="list" onclick="">Few Stock</button>
                            <button class="list" onclick="">By Category</button>
                            <button class="list" onclick="">By Subcategory</button>
                        </div>                    
                        <div class="table-admin">
                            <table>
                               <tr>
                                   <th>ID</th>
                                   <th>Product Name</th>
                                   <th>Stock</th>
                                   <th>Price</th>
                                   <th>Id Subcategory</th>
                               </tr>
                               <tr>
                                   <td>#id</td>
                                   <td>#name</td>
                                   <td>#stock</td>
                                   <td>#price</td>
                                   <td>#id sub</td>
                               </tr>
                           </table>
                        </div>
                    </div>
                </div>
                
                
                <div id="ccaa-page" class="page-content">
                    <h2>CCAA</h2>
                    <p>Content for Users page...</p>
                </div>
                <div id="province-page" class="page-content">
                    <h2>Province</h2>
                    <p>Content for Users page...</p>
                </div>
                <div id="municipality-page" class="page-content">
                    <h2>Municipality</h2>
                    <p>Content for Users page...</p>
                </div>
                
                
            </div>
                                   
        </body>
        
    </main>    
    
    <script src="/assets/js/admin.js"></script>
</body>
</html>