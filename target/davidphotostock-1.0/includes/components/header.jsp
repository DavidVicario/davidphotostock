<%@ page import="com.project.davidphotostock.domain.Users" %>
<header class="header-container" id="header-container">
    <div class="header-row">
        <div href="/pages/users/home.jsp" class="header-logo">
            <a href="/pages/users/home.jsp" class="link-logo">
                <img src="/assets/img/DV-100px.png" alt="logo">
                <div class="name">
                    <h1>DAVID VICARIO</h1>
                    <span>PHOTOGRAPHY</span>
                </div>
            </a>
        </div>
        <div class="nav">
            <ul class="list-header">
                <li><a href="ProductServlet?action=allProduct">PORTFOLIO</a></li>
                <li><a href="/pages/users/about.jsp">ABOUT</a></li>
                <li><a href="/pages/users/contact.jsp">CONTACT</a></li>
            </ul>
        </div>
        <div class="users">
            <ul class="list-header">
                <li><a id="user-link" style="display: none; text-transform: uppercase;" onclick="openForm('profile')"></a></li>
                <li><a id="logout-link" style="display: none;" onclick="logout()">LOGOUT</a></li>
                <li><a id="login-link" onclick="openForm('login')">LOGIN</a></li>
                <li><a id="signup-link" onclick="openForm('signup')">SIGN UP</a></li>
            </ul>
        </div>
        <div class="mobile-close-header">
            <div class="container-x" onclick="animateX(this)">
                <div class="bar1"></div>
                <div class="bar2"></div>
                <div class="bar3"></div>
            </div>
        </div>                    
        <div class="shop">
            <i class="bi bi-bag">
                <span class="badge">3</span>
            </i>
            <div class="contain-cart">
                <h2 class="title-cart">Items:</h2>
                <form class="container-item">
                    <ul>
                        <li class="item-row">
                            <div class="left-item">
                                <img class="img-item" src="/assets/img/flowers(1).jpg" alt="Flower"/>                             
                                <div class="detail-item">
                                    <span>Nombre foto</span>
                                </div>
                            </div>
                            <div class="right-item">
                                <div class="detail-item">
                                    <div class="amout-item">
                                        <input type="text" name="name" value="1" autocomplete="off">
                                    </div>
                                    <div class="price-item">
                                        <span class="price">Precio</span>
                                    </div>
                                    <div class="remove-item">
                                        <span onclick="" class="remove">&times;</span>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                </form>
                <a href="" class="btn-item">Cart</a>
            </div>
        </div>
    </div>
</header>
