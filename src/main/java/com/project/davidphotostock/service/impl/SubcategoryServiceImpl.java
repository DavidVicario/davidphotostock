package com.project.davidphotostock.service.impl;

//Imports
import com.project.davidphotostock.data.ISubcategoryDao;
import com.project.davidphotostock.domain.Subcategory;
import com.project.davidphotostock.service.SubcategoryService;
import java.util.Collections;
import java.util.List;

//Implementamos en la clase su Service correspondiente donde estan los metodos a usar.
public class SubcategoryServiceImpl implements SubcategoryService {

    //Declaramos el interfaz Dao para poder usar la implementacion de sus metodos.
    private ISubcategoryDao iscd;

    //Definimos el constructor de la implementacion y tomamos el objeto dao como parametro. 
    public SubcategoryServiceImpl(ISubcategoryDao iscd) {
        this.iscd = iscd;
    }

    //Metodo para crear un nuevo registro en la base de datos. Al no tener campo unico, creamos sin hacer filtro.
    @Override
    public void createSubcategory(Subcategory sc) {
        iscd.create(sc);
    }

    //Metodo para actualizar un registro en la base de datos si este existe.
    @Override
    public void updateSubcategory(Subcategory sc) {
        Subcategory subcategoryN = iscd.obtainByName(sc.getSubcategoryName());
        //Si devuelve el registro es que es igual, entonces no tiene sentido actualizar.
        if (subcategoryN != null) {
            System.out.println("El nombre de la subcategoría ya existe.");
        } else {
            //Despues confirmamos con metodo del Dao que obtiene el ID para comprobar si existe.
            Subcategory subcategoryI = iscd.obtainById(sc.getIdSubcategory());
            if (subcategoryI != null) {
                //Si vuelve un valor de ID, actualizamos.
                iscd.update(sc);
            } else {
                //Si devuelve null es que el registro no existe.
                System.out.println("El ID de la subcategoría no existe.");
            }
        }
    }

    //Metodo para borrar un registro si este existe. 
    @Override
    public void deleteSubcategory(Subcategory sc) {
        Subcategory subcategoryI = iscd.obtainById(sc.getIdSubcategory());
        if (subcategoryI != null) {
            //Si el Id existe se elimina el registro. 
            iscd.delete(sc);
        } else {
            System.out.println("El ID de la subcategoría no existe.");
        }
    }

    //Metodo para obtener todos los registros.
    @Override
    public List<Subcategory> obtainAllSubcategories() {
        //Simplemente llamamos al Dao.
        return iscd.obtainAll();
    }

    //Metodo para obtener un registro por id.
    @Override
    public Subcategory obtainSubcategoryById(Integer id) {
        return iscd.obtainById(id);
    }

    //Metodo para obtener un registro por nombre.
    @Override
    public Subcategory obtainSubcategoryByName(String name) {
        return iscd.obtainByName(name);
    }

    //Metodo para obtener todos los registros de subcategorias por categoria.
    @Override
    public List<Subcategory> obtainSubcategoryByCategory(Integer idCategory) {
        //Llamamos al metodo del Dao para realizar la busqueda por idCategory.
        List<Subcategory> subcategories = iscd.obtainSubByCate(idCategory);
        //Si no es null devolvera la lista.
        if (subcategories != null) {
            return subcategories;
        } else {
            //Si devuelve un null, sale un texto de que no existe la categoria y devolvemos una lista vacia.
            System.out.println("La categoria indicada no existe.");
            return Collections.emptyList();
        }
    }

}
