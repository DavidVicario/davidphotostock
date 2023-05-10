package com.project.davidphotostock.service;

import com.project.davidphotostock.domain.Shipment;
import java.util.Date;
import java.util.List;

public interface ShipmentService {
        
    void createShipment(Shipment s);

    void updateShipment(Shipment s);

    void deleteShipment(Shipment s);

    List<Shipment> obtainAllShipments();    
    
    Shipment obtainShipmentById(Integer id);
    
    List<Shipment> obtainShipmentsByFinished();
    
    List<Shipment> obtainShipmentsByUnfinished();
    
    List<Shipment> obtainShipmentsByAddress(String address);
    
    List<Shipment> obtainShipmentsByDate(Date date);
    
    List<Shipment> obtainShipmentsByDateRange(Date startDate, Date endDate);
    
}
