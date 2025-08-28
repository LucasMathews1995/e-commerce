package com.lucascomercial.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.lucascomercial.e_commerce.model.product.Product;

import java.util.Optional;



public interface ProductRepository extends JpaRepository<Product,Long> {

    public Optional< Product>  findByName(String name);
 
}
