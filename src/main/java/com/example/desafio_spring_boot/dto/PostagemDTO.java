package com.example.desafio_spring_boot.dto;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostagemDTO {
    private String titulo;
    private String conteudo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private Integer autorId;
}
