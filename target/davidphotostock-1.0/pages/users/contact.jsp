<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact</title>
    <link rel="shortcut icon" href="/assets/img/DV-logo-favicon2.svg" type="image/svg+xml">
    <link rel="shortcut icon" href="/assets/img/negro-2k.png" type="image/png">
    <link rel="stylesheet" href="/assets/icons/bootstrap-icons.css">
    <link rel="stylesheet" href="/assets/css/general.css">
    <link rel="stylesheet" href="/assets/css/contact_style.css">
    <link rel="stylesheet" href="/assets/css/header.css">
    <link rel="stylesheet" href="/assets/css/subheader.css">
    <link rel="stylesheet" href="/assets/css/footer.css">
</head>
<body>
    <jsp:include page="/includes/components/header.jsp"/>
    <jsp:include page="/includes/components/subheader.jsp">
        <jsp:param name="title" value="CONTACT" />
        <jsp:param name="description1" value="I'd love to hear from you" />
        <jsp:param name="image" value="/assets/img/social(3).jpg" />
    </jsp:include>
    <main>
        <div class="title-main">
            <h3 class="hm">Contact me</h3>
            <p class="pm">
            You’re invited to reach out to me with any questions or <br>
            queries you may have. I’ll endeavour to get back to you <br>
            as quickly as possible. So, please bear with us.<br><br>           
            Mail: davidphotostock8@gmail.com<br>
            Phone: 617597842</p>
            <ul>
                <li><a href="https://www.facebook.com/Daisuke8free" target="_blank" class="bi bi-facebook"></a></li>
                <li><a href="https://www.instagram.com/davidvicariophoto/" target="_blank" class="bi bi-instagram"></a></li>
            </ul>
        </div>
        <div class="contain-contact">
            <form class="container-contact" action="/UsersServlet?action=contact" method="post">
                <label for="name"><b>Name *</b></label>
                <input id="name" type="text" placeholder="Enter name" name="name" required>                    
                <label for="mail"><b>Mail *</b></label>
                <input id="mail" type="text" placeholder="Enter mail" name="mail" required>
                <label for="phone"><b>Phone *</b></label>
                <input id="phone" type="text" placeholder="Enter phone" name="phone" required>            
                <label for="subject">Subject *</label>
                <textarea id="subject" type="text" placeholder="Your message.." name="subject" style="height:200px" required></textarea>
                <button class="btn-send" onclick="openForm('message')" type="submit">SEND</button>
            </form>
        </div>
        <jsp:include page="/includes/forms/login.jsp"/>
        <jsp:include page="/includes/forms/signup.jsp"/>
    </main>
    <% if (request.getAttribute("message") != null) { %>
        <section class="section-message">
            <form class="contain-message ani-mess">
                <p><%= request.getAttribute("message") %></p>
                <button class="btn-accept" onclick="closeForm('message')" type="submit">Accept</button>
            </form>
        </section>
    <% } %>
    <jsp:include page="/includes/components/footer.jsp"/>
    <script src="/assets/js/header.js"></script>
    <script src="/assets/js/forms.js"></script>
</body>
</html>