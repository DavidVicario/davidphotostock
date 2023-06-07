<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DavidPhotoStock</title>
    <link rel="shortcut icon" href="/assets/img/img/DV-logo-favicon2.svg" type="image/svg+xml">
    <link rel="shortcut icon" href="/assets/img/img/negro-2k.png" type="image/png">
    <link rel="stylesheet" href="/assets/icons/bootstrap-icons.css">
    <link rel="stylesheet" href="/assets/css/general.css">
    <link rel="stylesheet" href="/assets/css/home_style.css">
    <link rel="stylesheet" href="/assets/css/header.css">
    <link rel="stylesheet" href="/assets/css/footer.css">
</head>
<body>
    <jsp:include page="/includes/components/header.jsp"/>    
    <a class="btn-top" id="btn-top">
        <svg class="progress-ring" width="60" height="60">
            <circle class="progress-ring-circle" stroke="#ff8000" stroke-width="3" fill="#ffffff" r="28" cx="30" cy="30"/>
            <text x="50%" y="50%" text-anchor="middle" stroke="#ff9934" fill="#ff9934" dy=".3em">TOP</text>
        </svg>
    </a>
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
                            <a href="/ProductServlet?action=allProduct">VIEW NOW</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="wrapper-slider ani-slider">
                <div class="image-slider flowers" data-desktop-content-width="auto" data-tablet-content-width="auto" 
                     data-bg-alignment="center" data-color-scheme="light" data-x-pos="centered" data-y-pos="middle"></div>
                <div class="content-slider">
                    <h1 class="head-slider">NATURE</h1>
                    <p class="subhead-slider">
                        <span>Ephemeral beauty</span>
                    </p>
                    <div class="buttons">
                        <div class="button transparent">
                            <a href="/ProductServlet?action=allProduct">VIEW NOW</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="wrapper-slider ani-slider">
                <div class="image-slider insect" data-desktop-content-width="auto" data-tablet-content-width="auto" 
                     data-bg-alignment="center" data-color-scheme="light" data-x-pos="centered" data-y-pos="middle"></div>
                <div class="content-slider">
                    <h1 class="head-slider">MACRO</h1>
                    <p class="subhead-slider">
                        <span>Little warrior</span>
                    </p>
                    <div class="buttons">
                        <div class="button transparent">
                            <a href="/ProductServlet?action=allProduct">VIEW NOW</a>
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
                            <a href="/ProductServlet?action=allProduct">VIEW NOW</a>
                        </div>
                    </div>
                </div>            
            </div>
            <a class="arrow left" onclick="plusSlides(-1)"><p><</p></a>          
            <a class="arrow right" onclick="plusSlides(1)"><p>></p></a>
        </section>
        <!--Middle-->
        <div class="content-home-uno">
            <div class="image-home travel observe">
                <div class="image-content ani-middle-img"></div>
            </div>
            <div class="container-home observe">
                <div class="ani-middle-txt">
                    <h1 class="hh">EAGLE EYES</h1>
                    <p class="hp">
                        It takes a lot of patience, calm and perseverance to find 
                        the best specimens in its tiny landscapes.
                    </p>
                </div>
            </div>
        </div>
        <div class="content-home-dos observe">            
            <div class="container-home">
                <div class="ani-middle-txt">
                    <h1 class="hh">ORCHID HUNTING</h1>
                    <p class="hp">
                        On the hunt for these strange flowers, which sometimes 
                        look like something out of a horror story. Very delicate 
                        and difficult to find plants. 
                    </p>
                </div>
            </div>
            <div class="image-home author">
                <div class="image-content ani-middle-img"></div>
            </div>            
        </div>
        <div class="content-home-uno observe">
            <div class="image-home nature">
                <div class="image-content ani-middle-img"></div>
            </div>            
            <div class="container-home">
                <div class="ani-middle-txt">
                    <h1 class="hh">WORLD INHABITANT</h1>
                    <p class="hp">
                        The best thing about travel is that, even if you want to 
                        control everything, it's not possible. Sometimes you have 
                        real gifts for your lens.
                    </p>
                </div>
            </div>
        </div>
        <div class="content-home-dos observe">             
            <div class="container-home">
                <div class="ani-middle-txt">
                    <h1 class="hh">INFINITE IMAGINATION</h1>
                    <p class="hp">
                        Seeing what no one else sees. Look for different ways of 
                        seeing things. Change the focus of what is established. 
                        These are factors that give you excellence. 
                    </p>
                </div>
            </div>
            <div class="image-home abstract">
                <div class="image-content ani-middle-img"></div>
            </div>
        </div>
        <!--About-->
        <div class="about-home">
            <div class="about-home-image about-image">
                <div class="about-home-text">
                    <h1>KNOW ME</h1>
                    <p>Among my passions are nature and travel...</p>
                    <a href="/pages/users/about.jsp" class="about-home-btn">LEARN MORE</a>
                </div>
            </div>
        </div>
        <!--Instagram-->
        <h3 class="instagram-tittle">FOLLOW DAVIDVICARIOPHOTO</h3>
        <div class="contain-flip">
            <div class="observe">
                <div class="instagram-flip">
                    <div class="instagram-flip-inner">
                        <div class="instagram-flip-front image-a">
                            <h2>Iris de Madrid</h2>
                        </div>
                        <div class="instagram-flip-back">
                            <a href="https://www.instagram.com/p/Cornz99tHU_/" target="_blank">
                                ~Efímera. Se que ya no estas pero, tu recuerdo 
                                quedó grabado en el sensor de mi cámara.~</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="observe">
                <div class="instagram-flip">
                    <div class="instagram-flip-inner">
                        <div class="instagram-flip-front image-b">
                            <h2>Atardecer en un lugar de Madrid</h2>
                        </div>
                        <div class="instagram-flip-back">
                            <a href="https://www.instagram.com/p/CoZLGx_NRpb/" target="_blank">
                                ~Así terminó. Entre el mar de nubes y reflejos.~</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="observe">
                <div class="instagram-flip">
                    <div class="instagram-flip-inner">
                        <div class="instagram-flip-front image-c">
                            <h2>Corteza de cerezo - Calavera</h2>
                        </div>
                        <div class="instagram-flip-back">
                            <a href="https://www.instagram.com/p/Caf7r2PNC1g/" target="_blank">
                                ~Buscar donde nadie busca. Ver lo que nadie 
                                ve. Encontrar lo tetrico en lo bello.~</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="observe">
                <div class="instagram-flip">
                    <div class="instagram-flip-inner">
                        <div class="instagram-flip-front image-d">
                            <h2>Mariquita de viaje en Málaga</h2>
                        </div>
                        <div class="instagram-flip-back">
                            <a href="https://www.instagram.com/p/CfdnP-CNikI/" target="_blank">
                                ~Buscando de halle en un mar de espinas.~</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="observe">
                <div class="instagram-flip">
                    <div class="instagram-flip-inner">
                        <div class="instagram-flip-front image-e">
                            <h2>Boda sintoísta en Japón</h2>
                        </div>
                        <div class="instagram-flip-back">
                            <a href="https://www.instagram.com/p/CfoGTfUt7xJ/" target="_blank">
                                ~Mimo, perfección y cuidado al detalle. 
                                Preciosa novia luciéndose.~</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="observe">
                <div class="instagram-flip">
                    <div class="instagram-flip-inner">
                        <div class="instagram-flip-front image-f">
                            <h2>Lavanda de Brihuega</h2>
                        </div>
                        <div class="instagram-flip-back">
                            <a href="https://www.instagram.com/p/CjaWC8mtsPe/" target="_blank">
                                ~Lugares mágicos que nunca se olvidan.~</a>
                        </div>
                    </div>
                </div>
            </div>            
        </div>
        <a href="https://www.instagram.com/davidvicariophoto/" target="_blank" class="btn-insta"><i class="bi bi-instagram"></i> Instagram</a>
        <!--ThankYou-->
        <h3 class="instagram-tittle">ACKNOWLEDGMENT</h3>
        <div class="thankyou">
            <p>
                A mis padres, que siempre han estado ahí con paciencia y amor incondicionales, gracias. 
                A mis amigos, que se han convertido en mi roca y mi refugio en los momentos más duros, 
                gracias. Y a todas las personas que, de una forma u otra, han aportado a mi vida durante 
                este último año, os agradezco de corazón.
                <br><br>
                Ha sido un tiempo de desafíos y dificultades, pero también de aprendizajes y triunfos. 
                Gracias a vosotros, y a un trabajo personal de introspección y superación, he logrado salir 
                de la oscuridad que parecía perezne. Ahora, puedo mirarme al espejo y ver a una persona 
                renovada, más fuerte, con las ideas más claras. Hoy sé quién soy, qué quiero, cómo lo quiero 
                y tengo la certeza de que nada me detendrá. Si algo lo intenta, será simplemente una oportunidad 
                más para aprender y crecer.
                <br><br>
                Quiero invitarte a que sigas conmigo en este viaje, a que me conozcas en esta nueva etapa. 
                Tengo muchos proyectos que quiero seguir explorando y compartiendo con vosotros, como la 
                fotografía, los viajes y la escalada, que tanto me apasiona. Porque vosotros formáis parte 
                de este renacimiento, y sin vosotros, simplemente no sería lo mismo.
                <br><br>
                Así que, gracias. Gracias por estar, por apoyar, por creer. Brindo por todos nosotros, por lo 
                que hemos superado y por todo lo que está por venir.
            </p>
        </div>
        <jsp:include page="/includes/forms/login.jsp"/>
        <jsp:include page="/includes/forms/forgot.jsp"/>
        <jsp:include page="/includes/forms/signup.jsp"/>    
        <!-- REVISAR -->
        <c:if test="${not empty errorMessage}">
            <c:if test="${sessionScope.errorActive}">
                <section class="s-error" id="s-error">
                    <form class="c-error ani-form">
                        <div class="image-form">
                            <span onclick="closeError()" class="close-x">&times;</span>
                        </div>
                        <div class="">${errorMessage}</div>
                    </form>
                </section>
                <c:remove var="errorActive" scope="session" />
            </c:if>
        </c:if>    
    </main>
    <jsp:include page="/includes/components/footer.jsp"/>
    <script src="/assets/js/header.js"></script>
    <script src="/assets/js/home.js"></script>
    <script src="/assets/js/forms.js"></script>
    <script src="/assets/js/top.js"></script>
</body>
</html>