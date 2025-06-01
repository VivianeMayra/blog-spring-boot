package com.example.desafio_spring_boot.repository;

import com.example.desafio_spring_boot.Models.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,Integer> {
}
