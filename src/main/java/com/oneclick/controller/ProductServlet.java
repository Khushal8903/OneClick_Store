package com.oneclick.controller;

import com.oneclick.model.Product;
import com.oneclick.service.ProductService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    private ProductService productService = new ProductService();

    // ADD PRODUCT
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setStock(stock);

        boolean result = productService.addProduct(product);

        if (result) {
            response.sendRedirect("product");
        } else {
            response.getWriter().println("Product Not Added");
        }
    }

    // LIST PRODUCTS
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException, jakarta.servlet.ServletException {

        List<Product> products = productService.getAllProducts();

        request.setAttribute("products", products);

        request.getRequestDispatcher(
                "views/product/products.jsp"
        ).forward(request, response);
    }
}