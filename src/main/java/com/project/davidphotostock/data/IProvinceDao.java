package com.project.davidphotostock.data;

import com.project.davidphotostock.domain.Province;
import java.util.List;

public interface IProvinceDao {

    //CRUD de operaciones.
    List<Province> obtainAll();

    Province obtainById(Integer id);

    Province obtainByName(String name);

    List<Province> obtainProvByCcaa(Integer idCcaa);

}
