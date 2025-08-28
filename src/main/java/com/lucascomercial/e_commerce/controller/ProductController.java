package com.lucascomercial.e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lucascomercial.e_commerce.exceptions.BrandNotFoundException;
import com.lucascomercial.e_commerce.exceptions.NotEnoughStock;
import com.lucascomercial.e_commerce.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
private ProductService service;



@PostMapping("/addBrand")
public ResponseEntity <String> addBrand(@RequestParam String namebrand,@RequestParam String nameproduct){



try {
    String message = service.addBrand(namebrand, nameproduct);
    return ResponseEntity.status(HttpStatus.CREATED).body(message);
} catch (NotEnoughStock e) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
}catch(BrandNotFoundException e ){
 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
}

}
@PostMapping("/sell")
public ResponseEntity<String> sellProduct(@RequestParam Long idUser, @RequestParam String nameproduct,@RequestParam  Integer quantity){


   String messsage = service.sellProduct(idUser,nameproduct,quantity);



  return new ResponseEntity<>(messsage,HttpStatus.ACCEPTED);
}

@PostMapping("/addStock")
public ResponseEntity<String> addStock (@RequestParam String nameproduct,@RequestParam Integer quantity){


    String message = service.addStock(nameproduct, quantity);
    return new ResponseEntity<>(message,HttpStatus.ACCEPTED);
}


}
