package com.example.desafio_spring_boot.controllers;

import com.example.desafio_spring_boot.Models.Comentario;
import com.example.desafio_spring_boot.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    ComentarioService comentarioService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void criarComentario(@RequestBody Comentario comentario){
        comentarioService.criar(comentario);
    }

    @GetMapping
    public List<Comentario> listarComentarios(){
        return comentarioService.listarTodas();
    }
}
