package com.project.davidphotostock.data;

import com.project.davidphotostock.domain.Shipment;
import java.util.Date;
import java.util.List;

public interface IShipmentDao {

    //CRUD de operaciones.
    void create(Shipment s);

    void update(Shipment s);

    void delete(Shipment s);

    List<Shipment> obtainAll();

    Shipment obtainById(Integer id);

    List<Shipment> obtainByFinished(Boolean finish);

    List<Shipment> obtainByAddress(String address);

    List<Shipment> obtainByDate(Date date);

    List<Shipment> obtainByDateRange(Date startDate, Date endDate);

}
