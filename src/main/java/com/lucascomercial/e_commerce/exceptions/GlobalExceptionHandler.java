package com.lucascomercial.e_commerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<String> handleUserExists(UserAlreadyExistException ex){

        return new ResponseEntity<>("Usuário já existe", HttpStatus.CONFLICT);

    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException ex ){

        return new ResponseEntity<>("Usuario não encontrado", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BrandNotFoundException.class)
    public ResponseEntity<String> handleBrandNotFound(BrandNotFoundException ex){
         return new ResponseEntity<>("Marca não encontrada", HttpStatus.BAD_REQUEST);
    }

 @ExceptionHandler(NotebookRequireParamsException.class)
    public ResponseEntity<String> handleNotebookParamNotFound(NotebookRequireParamsException ex){
         return new ResponseEntity<>("Notebook não encontrado", HttpStatus.BAD_REQUEST);
    }
 @ExceptionHandler(NotEnoughStock.class)
    public ResponseEntity<String> handleNoStock(BrandNotFoundException ex){
         return new ResponseEntity<>("Produto Sem Estoque", HttpStatus.BAD_REQUEST);
    }

   @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleNotFoundProduct(ProductNotFoundException ex){
         return new ResponseEntity<>("Notebook não encontrado", HttpStatus.BAD_REQUEST);
    }

}
