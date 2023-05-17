<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Portfolio</title>
    <link rel="shortcut icon" href="/assets/img/DV-logo-favicon2.svg" type="image/svg+xml">
    <link rel="shortcut icon" href="/assets/img/negro-2k.png" type="image/png">
    <link rel="stylesheet" href="/assets/icons/bootstrap-icons.css">
    <link rel="stylesheet" href="/assets/css/general.css">
    <link rel="stylesheet" href="/assets/css/portfolio_style.css">
    <link rel="stylesheet" href="/assets/css/header.css">
    <link rel="stylesheet" href="/assets/css/subheader.css">
    <link rel="stylesheet" href="/assets/css/footer.css">
</head>
<body>
    <jsp:include page="/includes/components/header.jsp"/>
    <jsp:include page="/includes/components/subheader.jsp">
        <jsp:param name="title" value="PORTFOLIO" />
        <jsp:param name="description1" value="Texto de prueba" />
        <jsp:param name="description2" value="" />
        <jsp:param name="description3" value="" />
        <jsp:param name="image" value="/assets/img/header1.jpg" />
    </jsp:include>
    <main>
        
        
        
    <div id="myBtnContainer">
        <button class="btn active" onclick="filterSelection('all')"> Show all</button>
        <button class="btn" onclick="filterSelection('flower')"> Flower</button>
        <button class="btn" onclick="filterSelection('insect')"> Insect</button>
        <button class="btn" onclick="filterSelection('social')"> Social</button>
        <button class="btn" onclick="filterSelection('landscape')"> Landscape</button>
    </div>
        
        <!-- Portfolio Gallery Grid -->
    <div class="row">
        <div class="column flower">
            <div class="content">
                <img src="/assets/img/flowers(1).jpg" alt="Flower" style="width:100%">
                <h4>Mountains</h4>
                <p>Lorem ipsum dolor..</p>
            </div>
        </div>
        <div class="column flower">
            <div class="content">
                <img src="/assets/img/flowers(2).jpg" alt="Flower" style="width:100%">
                <h4>Lights</h4>
                <p>Lorem ipsum dolor..</p>
            </div>
        </div>
        <div class="column flower">
            <div class="content">
                <img src="/assets/img/flowers(3).jpg" alt="Flower" style="width:100%">
                <h4>Forest</h4>
                <p>Lorem ipsum dolor..</p>
            </div>
        </div>
        <div class="column flower">
            <div class="content">
                <img src="/assets/img/flowers(4).jpg" alt="Flower" style="width:100%">
                <h4>Forest</h4>
                <p>Lorem ipsum dolor..</p>
            </div>
        </div>
        <div class="column flower">
            <div class="content">
                <img src="/assets/img/flowers(5).jpg" alt="Flower" style="width:100%">
                <h4>Forest</h4>
                <p>Lorem ipsum dolor..</p>
            </div>
        </div>
        <div class="column flower">
            <div class="content">
                <img src="/assets/img/flowers(6).jpg" alt="Flower" style="width:100%">
                <h4>Forest</h4>
                <p>Lorem ipsum dolor..</p>
            </div>
        </div>

        
        <div class="column insect">
            <div class="content">
                <img src="/assets/img/insect(1).jpg" alt="Insect" style="width:100%">
                <h4>Retro</h4>
                <p>Lorem ipsum dolor..</p>
            </div>
        </div>
        <div class="column insect">
            <div class="content">
                <img src="/assets/img/insect(2).jpg" alt="Insect" style="width:100%">
                <h4>Retro</h4>
                <p>Lorem ipsum dolor..</p>
            </div>
        </div>
        <div class="column insect">
            <div class="content">
                <img src="/assets/img/insect(3).jpg" alt="Insect" style="width:100%">
                <h4>Retro</h4>
                <p>Lorem ipsum dolor..</p>
            </div>
        </div>
        <div class="column insect">
            <div class="content">
                <img src="/assets/img/insect(4).jpg" alt="Insect" style="width:100%">
                <h4>Retro</h4>
                <p>Lorem ipsum dolor..</p>
            </div>
        </div>
        

        <div class="column social">
            <div class="content">
                <img src="/assets/img/social(1).jpg" alt="Social" style="width:100%">
                <h4>Girl</h4>
                <p>Lorem ipsum dolor..</p>
            </div>
        </div>
        <div class="column social">
            <div class="content">
                <img src="/assets/img/social(2).jpg" alt="Social" style="width:100%">
                <h4>Girl</h4>
                <p>Lorem ipsum dolor..</p>
            </div>
        </div>
        <div class="column social">
            <div class="content">
                <img src="/assets/img/social(3).jpg" alt="Social" style="width:100%">
                <h4>Girl</h4>
                <p>Lorem ipsum dolor..</p>
            </div>
        </div>
        <div class="column social">
            <div class="content">
                <img src="/assets/img/social(4).jpg" alt="Social" style="width:100%">
                <h4>Girl</h4>
                <p>Lorem ipsum dolor..</p>
            </div>
        </div>
        <div class="column social">
            <div class="content">
                <img src="/assets/img/social(5).jpg" alt="Social" style="width:100%">
                <h4>Girl</h4>
                <p>Lorem ipsum dolor..</p>
            </div>
        </div>
        
        
        <div class="column landscape">
            <div class="content">
                <img src="/assets/img/landscape(1).jpg" alt="Landscape" style="width:100%">
                <h4>Man</h4>
                <p>Lorem ipsum dolor..</p>
            </div>
        </div>
        <div class="column landscape">
            <div class="content">
                <img src="/assets/img/landscape(2).jpg" alt="Landscape" style="width:100%">
                <h4>Man</h4>
                <p>Lorem ipsum dolor..</p>
            </div>
        </div>
        <div class="column landscape">
            <div class="content">
                <img src="/assets/img/landscape(3).jpg" alt="Landscape" style="width:100%">
                <h4>Man</h4>
                <p>Lorem ipsum dolor..</p>
            </div>
        </div>
        
    <!-- END GRID -->
    </div>
        
        
        
        
        
        
        
        
        
        
        
        
        <jsp:include page="/includes/forms/login.jsp"/>
        <jsp:include page="/includes/forms/signup.jsp"/>
    </main>
    <jsp:include page="/includes/components/footer.jsp"/>
    <script src="/assets/js/portfolio.js"></script>
    <script src="/assets/js/header.js"></script>
    <script src="/assets/js/forms.js"></script>
</body>
</html>
