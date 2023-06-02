<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.project.davidphotostock.domain.Users" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Administrator</title>
    <link rel="shortcut icon" href="/assets/img/img/DV-logo-favicon2.svg" type="image/svg+xml">
    <link rel="shortcut icon" href="/assets/img/img/negro-2k.png" type="image/png">
    <link rel="stylesheet" href="/assets/icons/bootstrap-icons.css">
    <link rel="stylesheet" href="/assets/css/admin_style.css">
    <link rel="stylesheet" href="/assets/css/general.css">
</head>
<body>
    <header class="header-admin">
        <div class="title-admin">
            <h1>ADMINISTRATOR</h1>
            <a class="logout-admin" href="index.jsp" onclick="logout()">LogOut</a>
        </div>
    </header>
    <main>
        <body>
            <div class="row-admin">
                <div class="row-menu">
                    <h2 class="title-menu">MENU</h2>
                    <input type="text" class="search-admin" id="search-admin" onkeyup="menuSearch()" placeholder="Search.." title="Type in a category">
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
                    <div class="title-add">
                        <h2>Users</h2>
                        <button class="add-new" onclick="">Add New</button>
                    </div>
                    <div class="content-wrapper">                                                                
                        <div class="container-user">
                            <div class="container-search">
                                <input type="text" class="search-data" name="search" placeholder="Search...">
                                <button class="bi bi-search"></button>
                            </div>
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
                            <button class="list" action="allUsers" onclick="obtainAllUsers()">All Users</button>
                        </div>                    
                        <div class="table-admin">
                            <input type="hidden" action="allUsers">
                            <table>
                                <tr>
                                    <th>Id</th>
                                    <th>Name</th>
                                    <th>Firt Surname</th>
                                    <th>Second Surname</th>
                                    <th>Mail</th>
                                    <th>Username</th>
                                    <th>Password</th>
                                </tr>                                
                                <tr>
                                    <td>#</td>
                                    <td>#</td>
                                    <td>#</td>
                                    <td>#</td>
                                    <td>#</td>
                                    <td>#</td>
                                    <td>#</td>
                                </tr>
                                <tr>
                                    <td>#</td>
                                    <td>#</td>
                                    <td>#</td>
                                    <td>#</td>
                                    <td>#</td>
                                    <td>#</td>
                                    <td>#</td>
                                </tr>
                           </table>
                        </div>
                    </div>
                </div>
                
                
                <div id="shipment-page" class="page-content">
                    <div class="title-add">
                        <h2>Shipment</h2>
                        <button class="add-new" onclick="">Add New</button>
                    </div>
                    <div class="content-wrapper">                                                                
                        <div class="container-shipment">
                            <div class="container-search">
                                <input type="text" class="search-data" name="search" placeholder="Search...">
                                <button class="bi bi-search"></button>
                            </div>
                            <div class="contain-address">
                                <div>
                                    <label for="ccaa"><b>Ccaa *</b></label>
                                    <input id="ccaa" type="text" placeholder="Enter Ccaa" name="ccaa" required>
                                </div>
                                <div>
                                    <label for="province"><b>Province *</b></label>
                                    <input id="province" type="text" placeholder="Enter Province" name="province">
                                </div>
                                <div>
                                    <label for="municipality"><b>Municipality *</b></label>
                                    <input id="municipality" type="text" placeholder="Enter Municipality" name="municipality" required>
                                </div>
                            </div>
                            <div class="contain-date">
                                <div>
                                    <label for="shipment-date"><b>Shipment Date *</b></label>
                                    <input id="shipment-date" type="datetime-local" placeholder="Enter Date" name="shipment-date" required>
                                </div>
                                <div class="finish">
                                    <label for="finished"><b>Finished *</b></label>
                                    <input id="finished" type="checkbox" name="name" required>
                                </div>
                            </div>
                            <div class="contain-id">
                                <div>
                                    <label for="id-user"><b>Id User *</b></label>
                                    <input id="id-user" type="number" placeholder="Enter Id User" name="id-user" required>
                                </div>                                
                                <div>
                                    <label for="id-municipality"><b>Id Municipality *</b></label>
                                    <input id="id-municipality" type="number" placeholder="Enter Id Municipality" name="id-municipality" required>
                                </div>
                            </div>
                            <button class="button-ud" onclick="">Update</button>
                            <button class="button-ud" onclick="">Delete</button>
                        </div>
                    </div>                    
                    <div class="section-list">
                        <h3>List</h3>
                        <div class="button-list">                        
                            <button class="list" action="" onclick="">All</button>
                        </div>                    
                        <div class="table-admin">
                            <input type="hidden" action="">
                            <table>
                                <tr>
                                    <th>Id</th>
                                    <th>Finished</th>
                                    <th>Address</th>
                                    <th>Shipment Date</th>
                                    <th>Id User</th>
                                    <th>Id Municipality</th>
                                </tr>
                                <tr>
                                    <td>#</td>
                                    <td>#</td>
                                    <td>#</td>
                                    <td>#</td>
                                    <td>#</td>
                                    <td>#</td>
                                </tr>
                           </table>
                        </div>
                    </div>
                </div>
                                    
                                    
                <div id="shipmentproduct-page" class="page-content">
                    <div class="title-add">
                        <h2>Users</h2>
                        <button class="add-new" onclick="">Add New</button>
                    </div>
                    <div class="content-wrapper">                                                                
                        <div class="container-shipmentproduct">
                            <div class="container-search">
                                <input type="text" class="search-data" name="search" placeholder="Search...">
                                <button class="bi bi-search"></button>
                            </div>
                            <div class="contain-id">
                                <div>
                                    <label for="amount"><b>Amount *</b></label>
                                    <input id="amount" type="number" placeholder="Enter Amount" name="amount" required>
                                </div>
                                <div>
                                    <label for="id-product"><b>Id Product *</b></label>
                                    <input id="id-product" type="number" placeholder="Enter Id Product" name="id-product" required>  
                                </div>
                            </div>
                            <button class="button-ud" onclick="">Update</button>
                            <button class="button-ud" onclick="">Delete</button>
                        </div>
                    </div>                    
                    <div class="section-list">
                        <h3>List</h3>
                        <div class="button-list">                        
                            <button class="list" action="" onclick="">All</button>
                        </div>                       
                        <div class="table-admin">
                            <input type="hidden" action="">
                            <table>
                                <tr>
                                    <th>Id</th>
                                    <th>Amount</th>
                                    <th>Id Shipment</th>
                                    <th>Id Product</th>
                                </tr>
                                <tr>
                                    <td>#</td>
                                    <td>#</td>
                                    <td>#</td>
                                    <td>#</td>
                                </tr>
                           </table>
                        </div>
                    </div>                    
                </div>
                                

                <div id="category-page" class="page-content">                    
                    <div class="title-add">
                        <h2>Category</h2>
                        <button class="add-new" onclick="">Add New</button>
                    </div>
                    <div class="content-wrapper">                                                                
                        <div class="container-category">
                            <div class="container-search">
                                <input type="text" class="search-data" name="search" placeholder="Search...">
                                <button class="bi bi-search"></button>
                            </div>
                            <label for="name"><b>Name *</b></label>
                            <input id="name" type="text" placeholder="Enter Name" name="name" required>                            
                            <button class="button-ud" onclick="">Update</button>
                            <button class="button-ud" onclick="">Delete</button>
                        </div>
                    </div>                    
                    <div class="section-list">
                        <h3>List</h3>
                        <div class="button-list">                        
                            <button class="list" action="" onclick="">All</button>
                        </div>                    
                        <div class="table-admin">
                            <input type="hidden" action="">
                            <table>
                                <tr>
                                    <th>Id</th>
                                    <th>Name</th>
                                </tr>
                                <tr>
                                    <td>#</td>
                                    <td>#</td>
                                </tr>                                
                           </table>
                        </div>
                    </div>
                </div>
                                    
                                    
                <div id="subcategory-page" class="page-content">
                    <div class="title-add">
                        <h2>Subcategory</h2>
                        <button class="add-new" onclick="">Add New</button>
                    </div>
                    <div class="content-wrapper">                                                                
                        <div class="container-subcategory">
                            <div class="container-search">
                                <input type="text" class="search-data" name="search" placeholder="Search...">
                                <button class="bi bi-search"></button>
                            </div>
                            <label for="name"><b>Name *</b></label>
                            <input id="name" type="text" placeholder="Enter Name" name="name" required>
                            <label for="id-category"><b>Id Category *</b></label>
                            <input id="id-category" type="number" placeholder="Enter Id Category" name="id-category" required>
                            <button class="button-ud" onclick="">Update</button>
                            <button class="button-ud" onclick="">Delete</button>
                        </div>
                    </div>                    
                    <div class="section-list">
                        <h3>List</h3>
                        <div class="button-list">                        
                            <button class="list" action="" onclick="">All</button>
                        </div>                       
                        <div class="table-admin">
                            <input type="hidden" action="">
                            <table>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>ID Category</th>
                                </tr>                                
                                <tr>
                                    <td>#</td>
                                    <td>#</td>
                                    <td>#</td>
                                </tr>                                
                           </table>
                        </div>
                    </div>
                </div>
                
                
                <div id="product-page" class="page-content">
                    <div class="title-add">
                        <h2>Product</h2>
                        <button class="add-new" onclick="">Add New</button>
                    </div>                    
                    <div class="content-wrapper">                                                                  
                        <div class="container-product">
                            <div class="container-search">
                                <input type="text" class="search-data" name="search" placeholder="Search...">
                                <button class="bi bi-search"></button>
                            </div>
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
                                    <td>#</td>
                                    <td>#</td>
                                    <td>#</td>
                                    <td>#</td>
                                    <td>#</td>
                               </tr>
                           </table>
                        </div>
                    </div>
                </div>
                
                
                <div id="ccaa-page" class="page-content">                                       
                    <div class="title-add">
                        <h2>CCAA</h2>
                    </div>            
                    <div class="section-list">
                        <h3>List</h3>
                        <div class="button-list">                        
                            <button class="list" action="" onclick="">All</button>
                        </div>                       
                        <div class="table-admin">
                            <input type="hidden" action="">
                            <table>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                </tr>                
                                <tr>
                                    <td>#</td>
                                    <td>#</td>
                                </tr>                
                           </table>
                        </div>
                    </div>
                </div>
                                

                <div id="province-page" class="page-content">
                    <div class="title-add">
                        <h2>Province</h2>                        
                    </div>                                       
                    <div class="section-list">
                        <h3>List</h3>
                        <div class="button-list">                        
                            <button class="list" action="" onclick="">All</button>
                        </div>                       
                        <div class="table-admin">
                            <input type="hidden" action="">
                            <table>
                                <tr>
                                    <th>Id</th>
                                    <th>Name</th>
                                    <th>Id Ccaa</th>
                                </tr>                
                                <tr>
                                    <td>#</td>
                                    <td>#</td>
                                    <td>#</td>
                                </tr>                
                           </table>
                        </div>
                    </div>
                </div>
                                
                <div id="municipality-page" class="page-content">                    
                    <div class="title-add">
                        <h2>Municipality</h2>
                    </div>                                        
                    <div class="section-list">
                        <h3>List</h3>
                        <div class="button-list">                        
                            <button class="list" action="" onclick="">All</button>
                        </div>                       
                        <div class="table-admin">
                            <input type="hidden" action="">
                            <table>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Id Province</th>
                                    <th>Cod Municipality</th>
                                    <th>DC</th>
                                </tr>                
                                <tr>
                                    <td>#</td>
                                    <td>#</td>
                                    <td>#</td>
                                    <td>#</td>
                                    <td>#</td>
                                </tr>                
                           </table>
                        </div>
                    </div>
                </div>
            </div>         
        </body>
    </main>
    <script src="/assets/js/admin.js"></script>
</body>
</html>