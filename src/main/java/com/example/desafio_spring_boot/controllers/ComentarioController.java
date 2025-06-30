package com.example.desafio_spring_boot.controllers;
import com.example.desafio_spring_boot.Models.Comentario;
import com.example.desafio_spring_boot.dto.ComentarioDTO;
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
    public void criarComentario(@RequestBody @Valid ComentarioDTO comentarioDTO){
        comentarioService.criar(comentarioDTO);
    }

    @GetMapping
    public List<Comentario> listarComentarios(){
        return comentarioService.listarTodas();
    }

    @GetMapping("{id}")
    public Comentario listarPorId(@PathVariable Integer id){
        return comentarioService.listarPorId(id);
    }

    @PatchMapping("/autor/{idAutor}/comment/{idComentario}")
    public Comentario atualizarComentario(@PathVariable Integer idAutor, @PathVariable Integer idComentario, @RequestBody ComentarioDTO comentarioDTO){
        return comentarioService.atualizar(idAutor, idComentario, comentarioDTO);
    }

    @DeleteMapping("/autor/{idAutor}/comment/{idComentario}")
    public void deletarComentario(@PathVariable Integer idAutor, @PathVariable Integer idComentario){
        comentarioService.deletar(idAutor, idComentario);
    }


}
