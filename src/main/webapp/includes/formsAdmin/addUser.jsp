<section class="section-add" id="add-user">
    <form class="content-add ani-add" action="/UsersAdminServlet?action=addUser" method="post">
        <div class="image-form">
            <span onclick="closeForm('user')" class="close-x">&times;</span>
        </div>
        <div class="container-add">
            <label for="name"><b>Name *</b></label>
            <input id="name" type="text" placeholder="Enter Name" name="name" required>                    
            <div class="add-two">
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
            <div class="add-two">
                <div>
                    <label for="pass"><b>Password *</b></label>
                    <input id="pass" type="password" placeholder="Enter Password" name="pass" required>
                </div>
                <div>
                    <label for="cpass"><b>Confirm Password *</b></label>
                    <input id="cpass" type="password" placeholder="Enter Confirm Password" name="cpass" required>
                </div>
            </div>
            <button class="btn-add" type="submit">ADD</button>            
        </div>
    </form>
</section>