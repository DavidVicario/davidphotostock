package com.project.davidphotostock.service.impl;

//Imports
import com.project.davidphotostock.data.IMunicipalityDao;
import com.project.davidphotostock.domain.Municipality;
import com.project.davidphotostock.service.MunicipalityService;
import java.util.Collections;
import java.util.List;

//Implementamos en la clase su Service correspondiente donde estan los metodos a usar.
public class MunicipalityServiceImpl implements MunicipalityService {

    //Declaramos el interfaz Dao para poder usar la implementacion de sus metodos.
    private IMunicipalityDao imd;

    //Definimos el constructor de la implementacion y tomamos el objeto dao como parametro. 
    public MunicipalityServiceImpl(IMunicipalityDao imd) {
        this.imd = imd;
    }

    //Metodo para obtener todos los registros.
    @Override
    public List<Municipality> obtainAllMunicipalities() {
        //Simplemente llamamos al Dao.
        return imd.obtainAll();
    }

    //Metodo para obtener un registro por id.
    @Override
    public Municipality obtainMunicipalityById(Integer id) {
        return imd.obtainById(id);
    }

    //Metodo para obtener un registro por nombre.
    @Override
    public Municipality obtainMunicipalityByName(String name) {
        return imd.obtainByName(name);
    }

    //Metodo para obtener Municipios por Provincia.
    @Override
    public List<Municipality> obtainMunicipalityByProvince(Integer idProvince) {
        //Llamamos al metodo del Dao para realizar la busqueda por idProvince.
        List<Municipality> municipalities = imd.obtainMuniByProv(idProvince);
        //Si no es null devolvera la lista.
        if (municipalities != null) {
            return municipalities;
        } else {
            //Si devuelve un null, sale un texto de que no existe la provincia y devolvemos una lista vacia.
            System.out.println("La provincia indicada no existe.");
            return Collections.emptyList();
        }
    }

}
