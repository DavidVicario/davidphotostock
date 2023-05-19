<section class="section-signup" id="section-signup">
    <form class="content-signup ani-form" action="UsersServlet?action=create" method="post">
        <div class="image-form">
            <span onclick="closeSignUp()" class="close-x">&times;</span>
            <img src="/assets/img/color-2k.png" alt="Logo" class="logo-form">
        </div>
        <div class="container-signup">
            <label for="name"><b>Name *</b></label>
            <input id="name" type="text" placeholder="Enter Name" name="name" required>                    
            <div class="surnames">
                <div>
                    <label for="fsurname"><b>First Surname *</b></label>
                    <input id="fsurname" type="text" placeholder="Enter First Surname" name="fsurname" required>
                </div>
                <div>
                    <label for="ssurname"><b>Second Surname</b></label>
                    <input id="ssurname" type="text" placeholder="Enter Second Surname" name="ssurname">
                </div>
            </div>
            <label for="mail"><b>Mail *</b></label>
            <input id="mail" type="text" placeholder="Enter Mail" name="mail" required>
            <label for="user"><b>Username *</b></label>
            <input id="user" type="text" placeholder="Enter Username" name="user" required>            
            <div class="passwords">
                <div>
                    <label for="pass"><b>Password *</b></label>
                    <input id="pass" type="password" placeholder="Enter Password" name="pass" required>
                </div>
                <div>
                    <label for="cpass"><b>Confirm Password *</b></label>
                    <input id="cpass" type="password" placeholder="Enter Confirm Password" name="cpass" required>
                </div>
            </div>
            <button class="btn-signup" type="submit">Sign Up</button>
            <span class="u-user">Already a member? &nbsp;<a href="#" onclick="login()">Login</a></span>
        </div>
    </form>
</section>