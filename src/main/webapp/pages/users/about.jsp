<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About</title>
    <link rel="shortcut icon" href="/assets/img/DV-logo-favicon2.svg" type="image/svg+xml">
    <link rel="shortcut icon" href="/assets/img/negro-2k.png" type="image/png">
    <link rel="stylesheet" href="/assets/icons/bootstrap-icons.css">
    <link rel="stylesheet" href="/assets/css/general.css">
    <link rel="stylesheet" href="/assets/css/about_style.css">
    <link rel="stylesheet" href="/assets/css/header.css">
    <link rel="stylesheet" href="/assets/css/subheader.css">
    <link rel="stylesheet" href="/assets/css/footer.css">
</head>
<body>
    <jsp:include page="/includes/components/header.jsp"/>
    <jsp:include page="/includes/components/subheader.jsp">
        <jsp:param name="title" value="ABOUT" />
        <jsp:param name="description1" value="Texto de prueba" />
        <jsp:param name="image" value="/assets/img/header3.png" />
    </jsp:include>
    <main>
        <h3 class="title-main hm">My Worldview</h3>
        <p class="title-main pm">Printed on silk photography paper, 250 grm.<br>
        All images have a size of 100x70 cm.</p>
        
        
        <svg class="progress-ring" width="120" height="120">
            <circle class="progress-ring__circle" stroke="blue" stroke-width="4" fill="transparent" r="52" cx="60" cy="60"/>
            <text x="50%" y="50%" text-anchor="middle" stroke="#51c5cf" stroke-width="1px" dy=".3em">TOP</text>
        </svg>
        <jsp:include page="/includes/forms/login.jsp"/>
        <jsp:include page="/includes/forms/signup.jsp"/>
    </main>
    <jsp:include page="/includes/components/footer.jsp"/>
    <script src="/assets/js/header.js"></script>
    <script src="/assets/js/forms.js"></script>
</body>
</html>
