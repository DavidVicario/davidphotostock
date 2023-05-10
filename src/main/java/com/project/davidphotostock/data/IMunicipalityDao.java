package com.project.davidphotostock.data;

import com.project.davidphotostock.domain.Municipality;
import java.util.List;

public interface IMunicipalityDao {

    //CRUD de operaciones.
    List<Municipality> obtainAll();

    Municipality obtainById(Integer id);

    Municipality obtainByName(String name);

    List<Municipality> obtainMuniByProv(Integer idProvince);

}
