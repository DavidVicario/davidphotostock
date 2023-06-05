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
    <link rel="stylesheet" href="/assets/css/header.css">
    <link rel="stylesheet" href="/assets/css/footer.css">
</head>
<body>
    <jsp:include page="/includes/components/header.jsp"/>
    <jsp:include page="/includes/components/subheader.jsp">
        <jsp:param name="title" value="CHECKOUT" />
        <jsp:param name="description1" value="" />
        <jsp:param name="image" value="/assets/img/img/2504211058-2.jpg" />
    </jsp:include>
    
    <div>
        
        
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
