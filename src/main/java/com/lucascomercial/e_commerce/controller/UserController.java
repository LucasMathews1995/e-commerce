package com.lucascomercial.e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucascomercial.e_commerce.DTO.UserDTO;

import com.lucascomercial.e_commerce.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

@Autowired
private UserService service;



@PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody UserDTO userDTO){
String message =service.saveUser(userDTO);

return new ResponseEntity<>(message,HttpStatus.ACCEPTED);

    
}
}