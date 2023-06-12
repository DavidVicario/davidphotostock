<section class="section-add" id="add-shipment">
    <form class="content-add ani-add" action="/UsersAdminServlet?action=addUser" method="post">
        <div class="image-form">
            <span onclick="closeForm('shipment')" class="close-x">&times;</span>
        </div>
        <div class="container-add">
            <div class="add-three">
                <div>
                    <label for="ccaa"><b>Ccaa *</b></label>
                    <input id="ccaa" type="text" placeholder="Enter Ccaa" name="ccaa" required>
                </div>
                <div>
                    <label for="province"><b>Province *</b></label>
                    <input id="province" type="text" placeholder="Enter Province" name="province">
                </div>
                <div>
                    <label for="municipality"><b>Municipality *</b></label>
                    <input id="municipality" type="text" placeholder="Enter Municipality" name="municipality" required>
                </div>
            </div>
            <div class="add-two">
                <div>
                    <label for="shipment-date"><b>Shipment Date *</b></label>
                    <input id="shipment-date" type="datetime-local" placeholder="Enter Date" name="shipment-date" required>
                </div>
                <div class="finish">
                    <label for="finished"><b>Finished *</b></label>
                    <input id="finished" type="checkbox" name="finished" required>
                </div>
            </div>
            <div class="add-two">
                <div>
                    <label for="id-user"><b>Id User *</b></label>
                    <input id="id-user" type="number" placeholder="Enter Id User" name="id-user" required>
                </div>                                
                <div>
                    <label for="id-municipality"><b>Id Municipality *</b></label>
                    <input id="id-municipality" type="number" placeholder="Enter Id Municipality" name="id-municipality" required>
                </div>
            </div>
            <button class="btn-add" type="submit">ADD</button>            
        </div>
    </form>
</section>