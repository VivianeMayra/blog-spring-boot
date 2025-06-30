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

    @GetMapping("{id}")
    public Postagem listarPorId(@PathVariable Integer id){
        return  postagemService.listarPorId(id);
    }

    @GetMapping("/autor/{id}")
    public List<Postagem> listarPorAutor(@PathVariable Integer id){
        return postagemService.listarPorIdAutor(id);
    }

    @PatchMapping("/autor/{idAutor}/post/{idPost}")
    public Postagem atualizarPostagem(@PathVariable Integer idAutor, @PathVariable  Integer idPost, @RequestBody PostagemDTO postagemDTO ){
        return postagemService.atualizarPost(idAutor,idPost,postagemDTO);
    }

    @DeleteMapping("/autor/{idAutor}/post/{idPost}")
    public void deletarPost(@PathVariable Integer idAutor, @PathVariable  Integer idPost){
        postagemService.deletarPostagem(idAutor, idPost);
    }
}
