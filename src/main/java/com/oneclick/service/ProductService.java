package com.oneclick.service;

import com.oneclick.dao.ProductDAO;
import com.oneclick.model.Product;

import java.util.List;

public class ProductService {

    private ProductDAO productDAO = new ProductDAO();

    // ADD PRODUCT
    public boolean addProduct(Product product) {
        return productDAO.addProduct(product);
    }

    // GET ALL PRODUCTS
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    // GET PRODUCT BY ID
    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }
}