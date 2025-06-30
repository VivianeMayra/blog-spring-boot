package com.example.desafio_spring_boot.services;
import com.example.desafio_spring_boot.Models.Usuario;
import com.example.desafio_spring_boot.exceptions.NotFoundException;
import com.example.desafio_spring_boot.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

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
              new NotFoundException("Usuário com Id:" + id + " não encontrado."));
    }

    public Usuario atualizar(Integer id, Usuario usuario){
        listarPorId(id); //valido que existe no banco de dados
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    public void deletar(Integer id){
        Usuario user= listarPorId(id);
        usuarioRepository.delete(user);
    }

}
