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
import com.project.davidphotostock.domain.Product;
import com.project.davidphotostock.domain.Subcategory;
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
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"/ProductServlet"})
public class ProductServlet extends HttpServlet {

    ProductService ps;
    CategoryService cs;
    SubcategoryService ss;
    
    UsersService us;
    CcaaService cas;
    ProvinceService prs;
    MunicipalityService ms;
    ShipmentService shs;
    ShipmentProductService sps;
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        
        // Chequear si el usuario quiere ver todos los productos
        if (action != null && action.equals("allProduct")) {
            this.showAllProduct(request, response);
        } else {
            // Si no, delegar a doPost
            doPost(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        
        if (action != null) {
            switch (action) {                
                case "addCart":
                    this.addCart(request, response);
                    break;
                case "removeCart":
                    this.removeCart(request, response);
                    break;
                case "checkout":
                    this.checkout(request, response);
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

        response.sendRedirect("pages/users/portfolio.jsp");
    }

    private void showAllProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        IProductDao ipd = new IProductDaoImpl(getInstance());
        ps = new ProductServiceImpl(ipd);
        
        ICategoryDao icd = new ICategoryDaoImpl(getInstance());
        cs = new CategoryServiceImpl(icd);

        ISubcategoryDao isd = new ISubcategoryDaoImpl(getInstance());
        ss = new SubcategoryServiceImpl(isd);
        
        List<Product> products = ps.obtainAllProducts();
        List<Category> categories = cs.obtainAllCategories();
        List<Subcategory> subcategories = ss.obtainAllSubcategories();
        
        request.setAttribute("products", products);
        request.setAttribute("categories", categories);
        request.setAttribute("subcategories", subcategories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/users/portfolio.jsp");
        dispatcher.forward(request, response);
    }

    private void addCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        List<Product> cart = (List<Product>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        String idProduct = request.getParameter("idProduct");

        if (idProduct != null && !idProduct.trim().equals("")) {
            int productId = Integer.parseInt(idProduct);
            Product product = ps.obtainProductById(productId);
            if (product != null) {
                cart.add(product);
            }
        }
        session.setAttribute("cart", cart);
        
        showAllProduct(request, response);
    }
    
    private void removeCart(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();

        List<Product> cart = (List<Product>) session.getAttribute("cart");
        
        String idProduct = request.getParameter("idProduct");
        
        if (idProduct != null && !idProduct.trim().equals("")) {
            int productId = Integer.parseInt(idProduct);
            cart.remove(productId);
        }
        session.setAttribute("cart", cart);
        
        String view = request.getParameter("view");
        
        if (view != null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("pages/users/cart.jsp");
            dispatcher.forward(request, response);
        } else {
            showAllProduct(request, response);
        }
        
    }
    
    private void checkout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        IUsersDao iud = new IUsersDaoImpl(getInstance());
        us = new UsersServiceImpl(iud);        
        ICategoryDao icd = new ICategoryDaoImpl(getInstance());
        cs = new CategoryServiceImpl(icd);
        ISubcategoryDao isd = new ISubcategoryDaoImpl(getInstance());
        ss = new SubcategoryServiceImpl(isd);
        IProductDao ipd = new IProductDaoImpl(getInstance());
        ps = new ProductServiceImpl(ipd);
        ICcaaDao icad = new ICcaaDaoImpl(getInstance());
        cas = new CcaaServiceImpl(icad);        
        IProvinceDao iprd = new IProvinceDaoImpl(getInstance());
        prs = new ProvinceServiceImpl(iprd);
        IMunicipalityDao imd = new IMunicipalityDaoImpl(getInstance());
        ms = new MunicipalityServiceImpl(imd);
        IShipmentDao issd = new IShipmentDaoImpl(getInstance());
        shs = new ShipmentServiceImpl(issd);
        IShipmentProductDao ispd = new IShipmentProductDaoImpl(getInstance());
        sps = new ShipmentProductServiceImpl(ispd);
        
        
        
    }

}
