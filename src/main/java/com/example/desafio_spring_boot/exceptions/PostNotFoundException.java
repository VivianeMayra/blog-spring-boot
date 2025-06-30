package com.example.desafio_spring_boot.exceptions;

public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(){super("Postagem não encontrada");}

    public PostNotFoundException(String message) {
        super(message);
    }
}
