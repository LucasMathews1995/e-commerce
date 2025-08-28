package com.lucascomercial.e_commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucascomercial.e_commerce.DTO.UserDTO;
import com.lucascomercial.e_commerce.model.User;
import com.lucascomercial.e_commerce.repository.UserRepository;

@Service
public class UserService {


@Autowired
private UserRepository repository;







public String saveUser(UserDTO userDTO){
    User user = new User(userDTO.nome(),userDTO.cidade(),userDTO.email(),false,userDTO.money());
    repository.save(user);


    return String.format("usuário salvo com o nome de %s", user.getNome());

}
}
