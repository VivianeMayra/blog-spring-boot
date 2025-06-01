package com.example.desafio_spring_boot.services;

import com.example.desafio_spring_boot.Models.Postagem;
import com.example.desafio_spring_boot.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostagemService {

    @Autowired
    PostagemRepository postagemRepository;

    public void criar(Postagem postagem){
        postagemRepository.save(postagem);
    }

    public List<Postagem> listarTodas(){
        return postagemRepository.findAll();
    }

    public Postagem listarPorAutor(Integer id){
        Optional<Postagem> optional = postagemRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }





}
