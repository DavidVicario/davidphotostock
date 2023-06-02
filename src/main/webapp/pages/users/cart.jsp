<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart</title>
    <link rel="shortcut icon" href="/assets/img/img/DV-logo-favicon2.svg" type="image/svg+xml">
    <link rel="shortcut icon" href="/assets/img/img/negro-2k.png" type="image/png">
    <link rel="stylesheet" href="/assets/icons/bootstrap-icons.css">
    <link rel="stylesheet" href="/assets/css/general.css">
    <link rel="stylesheet" href="/assets/css/cart_style.css">
    <link rel="stylesheet" href="/assets/css/header.css">
    <link rel="stylesheet" href="/assets/css/subheader.css">
    <link rel="stylesheet" href="/assets/css/footer.css">
</head>
<body>
    <jsp:include page="/includes/components/header.jsp"/>
    <jsp:include page="/includes/components/subheader.jsp">
        <jsp:param name="title" value="CART" />
        <jsp:param name="description1" value="" />
        <jsp:param name="image" value="/assets/img/img/2504211058-2.jpg" />
    </jsp:include>
    <a class="btn-top" id="btn-top">
        <svg class="progress-ring" width="60" height="60">
            <circle class="progress-ring-circle" stroke="#ff8000" stroke-width="3" fill="#ffffff" r="28" cx="30" cy="30"/>
            <text x="50%" y="50%" text-anchor="middle" stroke="#ff9934" fill="#ff9934" dy=".3em">TOP</text>
        </svg>
    </a>
    <main>
    <h3 class="title-main hm">Cart</h3>
    <p class="title-main pm">What you want at home.</p>
    <div class="section-buy">            
        <div class="contain-buy">
            <h4 class="title-buy">Items:</h4>
            <c:if test="${empty cart}">
                <form class="container-empty">
                    <h5 class="empty-cart">-- Empty Cart --</h5>
                </form>
            </c:if>
            <c:if test="${not empty cart}">
                <c:forEach var="item" varStatus="row" items="${cart}">
                    <form class="container-buy">
                        <ul>
                            <li class="buy-row">
                                <div class="left-buy">
                                    <img class="img-buy" src="/assets/img/img-product/${item.idProduct}.jpg" alt="${item.productName}"/>                             
                                    <div class="detail-buy">
                                        <span>${item.productName}</span>
                                    </div>
                                </div>
                                <div class="right-buy">
                                    <div class="detail-buy">
                                        <div class="amout-buy">
                                            <input type="number" id="quantity-${item.idProduct}" name="name" value="1" min="1" max="${item.stock}" autocomplete="off">
                                        </div>
                                        <div class="price-buy">
                                            <p class="price" id="price-${item.idProduct}">€${item.price}</p>
                                        </div>
                                        <div class="remove-buy">
                                            <a href="/ProductServlet?action=removeCart&idProduct=${row.index}&view=cart" class="remove">&times;</a>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </form>
                </c:forEach>
            </c:if>
            <div class="total-price" style="color: white">
                <p class="total-price" id="total-price" style="color: white"></p>
            </div>
            <div class="contain-btn">
                <a href="/ProductServlet?action=allProduct" class="btn-buy">Continue</a>
                <a href="" class="btn-buy">Checkout</a>
            </div>
        </div>
    </div>
    <jsp:include page="/includes/forms/login.jsp"/>
    <jsp:include page="/includes/forms/signup.jsp"/>
    </main>
    <jsp:include page="/includes/components/footer.jsp"/>
    <script src="/assets/js/header.js"></script>
    <script src="/assets/js/forms.js"></script>
    <script src="/assets/js/top.js"></script>
</body>
</html>
