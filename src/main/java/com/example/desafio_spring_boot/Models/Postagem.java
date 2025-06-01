package com.example.desafio_spring_boot.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "postagens")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Postagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "O título é obrigatório ser informado")
    @Size(min = 3,max = 255,message = "O título precisa ter no mínimo 3 caracteres e 255 no máximo")
    private String titulo;

    @NotBlank(message = "Conteúdo é obrigatório ser passado")
    @Size(min = 3, message = "O conteúdo precisa ter no mínimo 3 caracteres, sem limite máximo")
    private String conteudo;

    @NotNull
    private LocalDateTime dataCriacao;

    @NotNull
    private LocalDateTime dataAtualizacao;

    //Muitas postagens para somente 1 usuário
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario autor;

    public Postagem(String titulo, String conteudo ,LocalDateTime dataCriacao, LocalDateTime dataAtualizacao, Usuario autor){
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.autor = autor;
    }
}
