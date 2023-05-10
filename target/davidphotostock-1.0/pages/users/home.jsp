<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>David Vicario</title>
    <link rel="shortcut icon" href="/assets/img/DV-logo-favicon2.svg" type="image/svg+xml">
    <link rel="shortcut icon" href="/assets/img/negro-2k.png" type="image/png">
    <link rel="stylesheet" href="/assets/icons/bootstrap-icons.css">
    <link rel="stylesheet" href="/assets/css/general.css">
    <link rel="stylesheet" href="/assets/css/home_style.css">
    <link rel="stylesheet" href="/assets/css/header.css">
    <link rel="stylesheet" href="/assets/css/footer.css">
</head>
<body>
    <jsp:include page="/includes/components/header.jsp"/>
    <main>
    <!--Slider-->
        <section class="section-slider">
            <div class="wrapper-slider ani-slider">
                <div class="image-slider landscape" data-desktop-content-width="auto" data-tablet-content-width="auto" 
                data-bg-alignment="center" data-color-scheme="light" data-x-pos="centered" data-y-pos="middle"></div>
                <div class="content-slider">
                    <h1 class="head-slider">LANDSCAPE</h1>
                    <p class="subhead-slider">
                        <span>Awesome power</span>
                    </p>
                    <div class="buttons">
                        <div class="button transparent">
                            <a href="">VIEW NOW</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="wrapper-slider ani-slider">
                <div class="image-slider flowers" data-desktop-content-width="auto" data-tablet-content-width="auto" 
                data-bg-alignment="center" data-color-scheme="light" data-x-pos="centered" data-y-pos="middle"></div>
                <div class="content-slider">
                    <h1 class="head-slider">FLOWER</h1>
                    <p class="subhead-slider">
                        <span>Ephemeral beauty</span>
                    </p>
                    <div class="buttons">
                        <div class="button transparent">
                            <a href="">VIEW NOW</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="wrapper-slider ani-slider">
                <div class="image-slider insect" data-desktop-content-width="auto" data-tablet-content-width="auto" 
                data-bg-alignment="center" data-color-scheme="light" data-x-pos="centered" data-y-pos="middle"></div>
                <div class="content-slider">
                    <h1 class="head-slider">INSECT</h1>
                    <p class="subhead-slider">
                        <span>Little warrior</span>
                    </p>
                    <div class="buttons">
                        <div class="button transparent">
                            <a href="">VIEW NOW</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="wrapper-slider ani-slider">
                <div class="image-slider social" data-desktop-content-width="auto" data-tablet-content-width="auto" 
                data-bg-alignment="center" data-color-scheme="light" data-x-pos="centered" data-y-pos="middle"></div>
                <div class="content-slider">
                    <h1 class="head-slider">SOCIAL</h1>
                    <p class="subhead-slider">
                        <span>Unique moments</span>
                    </p>
                    <div class="buttons">
                        <div class="button transparent">
                            <a href="">VIEW NOW</a>
                        </div>
                    </div>
                </div>            
            </div>
            <a class="arrow left" onclick="plusSlides(-1)"><p><</p></a>          
            <a class="arrow right" onclick="plusSlides(1)"><p>></p></a>
        </section>
    <a href="/pages/admin/admin.jsp" target="_blank" class="logo"><b>ADMINISTRADOR</b></a>
        <jsp:include page="/includes/forms/login.jsp"/>
        
        <jsp:include page="/includes/forms/signup.jsp"/>
        <c:if test="${not empty errorMessage}">
            <div class="error">${errorMessage}</div>
        </c:if>
    </main>
    <jsp:include page="/includes/components/footer.jsp"/>
    <script src="/assets/js/header.js"></script>
    <script src="/assets/js/slider.js"></script>
    <script src="/assets/js/forms.js"></script>
</body>
</html>