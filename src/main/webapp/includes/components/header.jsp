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
            <ul>
                <li><a href="/pages/users/portfolio.jsp">PORTFOLIO</a></li>
                <li><a href="/pages/users/about.jsp">ABOUT</a></li>
                <li><a href="/pages/users/contact.jsp">CONTACT</a></li>
            </ul>
        </div>
        <div class="users">
            <ul>
                <% 
                Users loggedInUser = (Users) session.getAttribute("user");
                if (loggedInUser != null) { 
                    String username = loggedInUser.getUsername();
                %>
                    <li><a onclick="openForm('profile')"><%= username %></a></li>
                    <li><a onclick="logout()">LOGOUT</a></li>
                <% } else { %>
                    <li><a onclick="openForm('login')">LOGIN</a></li>
                    <li><a onclick="openForm('signup')">SIGN UP</a></li>
                <% } %>
            </ul>
        </div>
        <div class="mobile-close-header">
            <div class="container-x" onclick="myFunction(this)">
                <div class="bar1"></div>
                <div class="bar2"></div>
                <div class="bar3"></div>
            </div>
        </div>                    
        <div class="shop">
            <a href="" class="bi bi-bag"></a>
        </div>
    </div>
</header>
