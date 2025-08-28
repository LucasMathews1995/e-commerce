package com.lucascomercial.e_commerce.model.product;

import java.time.LocalDate;

import java.time.temporal.ChronoUnit;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name= "tb_eletronics")
@PrimaryKeyJoinColumn(name = "product_id")
public  abstract class Eletronics extends Product {


    
    private String model;
    private String voltage; 
    private LocalDate warrantyPeriod;

public Eletronics(){
    
}
    
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getVoltage() {
        return voltage;
    }
    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }
   public LocalDate getWarrantyPeriod() {
        return warrantyPeriod;
    }
    public void setWarrantyPeriod(LocalDate warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }
    


    public Eletronics(String name,Double price, Integer stock, double discount, String model, String voltage,
            LocalDate warrantyPeriod) {
        super(name,price, stock, discount);
        this.model = model;
        this.voltage = voltage;
       this.warrantyPeriod = warrantyPeriod;
    }
    public Eletronics(String model, String voltage, LocalDate warrantyPeriod) {
        this.model = model;
        this.voltage = voltage;
        this.warrantyPeriod= warrantyPeriod;
        
    }
    public Eletronics(String name, Double price, Integer stock, String model, String voltage,
            LocalDate warrantyPeriod) {
        super(name, price, stock);
        this.model = model;
        this.voltage = voltage;
        this.warrantyPeriod = warrantyPeriod;
     
    }

    public boolean isOnWarranty(){
      LocalDate now = LocalDate.now();
    return warrantyPeriod.isBefore(now);
    } 


public String getRemainingWarrantyDays(){

   var diferenca = ChronoUnit.DAYS.between(LocalDate.now(), warrantyPeriod);
    if(diferenca>=0){return String.format("a garantia ainda tem %d dias", diferenca);}
    else {
        return String.format("já perdeu a garantia há: %d dias", diferenca);
    }
   
}

    
   

    

}
