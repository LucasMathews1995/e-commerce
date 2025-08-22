package com.lucascomercial.e_commerce.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lucascomercial.e_commerce.model.product.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name  = "tb_marca")
public class Brand {


    private String name;
    private String nacionality;
    @OneToMany
    @JsonBackReference
    private List<Product> product;


    
    public Brand(String name, String nacionality) {
        this.name = name;
        this.nacionality = nacionality;
        this.product = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNacionality() {
        return nacionality;
    }
    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }
    public List<Product> getProduct() {
        return product;
    }
    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public void addProduto(Product p){
    this.product.add(p);
    p.setBrand(this);

}
public void removeProduto(Product p){
    this.product.remove(p);
    p.setBrand(null);

}


}
