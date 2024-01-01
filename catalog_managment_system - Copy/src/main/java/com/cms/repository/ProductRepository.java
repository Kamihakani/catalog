package com.cms.repository;

import com.cms.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
Product searchByName(String name);
List<Product> searchByBrand(String brand); //FILTERING BRAND DATA
}
