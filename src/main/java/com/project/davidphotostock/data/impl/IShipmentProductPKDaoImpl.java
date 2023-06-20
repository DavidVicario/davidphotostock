package com.project.davidphotostock.data.impl;

import com.project.davidphotostock.data.IShipmentProductPKDao;
import com.project.davidphotostock.domain.ShipmentProductPK;
import javax.persistence.EntityManager;

public class IShipmentProductPKDaoImpl implements IShipmentProductPKDao {

     private EntityManager em;
    public IShipmentProductPKDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(ShipmentProductPK sp) {
        em.getTransaction().begin();
        em.persist(sp);
        em.getTransaction().commit();
    }
    
}
