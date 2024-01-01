package com.cms.controller;
import com.cms.entity.Product;
import com.cms.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    Logger logger= LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductService productService;
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product product1 = productService.createProduct(product);
        logger.info("Name{}",product.getName());
        logger.info("Brand{}",product.getBrand());
        logger.info("Category{}",product.getCategory());
        logger.info("price{}",product.getPrice());
        logger.info("Quatity{}",product.getQuantity());
        logger.info("Description{}",product.getDescription());
        logger.info("Date{}",product.getDateAdded());
        return new ResponseEntity<>(product1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
public ResponseEntity<Product> getProductById(@PathVariable("id") int id){
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }
    @GetMapping("/all")
    public List<Product> getAllProduct(){
        return  productService.getAllProducts();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") int id){
        productService.deleteProductById(id);
        return new ResponseEntity<String>("Product for given id deleted",HttpStatus.OK);
    }
@PutMapping("/{id}")
public ResponseEntity<Product> updateProduct(@PathVariable("id") int id,@RequestBody Product product){
    Product product1 = productService.updateProductById(id, product);
    return new ResponseEntity<>(product1,HttpStatus.OK);
}
    /////////////////////////////////////////////////
    @GetMapping("/name/{productName}")
    public Product searchProductByName(@PathVariable String productName)
    {
        return productService.searchProductByName(productName);
    }

    @GetMapping("/brand/{productBrand}")
    public List<Product> searchProductByBrand(@PathVariable String productBrand)
    {
        return productService.searchProductByBrand(productBrand);
    }
}

