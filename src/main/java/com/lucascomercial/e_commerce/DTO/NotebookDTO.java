package com.lucascomercial.e_commerce.DTO;

import java.time.LocalDate;

public record NotebookDTO(String name, Double price,Integer stock, Double discount,String model , String  voltage, LocalDate warrantyPeriod,Integer storageCapacity,Double screenSize,String operatingSystem,String color,Float weight,String brandname) {

}
