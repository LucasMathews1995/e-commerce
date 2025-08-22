package com.lucascomercial.e_commerce.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lucascomercial.e_commerce.exceptions.ProdutoEstoqueException;
import com.lucascomercial.e_commerce.model.Brand;
import com.lucascomercial.e_commerce.model.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public  abstract class Product {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private Double price;
    private String description;
    private Integer stock;
    private double discount;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
    @ManyToOne
    @JoinColumn(name= "marca_id")
    @JsonBackReference
    private Brand brand;




    public Product( Double price, Integer stock, double discount) {
        this.price = price;
        this.stock = stock;
        this.discount = discount;
    }





    public Product() {
    }





    public long getId() {
        return id;
    }





    public void setId(long id) {
        this.id = id;
    }





    public String getName() {
        return name;
    }





    public void setName(String nome) {
        this.name = nome;
    }





    public Double getPrice() {
        return price;
    }





    public void setPrice(Double preco) {
        this.price = preco;
    }





    public String getDescription() {
        return description;
    }





    public void setDescription(String descricao) {
        this.description = descricao;
    }





    public Integer getStock() {
        return stock;
    }





    public void setStock(Integer estoque) {
        this.stock = estoque;
    }





    public double getDiscount() {
        return discount;
    }





    public void setDiscount(double desconto) {
        this.discount = desconto;
    }





    protected boolean verifyAvailability(){
        return this.stock > 0;
    } 



    public void sellProduct(int quantidade){
       double total =  quantidade*getPrice();
        if(verifyAvailability() && user.getMoney()>=total){
            
            setStock(getStock()- quantidade);
        user.setMoney(user.getMoney()- total);

        }else if(verifyAvailability() && user.getMoney()>=total && user.isVip() ){
               setStock(getStock()- quantidade);
               user.setMoney(user.getMoney()-quantidade*discount());
        
        
        }
        
        else {
            throw new ProdutoEstoqueException("Produto não tem estoque para ser vendido");
        }
    }

    public void buyProduct (int quantidade){
        setStock(getStock()+quantidade);
    }





    public User getUser() {
        return user;
    }





    public void setUser(User user) {
        this.user = user;
    }

protected Double discount(){
    return getPrice()*getDiscount()/100;
}





public Brand getBrand() {
    return brand;
}





public void setBrand(Brand brand) {
    this.brand = brand;
}


    
    

}
