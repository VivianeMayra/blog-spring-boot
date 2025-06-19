package com.example.desafio_spring_boot.services;

import com.example.desafio_spring_boot.Models.Comentario;
import com.example.desafio_spring_boot.Models.Postagem;
import com.example.desafio_spring_boot.Models.Usuario;
import com.example.desafio_spring_boot.dto.ComentarioDTO;
import com.example.desafio_spring_boot.exceptions.CommentNotFoundException;
import com.example.desafio_spring_boot.exceptions.PostNotFoundException;
import com.example.desafio_spring_boot.exceptions.UserNotFoundException;
import com.example.desafio_spring_boot.repository.ComentarioRepository;
import com.example.desafio_spring_boot.repository.PostagemRepository;
import com.example.desafio_spring_boot.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComentarioService {
    private final ComentarioRepository comentarioRepository;
    private final UsuarioRepository usuarioRepository;
    private final PostagemRepository postagemRepository;

    public void criar(ComentarioDTO comentarioDTO){
        Usuario autor = usuarioRepository.findById(comentarioDTO.getAutorId()).orElseThrow(
                () -> new UserNotFoundException("Usuário com Id:" + comentarioDTO.getAutorId() + " não encontrado."));


        Postagem postagem = postagemRepository.findById(comentarioDTO.getPostagemId()).orElseThrow(
                () -> new PostNotFoundException("Postagem com Id: " + comentarioDTO.getPostagemId() + " não encontrado."));

        Comentario comentario = new Comentario();
        comentario.setConteudo(comentarioDTO.getConteudo());
        comentario.setDataCriacao(comentarioDTO.getDataCriacao());
        comentario.setAutor(autor);
        comentario.setPostagem(postagem);

        comentarioRepository.save(comentario);
    }

    public List<Comentario> listarTodas(){
        return comentarioRepository.findAll();
    }

    public Comentario listarPorId(Integer id){
        return comentarioRepository.findById(id).orElseThrow(() ->
                new CommentNotFoundException("Comentário com Id:" + id + " não encontrado."));
    }

    public Comentario atualizar(Integer idAutor,Integer idComentario, ComentarioDTO comentarioDTO){

        Comentario comentario =listarPorId(idComentario);

        if(comentario.getAutor().getId() == idAutor){
            comentario.setConteudo(comentarioDTO.getConteudo());
            comentario.setDataAtualizacao(comentarioDTO.getDataAtualizacao());
        }

        return comentarioRepository.save(comentario);
    }

    public void deletar(Integer idAutor, Integer idComentario){
        Comentario comentario = listarPorId(idComentario);

        if(comentario.getAutor().getId() == idAutor){
            comentarioRepository.delete(comentario);
        }
    }
}
