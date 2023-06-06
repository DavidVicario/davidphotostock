package com.project.davidphotostock.service;

import com.project.davidphotostock.domain.Category;
import java.util.List;

public interface CategoryService {
    
    Boolean createCategory(Category c);

    void updateCategory(Category c);

    void deleteCategory(Category c);

    List<Category> obtainAllCategories();    
    
    Category obtainCategoryById(Integer id);
    
    Category obtainCategoryByName(String name);
    
}
