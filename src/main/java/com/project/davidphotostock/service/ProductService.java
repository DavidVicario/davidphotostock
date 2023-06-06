package com.project.davidphotostock.service;

import com.project.davidphotostock.domain.Product;
import java.util.List;

public interface ProductService {
    
    Boolean createProduct(Product p);

    void updateProduct(Product p);

    void deleteProduct(Product p);

    List<Product> obtainAllProducts();    
    
    Product obtainProductById(Integer id);
    
    Product obtainProductByName(String name);
    
    List<Product> obtainProductsWithoutStock();
    
    List<Product> obtainProductsWithFewStock();
    
    List<Product> obtainProductsByCategory(Integer idC);
    
    List<Product> obtainProductsBySubcategory(Integer idS);
    
}
