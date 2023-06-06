<section class="section-add" id="add-shipmentproduct">
    <form class="content-add ani-add" action="/UsersAdminServlet?action=addShipmentProduct" method="post">
        <div class="image-form">
            <span onclick="closeForm('shipmentproduct')" class="close-x">&times;</span>
        </div>
        <div class="container-add">
            <div class="add-three">
                <div>
                    <label for="amount"><b>Amount *</b></label>
                    <input id="amount" type="number" placeholder="Enter Amount" name="amount" required>
                </div>
                <div>
                    <label for="id-shipment"><b>Id Shipment *</b></label>
                    <input id="id-shipment" type="number" placeholder="Enter Id Shipment" name="id-shipment" required>  
                </div>
                <div>
                    <label for="id-product"><b>Id Product *</b></label>
                    <input id="id-product" type="number" placeholder="Enter Id Product" name="id-product" required>  
                </div>
            </div>
            <button class="btn-add" type="submit">ADD</button>            
        </div>
    </form>
</section>