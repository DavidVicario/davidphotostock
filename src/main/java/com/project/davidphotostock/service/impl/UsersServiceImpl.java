package com.project.davidphotostock.service.impl;

//Imports
import com.project.davidphotostock.data.IUsersDao;
import com.project.davidphotostock.domain.Users;
import com.project.davidphotostock.service.UsersService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
//Implementamos en la clase su Service correspondiente donde estan los metodos a usar.
public class UsersServiceImpl implements UsersService {

    
    //Declaramos el interfaz Dao para poder usar la implementacion de sus metodos.
    @EJB
    private IUsersDao iud;

    //Metodo para crear un nuevo registro en la base de datos si este no existe, lo comprobamos con dos campos unicos.
    @Override
    public Boolean createUser(Users u) {
        Boolean resul = true;
        //Llamamos al metodo del Dao para realizar la busqueda de u.
        Users userUN = iud.obtainByUsername(u.getUsername());
        if (userUN != null) {
            //Si devuelve un registro, es que ya existe y saltara un mensaje.
            System.out.println("El nombre de usuario ya existe.");
            resul = false;
        } else {
            //Despues confirmamos con metodo del Dao que obtiene el mail para comprobar si existe.
            Users userM = iud.obtainByMail(u.getMail());
            if (userM != null) {
                //Si devuelve un registro, es que ya existe y saltara un mensaje.
                System.out.println("El correo electronico ya existe.");
                resul = false;
            } else {
                //Si devuelve un null creara el registro nuevo.
                iud.create(u);
            }
        } 
        return resul;
    }

    //Metodo para actualizar un registro en la base de datos si este existe.
    @Override
    public void updateUser(Users u) {
        /*
        Tuve que crear una Excepcion ya que se tendria que comprobar tres valores unicos
        y que no eche para atras si alguno falta pero otro no.
         */
        try {
            iud.update(u);
        } catch (Exception ex) {
            System.out.println("No se ha podido actualizar los datos del usuario.");
        }
    }

    //Metodo para borrar un registro si este existe. 
    @Override
    public void deleteUser(Users u) {
        Users userI = iud.obtainById(u.getIdUser());
        if (userI != null) {
            //Si el Id existe se elimina el registro. 
            iud.delete(u);
        } else {
            System.out.println("El ID del usuario no existe.");
        }
    }

    //Metodo para obtener todos los registros.
    @Override
    public List<Users> obtainAllUsers() {
        //Simplemente llamamos al Dao.
        return iud.obtainAll();
    }

    //Metodo para obtener un registro por id.
    @Override
    public Users obtainUserById(Integer id) {
        return iud.obtainById(id);
    }

    //Metodo para obtener un registro por username.
    @Override
    public Users obtainUserByUsername(String uName) {
        return iud.obtainByUsername(uName);
    }

    //Metodo para obtener un registro por mail.
    @Override
    public Users obtainUserByMail(String mail) {
        return iud.obtainByMail(mail);
    }

    //Metodo para obtener un registro por username y password.
    @Override
    public Users obtainUserByUsernameAndPass(String username, String password) {
        return iud.obtainByUsernameAndPass(username, password);
    }

}
