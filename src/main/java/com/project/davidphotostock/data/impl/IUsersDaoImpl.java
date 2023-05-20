package com.project.davidphotostock.data.impl;

//Imports
import com.project.davidphotostock.data.IUsersDao;
import com.project.davidphotostock.domain.Users;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

//Incidamos que se implementa los metodos del interfaz del Dao correspondiente.
public class IUsersDaoImpl implements IUsersDao {

    /*
    Declaramos la variable em en un tipo EntityManager, que es una API del persistance,
    Esto ayudara a manejar las operaciones que involucran a las entidades y al almacenamiento
    en la base de datos. 
    Lo que implica que podemos hacer las consultas de MySQL "por debajo" con objetos de Java.
     */
    private EntityManager em;

    public IUsersDaoImpl(EntityManager em) {
        this.em = em;
    }
    //Definimos el metodo para crear una nueva entidad en la base de datos.
    @Override
    public void create(Users u) {
        //Utilizamos em para empezar la transaccion de los datos.
        /*
        El getTransaction es para hacer el conjunto de las operaciones que debe realizar 
        juntas para mantener la integridad de los datos. En caso de ocurrir un problema
        lanzaria una excepcion y revirtiria todos los cambios.
         */
        em.getTransaction().begin();
        //Cogemos p y lo guardamos en la base de datos.
        em.persist(u);
        //Con el commit confirmamos los cambios. Si ocurre algún problema el Transaction haria un rollback
        em.getTransaction().commit();
    }

    //Definimos el metodo para editar una nueva entidad en la base de datos.
    @Override
    public void update(Users u) {
        em.getTransaction().begin();
        //Actualizamos la entidad existente en la base de datos a otra.
        em.merge(u);
        em.getTransaction().commit();
    }

    //Definimos el metodo para eliminar una nueva entidad en la base de datos.
    @Override
    public void delete(Users u) {
        em.getTransaction().begin();
        //Eliminamos la entidad existente en la base de datos.
        em.remove(u);
        em.getTransaction().commit();
    }

    //Listamos todos los registros que esten guardados en la tabla de la base de datos.
    @Override
    public List<Users> obtainAll() {
        /*
        Realizamos la consulta con el metodo createQuery, que se utiliza para realizar
        consultas en JPQL. Que es igual al SQL pero este trabaja con objetos y clases.
        Escribimos la consulta en JPQL e indicamos la clase que queremos que devuelva.
        Terminamos con getResultList, que ejecuta la consulta.
         */
        return em.createQuery("SELECT u FROM Users u", Users.class).getResultList();
    }

    //Recumeramos un registro en especifico a traves del id.
    @Override
    public Users obtainById(Integer id) {
        //Find se encarga de buscar en la base de datos y devolver el registro indicado o null si no lo encuentra
        return em.find(Users.class, id);
    }

    //Recumeramos un registro en especifico a traves del username.
    @Override
    public Users obtainByUsername(String uName) {
        /*
        Almacenamos la consulta gracias al TypedQuery en query y a de buscarlo en el parametro :uName
        que ha sido declarado asi para que no se vea la consulta que se hace y lo gestione "por debajo"
        asi añadimos seguridad a la busqueda. 
         */
        TypedQuery<Users> query = em.createQuery(
                "SELECT u FROM Users u WHERE u.username like :uName", Users.class);
        //Aqui ya le damos un valor al uName, con setParameter. y confirmamos la operacion con el getResultList
        List<Users> users = query.setParameter("uName", uName).getResultList();
        //Verificamos si a encontrado un registro o no, siendo null en este ultimo caso.
        if (users.isEmpty()) {
            return null;
        } else {
            //Si lo encuentra devuelve el primer registro (Posicion 0) de la lista.
            return users.get(0);
        }
    }

    //Recumeramos un registro en especifico a traves del Mail.
    @Override
    public Users obtainByMail(String mail) {
        TypedQuery<Users> query = em.createQuery(
                "SELECT u FROM Users u WHERE u.mail like :mail", Users.class);
        List<Users> users = query.setParameter("mail", mail).getResultList();
        if (users.isEmpty()) {
            return null;
        } else {
            return users.get(0);
        }
    }

    //Recumeramos un registro en especifico a traves del Usuario y la Pass.
    @Override
    public Users obtainByUsernameAndPass(String username, String password) {
        TypedQuery<Users> query = em.createQuery(
                "SELECT u FROM Users u WHERE u.username = :username AND u.password = :password", Users.class);
        List<Users> users = query.setParameter("username", username).setParameter("password", password).getResultList();
        if (users.isEmpty()) {
            return null;
        } else {
            return users.get(0);
        }
    }

}
