package com.project.davidphotostock.service.impl;

//Imports
import com.project.davidphotostock.data.ICcaaDao;
import com.project.davidphotostock.domain.Ccaa;
import com.project.davidphotostock.service.CcaaService;
import java.util.List;

//Implementamos en la clase su Service correspondiente donde estan los metodos a usar.
public class CcaaServiceImpl implements CcaaService {

    //Declaramos el interfaz Dao para poder usar la implementacion de sus metodos.
    private ICcaaDao icd;

    //Definimos el constructor de la implementacion y tomamos el objeto dao como parametro. 
    public CcaaServiceImpl(ICcaaDao icd) {
        this.icd = icd;
    }

    //Metodo para obtener todos los registros.
    @Override
    public List<Ccaa> obtainAllCcaa() {
        //Simplemente llamamos al Dao.
        return icd.obtainAll();
    }

    //Metodo para obtener un registro por id.
    @Override
    public Ccaa obtainCcaaById(Integer id) {
        return icd.obtainById(id);
    }

    //Metodo para obtener un registro por nombre.
    @Override
    public Ccaa obtainCcaaByName(String name) {
        return icd.obtainByName(name);
    }

}
