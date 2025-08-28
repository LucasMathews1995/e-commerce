package com.lucascomercial.e_commerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucascomercial.e_commerce.model.Brand;

public interface BrandRepository  extends JpaRepository<Brand,Long>{

    public Optional<Brand> findByName(String name);


}
