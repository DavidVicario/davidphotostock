package com.project.davidphotostock.data.impl;

//Imports
import com.project.davidphotostock.data.ICategoryDao;
import com.project.davidphotostock.domain.Category;
import jakarta.ejb.Stateless;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

//Incidamos que se implementa los metodos del interfaz del Dao correspondiente.
public class ICategoryDaoImpl implements ICategoryDao {

    /*
    Declaramos la variable em en un tipo EntityManager, que es una API del persistance,
    Esto ayudara a manejar las operaciones que involucran a las entidades y al almacenamiento
    en la base de datos. 
    Lo que implica que podemos hacer las consultas de MySQL "por debajo" con objetos de Java.
     */    
    private EntityManager em;

    public ICategoryDaoImpl(EntityManager em) {
        this.em = em;
    }
    
    //Definimos el metodo para crear una nueva entidad en la base de datos.
    @Override
    public void create(Category c) {
        //Utilizamos em para empezar la transaccion de los datos.
        /*
        El getTransaction es para hacer el conjunto de las operaciones que debe realizar 
        juntas para mantener la integridad de los datos. En caso de ocurrir un problema
        lanzaria una excepcion y revirtiria todos los cambios.
         */
        em.getTransaction().begin();
        //Cogemos c y lo guardamos en la base de datos.
        em.persist(c);
        //Con el commit confirmamos los cambios. Si ocurre algún problema el Transaction haria un rollback
        em.getTransaction().commit();
    }

    //Definimos el metodo para editar una nueva entidad en la base de datos.
    @Override
    public void update(Category c) {
        em.getTransaction().begin();
        //Actualizamos la entidad existente en la base de datos a otra.
        em.merge(c);
        em.getTransaction().commit();
    }

    //Definimos el metodo para eliminar una nueva entidad en la base de datos.
    @Override
    public void delete(Category c) {
        em.getTransaction().begin();
        //Eliminamos la entidad existente en la base de datos.
        em.remove(c);
        em.getTransaction().commit();
    }

    //Listamos todos los registros que esten guardados en la tabla de la base de datos.
    @Override
    public List<Category> obtainAll() {
        /*
        Realizamos la consulta con el metodo createQuery, que se utiliza para realizar
        consultas en JPQL. Que es igual al SQL pero este trabaja con objetos y clases.
        Escribimos la consulta en JPQL e indicamos la clase que queremos que devuelva.
        Terminamos con getResultList, que ejecuta la consulta.
         */
        return em.createQuery("SELECT c FROM Category c ORDER BY c.idCategory ASC", Category.class).getResultList();
    }

    //Recumeramos un registro en especifico a traves del id.
    @Override
    public Category obtainById(Integer id) {
        //Find se encarga de buscar en la base de datos y devolver el registro indicado o null si no lo encuentra
        return em.find(Category.class, id);
    }

    //Recumeramos un registro en especifico a traves del name.
    @Override
    public Category obtainByName(String name) {
        /*
        Almacenamos la consulta gracias al TypedQuery en query y a de buscarlo en el parametro :name
        que ha sido declarado asi para que no se vea la consulta que se hace y lo gestione "por debajo"
        asi añadimos seguridad a la busqueda. 
         */
        TypedQuery<Category> query = em.createQuery(
                "SELECT c FROM Category c WHERE c.categoryName like :name", Category.class);
        //Aqui ya le damos un valor al name, con setParameter. y confirmamos la operacion con el getResultList
        List<Category> categories = query.setParameter("name", name).getResultList();
        //Verificamos si a encontrado un registro o no, siendo null en este ultimo caso.       
        if (categories.isEmpty()) {
            return null;
        } else {
            //Si lo encuentra devuelve el primer registro (Posicion 0) de la lista.
            return categories.get(0);
        }
    }

}
