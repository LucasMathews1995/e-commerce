package com.lucascomercial.e_commerce.model.product;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
@Entity
@Table(name= "tb_washingmachine")
@PrimaryKeyJoinColumn(name= "eletronicss_id")
public class WashingMachine  extends Eletronics{

  
    private Integer weight;

    private Integer rpm;

    private String  energyEfficiency;

    private String color;

    private Integer washingPrograms;

    

    public WashingMachine(String name, Double price, Integer stock, String model, String voltage,
            LocalDate warrantyPeriod, Integer weight, Integer rpm, String energyEfficiency, String color,
            Integer washingPrograms) {
        super(name, price, stock, model, voltage, warrantyPeriod);
        this.weight = weight;
        this.rpm = rpm;
        this.energyEfficiency = energyEfficiency;
        this.color = color;
        this.washingPrograms = washingPrograms;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getRpm() {
        return rpm;
    }

    public void setRpm(Integer rpm) {
        this.rpm = rpm;
    }

    public String getEnergyEfficiency() {
        return energyEfficiency;
    }

    public void setEnergyEfficiency(String energyEfficiency) {
        this.energyEfficiency = energyEfficiency;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWashingPrograms() {
        return washingPrograms;
    }

    public void setWashingPrograms(Integer washingPrograms) {
        this.washingPrograms = washingPrograms;
    }



public String getSpecifications(){
return String.format("Washing weighs: %dkg %Efficency: %s%nColor : %s", getWeight(),getEnergyEfficiency(),getColor());

}

}
