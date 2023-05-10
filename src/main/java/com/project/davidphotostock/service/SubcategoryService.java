package com.project.davidphotostock.service;

import com.project.davidphotostock.domain.Subcategory;
import java.util.List;

public interface SubcategoryService {
    
    void createSubcategory(Subcategory sc);

    void updateSubcategory(Subcategory sc);

    void deleteSubcategory(Subcategory sc);

    List<Subcategory> obtainAllSubcategories();
    
    Subcategory obtainSubcategoryById(Integer id);
    
    Subcategory obtainSubcategoryByName(String name);
    
    List<Subcategory> obtainSubcategoryByCategory(Integer idCategory);
    
}
