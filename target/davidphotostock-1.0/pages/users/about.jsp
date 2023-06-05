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
        <h4 class="ha">MYSELF</h4>
        <div class="content-about-uno observe">            
            <div class="container-about">
                <div class="ani-about-txt">
                    <h5 class="hh">One With Nature</h5>
                    <p class="hp">
                        I feel alive in nature and that is why my path always leads 
                        me to it. I love trekking, alpinism and climbing, 
                        where I am always accompanied by photography.
                        <br><br>
                        Since the first cell phones had cameras.
                    </p>
                </div>
            </div>
            <div class="image-about me-a">
                <div class="image-content ani-about-img"></div>
            </div>            
        </div>
        <h4 class="ha">BEGINNINGS</h4>
        <p class="pa">
            I started as always, problems are solved and solutions are 
            adapted to your current self.
        </p>
        <div class="content-about-dos observe">
            <div class="image-about me-b">
                <div class="image-content ani-about-img"></div>
            </div>
            <div class="container-about">
                <div class="ani-about-txt">
                    <h5 class="hh">First Macros</h5>
                    <p class="hp">
                        The beginnings of some of my macros were in low cost studios. 
                        I used to support branches on the flagstones because I didn't 
                        have supports. 
                        <br><br>
                        I was acquiring material and knowledge of how to use light to 
                        my advantage. 
                        <br><br>
                        At present my approach is to adjust to the environment instead 
                        of altering it to get a correctly composed photograph. I prefer 
                        naturalness above all. 
                    </p>
                </div>
            </div>
        </div>
        <div class="about-home">
            <div class="about-image">
                <div class="about-text">
                    <h1>Strong Will</h1>
                    <p>Always looking to the horizon.</p>
                </div>
            </div>
        </div>
        <h4 class="ha" style="margin-bottom: 50px;">FUTURE</h4>
        <div class="content-about-uno observe">
            <div class="image-about me-c">
                <div class="image-content ani-about-img"></div>
            </div>
            <div class="container-about">
                <div class="ani-about-txt">
                    <p class="hp">
                        My life has changed a lot, and now I have other aspirations. But the 
                        essence has not changed, nor do I plan to change it. Photography and 
                        alpinism will be around for a long time.
                    </p>
                </div>
            </div>
        </div>
        <div class="content-about-dos observe">
            <div class="image-about me-d">
                <div class="image-content ani-about-img" style="background-position: center bottom;"></div>
            </div>
            <div class="container-about">
                <div class="ani-about-txt">
                    <p class="hp">
                        The road will not be easy, I do not count on it. What's more, I don't 
                        care. Always improving, always walking with a clear objective. The more 
                        stones on the road, the more learning awaits me. 
                    </p>
                </div>
            </div>
        </div>
        <h4 class="ha" style="margin-bottom: 50px;">NEVER SURRENDER</h4>
        <jsp:include page="/includes/forms/login.jsp"/>
        <jsp:include page="/includes/forms/signup.jsp"/>
    </main>
    <jsp:include page="/includes/components/footer.jsp"/>
    <script src="/assets/js/header.js"></script>
    <script src="/assets/js/forms.js"></script>
    <script src="/assets/js/top.js"></script>
</body>
</html>
