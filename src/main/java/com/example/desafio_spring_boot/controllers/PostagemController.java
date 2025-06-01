package com.example.desafio_spring_boot.controllers;

import com.example.desafio_spring_boot.Models.Postagem;
import com.example.desafio_spring_boot.Models.Usuario;
import com.example.desafio_spring_boot.services.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postagens")
public class PostagemController {

    @Autowired
    PostagemService postagemService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void criarPostagem(@RequestBody Postagem postagem){
        postagemService.criar(postagem);
    }

    @GetMapping
    public List<Postagem> listarPostagens(){
        return postagemService.listarTodas();
    }

    @GetMapping("/{id}")
    public Postagem listarPorId(@PathVariable Integer id){
        return postagemService.listarPorAutor(id);
    }


}
