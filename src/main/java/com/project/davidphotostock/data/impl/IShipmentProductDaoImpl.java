package com.project.davidphotostock.data.impl;

//Imports
import com.project.davidphotostock.data.IShipmentProductDao;
import com.project.davidphotostock.domain.ShipmentProduct;
import com.project.davidphotostock.domain.ShipmentProductPK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

//Incidamos que se implementa los metodos del interfaz del Dao correspondiente.
public class IShipmentProductDaoImpl implements IShipmentProductDao {

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
    public IShipmentProductDaoImpl(EntityManager em) {
        this.em = em;
    }

    //Definimos el metodo para crear una nueva entidad en la base de datos.
    @Override
    public void create(ShipmentProduct sp) {
        //Utilizamos em para empezar la transaccion de los datos.
        /*
        El getTransaction es para hacer el conjunto de las operaciones que debe realizar 
        juntas para mantener la integridad de los datos. En caso de ocurrir un problema
        lanzaria una excepcion y revirtiria todos los cambios.
         */
        em.getTransaction().begin();
        //Cogemos p y lo guardamos en la base de datos.
        em.persist(sp);
        //Con el commit confirmamos los cambios. Si ocurre algún problema el Transaction haria un rollback
        em.getTransaction().commit();
    }

    //Definimos el metodo para editar una nueva entidad en la base de datos.
    @Override
    public void update(ShipmentProduct sp) {
        em.getTransaction().begin();
        //Actualizamos la entidad existente en la base de datos a otra.
        em.merge(sp);
        em.getTransaction().commit();
    }

    //Definimos el metodo para eliminar una nueva entidad en la base de datos.
    @Override
    public void delete(ShipmentProduct sp) {
        em.getTransaction().begin();
        //Eliminamos la entidad existente en la base de datos.
        em.remove(sp);
        em.getTransaction().commit();
    }

    //Listamos todos los registros que esten guardados en la tabla de la base de datos.
    @Override
    public List<ShipmentProduct> obtainAll() {
        /*
        Realizamos la consulta con el metodo createQuery, que se utiliza para realizar
        consultas en JPQL. Que es igual al SQL pero este trabaja con objetos y clases.
        Escribimos la consulta en JPQL e indicamos la clase que queremos que devuelva.
        Terminamos con getResultList, que ejecuta la consulta.
         */
        return em.createQuery("SELECT sp FROM ShipmentProduct sp", ShipmentProduct.class).getResultList();
    }

    //Recumeramos un registro en especifico a traves del id.
    @Override
    public ShipmentProduct obtainById(ShipmentProductPK id) {
        /*
        Find se encarga de buscar en la base de datos y devolver el registro indicado o null si no lo encuentra.
        En este caso hay que especificar el ShipmentProductPK, ya que es una clave primaria compuesta.
         */
        return em.find(ShipmentProduct.class, id);
    }

    //Recumeramos los registros en especifico de cantidad por producto indicado.
    @Override
    public List<ShipmentProduct> obtainAmountByProduct(Integer idProduct) {
        /*
        Almacenamos la consulta gracias al TypedQuery en query y a de buscarlo en el parametro :idProduct
        que ha sido declarado asi para que no se vea la consulta que se hace y lo gestione "por debajo"
        asi añadimos seguridad a la busqueda. 
         */
        TypedQuery<ShipmentProduct> query = em.createQuery(
                //Filtramos para que solo los ShipmentProduct, cuyo idProduct tenga un idProduct
                "SELECT sp FROM ShipmentProduct sp WHERE sp.idProduct.idProduct = :idProduct", ShipmentProduct.class);
        //Aqui ya le damos un valor al :idProduct, con setParameter. y confirmamos la operacion con el getResultList
        List<ShipmentProduct> shipmentProducts = query.setParameter("idProduct", idProduct).getResultList();
        //Verificamos si a encontrado un registro o no, siendo null en este ultimo caso.
        if (shipmentProducts.isEmpty()) {
            return null;
        } else {
            //Devuelve los registros que entren en el parametro.
            return shipmentProducts;
        }
    }

    //Recumeramos los registros en especifico de productos por el envio indicado.
    @Override
    public List<ShipmentProduct> obtainProductByShipment(Integer idProduct, Integer idShipment) {
        TypedQuery<ShipmentProduct> query = em.createQuery(
                "SELECT sp FROM ShipmentProduct sp WHERE sp.idProduct.idProduct = :idProduct AND sp.shipment.idShipment = :idShipment", ShipmentProduct.class);
        query.setParameter("idProduct", idProduct).setParameter("idShipment", idShipment);
        return query.getResultList();
    }

}
