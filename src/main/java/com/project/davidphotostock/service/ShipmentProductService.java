package com.project.davidphotostock.service;

import com.project.davidphotostock.domain.ShipmentProduct;
import com.project.davidphotostock.domain.ShipmentProductPK;
import java.util.List;

public interface ShipmentProductService {
        
    Boolean createShipmentProduct(ShipmentProduct sp);

    void updateShipmentProduct(ShipmentProduct sp);

    void deleteShipmentProduct(ShipmentProduct sp);

    List<ShipmentProduct> obtainAllShipmentProducts();    
    
    ShipmentProduct obtainShipmentProductById(ShipmentProductPK id);
    
    List<ShipmentProduct> obtainAmountsByProduct(Integer idProduct);
    
    List<ShipmentProduct> obtainProductsByShipment(Integer idProduct, Integer idShipment);
    
}
