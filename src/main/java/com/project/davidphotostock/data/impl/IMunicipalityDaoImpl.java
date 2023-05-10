package com.project.davidphotostock.data.impl;

//Imports
import com.project.davidphotostock.data.IMunicipalityDao;
import com.project.davidphotostock.domain.Municipality;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

//Incidamos que se implementa los metodos del interfaz del Dao correspondiente.
public class IMunicipalityDaoImpl implements IMunicipalityDao {

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
    public IMunicipalityDaoImpl(EntityManager em) {
        this.em = em;
    }

    //Listamos todos los registros que esten guardados en la tabla de la base de datos.
    @Override
    public List<Municipality> obtainAll() {
        /*
        Realizamos la consulta con el metodo createQuery, que se utiliza para realizar
        consultas en JPQL. Que es igual al SQL pero este trabaja con objetos y clases.
        Escribimos la consulta en JPQL e indicamos la clase que queremos que devuelva.
        Terminamos con getResultList, que ejecuta la consulta.
         */
        return em.createQuery("SELECT m FROM Municipality m", Municipality.class).getResultList();
    }

    //Recumeramos un registro en especifico a traves del id.
    @Override
    public Municipality obtainById(Integer id) {
        //Find se encarga de buscar en la base de datos y devolver el registro indicado o null si no lo encuentra
        return em.find(Municipality.class, id);
    }

    //Recumeramos un registro en especifico a traves del name.
    @Override
    public Municipality obtainByName(String name) {
        /*
        Almacenamos la consulta gracias al TypedQuery en query y a de buscarlo en el parametro :name
        que ha sido declarado asi para que no se vea la consulta que se hace y lo gestione "por debajo"
        asi añadimos seguridad a la busqueda. 
         */
        TypedQuery<Municipality> query = em.createQuery(
                "SELECT m FROM Municipality m WHERE m.municipality like :name", Municipality.class);
        //Aqui ya le damos un valor al name, con setParameter. y confirmamos la operacion con el getResultList
        List<Municipality> municipalities = query.setParameter("name", name).getResultList();
        //Verificamos si a ecnontrado un registro o no, siendo null en este ultimo caso.
        if (municipalities.isEmpty()) {
            return null;
            //Si lo encuentra devuelve el primer registro (Posicion 0) de la lista.
        }
        return municipalities.get(0);
    }

    //Recumeramos los registros en especifico de Municipality que pertenezcan a una Provincia.
    @Override
    public List<Municipality> obtainMuniByProv(Integer idProvince) {
        TypedQuery<Municipality> query = em.createQuery(
                //Filtramos para que solo los Municipality, cuyo idProvince tenga un idProvince
                "SELECT m FROM Municipality m WHERE m.idProvince.idProvince = :idProvince", Municipality.class);
        List<Municipality> municipalities = query.setParameter("idProvince", idProvince).getResultList();
        if (municipalities.isEmpty()) {
            return null;
        } else {
            return municipalities;
        }
    }

}
