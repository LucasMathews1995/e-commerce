package com.lucascomercial.e_commerce.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucascomercial.e_commerce.DTO.BrandDTO;
import com.lucascomercial.e_commerce.model.Brand;
import com.lucascomercial.e_commerce.repository.BrandRepository;

@Service
public class BrandService {




    @Autowired 
    private BrandRepository repository;

    public Brand addBrand(BrandDTO brand){

     Brand brand2  =  new Brand(brand.name(), brand.nationality());
        repository.save(brand2);
return brand2;
      
    }


    public String addAllBrand (List<BrandDTO> brandDTO){
        List<Brand> brand = brandDTO.stream().map((it)-> new Brand(it.name(),it.nationality())).toList();
   repository.saveAll(brand);
return "todos Salvos";
      
    }
}
