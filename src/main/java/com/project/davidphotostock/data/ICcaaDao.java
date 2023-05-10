package com.project.davidphotostock.data;

import com.project.davidphotostock.domain.Ccaa;
import java.util.List;

public interface ICcaaDao {

    //CRUD de operaciones.
    List<Ccaa> obtainAll();

    Ccaa obtainById(Integer id);

    Ccaa obtainByName(String name);

}
