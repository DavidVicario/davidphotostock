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
<body class="fixed-header">
    <jsp:include page="/includes/components/header.jsp"/>
    <jsp:include page="/includes/components/subheader.jsp">
        <jsp:param name="title" value="PORTFOLIO" />
        <jsp:param name="description1" value="My view of the world through the camera lens." />
        <jsp:param name="image" value="/assets/img/social(1).jpg" />
    </jsp:include>
    <main>
        <h3 class="title-main hm">My Worldview</h3>
        <p class="title-main pm">Printed on silk photography paper, 250 grm.<br>
        All images have a size of 100x70 cm.</p>
        <div class="container-btn-pf" id="container-btn-pf">
            <button class="btn-pf btn-bsc active-pf" onclick="filterSelection('all')"> Show all</button>
            <div class="dropdown">
                <button class="btn-drop btn-bsc" onclick="showDrop('cdd')"> Categories</button>
                <div id="cdd" class="content-dropdown">
                    <a class="btn-pf" onclick="filterSelection('flower'); showDrop('cdd')"> Author</a>
                    <a class="btn-pf" onclick="filterSelection('insect'); showDrop('cdd')"> Macro</a>
                    <a class="btn-pf" onclick="filterSelection('social'); showDrop('cdd')"> Nature</a>
                    <a class="btn-pf" onclick="filterSelection('landscape'); showDrop('cdd')"> Travel</a>
                    <a class="btn-pf" onclick="filterSelection('landscape'); showDrop('cdd')"> Social</a>
                    <a class="btn-pf" onclick="filterSelection('landscape'); showDrop('cdd')"> Commercial</a>
                </div>
            </div>
            <div class="dropdown">
                <button class="btn-drop btn-bsc" onclick="showDrop('sdd')"> Subcategories</button>
                <div id="sdd" class="content-dropdown">
                    <a class="btn-pf" onclick="filterSelection('flower macro'); showDrop('sdd')"> A. Author</a>
                    <a class="btn-pf" onclick="filterSelection('insect'); showDrop('sdd')"> A. Abstract</a>
                    <a class="btn-pf" onclick="filterSelection('social'); showDrop('sdd')"> M. Insect</a>
                    <a class="btn-pf" onclick="filterSelection('landscape'); showDrop('sdd')"> M. Flora</a>
                    <a class="btn-pf" onclick="filterSelection('landscape'); showDrop('sdd')"> N. Fauna</a>
                    <a class="btn-pf" onclick="filterSelection('landscape'); showDrop('sdd')"> N. Flora</a>
                    <a class="btn-pf" onclick="filterSelection('landscape'); showDrop('sdd')"> N. Landscape</a>
                    <a class="btn-pf" onclick="filterSelection('landscape'); showDrop('sdd')"> T. Culture</a>
                    <a class="btn-pf" onclick="filterSelection('landscape'); showDrop('sdd')"> T. People</a>
                    <a class="btn-pf" onclick="filterSelection('landscape'); showDrop('sdd')"> T. Landscape</a>
                    <a class="btn-pf" onclick="filterSelection('landscape'); showDrop('sdd')"> T. Architecture</a>
                    <a class="btn-pf" onclick="filterSelection('landscape'); showDrop('sdd')"> S. Portrait</a>
                    <a class="btn-pf" onclick="filterSelection('landscape'); showDrop('sdd')"> S. People</a>
                    <a class="btn-pf" onclick="filterSelection('landscape'); showDrop('sdd')"> S. Street</a>
                    <a class="btn-pf" onclick="filterSelection('landscape'); showDrop('sdd')"> C. Product</a>
                    <a class="btn-pf" onclick="filterSelection('landscape'); showDrop('sdd')"> C. Foot</a>
                </div>
            </div>
        </div>

        
        <div class="row-pf">
            <div class="column-pf flower macro">
                <div class="content-pf">
                    <img src="/assets/img/flowers(1).jpg" alt="Flower" style="width:100%">
                    <div class="content-info">
                        <div class="pf-text">
                            <h4 class="hpf">Sakura</h4>
                            <p class="ppf">€100.00</p>
                        </div>
                        <button class="btn-cart">Add Cart <i class="bi bi-bag-plus"></i></button>
                    </div>
                </div>
            </div>
            <div class="column-pf flower retrato">
                <div class="content-pf">
                    <img src="/assets/img/flowers(2).jpg" alt="Flower" style="width:100%">
                    <div class="content-info">
                        <div class="pf-text">
                            <h4 class="hpf">Sakura</h4>
                            <p class="ppf">€100.00</p>
                        </div>
                        <button class="btn-cart">Add Cart <i class="bi bi-bag-plus"></i></button>
                    </div>
                </div>
            </div>
            <div class="column-pf flower">
                <div class="content-pf">
                    <img src="/assets/img/flowers(3).jpg" alt="Flower" style="width:100%">
                    <div class="content-info">
                        <div class="pf-text">
                            <h4 class="hpf">Sakura</h4>
                            <p class="ppf">€100.00</p>
                        </div>
                        <button class="btn-cart">Add Cart <i class="bi bi-bag-plus"></i></button>
                    </div>
                </div>
            </div>
            <div class="column-pf flower">
                <div class="content-pf">
                    <img src="/assets/img/flowers(4).jpg" alt="Flower" style="width:100%">
                    <div class="content-info">
                        <div class="pf-text">
                            <h4 class="hpf">Sakura</h4>
                            <p class="ppf">€100.00</p>
                        </div>
                        <button class="btn-cart">Add Cart <i class="bi bi-bag-plus"></i></button>
                    </div>
                </div>
            </div>
            <div class="column-pf flower">
                <div class="content-pf">
                    <img src="/assets/img/flowers(5).jpg" alt="Flower" style="width:100%">
                    <div class="content-info">
                        <div class="pf-text">
                            <h4 class="hpf">Sakura</h4>
                            <p class="ppf">€100.00</p>
                        </div>
                        <button class="btn-cart">Add Cart <i class="bi bi-bag-plus"></i></button>
                    </div>
                </div>
            </div>
            <div class="column-pf flower">
                <div class="content-pf">
                    <img src="/assets/img/flowers(6).jpg" alt="Flower" style="width:100%">
                    <div class="content-info">
                        <div class="pf-text">
                            <h4 class="hpf">Sakura</h4>
                            <p class="ppf">€100.00</p>
                        </div>
                        <button class="btn-cart">Add Cart <i class="bi bi-bag-plus"></i></button>
                    </div>
                </div>
            </div>
            
            
            <div class="column-pf insect">
                <div class="content-pf">
                    <img src="/assets/img/insect(1).jpg" alt="Insect" style="width:100%">
                    <div class="content-info">
                        <div class="pf-text">
                            <h4 class="hpf">Bicho</h4>
                            <p class="ppf">€150.00</p>
                        </div>
                        <button class="btn-cart">Add Cart <i class="bi bi-bag-plus"></i></button>
                    </div>
                </div>
            </div>
            <div class="column-pf insect">
                <div class="content-pf">
                    <img src="/assets/img/insect(2).jpg" alt="Insect" style="width:100%">
                    <div class="content-info">
                        <div class="pf-text">
                            <h4 class="hpf">Bicho</h4>
                            <p class="ppf">€150.00</p>
                        </div>
                        <button class="btn-cart">Add Cart <i class="bi bi-bag-plus"></i></button>
                    </div>
                </div>
            </div>
            <div class="column-pf insect">
                <div class="content-pf">
                    <img src="/assets/img/insect(3).jpg" alt="Insect" style="width:100%">
                    <div class="content-info">
                        <div class="pf-text">
                            <h4 class="hpf">Bicho</h4>
                            <p class="ppf">€150.00</p>
                        </div>
                        <button class="btn-cart">Add Cart <i class="bi bi-bag-plus"></i></button>
                    </div>
                </div>
            </div>
            <div class="column-pf insect">
                <div class="content-pf">
                    <img src="/assets/img/insect(4).jpg" alt="Insect" style="width:100%">
                    <div class="content-info">
                        <div class="pf-text">
                            <h4 class="hpf">Bicho</h4>
                            <p class="ppf">€150.00</p>
                        </div>
                        <button class="btn-cart">Add Cart <i class="bi bi-bag-plus"></i></button>
                    </div>
                </div>
            </div>


            <div class="column-pf social">
                <div class="content-pf">
                    <img src="/assets/img/social(1).jpg" alt="Social" style="width:100%">
                    <div class="content-info">
                        <div class="pf-text">
                            <h4 class="hpf">Andrea</h4>
                            <p class="ppf">€170.00</p>
                        </div>
                        <button class="btn-cart">Add Cart <i class="bi bi-bag-plus"></i></button>
                    </div>
                </div>
            </div>
            <div class="column-pf social">
                <div class="content-pf">
                    <img src="/assets/img/social(2).jpg" alt="Social" style="width:100%">
                    <div class="content-info">
                        <div class="pf-text">
                            <h4 class="hpf">Andrea</h4>
                            <p class="ppf">€170.00</p>
                        </div>
                        <button class="btn-cart">Add Cart <i class="bi bi-bag-plus"></i></button>
                    </div>
                </div>
            </div>
            <div class="column-pf social">
                <div class="content-pf">
                    <img src="/assets/img/social(3).jpg" alt="Social" style="width:100%">
                    <div class="content-info">
                        <div class="pf-text">
                            <h4 class="hpf">Andrea</h4>
                            <p class="ppf">€170.00</p>
                        </div>
                        <button class="btn-cart">Add Cart <i class="bi bi-bag-plus"></i></button>
                    </div>
                </div>
            </div>
            <div class="column-pf social">
                <div class="content-pf">
                    <img src="/assets/img/social(4).jpg" alt="Social" style="width:100%">
                    <div class="content-info">
                        <div class="pf-text">
                            <h4 class="hpf">Andrea</h4>
                            <p class="ppf">€170.00</p>
                        </div>
                        <button class="btn-cart">Add Cart <i class="bi bi-bag-plus"></i></button>
                    </div>
                </div>
            </div>
            <div class="column-pf social">
                <div class="content-pf">
                    <img src="/assets/img/social(5).jpg" alt="Social" style="width:100%">
                    <div class="content-info">
                        <div class="pf-text">
                            <h4 class="hpf">Andrea</h4>
                            <p class="ppf">€170.00</p>
                        </div>
                        <button class="btn-cart">Add Cart <i class="bi bi-bag-plus"></i></button>
                    </div>
                </div>
            </div>


            <div class="column-pf landscape">
                <div class="content-pf">
                    <img src="/assets/img/landscape(1).jpg" alt="Landscape" style="width:100%">
                    <div class="content-info">
                        <div class="pf-text">
                            <h4 class="hpf">Cantabria</h4>
                            <p class="ppf">€130.00</p>
                        </div>
                        <button class="btn-cart">Add Cart <i class="bi bi-bag-plus"></i></button>
                    </div>
                </div>
            </div>
            <div class="column-pf landscape">
                <div class="content-pf">
                    <img src="/assets/img/landscape(2).jpg" alt="Landscape" style="width:100%">
                    <div class="content-info">
                        <div class="pf-text">
                            <h4 class="hpf">Cantabria</h4>
                            <p class="ppf">€130.00</p>
                        </div>
                        <button class="btn-cart">Add Cart <i class="bi bi-bag-plus"></i></button>
                    </div>
                </div>
            </div>
            <div class="column-pf landscape">
                <div class="content-pf">
                    <img src="/assets/img/landscape(3).jpg" alt="Landscape" style="width:100%">
                    <div class="content-info">
                        <div class="pf-text">
                            <h4 class="hpf">Cantabria</h4>
                            <p class="ppf">€130.00</p>
                        </div>
                        <button class="btn-cart">Add Cart <i class="bi bi-bag-plus"></i></button>
                    </div>
                </div>
            </div>

            
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
