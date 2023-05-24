package com.project.davidphotostock.web;

import com.project.davidphotostock.data.IProductDao;
import com.project.davidphotostock.data.impl.IProductDaoImpl;
import com.project.davidphotostock.domain.Product;
import com.project.davidphotostock.domain.Subcategory;
import com.project.davidphotostock.service.ProductService;
import com.project.davidphotostock.service.impl.ProductServiceImpl;
import static com.project.davidphotostock.util.ConectionUtil.getInstance;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"/ProductServlet"})
public class ProductServlet extends HttpServlet {

    ProductService ps;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        System.out.println("ACtiiion" + action);
        // Chequear si el usuario quiere ver todos los productos
        if (action != null && action.equals("allProduct")) {
            this.showAllProduct(request, response);
        } else {
            // Si no, delegar a doPost como antes
            doPost(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "create":
                    this.signUpProduct(request, response);
                    break;
                case "update":
                    this.updateProduct(request, response);
                    break;
                case "delete":
                    this.deleteProduct(request, response);
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

    private void showAllProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        IProductDao ipd = new IProductDaoImpl(getInstance());

        ps = new ProductServiceImpl(ipd);

        List<Product> products = ps.obtainAllProducts();

        System.out.println("Lista de productos" + products);
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("pages/users/portfolio.jsp");
        dispatcher.forward(request, response);
    }

    private void signUpProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
        IProductDao ipd = new IProductDaoImpl(getInstance());
        
        ps = new ProductServiceImpl(ipd);
        
        String name = request.getParameter("name-product");
        int stock = Integer.parseInt(request.getParameter("stock"));
        BigDecimal price = new BigDecimal(request.getParameter("price"));
        Integer idSub = Integer.parseInt(request.getParameter("id-subcategory"));
                
        Product product = new Product(name, stock, price, idSub);
        
        if (!ps.createProduct(product)){
            request.getSession().setAttribute("errorActive", true);
            request.getRequestDispatcher("includes/forms/errorPage.jsp").forward(request, response);
        }
        response.sendRedirect("pages/admin/admin.jsp");
         */
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("portfolio.jsp");
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("portfolio.jsp");
    }

}
