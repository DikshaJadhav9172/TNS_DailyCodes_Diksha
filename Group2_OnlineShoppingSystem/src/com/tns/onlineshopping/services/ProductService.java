package com.tns.onlineshopping.services;


import com.tns.onlineshopping.dao.ProductDAO;
import com.tns.onlineshopping.entities.Product;

import java.util.List;

public class ProductService {
    private ProductDAO productDAO = new ProductDAO();

    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    public void removeProduct(int productId) {
        productDAO.removeProduct(productId);
    }

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    public Product getProductById(int productId) {
        return productDAO.getProductById(productId);
    }

    public void updateStock(int productId, int stock) {
        productDAO.updateStock(productId, stock);
    }
}

