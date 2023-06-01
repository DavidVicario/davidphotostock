<section class="section-login" id="section-login">
    <form class="content-login ani-form" action="/UsersServlet?action=login" method="post">
        <div class="image-form">
            <span onclick="closeForm('login')" class="close-x">&times;</span>
            <img src="/assets/img/color-2k.png" alt="Logo" class="logo-form">
        </div>
        <div class="container-login">
            <label for="user"><b>Username</b></label>
            <input id="user-l" type="text" placeholder="Enter Username" name="user" required>
            <label for="pass"><b>Password</b></label>
            <input id="pass-l" type="password" placeholder="Enter Password" name="pass" required>
            <input id="remember" type="checkbox" checked="checked" name="remember">
            <label class="me" for="remember"> Remember Me</label>
            <span class="forgot">Forgot <a href="#">password?</a></span>
            <button class="btn-login" type="submit">Login</button>
            <span class="no-user">Not a member? &nbsp;<a href="#" onclick="closeForm('login'); openForm('signup')">Sign Up</a></span>
        </div>
    </form>
</section>