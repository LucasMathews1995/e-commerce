package com.lucascomercial.e_commerce.exceptions;

public class NotEnoughStock extends RuntimeException {
public NotEnoughStock(String message){
    super(message);
}
}
