package com.example.desafio_spring_boot.exceptions;

//Preciso que ela se comporte como uma exceção nativa do java mas minha mensagem personalizada
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(){super("Usuário não encontrado");}

    public UserNotFoundException(String message){super(message);}
}
