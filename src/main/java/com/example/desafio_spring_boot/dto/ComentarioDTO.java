package com.example.desafio_spring_boot.dto;

import java.time.LocalDateTime;

public class ComentarioDTO {
    private String conteudo;
    private LocalDateTime dataCriacao;
    private Integer autorId;
    private Integer postagemId;

    public String getConteudo(){
        return conteudo;
    }

    public LocalDateTime getDataCriacao(){
        return dataCriacao;
    }

    public Integer getAutorId(){
        return autorId;
    }

    public Integer getPostagemId(){
        return postagemId;
    }
}
