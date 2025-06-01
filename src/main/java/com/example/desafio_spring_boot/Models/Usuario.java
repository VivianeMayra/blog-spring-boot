package com.example.desafio_spring_boot.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//@OneToMany (1:N) -> Um usuário pode ter vários comentários ou várias postagens:
//No Spring Boot o relacionamento entre usuário e comentário/postagem utilizamos notações @OneToMany e @ManyToOne para
// definir essa relação. O Usuário (@OneToMany) tem vários comentários associados a ele, e cada comentário (@ManyToOne)
// tem somente um usuário associado. Esta é a forma como a relação é definida no Spring Boot.

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor //Quando eu for atualizar preciso passar um id como parâmetro
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Nome obrigatório para registro")
    private String nome;

    @NotBlank(message = "Sobrenome obrigatório para registro")
    private String sobrenome;

    @NotBlank(message = "Email obrigatório para registro")
    @Email
    private String email;

    @NotBlank(message = "Senha obrigatório para registro")
    @Size(min = 8,max = 15,message = "A senha precisa ter entre 8 a 15 caracteres")
    private String senha;

    public Usuario(String nome, String sobrenome, String email, String senha){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
    }
}
