package com.lucascomercial.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucascomercial.e_commerce.model.product.Notebook;


public interface NotebookRepository extends JpaRepository<Notebook,Long> {

}
