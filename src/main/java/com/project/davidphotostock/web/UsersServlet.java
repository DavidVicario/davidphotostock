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
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.regex.Pattern;

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
                case "login":
                    this.loginUser(request, response);
                    break;
                case "logout":
                    this.logoutUser(request, response);
                    break;
                case "createAdmin":
                    this.addNewUser(request, response);
                    break;
                case "update":
                    this.updateUser(request, response);
                    break;
                case "delete":
                    this.deleteUser(request, response);
                    break;
                case "allUsers":
                    this.actionDefaultAdmin(request, response);
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
        IUsersDao iud = new IUsersDaoImpl(getInstance());
        us = new UsersServiceImpl(iud);
        List<Users> users = us.obtainAllUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("pages/admin/admin.jsp").forward(request, response);
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
            request.getSession().setAttribute("errorActive", true);
            request.getRequestDispatcher("includes/forms/errorPage.jsp").forward(request, response);
            return;
        }
        
        Users user = new Users(name, firstSurname, secondSurname, mail, username, password);
        
        if (!us.createUser(user)){
            request.getSession().setAttribute("errorActive", true);
            request.getRequestDispatcher("includes/forms/errorPage.jsp").forward(request, response);
        }
        response.sendRedirect("index.jsp");
        
    }
    
    //Metodo para login de un usuario
    private void loginUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        IUsersDao iud = new IUsersDaoImpl(getInstance());
        
        us = new UsersServiceImpl(iud);
        
        String username = sanitizeInput(request.getParameter("user"));
        String password = hashPassword(sanitizeInput(request.getParameter("pass")));

        Users user = us.obtainUserByUsernameAndPass(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("errorMessage", "Compruebe su usuario o contraseña.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
    
    private String sanitizeInput(String input) {
        if (input == null) {
            return "";  
        }
        return Pattern.compile("[^a-zA-Z0-9]").matcher(input).replaceAll("");
    }
    
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedPassword) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    private void logoutUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        HttpSession session = request.getSession();
        session.invalidate(); // invalidamos la sesión

        response.sendRedirect("index.jsp"); 
    }
    
    
    //Metodo para login de un usuario
    private void listAllUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        IUsersDao iud = new IUsersDaoImpl(getInstance());
        
        us = new UsersServiceImpl(iud);
        
        List<Users> users = us.obtainAllUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("pages/admin/usersList.jsp").forward(request, response);
    }
    
    //Metodo para agregar un usuario desde admin
    private void addNewUser(HttpServletRequest request, HttpServletResponse response)
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
            request.getSession().setAttribute("errorActive", true);
            request.getRequestDispatcher("includes/forms/errorPage.jsp").forward(request, response);
            return;
        }
        
        Users user = new Users(name, firstSurname, secondSurname, mail, username, password);
        
        if (!us.createUser(user)){
            request.getSession().setAttribute("errorActive", true);
            request.getRequestDispatcher("includes/forms/errorPage.jsp").forward(request, response);
        }
        response.sendRedirect("pages/admin/admin.jsp");
    }
    
    //Metodo para actualizar un usuario desde admin
    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        IUsersDao iud = new IUsersDaoImpl(getInstance());
        
        us = new UsersServiceImpl(iud);
        
        
    }
    
    //Metodo para borrar un usuario desde admin
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        IUsersDao iud = new IUsersDaoImpl(getInstance());
        
        us = new UsersServiceImpl(iud);
    }
    
}
