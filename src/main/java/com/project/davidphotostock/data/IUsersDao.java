package com.project.davidphotostock.data;

import com.project.davidphotostock.domain.Users;
import java.util.List;

public interface IUsersDao {
    
    //CRUD de operaciones.
    void create(Users u);

    void update(Users u);

    void delete(Users u);

    List<Users> obtainAll();
    
    Users obtainById(Integer id);
    
    Users obtainByUsername(String uName);
    
    Users obtainByMail(String mail);
    
    Users obtainByUsernameAndPass(String username, String password);
    
}
