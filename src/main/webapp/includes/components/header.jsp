<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.project.davidphotostock.domain.Users" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
                <li><a href="/ProductServlet?action=allProduct">PORTFOLIO</a></li>
                <li><a href="/pages/users/about.jsp">ABOUT</a></li>
                <li><a href="/pages/users/contact.jsp">CONTACT</a></li>
            </ul>
        </div>
        <div class="users">
            <ul class="list-header">
                <li><a id="user-link" href="/pages/users/cart.jsp" style="display: none; text-transform: uppercase;"></a></li>
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
            <c:choose>
                <c:when test="${not empty cart}">
                    <i class="bi bi-bag">
                        <span class="badge">${fn:length(cart)}</span>
                    </i>
                </c:when>
                <c:otherwise>
                    <i class="bi bi-bag">
                        <span class="badge badge-hidden"></span>
                    </i>
                </c:otherwise>
            </c:choose>
            <div class="contain-cart">
                <h2 class="title-cart">Items:</h2>
                <c:if test="${empty cart}">
                    <form class="container-empty-header">
                        <h5 class="empty-cart-header">-- Empty Cart --</h5>
                    </form>
                </c:if>
                <c:if test="${not empty cart}">
                    <c:forEach var="item" varStatus="row" items="${cart}">
                        <form class="container-item">
                            <ul>
                                <li class="item-row">
                                    <div class="left-item">
                                        <img class="img-item" src="/assets/img/flowers(1).jpg" alt="Flower"/>                             
                                        <div class="detail-item">
                                            <span>${item.productName}</span>
                                        </div>
                                    </div>
                                    <div class="right-item">
                                        <div class="detail-item">
                                            <div class="amout-item">
                                                <input type="number" name="name" value="1" autocomplete="off">
                                            </div>
                                            <div class="price-item">
                                                <p class="price">€ ${item.price}</p>
                                            </div>
                                            <div class="remove-item">
                                                <a href="/ProductServlet?action=removeCart&idProduct=${row.index}" class="remove">&times;</a>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </form>
                    </c:forEach>
                    <a href="/pages/users/cart.jsp" class="btn-item">Cart</a>
                </c:if>
            </div>
        </div>
    </div>
</header>
