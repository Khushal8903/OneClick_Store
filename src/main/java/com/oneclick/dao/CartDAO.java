package com.oneclick.dao;

import com.oneclick.model.Cart;
import com.oneclick.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {

    // ADD TO CART
    public boolean addToCart(Cart cart) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "INSERT INTO cart(customer_id,product_id,quantity) VALUES(?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, cart.getCustomerid());
            ps.setInt(2, cart.getProductid());
            ps.setInt(3, cart.getQuantity());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // GET CART ITEMS
    public List<Cart> getCartItems(int customerId) {

        List<Cart> cartList = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String query =
                    "SELECT * FROM cart WHERE customer_id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, customerId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Cart cart = new Cart();

                cart.setCartid(rs.getInt("cart_id"));
                cart.setCustomerid(rs.getInt("customer_id"));
                cart.setProductId(rs.getInt("product_id"));
                cart.setQuantity(rs.getInt("quantity"));

                cartList.add(cart);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cartList;
    }
}