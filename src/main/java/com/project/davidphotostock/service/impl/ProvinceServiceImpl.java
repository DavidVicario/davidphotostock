package com.project.davidphotostock.service.impl;

//Imports
import com.project.davidphotostock.data.IProvinceDao;
import com.project.davidphotostock.domain.Province;
import com.project.davidphotostock.service.ProvinceService;
import java.util.Collections;
import java.util.List;

//Implementamos en la clase su Service correspondiente donde estan los metodos a usar.
public class ProvinceServiceImpl implements ProvinceService {

    //Declaramos el interfaz Dao para poder usar la implementacion de sus metodos.
    private IProvinceDao ipd;

    //Definimos el constructor de la implementacion y tomamos el objeto dao como parametro. 
    public ProvinceServiceImpl(IProvinceDao ipd) {
        this.ipd = ipd;
    }

    //Metodo para obtener todos los registros.
    @Override
    public List<Province> obtainAllProvinces() {
        //Simplemente llamamos al Dao.
        return ipd.obtainAll();
    }

    //Metodo para obtener un registro por id.
    @Override
    public Province obtainProvinceById(Integer id) {
        return ipd.obtainById(id);
    }

    //Metodo para obtener un registro por nombre.
    @Override
    public Province obtainProvinceByName(String name) {
        return ipd.obtainByName(name);
    }

    //Metodo para obtener Provincias por Ccaa.
    @Override
    public List<Province> obtainProvinceByCcaa(Integer idCcaa) {
        //Llamamos al metodo del Dao para realizar la busqueda por idCcaa.
        List<Province> provinces = ipd.obtainProvByCcaa(idCcaa);
        //Si no es null devolvera la lista.
        if (provinces != null) {
            return provinces;
        } else {
            //Si devuelve un null, sale un texto de que no existe la Ccaa y devolvemos una lista vacia.
            System.out.println("La comunidad autonoma indicada no existe.");
            return Collections.emptyList();
        }
    }

}
