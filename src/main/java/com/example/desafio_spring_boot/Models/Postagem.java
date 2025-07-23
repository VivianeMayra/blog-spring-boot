package com.example.desafio_spring_boot.Models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "postagens")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Postagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "{titulo.obrigatorio}")
    @Size(min = 3,max = 255,message = "{titulo.size.min3.max255}")
    @Setter
    private String titulo;

    @NotBlank(message = "{conteudo.obrigatorio}")
    @Size(min = 3, message = "{conteudo.size.min3}")
    @Setter
    private String conteudo;

    @Setter
    private LocalDateTime dataAtualizacao;

    @NotNull
    private LocalDateTime dataCriacao;

    //Muitas postagens para somente 1 usuário
    @NotNull(message = "{usuarioId.obrigatorio}")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario autor;

    public Postagem(String titulo, String conteudo ,LocalDateTime dataCriacao,Usuario autor){
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.dataCriacao = dataCriacao;
        this.autor = autor;
    }
}
