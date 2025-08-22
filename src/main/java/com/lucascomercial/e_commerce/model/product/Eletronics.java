package com.lucascomercial.e_commerce.model.product;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "product_id")
public class Eletronics extends Product {


    private String nome;
    


}
