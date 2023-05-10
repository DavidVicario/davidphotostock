package com.project.davidphotostock.data;

import com.project.davidphotostock.domain.Subcategory;
import java.util.List;

public interface ISubcategoryDao {

    //CRUD de operaciones.
    void create(Subcategory sc);

    void update(Subcategory sc);

    void delete(Subcategory sc);

    List<Subcategory> obtainAll();

    Subcategory obtainById(Integer id);

    Subcategory obtainByName(String name);

    List<Subcategory> obtainSubByCate(Integer idCategory);

}
