package com.example.desafio_spring_boot.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//Um usuário pode tanto criar novas postagem, como adicionar um comentário em qualquer postagem existente. As
//funcionalidades de editar e excluir, tanto postagem quanto comentários, só são permitidas
//a serem realizadas pelo usuário que criou a entidade em questão (pelo usuário com id correspondente)


//@ManyToOne -> Vários comentários podem ter o mesmo usuário autor
//Unidirecional -> apenas uma das entidades possui referencia para a outra

@Entity
@Table(name = "comentarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Comentário obrigatório")
    @Size(min = 3, message = "O conteúdo precisa ter no mínimo 3 caracteres, sem limite máximo")
    private String conteudo;

    @NotNull
    private LocalDateTime dataCriacao;

    @NotNull
    private LocalDateTime dataAtualizacao;

    //Vários comentários para 1 usuário (N:1)
    @NotNull
    @ManyToOne
    private Usuario autor;


    @NotNull
    @ManyToOne
    private Postagem postagem;

    public Comentario(String conteudo, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao, Usuario autor, Postagem postagem){
        this.conteudo = conteudo;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.autor = autor;
        this.postagem = postagem;
    }
}
