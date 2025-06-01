package com.example.desafio_spring_boot.repository;

import com.example.desafio_spring_boot.Models.Postagem;
import com.example.desafio_spring_boot.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Integer> {
}
