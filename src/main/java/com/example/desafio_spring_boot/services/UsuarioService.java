package com.example.desafio_spring_boot.services;

import com.example.desafio_spring_boot.Models.Usuario;
import com.example.desafio_spring_boot.exceptions.UserNotFoundException;
import com.example.desafio_spring_boot.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

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
      return usuarioRepository.findById(id).orElseThrow(() ->
              new UserNotFoundException("Usuário com Id:" + id + " não encontrado."));
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
