package com.project.davidphotostock.web;

import com.project.davidphotostock.data.ICategoryDao;
import com.project.davidphotostock.data.ICcaaDao;
import com.project.davidphotostock.data.IMunicipalityDao;
import com.project.davidphotostock.data.IProductDao;
import com.project.davidphotostock.data.IProvinceDao;
import com.project.davidphotostock.data.IShipmentDao;
import com.project.davidphotostock.data.IShipmentProductDao;
import com.project.davidphotostock.data.ISubcategoryDao;
import com.project.davidphotostock.data.IUsersDao;
import com.project.davidphotostock.data.impl.ICategoryDaoImpl;
import com.project.davidphotostock.data.impl.ICcaaDaoImpl;
import com.project.davidphotostock.data.impl.IMunicipalityDaoImpl;
import com.project.davidphotostock.data.impl.IProductDaoImpl;
import com.project.davidphotostock.data.impl.IProvinceDaoImpl;
import com.project.davidphotostock.data.impl.IShipmentDaoImpl;
import com.project.davidphotostock.data.impl.IShipmentProductDaoImpl;
import com.project.davidphotostock.data.impl.ISubcategoryDaoImpl;
import com.project.davidphotostock.data.impl.IUsersDaoImpl;
import com.project.davidphotostock.domain.Category;
import com.project.davidphotostock.domain.Ccaa;
import com.project.davidphotostock.domain.Municipality;
import com.project.davidphotostock.domain.Product;
import com.project.davidphotostock.domain.Province;
import com.project.davidphotostock.domain.Shipment;
import com.project.davidphotostock.domain.ShipmentProduct;
import com.project.davidphotostock.domain.Subcategory;
import com.project.davidphotostock.domain.Users;
import com.project.davidphotostock.service.CategoryService;
import com.project.davidphotostock.service.CcaaService;
import com.project.davidphotostock.service.MunicipalityService;
import com.project.davidphotostock.service.ProductService;
import com.project.davidphotostock.service.ProvinceService;
import com.project.davidphotostock.service.ShipmentProductService;
import com.project.davidphotostock.service.ShipmentService;
import com.project.davidphotostock.service.SubcategoryService;
import com.project.davidphotostock.service.UsersService;
import com.project.davidphotostock.service.impl.CategoryServiceImpl;
import com.project.davidphotostock.service.impl.CcaaServiceImpl;
import com.project.davidphotostock.service.impl.MunicipalityServiceImpl;
import com.project.davidphotostock.service.impl.ProductServiceImpl;
import com.project.davidphotostock.service.impl.ProvinceServiceImpl;
import com.project.davidphotostock.service.impl.ShipmentProductServiceImpl;
import com.project.davidphotostock.service.impl.ShipmentServiceImpl;
import com.project.davidphotostock.service.impl.SubcategoryServiceImpl;
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
    CategoryService cs;
    SubcategoryService scs;
    ProductService ps;
    CcaaService cas;
    ProvinceService prs;
    MunicipalityService ms;
    ShipmentService ss;
    ShipmentProductService sps;
    
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
                default: 
                    this.listAll(request, response);
            }
        } else {
            this.listAll(request, response);
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
    private void listAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        IUsersDao iud = new IUsersDaoImpl(getInstance());
        us = new UsersServiceImpl(iud);        
        ICategoryDao icd = new ICategoryDaoImpl(getInstance());
        cs = new CategoryServiceImpl(icd);
        ISubcategoryDao isd = new ISubcategoryDaoImpl(getInstance());
        scs = new SubcategoryServiceImpl(isd);
        IProductDao ipd = new IProductDaoImpl(getInstance());
        ps = new ProductServiceImpl(ipd);
        ICcaaDao icad = new ICcaaDaoImpl(getInstance());
        cas = new CcaaServiceImpl(icad);        
        IProvinceDao iprd = new IProvinceDaoImpl(getInstance());
        prs = new ProvinceServiceImpl(iprd);
        IMunicipalityDao imd = new IMunicipalityDaoImpl(getInstance());
        ms = new MunicipalityServiceImpl(imd);
        IShipmentDao issd = new IShipmentDaoImpl(getInstance());
        ss = new ShipmentServiceImpl(issd);
        IShipmentProductDao ispd = new IShipmentProductDaoImpl(getInstance());
        sps = new ShipmentProductServiceImpl(ispd);
        
        
        List<Users> users = us.obtainAllUsers();
        List<Category> categories = cs.obtainAllCategories();
        List<Subcategory> subcategories = scs.obtainAllSubcategories();
        List<Product> products = ps.obtainAllProducts();
        List<Ccaa> ccaas = cas.obtainAllCcaa();        
        List<Province> provinces = prs.obtainAllProvinces();
        List<Municipality> municipalities = ms.obtainAllMunicipalities();       
        List<Shipment> shipments = ss.obtainAllShipments();
        List<ShipmentProduct> shipmentProducts = sps.obtainAllShipmentProducts();
        
        
        request.setAttribute("users", users);
        request.setAttribute("categories", categories);
        request.setAttribute("subcategories", subcategories);
        request.setAttribute("products", products);
        request.setAttribute("ccaas", ccaas);
        request.setAttribute("provinces", provinces);
        request.setAttribute("municipalities", municipalities);
        request.setAttribute("shipments", shipments);
        request.setAttribute("shipmentProducts", shipmentProducts);
        request.getRequestDispatcher("pages/admin/admin.jsp").forward(request, response);
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
