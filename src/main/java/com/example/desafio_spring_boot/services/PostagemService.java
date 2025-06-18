package com.example.desafio_spring_boot.services;

import com.example.desafio_spring_boot.Models.Postagem;
import com.example.desafio_spring_boot.Models.Usuario;
import com.example.desafio_spring_boot.dto.PostagemDTO;
import com.example.desafio_spring_boot.exceptions.UserNotFoundException;
import com.example.desafio_spring_boot.repository.PostagemRepository;
import com.example.desafio_spring_boot.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostagemService {

    private final PostagemRepository postagemRepository;
    private final UsuarioRepository usuarioRepository;

    public void criar(PostagemDTO postagemDTO){
        Usuario usuario = usuarioRepository.findById(postagemDTO.getAutorId()).orElseThrow(
                ()->new UserNotFoundException("Usuário com Id:" + postagemDTO.getAutorId() + " não encontrado.")
        );

        Postagem postagem = new Postagem();
        postagem.setTitulo(postagemDTO.getTitulo());
        postagem.setConteudo(postagemDTO.getConteudo());
        postagem.setDataCriacao(postagemDTO.getDataCriacao());
        postagem.setAutor(usuario);

        postagemRepository.save(postagem);
    }

    public List<Postagem> listarTodas(){
        return postagemRepository.findAll();
    }

    public List<Postagem> listarPorIdAutor(Integer id){
        return postagemRepository.findByAutor_Id(id);
    }

}
