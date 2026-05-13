package com.oneclick.controller;

import com.oneclick.model.Cart;
import com.oneclick.model.Customer;
import com.oneclick.service.CartService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    private CartService cartService = new CartService();

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession();
        Customer user = (Customer) session.getAttribute("user");

        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Cart cart = new Cart();
        cart.setCustomerId(user.getCustomerId());
        cart.setProductId(productId);
        cart.setQuantity(quantity);

        boolean result = cartService.addToCart(cart);

        if (result) {
            response.sendRedirect("views/cart/cart.jsp");
        } else {
            response.getWriter().println("Failed to add to cart");
        }
    }
}