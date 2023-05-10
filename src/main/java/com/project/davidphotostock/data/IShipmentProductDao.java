package com.project.davidphotostock.data;

import com.project.davidphotostock.domain.ShipmentProduct;
import com.project.davidphotostock.domain.ShipmentProductPK;
import java.util.List;

public interface IShipmentProductDao {

    //CRUD de operaciones.
    void create(ShipmentProduct sp);

    void update(ShipmentProduct sp);

    void delete(ShipmentProduct sp);

    List<ShipmentProduct> obtainAll();

    //Aquí hay que especificar el ShipmentProductPK, ya que hace referencia a la clave primaria compuesta.
    ShipmentProduct obtainById(ShipmentProductPK id);

    List<ShipmentProduct> obtainAmountByProduct(Integer idProduct);

    List<ShipmentProduct> obtainProductByShipment(Integer idProduct, Integer idShipment);

}
