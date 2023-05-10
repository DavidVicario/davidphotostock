package com.project.davidphotostock.data.impl;

//Imports
import com.project.davidphotostock.data.IShipmentDao;
import com.project.davidphotostock.domain.Shipment;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

//Incidamos que se implementa los metodos del interfaz del Dao correspondiente.
public class IShipmentDaoImpl implements IShipmentDao {

    /*
    Declaramos la variable em en un tipo EntityManager, que es una API del persistance,
    Esto ayudara a manejar las operaciones que involucran a las entidades y al almacenamiento
    en la base de datos. 
    Lo que implica que podemos hacer las consultas de MySQL "por debajo" con objetos de Java.
     */
    private EntityManager em;

    /*
    Definimos un constructor y llamamos de parametro a nuestro EntityManager em
    de esta manera podemos usarlo para realizar operaciones.
     */
    public IShipmentDaoImpl(EntityManager em) {
        this.em = em;
    }

    //Definimos el metodo para crear una nueva entidad en la base de datos.
    @Override
    public void create(Shipment s) {
        //Utilizamos em para empezar la transaccion de los datos.
        /*
        El getTransaction es para hacer el conjunto de las operaciones que debe realizar 
        juntas para mantener la integridad de los datos. En caso de ocurrir un problema
        lanzaria una excepcion y revirtiria todos los cambios.
         */
        em.getTransaction().begin();
        //Cogemos p y lo guardamos en la base de datos.
        em.persist(s);
        //Con el commit confirmamos los cambios. Si ocurre algún problema el Transaction haria un rollback
        em.getTransaction().commit();
    }

    //Definimos el metodo para editar una nueva entidad en la base de datos.
    @Override
    public void update(Shipment s) {
        em.getTransaction().begin();
        //Actualizamos la entidad existente en la base de datos a otra.
        em.merge(s);
        em.getTransaction().commit();
    }

    //Definimos el metodo para eliminar una nueva entidad en la base de datos.
    @Override
    public void delete(Shipment s) {
        em.getTransaction().begin();
        //Eliminamos la entidad existente en la base de datos.
        em.remove(s);
        em.getTransaction().commit();
    }

    //Listamos todos los registros que esten guardados en la tabla de la base de datos.
    @Override
    public List<Shipment> obtainAll() {
        /*
        Realizamos la consulta con el metodo createQuery, que se utiliza para realizar
        consultas en JPQL. Que es igual al SQL pero este trabaja con objetos y clases.
        Escribimos la consulta en JPQL e indicamos la clase que queremos que devuelva.
        Terminamos con getResultList, que ejecuta la consulta.
         */
        return em.createQuery("SELECT s FROM Shipment s", Shipment.class).getResultList();
    }

    //Recumeramos un registro en especifico a traves del id.
    @Override
    public Shipment obtainById(Integer id) {
        //Find se encarga de buscar en la base de datos y devolver el registro indicado o null si no lo encuentra
        return em.find(Shipment.class, id);
    }

    //Listamos todos los registros que esten guardados en la tabla de la base de datos por si han finalizado o no.
    @Override
    public List<Shipment> obtainByFinished(Boolean finish) {
        /*
        Almacenamos la consulta gracias al TypedQuery en query y a de buscarlo en el parametro :finish
        que ha sido declarado asi para que no se vea la consulta que se hace y lo gestione "por debajo"
        asi añadimos seguridad a la busqueda. 
         */
        TypedQuery<Shipment> query = em.createQuery(
                "SELECT s FROM Shipment s WHERE s.finished = :finish", Shipment.class);
        //Aqui ya le damos un valor al finish, con setParameter. y confirmamos la operacion con el getResultList
        query.setParameter("finish", finish);
        //Devolvemos la lista de los que tengan el parametro indicado. (True o False)
        return query.getResultList();
    }

    //Listamos todos los registros que esten guardados en la tabla de la base de datos por direccion.
    @Override
    public List<Shipment> obtainByAddress(String address) {
        TypedQuery<Shipment> query = em.createQuery(
                "SELECT s FROM Shipment s WHERE s.address = :address", Shipment.class);
        query.setParameter("address", address);
        return query.getResultList();
    }

    //Listamos todos los registros que esten guardados en la tabla de la base de datos por Fecha.
    @Override
    public List<Shipment> obtainByDate(Date date) {
        TypedQuery<Shipment> query = em.createQuery(
                "SELECT s FROM Shipment s WHERE s.shipmentDate = :date", Shipment.class);
        query.setParameter("date", date);
        return query.getResultList();
    }

    //Listamos todos los registros que esten guardados en la tabla de la base de datos por rango de fechas.
    @Override
    public List<Shipment> obtainByDateRange(Date startDate, Date endDate) {
        TypedQuery<Shipment> query = em.createQuery(
                "SELECT s FROM Shipment s WHERE s.shipmentDate BETWEEN :startDate AND :endDate", Shipment.class);
        query.setParameter("startDate", startDate).setParameter("endDate", endDate);
        return query.getResultList();
    }

}
