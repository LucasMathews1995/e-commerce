package com.lucascomercial.e_commerce.model.product;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
@Entity
@Table(name = "tb_notebook")
@PrimaryKeyJoinColumn(name = "eletronics_id")
public class Notebook extends Eletronics{


    private Integer storageCapacity;
    private Double screenSize;
    private String operatingSystem;
    private String color;
    private Float weight;


    public Notebook(){
        super();
    }

    public Notebook(String name, Double price,Integer stock, Double discount,String model , String  voltage, LocalDate warrantyPeriod,Integer storageCapacity,Double screenSize,String operatingSystem,String color,Float weight) {
        super(name, price, stock, discount, model, voltage, warrantyPeriod);
        this.storageCapacity = storageCapacity;
        this.screenSize = screenSize;
        this.operatingSystem = operatingSystem;
        this.color = color;
        this.weight = weight;
    }




    


    public Integer getStorageCapacity() {
        return storageCapacity;
    }



    public void setStorageCapacity(Integer storageCapacity) {
        this.storageCapacity = storageCapacity;
    }



    public Double getScreenSize() {
        return screenSize;
    }



    public void setScreenSize(Double screenSize) {
        this.screenSize = screenSize;
    }



    public String getOperatingSystem() {
        return operatingSystem;
    }



    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }



    public String getColor() {
        return color;
    }



    public void setColor(String color) {
        this.color = color;
    }



    public Float getWeight() {
        return weight;
    }



    public void setWeight(Float weight) {
        this.weight = weight;
    }
    public String getSpecifications(){
return String.format("Notebook contains: %dGB%nScreenSize: %.1f%nColor : %s", getStorageCapacity(),getScreenSize(),getColor());
    }
    


}
