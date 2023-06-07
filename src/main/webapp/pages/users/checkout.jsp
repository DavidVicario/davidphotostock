<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Checkout</title>
    <link rel="shortcut icon" href="/assets/img/img/DV-logo-favicon2.svg" type="image/svg+xml">
    <link rel="shortcut icon" href="/assets/img/img/negro-2k.png" type="image/png">
    <link rel="stylesheet" href="/assets/icons/bootstrap-icons.css">
    <link rel="stylesheet" href="/assets/css/general.css">
    <link rel="stylesheet" href="/assets/css/checkout_style.css">
    <link rel="stylesheet" href="/assets/css/header.css">
    <link rel="stylesheet" href="/assets/css/subheader.css">
    <link rel="stylesheet" href="/assets/css/footer.css">
</head>
<body>
    <jsp:include page="/includes/components/header.jsp"/>
    <jsp:include page="/includes/components/subheader.jsp">
        <jsp:param name="title" value="CHECKOUT" />
        <jsp:param name="description1" value="" />
        <jsp:param name="image" value="/assets/img/img-product/4.jpg" />
    </jsp:include>
    <section class="section-checkout" id="section-checkout">
        
        <h2 class="user-name">DAVID</h2>
        
        <form class="content-checkout" action="/UsersServlet?action=login" method="post">
            <div class="container-checkout">
                <label for="user"><b>Username</b></label>
                <input id="user-checkout" type="text" placeholder="Enter Username" name="user" required>
                <label for="pass"><b>Password</b></label>
                <input id="pass-checkout" type="password" placeholder="Enter Password" name="pass" required>
                <input id="remember" type="checkbox" checked="checked" name="remember">
                <label class="me" for="remember"> Remember Me</label>
                <span class="forgot">Forgot <a href="#">password?</a></span>
                <button class="btn-checkout" type="submit">Login</button>
                <span class="no-user">Not a member? &nbsp;<a href="#" onclick="openForm('signup')">Sign Up</a></span>
            </div>
        </form>
                
        <form class="content-checkout" style="margin-top: 0;" action="/UsersServlet?action=create" method="post">
            <div class="container-checkout">
                <div class="adress-checkout">
                    <div>
                        <label for="ccaa"><b>CCAA *</b></label>
                        <input id="ccaa" type="text" placeholder="Enter CCAA" name="ccaa" required>
                    </div>
                    <div>
                        <label for="province"><b>Province *</b></label>
                        <input id="province" type="text" placeholder="Enter Province" name="province">
                    </div>
                    <div>
                        <label for="municipality"><b>Municipality *</b></label>
                        <input id="municipality" type="text" placeholder="Enter Municipality" name="municipality">
                    </div>
                </div>
            </div>
        </form>
        <button class="btn-buy" type="submit">BUY</button>
    </section>
    <jsp:include page="/includes/forms/login.jsp"/>
    <jsp:include page="/includes/forms/forgot.jsp"/>
    <jsp:include page="/includes/forms/signup.jsp"/>
    </main>
    <jsp:include page="/includes/components/footer.jsp"/>
    <script src="/assets/js/header.js"></script>
    <script src="/assets/js/forms.js"></script>
    <script src="/assets/js/top.js"></script>
</body>
</html>
