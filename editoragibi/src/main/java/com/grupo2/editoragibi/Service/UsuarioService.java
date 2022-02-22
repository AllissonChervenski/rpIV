package com.grupo2.editoragibi.Service;

import com.grupo2.editoragibi.Data.Entity.UsuarioEntity;
import com.grupo2.editoragibi.Data.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UsuarioService implements UserDetailsService {

    @Autowired
    IUsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        for (UsuarioEntity usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                return usuario;
            }
        }
        throw new UsernameNotFoundException("Usuário não está no sistema");
    }
}
