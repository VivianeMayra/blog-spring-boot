package com.example.desafio_spring_boot.dto;
import java.time.LocalDateTime;

public class PostagemDTO {
    private String titulo;
    private String conteudo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private Integer autorId;

    public String getTitulo(){
        return titulo;
    }

    public String getConteudo(){
        return conteudo;
    }

    public LocalDateTime getDataCriacao(){
        return dataCriacao;
    }

    public LocalDateTime getDataAtualizacao(){
        return dataAtualizacao;
    }

    public Integer getAutorId(){
        return autorId;
    }

}
