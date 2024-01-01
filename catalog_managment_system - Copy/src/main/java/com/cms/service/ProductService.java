package com.cms.service;

import com.cms.entity.Product;

import java.util.List;

public interface ProductService {
    public Product createProduct(Product product);
    public Product getProductById(int id);
    public List<Product> getAllProducts();
    public Product UpdatedProduct(int id, Product product);
    public void deleteProduct(int id);

    public Product getProductByName(String productName);

    void deleteProductById(int id);
    Product updateProductById(int id, Product product);

  ///////////////////////////////////////

    public Product searchProductByName(String name);
public List<Product> searchProductByBrand(String brand);   }
