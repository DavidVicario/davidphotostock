package com.project.davidphotostock.data;

import com.project.davidphotostock.domain.Product;
import java.util.List;

public interface IProductDao {

    //CRUD de operaciones.
    void create(Product p);

    void update(Product p);

    void delete(Product p);

    List<Product> obtainAll();

    Product obtainById(Integer id);

    Product obtainByName(String name);

    List<Product> obtainProductsByStock(Integer stock);

    List<Product> obtainProductsByCategory(Integer idC);

    List<Product> obtainProductsBySubcategory(Integer idS);

}
