package com.lucascomercial.e_commerce.model;

import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lucascomercial.e_commerce.model.product.Product;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name  = "tb_brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String nationality;
    
    
    @OneToMany(mappedBy= "brand",cascade = CascadeType.ALL,orphanRemoval = true) 
    @JsonManagedReference
    private List<Product> product;

    public Brand(){
        
    }
    
    public Brand(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
        this.product = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNacionality() {
        return nationality;
    }
    public void setNacionality(String nacionality) {
        this.nationality = nacionality;
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

public void removeProducts(List<Product> productsToRemove){

    this.product.removeAll(productsToRemove);
    productsToRemove.stream().forEach(x-> x.setBrand(null));


}
    



public int getTotalProducts(){
    return product.size();
}



public void clearProducts(){
    this.product.clear();
}
public long getId() {
    return id;
}
public void setId(long id) {
    this.id = id;
}





}
