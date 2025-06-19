package com.example.desafio_spring_boot.exceptions;

public class CommentNotFoundException extends RuntimeException {

    public CommentNotFoundException(){super("Comentário não encontrado");}
    public CommentNotFoundException(String message) {
        super(message);
    }
}
