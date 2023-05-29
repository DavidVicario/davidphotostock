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
            <a href="" class="bi bi-bag">
                <span class="badge">3</span>
            </a>
            <div class="cesta hidden">
                <h2>Items:</h2>
                <form action="action">
                    <ul>
                        <li>
                            <a><img src="src" alt="alt"/></a>                             
                            <div class="item-detail">
                                <a>Nombre foto</a>
                            </div>
                            <div class="item-detail">
                                <div class="amout-item">
                                    <input type="number" name="name" value="1" autocomplete="off">
                                </div>
                                <div class="price-item">
                                    <span class="price">Precio</span>
                                </div>
                                <div class="remove-item">
                                    <span onclick="" class="remove">&times;</span>
                                </div>
                            </div>
                        </li>
                    </ul>
                </form>
                <a>Checkout</a>
            </div>
        </div>
    </div>
</header>
