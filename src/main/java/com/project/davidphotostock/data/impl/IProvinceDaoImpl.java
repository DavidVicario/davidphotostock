package com.project.davidphotostock.data.impl;

//Imports
import com.project.davidphotostock.data.IProvinceDao;
import com.project.davidphotostock.domain.Province;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

//Incidamos que se implementa los metodos del interfaz del Dao correspondiente.
public class IProvinceDaoImpl implements IProvinceDao {

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
    public IProvinceDaoImpl(EntityManager em) {
        this.em = em;
    }

    //Listamos todos los registros que esten guardados en la tabla de la base de datos.
    @Override
    public List<Province> obtainAll() {
        /*
        Realizamos la consulta con el metodo createQuery, que se utiliza para realizar
        consultas en JPQL. Que es igual al SQL pero este trabaja con objetos y clases.
        Escribimos la consulta en JPQL e indicamos la clase que queremos que devuelva.
        Terminamos con getResultList, que ejecuta la consulta.
         */
        return em.createQuery("SELECT p FROM Province p", Province.class).getResultList();
    }

    //Recumeramos un registro en especifico a traves del id.
    @Override
    public Province obtainById(Integer id) {
        //Find se encarga de buscar en la base de datos y devolver el registro indicado o null si no lo encuentra
        return em.find(Province.class, id);
    }

    //Recumeramos un registro en especifico a traves del name.
    @Override
    public Province obtainByName(String name) {
        /*
        Almacenamos la consulta gracias al TypedQuery en query y a de buscarlo en el parametro :name
        que ha sido declarado asi para que no se vea la consulta que se hace y lo gestione "por debajo"
        asi añadimos seguridad a la busqueda. 
         */
        TypedQuery<Province> query = em.createQuery(
                "SELECT p FROM Province p WHERE p.province like :name", Province.class);
        //Aqui ya le damos un valor al name, con setParameter. y confirmamos la operacion con el getResultList
        List<Province> provinces = query.setParameter("name", name).getResultList();
        //Verificamos si a ecnontrado un registro o no, siendo null en este ultimo caso.
        if (provinces.isEmpty()) {
            return null;
            //Si lo encuentra devuelve el primer registro (Posicion 0) de la lista.
        }
        return provinces.get(0);
    }

    //Recumeramos los registros en especifico de Province que pertenezcan a una Ccaa.
    @Override
    public List<Province> obtainProvByCcaa(Integer idCcaa) {
        TypedQuery<Province> query = em.createQuery(
                //Filtramos para que solo los Province, cuyo idCcaa tenga un idCcaa.
                "SELECT p FROM Province p WHERE p.idCcaa.idCcaa = :idCcaa", Province.class);
        List<Province> provinces = query.setParameter("idCcaa", idCcaa).getResultList();
        if (provinces.isEmpty()) {
            return null;
        } else {
            return provinces;
        }
    }

}
