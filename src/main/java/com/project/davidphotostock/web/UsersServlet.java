package com.project.davidphotostock.web;

import com.project.davidphotostock.data.IUsersDao;
import com.project.davidphotostock.data.impl.IUsersDaoImpl;
import com.project.davidphotostock.domain.Users;
import com.project.davidphotostock.service.UsersService;
import com.project.davidphotostock.service.impl.UsersServiceImpl;
import static com.project.davidphotostock.util.ConectionUtil.getInstance;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@WebServlet(name = "UsersServlet", urlPatterns = {"/UsersServlet"})
public class UsersServlet extends HttpServlet {

    UsersService us;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "create":
                    this.signUpUser(request, response);
                    break;
                case "login":
                    this.loginUser(request, response);
                    break;
                case "checkLogin":
                    this.checkLogin(request, response);
                    break;
                case "logout":
                    this.logoutUser(request, response);
                    break;
                case "forgot":
                    this.forgotPass(request, response);
                    break;
                case "contact":
                    this.contactForm(request, response);
                    break;
                default:
                    this.actionDefault(request, response);
            }
        } else {
            this.actionDefault(request, response);
        }
    }

    private void actionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("index.jsp");
    }

    //Metodo para dar de alta un usuario.
    private void signUpUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

        if (!us.createUser(user)) {
            request.getSession().setAttribute("errorActive", true);
            request.getRequestDispatcher("includes/forms/errorPage.jsp").forward(request, response);
        }
        response.sendRedirect("index.jsp");
    }

    //Metodo para login de un usuario
    private void loginUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        IUsersDao iud = new IUsersDaoImpl(getInstance());
        us = new UsersServiceImpl(iud);

        String username = request.getParameter("user");
        String password = request.getParameter("pass");

        Users user = us.obtainUserByUsernameAndPass(username, password);
        
        String currentUrl = request.getParameter("currentUrl");
        
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("idUser", user.getIdUser());
            //Si el usuario selecciona "Recordarme", guarda su nombre de usuario en una Cookie.
            if ("on".equals(request.getParameter("remember"))) {
                Cookie usernameCookie = new Cookie("username", username);
                usernameCookie.setMaxAge(60 * 60 * 24 * 15); // 15 días
                response.addCookie(usernameCookie);
            }
            if (username.equals("admin")) {
                response.sendRedirect("UsersAdminServlet");
            } else {
                if (currentUrl != null && currentUrl.contains("checkout")) {
                    response.sendRedirect(currentUrl);
                } else {
                    response.sendRedirect("index.jsp");
            }
            }
        } else {
            request.setAttribute("message", "Compruebe su usuario o contraseña.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
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

        out.flush();
    }

    // Método para cerrar sesion de usuario.
    private void logoutUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.invalidate();

        response.sendRedirect("index.jsp");
    }

    private void forgotPass(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        
        
        
        
        
        IUsersDao iud = new IUsersDaoImpl(getInstance());
    us = new UsersServiceImpl(iud);

    String username = request.getParameter("user");
    HttpSession session = request.getSession();
    PrintWriter out = response.getWriter();
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    if ("false".equals(request.getParameter("username-verified"))) {
        Users user = us.obtainUserByUsername(username);
        if (user != null) {
            session.setAttribute("username-verified", "true");
            session.setAttribute("user", user);
            out.print("{\"usernameVerified\": \"true\"}");
        } else {
            // Usuario no encontrado
            out.print("{\"usernameVerified\": \"false\"}");
        }
    } else {
        Users user = us.obtainUserByUsername(username);
            // Cambiar contraseña
            String newPassword = request.getParameter("pass");
            String confirmPassword = request.getParameter("cpass");

            // Comprobar que las contraseñas son iguales
            if (newPassword.equals(confirmPassword)) {
                user.setPassword(newPassword);
                if (us.updateUser(user)) {
                    // La contraseña se cambió con éxito
                    response.sendRedirect("index.jsp");
                } else {
                    // Error al actualizar la contraseña
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            } else {
                // Las contraseñas no coinciden
                request.setAttribute("error", "Las contraseñas no coinciden.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
    }

    out.flush();
        
        //Hay que cambiar la FUNCION DE CARRITO
        
        /*
        IUsersDao iud = new IUsersDaoImpl(getInstance());
        us = new UsersServiceImpl(iud);

        String username = request.getParameter("user");

        if ("false".equals(request.getParameter("username-verified"))) {
            Users user = us.obtainUserByUsername(username);
            if (user != null) {
                request.setAttribute("username-verified", "true");
                request.setAttribute("user", user);
            } else {
                // Usuario no encontrado
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            Users user = us.obtainUserByUsername(username);
            // Cambiar contraseña
            String newPassword = request.getParameter("pass");
            String confirmPassword = request.getParameter("cpass");

            // Comprobar que las contraseñas son iguales
            if (newPassword.equals(confirmPassword)) {
                user.setPassword(newPassword);
                if (us.updateUser(user)) {
                    // La contraseña se cambió con éxito
                    response.sendRedirect("index.jsp");
                } else {
                    // Error al actualizar la contraseña
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            } else {
                // Las contraseñas no coinciden
                request.setAttribute("error", "Las contraseñas no coinciden.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
        */
    }

    private void contactForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String mail = request.getParameter("mail");
        String phone = request.getParameter("phone");
        String subject = request.getParameter("subject");

        // Definir el cuerpo del correo
        String body = "Nombre: " + name + "\n"
                + "Correo: " + mail + "\n"
                + "Teléfono: " + phone + "\n"
                + "Asunto: " + subject;

        // Definir los correos de envío y recepción
        Email from = new Email("davidphotostock8@gmail.com");
        Email to = new Email("davidphotostock8@gmail.com");

        // Crear el contenido del correo
        Content content = new Content("text/plain", body);

        // Crear el correo
        Mail mailToSend = new Mail(from, subject, to, content);

        // Crear un objeto SendGrid y enviar el correo
        SendGrid sg = new SendGrid("Poner aquí la key");
        com.sendgrid.Request requestSendGrid = new com.sendgrid.Request();

        try {
            requestSendGrid.setMethod(Method.POST);
            requestSendGrid.setEndpoint("mail/send");
            requestSendGrid.setBody(mailToSend.build());
            Response responseSendGrid = sg.api(requestSendGrid);
            System.out.println(responseSendGrid.getStatusCode());
            System.out.println(responseSendGrid.getBody());
            System.out.println(responseSendGrid.getHeaders());
            if (responseSendGrid.getStatusCode() == 202) {
                request.setAttribute("message", "¡Tu mensaje ha sido enviado con éxito!");
            } else {
                request.setAttribute("message", "Ocurrió un error al enviar tu mensaje. Por favor, inténtalo de nuevo más tarde.");
            }
            request.getRequestDispatcher("pages/users/contact.jsp").forward(request, response);
        } catch (IOException ex) {
            throw ex;
        }
    }

}
