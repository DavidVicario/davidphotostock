package com.project.davidphotostock.service.impl;

//Imports
import com.project.davidphotostock.data.ICategoryDao;
import com.project.davidphotostock.domain.Category;
import com.project.davidphotostock.service.CategoryService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

//Implementamos en la clase su Service correspondiente donde estan los metodos a usar.
public class CategoryServiceImpl implements CategoryService {
    
    //Declaramos el interfaz Dao para poder usar la implementacion de sus metodos.
    private ICategoryDao icd;

    public CategoryServiceImpl(ICategoryDao icd) {
        this.icd = icd;
    }
    
    //Metodo para crear un nuevo registro en la base de datos si este no existe.
    @Override
    public Boolean createCategory(Category c) {
        Boolean resul = true;
        //Llamamos al metodo del Dao para realizar la busqueda de c.
        Category categoryN = icd.obtainByName(c.getCategoryName());
        //Si devuelve un registro, es que ya existe y saltara un mensaje.
        if (categoryN != null) {
            System.out.println("La categoria ya existe.");
            resul = false;
        } else {
            //Si devuelve un null creara el registro nuevo. 
            icd.create(c);
        }
        return resul;
    }

    //Metodo para actualizar un registro en la base de datos si este existe.
    @Override
    public void updateCategory(Category c) {
        //Llamamos al metodo del Dao para realizar la busqueda de c.
        Category categoryN = icd.obtainByName(c.getCategoryName());
        //Si devuelve el registro es que es igual, entonces no tiene sentido actualizar.
        if (categoryN != null) {
            System.out.println("El nombre de la categoría ya existe.");
        } else {
            //Despues confirmamos con metodo del Dao que obtiene el ID para comprobar si existe.
            Category categoryI = icd.obtainById(c.getIdCategory());
            if (categoryI != null) {
                //Si vuelve un valor de ID ya si, actualizamos. 
                icd.update(c);
            } else {
                //Si devuelve null es que el registro no existe.
                System.out.println("El ID de la categoría no existe.");
            }
        }
    }

    //Metodo para borrar un registro si este existe. 
    @Override
    public void deleteCategory(Category c) {
        Category categoryI = icd.obtainById(c.getIdCategory());
        if (categoryI != null) {
            //Si el Id existe se elimina el registro.
            icd.delete(c);
        } else {
            System.out.println("El ID de la categoría no existe.");
        }
    }

    //Metodo para obtener todos los registros.
    @Override
    public List<Category> obtainAllCategories() {
        //Simplemente llamamos al Dao.
        return icd.obtainAll();
    }

    //Metodo para obtener un registro por id
    @Override
    public Category obtainCategoryById(Integer id) {
        return icd.obtainById(id);
    }

    //Metodo para obtener un registro por nombre
    @Override
    public Category obtainCategoryByName(String name) {
        return icd.obtainByName(name);
    }

}
