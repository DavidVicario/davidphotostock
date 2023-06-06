package com.project.davidphotostock.service.impl;

//Imports
import com.project.davidphotostock.data.IProductDao;
import com.project.davidphotostock.domain.Product;
import com.project.davidphotostock.service.ProductService;
import static com.project.davidphotostock.util.Constants.*;
import java.util.List;

//Implementamos en la clase su Service correspondiente donde estan los metodos a usar.
public class ProductServiceImpl implements ProductService {

    //Declaramos el interfaz Dao para poder usar la implementacion de sus metodos.
    private IProductDao ipd;

    //Definimos el constructor de la implementacion y tomamos el objeto dao como parametro. 
    public ProductServiceImpl(IProductDao ipd) {
        this.ipd = ipd;
    }

    //Metodo para crear un nuevo registro en la base de datos si este no existe.
    @Override
    public Boolean createProduct(Product p) {
        Boolean resul = true;
        //Llamamos al metodo del Dao para realizar la busqueda de p.
        Product productN = ipd.obtainByName(p.getProductName());
        //Si devuelve un registro, es que ya existe y saltara un mensaje.
        if (productN != null) {
            System.out.println("El producto ya existe.");
            resul = false;
        } else {
            //Si devuelve un null creara el registro nuevo.
            ipd.create(p);
        }
        return resul;
    }

    //Metodo para actualizar un registro en la base de datos si este existe.
    @Override
    public void updateProduct(Product p) {
        //Llamamos al metodo del Dao para realizar la busqueda de p.
        Product productN = ipd.obtainByName(p.getProductName());
        //Si devuelve el registro es que es igual, entonces no tiene sentido actualizar.
        if (productN != null) {
            System.out.println("El nombre del producto ya existe.");
        } else {
            //Despues confirmamos con metodo del Dao que obtiene el ID para comprobar si existe.
            Product productI = ipd.obtainById(p.getIdProduct());
            if (productI != null) {
                //Si vuelve un valor de ID ya si, actualizamos.
                ipd.update(p);
            } else {
                //Si devuelve null es que el registro no existe.
                System.out.println("El ID del producto no existe.");
            }
        }
    }

    //Metodo para borrar un registro si este existe. 
    @Override
    public void deleteProduct(Product p) {
        Product productI = ipd.obtainById(p.getIdProduct());
        if (productI != null) {
            //Si el Id existe se elimina el registro. 
            ipd.delete(p);
        } else {
            System.out.println("El ID del producto no existe.");
        }
    }

    //Metodo para obtener todos los registros.
    @Override
    public List<Product> obtainAllProducts() {
        //Simplemente llamamos al Dao.
        return ipd.obtainAll();
    }

    //Metodo para obtener un registro por id.
    @Override
    public Product obtainProductById(Integer id) {
        return ipd.obtainById(id);
    }

    //Metodo para obtener un registro por nombre.
    @Override
    public Product obtainProductByName(String name) {
        return ipd.obtainByName(name);
    }

    //Metodo para obtener los registros que estan con el Stock a 0.
    @Override
    public List<Product> obtainProductsWithoutStock() {
        //Los valores los añadimos en una clase llamada Util como constantes, 
        //para tenerlos mas controlados y de facil acceso. 
        return ipd.obtainProductsByStock(WITHOUTSTOCK);
    }

    //Metodo para obtener los registros que estan con el Stock a 5 o menos.
    @Override
    public List<Product> obtainProductsWithFewStock() {
        return ipd.obtainProductsByStock(FEWSTOCK);
    }

    //Metodo para obtener los registros de producto por categoria.
    @Override
    public List<Product> obtainProductsByCategory(Integer idC) {
        return ipd.obtainProductsByCategory(idC);
    }

    //Metodo para obtener los registros de producto por subcategoria.
    @Override
    public List<Product> obtainProductsBySubcategory(Integer idS) {
        return ipd.obtainProductsBySubcategory(idS);
    }
}
