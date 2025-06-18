package com.example.desafio_spring_boot.controllers;

import com.example.desafio_spring_boot.Models.Postagem;
import com.example.desafio_spring_boot.dto.PostagemDTO;
import com.example.desafio_spring_boot.services.PostagemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postagens")
@RequiredArgsConstructor
public class PostagemController {

    private final PostagemService postagemService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void criarPostagem(@RequestBody @Valid PostagemDTO postagemDTO){
        postagemService.criar(postagemDTO);
    }

    @GetMapping
    public List<Postagem> listarTodasPostagens(){
        return postagemService.listarTodas();
    }

    @GetMapping("/autor/{id}")
    public List<Postagem> listarPorAutor(@PathVariable Integer id){
        return postagemService.listarPorIdAutor(id);
    }
}
