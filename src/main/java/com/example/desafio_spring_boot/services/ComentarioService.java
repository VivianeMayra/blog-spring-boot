package com.example.desafio_spring_boot.services;

import com.example.desafio_spring_boot.Models.Comentario;
import com.example.desafio_spring_boot.Models.Postagem;
import com.example.desafio_spring_boot.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    @Autowired
    ComentarioRepository comentarioRepository;

    public void criar(Comentario comentario){
        comentarioRepository.save(comentario);
    }

    public List<Comentario> listarTodas(){
        return comentarioRepository.findAll();
    }
}
