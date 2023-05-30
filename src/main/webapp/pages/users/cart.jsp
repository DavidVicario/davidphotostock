<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cart</title>
        <link rel="shortcut icon" href="/assets/img/DV-logo-favicon2.svg" type="image/svg+xml">
        <link rel="shortcut icon" href="/assets/img/negro-2k.png" type="image/png">
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
            <jsp:param name="image" value="/assets/img/insect(1).jpg" />
        </jsp:include>
        
        <main>
        <h3 class="title-main hm">Cart</h3>
        <p class="title-main pm">What you want at home.</p>
        
        <div class="section-buy">            
            <div class="contain-buy">
                <h4 class="title-buy">Items:</h4>
                <c:if test="${not empty products}">
                    <c:forEach var="product" items="${sessionScope.cart}">
                        <form class="container-buy">
                            <ul>
                                <li class="buy-row">
                                    <div class="left-buy">
                                        <img class="img-buy" src="/assets/img/flowers(1).jpg" alt="Flower"/>                             
                                        <div class="detail-buy">
                                            <span>Nombre</span>
                                        </div>
                                    </div>
                                    <div class="right-buy">
                                        <div class="detail-buy">
                                            <div class="amout-buy">
                                                <input type="number" name="name" value="1" autocomplete="off">
                                            </div>
                                            <div class="price-buy">
                                                <p class="price">€200</p>
                                            </div>
                                            <div class="remove-buy">
                                                <span onclick="" class="remove">&times;</span>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </form>
                    </c:forEach>
                </c:if>
                <div class="contain-btn">
                    <a href="/pages/users/portfolio.jsp" class="btn-buy">Continue Shopping</a>
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
    </body>
</html>
