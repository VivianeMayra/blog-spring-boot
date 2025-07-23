package com.example.desafio_spring_boot.Models;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@OneToMany (1:N) -> Um usuário pode ter vários comentários ou várias postagens:
//No Spring Boot o relacionamento entre usuário e comentário/postagem utilizamos notações @OneToMany e @ManyToOne para
// definir essa relação. O Usuário (@OneToMany) tem vários comentários associados a ele, e cada comentário (@ManyToOne)
// tem somente um usuário associado. Esta é a forma como a relação é definida no Spring Boot.

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor //Quando eu for atualizar preciso passar um id como parâmetro
@Getter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
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
}
