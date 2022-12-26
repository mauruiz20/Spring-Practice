package com.spring.crudtemplate.security;

import com.spring.crudtemplate.model.Usuario;
import com.spring.crudtemplate.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImp implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String Email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository
                .iniciarSesion(Email)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con email " + Email + " no existe."));

        return new UserDetailsImp(usuario);
    }
}
