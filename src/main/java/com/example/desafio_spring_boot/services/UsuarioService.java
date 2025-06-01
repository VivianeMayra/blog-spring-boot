package com.example.desafio_spring_boot.services;

import com.example.desafio_spring_boot.Models.Usuario;
import com.example.desafio_spring_boot.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public void criar(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    //Retorna uma lista de usuários
    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }

    //Retorna um Optional do tipo usuário
    //Optional é uma classe  e representa um container que pode ou não conter um valor não nulo (diferente de null).
    //Evita NullPointerException
    public Usuario listarPorId(Integer id){
      Optional<Usuario> optional = usuarioRepository.findById(id);
      if(optional.isPresent()){
          return optional.get();
      }
      return null;
    }

    public Usuario atualizar(Integer id, Usuario usuario){
        Optional<Usuario> optional = usuarioRepository.findById(id);
        if(optional.isPresent()){
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public void deletar(Integer id){
        Optional<Usuario> optional = usuarioRepository.findById(id);
        if(optional.isPresent()) {
            usuarioRepository.delete(optional.get());
        }
    }

}
