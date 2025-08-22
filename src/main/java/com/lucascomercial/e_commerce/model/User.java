package com.lucascomercial.e_commerce.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lucascomercial.e_commerce.model.product.Product;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "tb_user")
public class User {


    private String nome;
    private String cidade;
    private String email;
    private boolean isVip;
   @OneToMany(mappedBy= "produto",cascade = CascadeType.ALL,orphanRemoval = true) 
    @JsonManagedReference
    private List<Product> product;
    private Double money;
    


    public User(String nome, String cidade, String email, boolean isVip, Double money) {
        this.nome = nome;
        this.cidade = cidade;
        this.email = email;
        this.isVip = isVip;
        this.money = money;
        this.product = new ArrayList<>();
    }
    public Double getMoney() {
        return money;
    }
    public void setMoney(Double money) {
        this.money = money;
    }
   public String getNome() {
    return nome;
   }
   public void setNome(String nome) {
    this.nome = nome;
   }
   public String getCidade() {
    return cidade;
   }
   public void setCidade(String cidade) {
    this.cidade = cidade;
   }
   public String getEmail() {
    return email;
   }
   public void setEmail(String email) {
    this.email = email;
   }
  
   

   public List<Product> getProduct() {
    return product;
}
   public void setProduct(List<Product> produto) {
    this.product = produto;
   }


   public void addProduto(Product p){
    this.product.add(p);
    p.setUser(this);

}
public void removeProduto(Product p){
    this.product.remove(p);
    p.setUser(null);

}
public boolean isVip() {
    return isVip;
}
public void setVip(boolean isVip) {
    this.isVip = isVip;
}


    

}
