package com.cms.service.impl;

import com.cms.entity.Product;
import com.cms.repository.ProductRepository;
import com.cms.service.ProductService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
Logger logger=LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        logger.info("Name{}",product.getName());
        logger.info("Brand{}",product.getBrand());
        logger.info("Category{}",product.getCategory());
        logger.info("Price{}",product.getPrice());
        logger.info("Quatity{}",product.getQuantity());
        logger.info("Description{}",product.getDescription());
        logger.info("Date{}",product.getDateAdded());
        return productRepository.save(product);
    }
    @Override
    public Product getProductById(int id) {

return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));

    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product UpdatedProduct(int id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(int id) {

    }

    @Override
    public Product getProductByName(String productName) {
        return null;
    }

    @Override
    public void deleteProductById(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProductById(int id, Product product) {
        Product updatedProduct = productRepository.findById(id).get();
        updatedProduct.setName(product.getName());
        updatedProduct.setBrand(product.getBrand());
        updatedProduct.setCategory(product.getCategory());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setQuantity(product.getQuantity());
        updatedProduct.setDateAdded(product.getDateAdded());
        return productRepository.save(updatedProduct);
    }

    @Override
   public Product searchProductByName(String name){
        return productRepository.searchByName(name);
    }

    @Override
    public List<Product> searchProductByBrand(String brand) {
        return productRepository.searchByBrand(brand);
    }
}
