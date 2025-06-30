package com.example.desafio_spring_boot.services;
import com.example.desafio_spring_boot.Models.Postagem;
import com.example.desafio_spring_boot.Models.Usuario;
import com.example.desafio_spring_boot.dto.PostagemDTO;
import com.example.desafio_spring_boot.exceptions.NotFoundException;
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
                ()->new NotFoundException("Usuário com Id:" + postagemDTO.getAutorId() + " não encontrado.")
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

    public Postagem listarPorId(Integer id){
        return postagemRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Postagem com Id:" + id + " não encontrado."));
    }

    public Postagem atualizarPost(Integer idAutor, Integer idPostagem, PostagemDTO postagemDTO){
        Postagem postagem = listarPorId(idPostagem);//Verifica se existe,seleciona o post exato e atribui ao modelo postagem

        if(postagem.getAutor().getId() == idAutor){
            postagem.setTitulo(postagemDTO.getTitulo());
            postagem.setConteudo(postagemDTO.getConteudo());
            postagem.setDataAtualizacao(postagemDTO.getDataAtualizacao());
        }

        return postagemRepository.save(postagem);
    }

    public void deletarPostagem(Integer idAutor, Integer idPostagem){
        Postagem postagem = listarPorId(idPostagem);

        if(postagem.getAutor().getId() == idAutor){
            postagemRepository.delete(postagem);
        }
    }

}