<section class="section-forgot" id="section-forgot">
    <form class="content-forgot ani-form" action="/UsersServlet?action=forgotPass" method="post">
        <div class="image-form">
            <span onclick="closeForm('forgot')" class="close-x">&times;</span>
            <img src="/assets/img/img/color-2k.png" alt="Logo" class="logo-form">
        </div>
        <div class="container-forgot">
            <label for="user"><b>Username</b></label>
            <input id="user-forgot" type="text" placeholder="Enter Username" name="user" required>
            <input class="btn-forgot" type="submit" value="Verify username" name="verify">
            <input type="hidden" id="username-verified" name="username-verified" value="<%=session.getAttribute("username-verified") != null ? session.getAttribute("username-verified") : "false" %>">            
            <div class="pass-forgot" style="display: none;">
                <span class="pass-code">Debe contener al menos un dígito, una letra minúscula, una letra mayúscula y seis caracteres mínimos de longitud.</span>
                <div>
                    <label for="pass"><b>Password *</b></label>
                    <input id="pass" type="password" placeholder="Enter Password" name="pass" required>
                </div>
                <div>
                    <label for="cpass"><b>Confirm Password *</b></label>
                    <input id="cpass" type="password" placeholder="Enter Confirm Password" name="cpass" required>
                </div>
                <button class="btn-forgot" type="submit">Confirm</button>
            </div>
        </div>
    </form>
</section>