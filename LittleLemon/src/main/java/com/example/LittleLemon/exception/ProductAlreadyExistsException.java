package com.example.LittleLemon.exception;

public class ProductAlreadyExistsException extends RuntimeException{

    ProductAlreadyExistsException(String message){
        super(message);
    }
}
