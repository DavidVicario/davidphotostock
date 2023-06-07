package com.project.davidphotostock.service;

import com.project.davidphotostock.domain.Users;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface UsersService {
    
    Boolean createUser(Users u);

    Boolean updateUser(Users u);

    Boolean deleteUser(Users u);

    List<Users> obtainAllUsers();
    
    Users obtainUserById(Integer id);
    
    Users obtainUserByUsername(String uName);
    
    Users obtainUserByMail(String mail);
    
    Users obtainUserByUsernameAndPass(String username, String password);
    
}
