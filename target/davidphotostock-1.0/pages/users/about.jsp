<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About</title>
    <link rel="shortcut icon" href="/assets/img/img/DV-logo-favicon2.svg" type="image/svg+xml">
    <link rel="shortcut icon" href="/assets/img/img/negro-2k.png" type="image/png">
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
        <jsp:param name="image" value="/assets/img/img-me/MG_0265.jpeg" />
    </jsp:include>
    <a class="btn-top" id="btn-top">
        <svg class="progress-ring" width="60" height="60">
            <circle class="progress-ring-circle" stroke="#ff8000" stroke-width="3" fill="#ffffff" r="28" cx="30" cy="30"/>
            <text x="50%" y="50%" text-anchor="middle" stroke="#ff9934" fill="#ff9934" dy=".3em">TOP</text>
        </svg>
    </a>
    <main>
        <div class="title-check">
            <div>
                <h3 class="title-main hm">Passion</h3>
                <p class="title-main pm">All my life with photography in my veins</p>
            </div>
            <div>
                <h3 class="title-main hm">Creative</h3>
                <p class="title-main pm">View from different points of view</p>
            </div>
            <div>
                <h3 class="title-main hm">Patient</h3>
                <p class="title-main pm">Observe quietly, the photograph appears by itself</p>
            </div>
        </div>
        <h4 class="ha">BEGINNINGS</h4>
        <div class="content-about-uno observe">            
            <div class="container-about">
                <div class="ani-about-txt">
                    <h5 class="hh">ORCHID HUNTING</h5>
                    <p class="hp">
                        On the hunt for these strange flowers, which sometimes 
                        look like something out of a horror story. Very delicate 
                        and difficult to find plants. 
                    </p>
                </div>
            </div>
            <div class="image-about me-a">
                <div class="image-content ani-about-img"></div>
            </div>            
        </div>
        <h4 class="ha">BEGINNINGS</h4>
        <p class="pa">skjadj asd asf g xnchkjhdsgf cxjfhkjds asgjh</p>
        <div class="content-about-dos observe">
            <div class="image-about me-b">
                <div class="image-content ani-about-img"></div>
            </div>
            <div class="container-about">
                <div class="ani-about-txt">
                    <h5 class="hh">ORCHID HUNTING</h5>
                    <p class="hp">
                        On the hunt for these strange flowers, which sometimes 
                        look like something out of a horror story. Very delicate 
                        and difficult to find plants. 
                    </p>
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
