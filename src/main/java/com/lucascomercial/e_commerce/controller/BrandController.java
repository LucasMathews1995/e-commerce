package com.lucascomercial.e_commerce.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucascomercial.e_commerce.DTO.BrandDTO;
import com.lucascomercial.e_commerce.model.Brand;
import com.lucascomercial.e_commerce.service.BrandService;

@RestController
@RequestMapping("/api/brand/")
public class BrandController {
@Autowired
private BrandService brandService;


    @PostMapping("/save")
    public ResponseEntity<Brand> saveBrand(@RequestBody BrandDTO brand){

Brand savedBrand = brandService.addBrand(brand);
        URI location = ServletUriComponentsBuilder
        .fromCurrentRequestUri()
        .path("/{id}")
        .buildAndExpand(savedBrand.getId())
        .toUri();

    
    return ResponseEntity.created(location).body(savedBrand);
           
        
    }


    @PostMapping("/saveAll")
    public ResponseEntity<String> saveAllBrand (@RequestBody List<BrandDTO> brandDTOs){

      String message =   brandService.addAllBrand(brandDTOs);

        return new ResponseEntity<>(message,HttpStatus.ACCEPTED);
    }


    
    
 

}
