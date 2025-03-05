package me.dio.decoltech.domain.service;

import lombok.RequiredArgsConstructor;
import me.dio.decoltech.domain.controller.exception.EmailJaCadastradoException;
import me.dio.decoltech.domain.controller.exception.ResourceNotFoundException;
import me.dio.decoltech.domain.model.Usuario;
import me.dio.decoltech.domain.respository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario criarUsuario(Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new EmailJaCadastradoException("Email já cadastrado");
        }
        return usuarioRepository.save(usuario);
    }

    public ResponseEntity<Usuario> obterUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
