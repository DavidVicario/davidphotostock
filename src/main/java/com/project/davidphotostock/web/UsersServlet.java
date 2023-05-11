package com.project.davidphotostock.web;

import com.project.davidphotostock.data.IUsersDao;
import com.project.davidphotostock.data.impl.IUsersDaoImpl;
import com.project.davidphotostock.domain.Users;
import com.project.davidphotostock.service.UsersService;
import com.project.davidphotostock.service.impl.UsersServiceImpl;
import static com.project.davidphotostock.util.ConectionUtil.getInstance;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UsersServlet", urlPatterns = {"/UsersServlet"})
public class UsersServlet extends HttpServlet {

    UsersService us;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        if (action != null){
            switch (action){
                case "create":
                    this.signUpUser(request, response);
                    break;
                case "createAdmin":
                    this.addNewUser(request, response);
                    break;
                case "allUsers":
                    this.addNewUser(request, response);
                    break;
                default: 
                    this.actionDefault(request, response);
            }
        } else {
            this.actionDefault(request, response);
        }
        
    }
    
    private void actionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.sendRedirect("index.jsp");
    }
    private void actionDefaultAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.sendRedirect("pages/admin/admin.jsp");
    }    
    
    //Metodo para dar de alta un usuario.
    private void signUpUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        IUsersDao iud = new IUsersDaoImpl(getInstance());
        
        us = new UsersServiceImpl(iud);
        
        String name = request.getParameter("name");
        String firstSurname = request.getParameter("fsurname");
        String secondSurname = request.getParameter("ssurname");
        String mail = request.getParameter("mail");
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        String cPassword = request.getParameter("cpass");
        
        if (!password.equals(cPassword)) {
            request.getSession().setAttribute("errorMessage", "Las contraseñas no coinciden.");
            response.sendRedirect("index.jsp");
            return;
        }
        
        Users user = new Users(name, firstSurname, secondSurname, mail, username, password);                    
        
        System.out.println(user);
        
        if (!us.createUser(user)){
            request.getSession().setAttribute("errorMessage", "Error al crear el usuario. Comprueba los datos.");
        }
        response.sendRedirect("index.jsp");
        
    }
    private void addNewUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
    }
    
}
