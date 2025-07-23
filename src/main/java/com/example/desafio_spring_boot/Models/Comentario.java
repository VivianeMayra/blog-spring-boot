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

//Um usuário pode tanto criar novas postagem, como adicionar um comentário em qualquer postagem existente. [OK]
// As funcionalidades de editar e excluir, tanto postagem quanto comentários, só são permitidas
//a serem realizadas pelo usuário que criou a entidade em questão (pelo usuário com id correspondente)


//@ManyToOne -> Vários comentários podem ter o mesmo usuário autor
//Unidirecional -> apenas uma das entidades possui referencia para a outra

@Entity
@Table(name = "comentarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "{conteudo.obrigatorio}")
    @Size(min = 3, message = "{conteudo.size.min3}")
    @Setter
    private String conteudo;

    @NotNull
    private LocalDateTime dataCriacao;

    @Setter
    private LocalDateTime dataAtualizacao;

    //Vários comentários para 1 usuário (N:1)
    @NotNull
    @ManyToOne
    private Usuario autor;

    //Vários comentários para 1 postagem (N:1)
    @NotNull
    @ManyToOne
    private Postagem postagem;

    public Comentario(String conteudo, LocalDateTime dataCriacao, Usuario autor, Postagem postagem){
        this.conteudo = conteudo;
        this.dataCriacao = dataCriacao;
        this.autor = autor;
        this.postagem = postagem;
    }
}
