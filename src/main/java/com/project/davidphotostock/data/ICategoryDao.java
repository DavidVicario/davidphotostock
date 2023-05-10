package com.project.davidphotostock.data;

import com.project.davidphotostock.domain.Category;
import java.util.List;

public interface ICategoryDao {

    //CRUD de operaciones.
    void create(Category c);

    void update(Category c);

    void delete(Category c);

    List<Category> obtainAll();

    Category obtainById(Integer id);

    Category obtainByName(String name);

}
