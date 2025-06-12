package com.example.desafio_spring_boot.Models;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "postagens")
@NoArgsConstructor
@AllArgsConstructor
public class Postagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "{titulo.obrigatorio}")
    @Size(min = 3,max = 255,message = "{titulo.size.min3.max255}")
    private String titulo;

    @NotBlank(message = "{conteudo.obrigatorio}")
    @Size(min = 3, message = "{conteudo.size.min3}")
    private String conteudo;

    private LocalDateTime dataAtualizacao;

    @NotNull
    private LocalDateTime dataCriacao;

    //Muitas postagens para somente 1 usuário
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario autor;

    public Integer getId(){
        return id;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getConteudo(){
        return conteudo;
    }

    public LocalDateTime getDataCriacao(){
        return dataCriacao;
    }

    public LocalDateTime getDataAtualizacao(){return dataAtualizacao;}

    public Usuario getAutor (){
        return autor;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setConteudo( String conteudo){
        this.conteudo = conteudo;
    }

    public void setDataCriacao( LocalDateTime dataCriacao){
        this.dataCriacao = dataCriacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao){
        this.dataAtualizacao = dataAtualizacao;
    }

    public void setAutor(Usuario autor){
        this.autor = autor;
    }

    public Postagem(String titulo, String conteudo ,LocalDateTime dataCriacao,Usuario autor){
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.dataCriacao = dataCriacao;
        this.autor = autor;
    }
}
