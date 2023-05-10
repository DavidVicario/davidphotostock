package com.project.davidphotostock.data.impl;

//Imports
import com.project.davidphotostock.data.IProductDao;
import com.project.davidphotostock.domain.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

//Incidamos que se implementa los metodos del interfaz del Dao correspondiente.
public class IProductDaoImpl implements IProductDao {

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
    public IProductDaoImpl(EntityManager em) {
        this.em = em;
    }

    //Definimos el metodo para crear una nueva entidad en la base de datos.
    @Override
    public void create(Product p) {
        //Utilizamos em para empezar la transaccion de los datos.
        /*
        El getTransaction es para hacer el conjunto de las operaciones que debe realizar 
        juntas para mantener la integridad de los datos. En caso de ocurrir un problema
        lanzaria una excepcion y revirtiria todos los cambios.
         */
        em.getTransaction().begin();
        //Cogemos p y lo guardamos en la base de datos.
        em.persist(p);
        //Con el commit confirmamos los cambios. Si ocurre algún problema el Transaction haria un rollback
        em.getTransaction().commit();
    }

    //Definimos el metodo para editar una nueva entidad en la base de datos.
    @Override
    public void update(Product p) {
        em.getTransaction().begin();
        //Actualizamos la entidad existente en la base de datos a otra.
        em.merge(p);
        em.getTransaction().commit();
    }

    //Definimos el metodo para eliminar una nueva entidad en la base de datos.
    @Override
    public void delete(Product p) {
        em.getTransaction().begin();
        //Eliminamos la entidad existente en la base de datos.
        em.remove(p);
        em.getTransaction().commit();
    }

    //Listamos todos los registros que esten guardados en la tabla de la base de datos.
    @Override
    public List<Product> obtainAll() {
        /*
        Realizamos la consulta con el metodo createQuery, que se utiliza para realizar
        consultas en JPQL. Que es igual al SQL pero este trabaja con objetos y clases.
        Escribimos la consulta en JPQL e indicamos la clase que queremos que devuelva.
        Terminamos con getResultList, que ejecuta la consulta.
         */
        return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    //Recumeramos un registro en especifico a traves del id.
    @Override
    public Product obtainById(Integer id) {
        //Find se encarga de buscar en la base de datos y devolver el registro indicado o null si no lo encuentra
        return em.find(Product.class, id);
    }

    //Recumeramos un registro en especifico a traves del name.
    @Override
    public Product obtainByName(String name) {
        /*
        Almacenamos la consulta gracias al TypedQuery en query y a de buscarlo en el parametro :name
        que ha sido declarado asi para que no se vea la consulta que se hace y lo gestione "por debajo"
        asi añadimos seguridad a la busqueda. 
         */
        TypedQuery<Product> query = em.createQuery(
                "SELECT p FROM Product p WHERE p.productName like :name", Product.class);
        //Aqui ya le damos un valor al name, con setParameter. y confirmamos la operacion con el getResultList
        List<Product> products = query.setParameter("name", name).getResultList();
        //Verificamos si a encontrado un registro o no, siendo null en este ultimo caso.
        if (products.isEmpty()) {
            return null;
        } else {
            //Si lo encuentra devuelve el primer registro (Posicion 0) de la lista.
            return products.get(0);
        }
    }

    //Recumeramos los registros en especifico por la cantidad de stock indicada.
    @Override
    public List<Product> obtainProductsByStock(Integer stock) {
        TypedQuery<Product> query = em.createQuery(
                "SELECT p FROM Product p WHERE p.stock = :stock", Product.class);
        List<Product> products = query.setParameter("stock", stock).getResultList();
        if (products.isEmpty()) {
            return null;
        }
        return products;
    }

    //Recumeramos los registros en especifico de Product que pertenezcan a una Category.
    @Override
    public List<Product> obtainProductsByCategory(Integer idC) {
        TypedQuery<Product> query = em.createQuery(
                //Filtramos para que solo los Product, cuyo idSubcategory tenga un idCategory
                "SELECT p FROM Product p WHERE p.idSubcategory.idCategory = :idC", Product.class);
        List<Product> products = query.setParameter("idC", idC).getResultList();
        if (products.isEmpty()) {
            return null;
        }
        return products;
    }

    //Recumeramos los registros en especifico de Product que pertenezcan a una Subcategory.
    @Override
    public List<Product> obtainProductsBySubcategory(Integer idS) {
        TypedQuery<Product> query = em.createQuery(
                //Filtramos para que solo los Product, cuyo idSubcategory tenga un idSubcategory
                "SELECT p FROM Product p WHERE p.idSubcategory.idSubcategory = :idS", Product.class);
        List<Product> products = query.setParameter("idS", idS).getResultList();
        if (products.isEmpty()) {
            return null;
        }
        return products;
    }

}
