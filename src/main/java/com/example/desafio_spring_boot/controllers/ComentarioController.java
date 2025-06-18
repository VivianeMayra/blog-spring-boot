package com.example.desafio_spring_boot.controllers;
import com.example.desafio_spring_boot.Models.Comentario;
import com.example.desafio_spring_boot.services.ComentarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
@RequiredArgsConstructor
public class ComentarioController {

    private final ComentarioService comentarioService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void criarComentario(@RequestBody @Valid Comentario comentario){
        comentarioService.criar(comentario);
    }

    @GetMapping
    public List<Comentario> listarComentarios(){
        return comentarioService.listarTodas();
    }
}
