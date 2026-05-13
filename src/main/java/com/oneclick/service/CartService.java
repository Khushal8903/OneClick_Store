package com.oneclick.service;

import com.oneclick.dao.CartDAO;
import com.oneclick.model.Cart;

import java.util.List;

public class CartService {

    private CartDAO cartDAO = new CartDAO();

    // ADD TO CART
    public boolean addToCart(Cart cart) {
        return cartDAO.addToCart(cart);
    }

    // GET CART ITEMS
    public List<Cart> getCartItems(int customerId) {
        return cartDAO.getCartItems(customerId);
    }
}