package com.lucascomercial.e_commerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucascomercial.e_commerce.exceptions.BrandNotFoundException;
import com.lucascomercial.e_commerce.exceptions.NotEnoughStock;
import com.lucascomercial.e_commerce.exceptions.ProductNotFoundException;
import com.lucascomercial.e_commerce.exceptions.UserNotFoundException;
import com.lucascomercial.e_commerce.model.Brand;
import com.lucascomercial.e_commerce.model.User;
import com.lucascomercial.e_commerce.model.product.Product;
import com.lucascomercial.e_commerce.repository.BrandRepository;
import com.lucascomercial.e_commerce.repository.ProductRepository;
import com.lucascomercial.e_commerce.repository.UserRepository;
@Service
public class ProductService {
@Autowired
private ProductRepository repository;

@Autowired 
private BrandRepository brandRepository;


@Autowired 
private UserRepository userRepository;
public String addBrand(String nameBrand,String nameProduct){

Brand brand = brandRepository.findByName(nameBrand).orElseThrow(()-> new BrandNotFoundException("não há marca desse tipo"));
Product product = repository.findByName(nameProduct).orElseThrow(()-> new NotEnoughStock("não há produto com esse nome em estoque"));

    product.setBrand(brand);
    repository.save(product);

    return String.format("A marca %s associou ao produto :%s", brand.getName(),product.getName());

}

public String sellProduct (Long id , String name,int quantidade){
if(id!=null && name!=null){
    User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
    Optional<Product> product = repository.findByName(name);
    Product productSaved = product.get();
    productSaved.addUsers(user);
    productSaved.sellProduct(1,user);
    repository.save(productSaved);
    
    
    return String.format("Parabéns  %s por adquirir %s ", user.getNome(),product.get().getName());
}else {
    return "insira  o valor correto";
}


}


public String addStock (String nameproduct, Integer quantity){

    Product p = repository.findByName(nameproduct).orElseThrow(()-> new ProductNotFoundException(nameproduct));
        p.addQuantidade(quantity);
        repository.save(p);
        return String.format("Foram adicionadas mais %d ao estoque de %s ", quantity,nameproduct);
}   
}