package com.example.desafio_spring_boot.repository;

import com.example.desafio_spring_boot.Models.Postagem;
import com.example.desafio_spring_boot.dto.PostagemDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Integer> {

    //A sintaxe deve seguir o padrão findBy[Relacionamento]_[Campo] quando estiver lidando com entidades relacionadas.
    //Spring Data entende isso e monta a query automaticamete
    //Tira a necessidade do @Query
    List<Postagem> findByAutor_Id(Integer id);

}
