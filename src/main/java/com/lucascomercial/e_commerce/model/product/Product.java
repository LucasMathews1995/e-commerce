package com.lucascomercial.e_commerce.model.product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lucascomercial.e_commerce.exceptions.NotEnoughStock;
import com.lucascomercial.e_commerce.model.Brand;
import com.lucascomercial.e_commerce.model.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tb_product")
public  abstract class Product {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private Double price;
    private Integer stock;
    private double discount;
   @ManyToMany
private List<User> users = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name= "marca_id")
    @JsonBackReference
    private Brand brand;




    public Product( String name ,Double price, Integer stock, double discount) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.discount = discount;
        this.users = new ArrayList<>();
       
    }





    public Product(String name, Double price, Integer stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.users = new ArrayList<>();
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



public Brand getBrand() {
    return brand;
}





public void setBrand(Brand brand) {
    this.brand = brand;
}

    



    protected boolean verifyAvailability(){
        return this.stock > 0;
    } 



    public void sellProduct(int quantidade,User user){
       double total =  quantidade*getPrice();
        if(verifyAvailability() && user.getMoney()>=total){
            
            setStock(getStock()- quantidade);
        user.setMoney(user.getMoney()- total);

        }else if(verifyAvailability() && user.getMoney()>=total && user.isVip() ){
               setStock(getStock()- quantidade);
               user.setMoney(user.getMoney()-quantidade*discount());
        
        
        }
        
        else {
            throw new NotEnoughStock("Produto não tem estoque para ser vendido");
        }
    }

    public void buyProduct (int quantidade){
        setStock(getStock()+quantidade);
    }





protected Double discount(){
    return getPrice()*getDiscount();
}





public void addQuantidade (int quantity){
setStock(getStock()+quantity);
}

public void removeQuantidade(int quantity){
    if(getStock()>quantity){
        setStock(getStock()-quantity);}
    
}





public List<User> getUsers() {
    return users;
}





public void setUsers(List<User> users) {
    this.users = users;
}

public void addUsers(User user){
    this.users.add(user);
    user.getProduct().add(this);
}






    
    

}
