package com.project.davidphotostock.service.impl;

//Imports
import com.project.davidphotostock.data.IShipmentDao;
import com.project.davidphotostock.domain.Shipment;
import com.project.davidphotostock.service.ShipmentService;
import java.util.Date;
import java.util.List;

//Implementamos en la clase su Service correspondiente donde estan los metodos a usar.
public class ShipmentServiceImpl implements ShipmentService {

    //Declaramos el interfaz Dao para poder usar la implementacion de sus metodos.
    private IShipmentDao isd;

    //Definimos el constructor de la implementacion y tomamos el objeto dao como parametro. 
    public ShipmentServiceImpl(IShipmentDao isd) {
        this.isd = isd;
    }

    //Metodo para crear un nuevo registro en la base de datos. Al no tener campo unico, creamos sin hacer filtro.
    @Override
    public void createShipment(Shipment s) {
        isd.create(s);
    }

    //Metodo para actualizar un registro en la base de datos si este existe.
    @Override
    public void updateShipment(Shipment s) {
        //Llamamos al metodo del Dao para realizar la busqueda de id.
        Shipment shipmentI = isd.obtainById(s.getIdShipment());
        if (shipmentI != null) {
            //Si vuelve un valor de ID, actualizamos.
            isd.update(s);
        } else {
            //Si devuelve null es que el registro no existe.
            System.out.println("El ID del envio no existe.");
        }
    }

    //Metodo para borrar un registro si este existe. 
    @Override
    public void deleteShipment(Shipment s) {
        Shipment shipmentI = isd.obtainById(s.getIdShipment());
        if (shipmentI != null) {
            //Si el Id existe se elimina el registro. 
            isd.delete(s);
        } else {
            System.out.println("El ID del envio no existe.");
        }
    }

    //Metodo para obtener todos los registros.
    @Override
    public List<Shipment> obtainAllShipments() {
        //Simplemente llamamos al Dao.
        return isd.obtainAll();
    }

    //Metodo para obtener un registro por id.
    @Override
    public Shipment obtainShipmentById(Integer id) {
        return isd.obtainById(id);
    }

    //Metodo para obtener los registros con el envio finalizado.
    @Override
    public List<Shipment> obtainShipmentsByFinished() {
        return isd.obtainByFinished(true);
    }

    //Metodo para obtener los registros con el envio en proceso.
    @Override
    public List<Shipment> obtainShipmentsByUnfinished() {
        return isd.obtainByFinished(false);
    }

    //Metodo para obtener los registros de envios por direccion.
    @Override
    public List<Shipment> obtainShipmentsByAddress(String address) {
        return isd.obtainByAddress(address);
    }

    //Metodo para obtener los registros de envios por fecha.
    @Override
    public List<Shipment> obtainShipmentsByDate(Date date) {
        return isd.obtainByDate(date);
    }

    //Metodo para obtener los registros de envios entre dos fechas.
    @Override
    public List<Shipment> obtainShipmentsByDateRange(Date startDate, Date endDate) {
        return isd.obtainByDateRange(startDate, endDate);
    }

}
