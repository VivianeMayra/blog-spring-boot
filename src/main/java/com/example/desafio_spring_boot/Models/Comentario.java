package com.example.desafio_spring_boot.Models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

//Um usuário pode tanto criar novas postagem, como adicionar um comentário em qualquer postagem existente. As
//funcionalidades de editar e excluir, tanto postagem quanto comentários, só são permitidas
//a serem realizadas pelo usuário que criou a entidade em questão (pelo usuário com id correspondente)


//@ManyToOne -> Vários comentários podem ter o mesmo usuário autor
//Unidirecional -> apenas uma das entidades possui referencia para a outra

@Entity
@Table(name = "comentarios")
@NoArgsConstructor
@AllArgsConstructor
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "{conteudo.obrigatorio}")
    @Size(min = 3, message = "{conteudo.size.min3}")
    private String conteudo;

    @NotNull
    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    //Vários comentários para 1 usuário (N:1)
    @NotNull
    @ManyToOne
    private Usuario autor;

    //Vários comentários para 1 postagem (N:1)
    @NotNull
    @ManyToOne
    private Postagem postagem;

    public Integer getId(){
        return id;
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

    public Usuario getAutor(){
        return autor;
    }

    public Postagem getPostagem(){
        return postagem;
    }

    public void setConteudo(String conteudo){
        this.conteudo = conteudo;
    }

    public void setDataCriacao(LocalDateTime dataCriacao){
        this.dataCriacao = dataCriacao;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public void setPostagem(Postagem postagem){
        this.postagem = postagem;
    }

    public Comentario(String conteudo, LocalDateTime dataCriacao, Usuario autor, Postagem postagem){
        this.conteudo = conteudo;
        this.dataCriacao = dataCriacao;
        this.autor = autor;
        this.postagem = postagem;
    }
}
