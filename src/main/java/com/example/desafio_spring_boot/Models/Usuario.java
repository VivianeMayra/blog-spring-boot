package com.example.desafio_spring_boot.Models;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@OneToMany (1:N) -> Um usuário pode ter vários comentários ou várias postagens:
//No Spring Boot o relacionamento entre usuário e comentário/postagem utilizamos notações @OneToMany e @ManyToOne para
// definir essa relação. O Usuário (@OneToMany) tem vários comentários associados a ele, e cada comentário (@ManyToOne)
// tem somente um usuário associado. Esta é a forma como a relação é definida no Spring Boot.

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor //Quando eu for atualizar preciso passar um id como parâmetro
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "{nome.obrigatorio}")
    private String nome;

    @NotBlank(message = "{sobrenome.obrigatorio}")
    private String sobrenome;


    @NotBlank(message = "{email.obrigatorio}")
    @Email
    private String email;

    @NotBlank(message = "{senha.obrigatoria}")
    @Size(min = 8, max = 15, message = "{senha.size.min8.max15}")
    private String senha;


    public Integer getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public String getSobrenome(){
        return sobrenome;
    }

    public String getEmail(){
        return email;
    }

    public String getSenha(){
        return senha;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }


    public Usuario(String nome, String sobrenome, String email, String senha){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
    }
}
