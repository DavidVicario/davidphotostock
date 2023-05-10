package com.project.davidphotostock.data.impl;

//Imports
import com.project.davidphotostock.data.ISubcategoryDao;
import com.project.davidphotostock.domain.Subcategory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

//Incidamos que se implementa los metodos del interfaz del Dao correspondiente.
public class ISubcategoryDaoImpl implements ISubcategoryDao {

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
    public ISubcategoryDaoImpl(EntityManager em) {
        this.em = em;
    }

    //Definimos el metodo para crear una nueva entidad en la base de datos.
    @Override
    public void create(Subcategory sc) {
        //Utilizamos em para empezar la transaccion de los datos.
        /*
        El getTransaction es para hacer el conjunto de las operaciones que debe realizar 
        juntas para mantener la integridad de los datos. En caso de ocurrir un problema
        lanzaria una excepcion y revirtiria todos los cambios.
         */
        em.getTransaction().begin();
        //Cogemos p y lo guardamos en la base de datos.
        em.persist(sc);
        //Con el commit confirmamos los cambios. Si ocurre algún problema el Transaction haria un rollback
        em.getTransaction().commit();
    }

    //Definimos el metodo para editar una nueva entidad en la base de datos.
    @Override
    public void update(Subcategory sc) {
        em.getTransaction().begin();
        //Actualizamos la entidad existente en la base de datos a otra.
        em.merge(sc);
        em.getTransaction().commit();
    }

    //Definimos el metodo para eliminar una nueva entidad en la base de datos.
    @Override
    public void delete(Subcategory sc) {
        em.getTransaction().begin();
        //Eliminamos la entidad existente en la base de datos.
        em.remove(sc);
        em.getTransaction().commit();
    }

    //Listamos todos los registros que esten guardados en la tabla de la base de datos.
    @Override
    public List<Subcategory> obtainAll() {
        /*
        Realizamos la consulta con el metodo createQuery, que se utiliza para realizar
        consultas en JPQL. Que es igual al SQL pero este trabaja con objetos y clases.
        Escribimos la consulta en JPQL e indicamos la clase que queremos que devuelva.
        Terminamos con getResultList, que ejecuta la consulta.
         */
        return em.createQuery("SELECT sc FROM Subcategory sc", Subcategory.class).getResultList();
    }

    //Recumeramos un registro en especifico a traves del id.
    @Override
    public Subcategory obtainById(Integer id) {
        //Find se encarga de buscar en la base de datos y devolver el registro indicado o null si no lo encuentra
        return em.find(Subcategory.class, id);
    }

    //Recumeramos un registro en especifico a traves del name.
    @Override
    public Subcategory obtainByName(String name) {
        /*
        Almacenamos la consulta gracias al TypedQuery en query y a de buscarlo en el parametro :name
        que ha sido declarado asi para que no se vea la consulta que se hace y lo gestione "por debajo"
        asi añadimos seguridad a la busqueda. 
         */
        TypedQuery<Subcategory> query = em.createQuery(
                "SELECT sc FROM Subcategory sc WHERE sc.subcategoryName like :name", Subcategory.class);
        //Aqui ya le damos un valor al name, con setParameter. y confirmamos la operacion con el getResultList
        List<Subcategory> subcategories = query.setParameter("name", name).getResultList();
        //Verificamos si a encontrado un registro o no, siendo null en este ultimo caso.
        if (subcategories.isEmpty()) {
            return null;
        } else {
            //Si lo encuentra devuelve el primer registro (Posicion 0) de la lista.
            return subcategories.get(0);
        }
    }

    //Recumeramos los registros en especifico de Subcategory que pertenezcan a una Categoryt.
    @Override
    public List<Subcategory> obtainSubByCate(Integer idCategory) {
        TypedQuery<Subcategory> query = em.createQuery(
                //Filtramos para que solo las Subcategory, cuyo idCategory tenga un idCategory
                "SELECT sc FROM Subcategory sc WHERE sc.idCategory.idCategory = :idCategory", Subcategory.class);
        List<Subcategory> subcategories = query.setParameter("idCategory", idCategory).getResultList();
        if (subcategories.isEmpty()) {
            return null;
        } else {
            return subcategories;
        }
    }

}
