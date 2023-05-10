package com.project.davidphotostock.service.impl;

//Imports
import com.project.davidphotostock.data.IShipmentProductDao;
import com.project.davidphotostock.domain.ShipmentProduct;
import com.project.davidphotostock.domain.ShipmentProductPK;
import com.project.davidphotostock.service.ShipmentProductService;
import java.util.Collections;
import java.util.List;

//Implementamos en la clase su Service correspondiente donde estan los metodos a usar.
public class ShipmentProductServiceImpl implements ShipmentProductService {

    //Declaramos el interfaz Dao para poder usar la implementacion de sus metodos.
    private IShipmentProductDao ispd;

    //Definimos el constructor de la implementacion y tomamos el objeto dao como parametro. 
    public ShipmentProductServiceImpl(IShipmentProductDao ispd) {
        this.ispd = ispd;
    }

    //Metodo para crear un nuevo registro en la base de datos. Al no tener campo unico, creamos sin hacer filtro.
    @Override
    public void createShipmentProduct(ShipmentProduct sp) {
        ispd.create(sp);
    }

    //Metodo para actualizar un registro en la base de datos si este existe.
    @Override
    public void updateShipmentProduct(ShipmentProduct sp) {
        //Llamamos al metodo del Dao para realizar la busqueda de id, al ser compuesta tenemos que llamar al ShipmentProductPK.
        ShipmentProduct shipmentProductI = ispd.obtainById(sp.getShipmentProductPK());
        if (shipmentProductI != null) {
            //Si vuelve un valor de ID, actualizamos.
            ispd.update(sp);
        } else {
            //Si devuelve null es que el registro no existe.
            System.out.println("El ID del envio de producto no existe.");
        }
    }

    //Metodo para borrar un registro si este existe. 
    @Override
    public void deleteShipmentProduct(ShipmentProduct sp) {
        ShipmentProduct shipmentProductI = ispd.obtainById(sp.getShipmentProductPK());
        if (shipmentProductI != null) {
            //Si el Id existe se elimina el registro. 
            ispd.delete(sp);
        } else {
            System.out.println("El ID del envio de producto no existe.");
        }
    }

    //Metodo para obtener todos los registros.
    @Override
    public List<ShipmentProduct> obtainAllShipmentProducts() {
        //Simplemente llamamos al Dao.
        return ispd.obtainAll();
    }

    //Metodo para obtener un registro por id, hay que recordar llamar a ShipmentProductPK.
    @Override
    public ShipmentProduct obtainShipmentProductById(ShipmentProductPK id) {
        return ispd.obtainById(id);
    }

    //Metodo para obtener todos los registros de cantidades de producto en un envio.
    @Override
    public List<ShipmentProduct> obtainAmountsByProduct(Integer idProduct) {
        //Llamamos al metodo del Dao para realizar la busqueda por idProduct.
        List<ShipmentProduct> shipmentProducts = ispd.obtainAmountByProduct(idProduct);
        //Si no es null devolvera la lista.
        if (shipmentProducts != null) {
            return shipmentProducts;
        } else {
            //Si devuelve un null, sale un texto de que no existe la categoria y devolvemos una lista vacia.
            System.out.println("El producto indicada no existe.");
            return Collections.emptyList();
        }
    }

    //Metodo para obtener todos los registros de los productos que hay en los envios.
    @Override
    public List<ShipmentProduct> obtainProductsByShipment(Integer idProduct, Integer idShipment) {
        return ispd.obtainProductByShipment(idProduct, idShipment);
    }

}
