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
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UsersAdminServlet", urlPatterns = {"/UsersAdminServlet"})
public class UsersAdminServlet extends HttpServlet {
    
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
                case "checkLogin":
                    this.checkLogin(request, response);
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
                    this.actionDefaultAdmin(request, response);
            }
        } else {
            this.actionDefaultAdmin(request, response);
        }
    }
    
        // Método para comprobar si un usuario ha iniciado sesión
    private void checkLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        if (user != null) {
            out.print(user.getUsername());
        } else {
            out.print("");
        }

        System.out.println("El Usuario es: "+user);
        out.flush();
    }
    
    // Método para cerrar sesion de usuario.
    private void logoutUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        HttpSession session = request.getSession();
        session.invalidate(); 

        response.setStatus(HttpServletResponse.SC_OK); 
    }
    
    //Acción por defecto para el usuario Admin.
    private void actionDefaultAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        IUsersDao iud = new IUsersDaoImpl(getInstance());
        
        us = new UsersServiceImpl(iud);
        
        List<Users> users = us.obtainAllUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("pages/admin/admin.jsp").forward(request, response);
    }
    
    //Metodo para listar los usuarios. 
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
    }
    
    //Metodo para borrar un usuario desde admin
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
    }

}
