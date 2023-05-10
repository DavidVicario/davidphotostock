/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.project.davidphotostock.test;

import com.project.davidphotostock.data.ICategoryDao;
import com.project.davidphotostock.data.impl.ICategoryDaoImpl;
import com.project.davidphotostock.domain.Category;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Marga
 */
public class testDao {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("davidphotostock-pu");
        EntityManager em = emf.createEntityManager();
        ICategoryDao categoryDao = new ICategoryDaoImpl();

        // Creamos un objeto de categoría y lo persistimos en la base de datos
        
        /*
        Category category = new Category();
        category.setCategoryName("Paisajes");
        categoryDao.create(category);
        
        Category category1 = new Category();
        category1.setCategoryName("Retrato");
        categoryDao.create(category1);
        
        Category category2 = new Category();
        category2.setCategoryName("Deporte");
        categoryDao.create(category2);
        */
        
        

        // Obtenemos todas las categorías de la base de datos
        List<Category> allCategories = categoryDao.obtainAll();
        //System.out.println(allCategories);
        
        for(int i = 0; i < allCategories.size(); i++){
            Category ct = allCategories.get(i);
            System.out.println("El nombre de la categoria es "+ct.getCategoryName()+" y su id es "+ct.getIdCategory());
            System.out.println(ct);
        }

        // Obtenemos una categoría específica según su id
        Category foundCategory = categoryDao.obtainById(1);
        System.out.println(foundCategory);
        
        // Obtenemos una categoría específica según su name
        Category foundCategory2 = categoryDao.obtainByName("Retrato");
        System.out.println(foundCategory2);
        
        // Cerramos el EntityManager y el EntityManagerFactory
        em.close();
        emf.close();
    }
}
