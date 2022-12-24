package com.spring.crudtemplate.security;

import com.spring.crudtemplate.model.Clientes;
import com.spring.crudtemplate.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImp implements UserDetailsService {

    @Autowired
    private ClientesRepository clientesRepository;

    @Override
    public UserDetails loadUserByUsername(String Email) throws UsernameNotFoundException {
        Clientes cliente = clientesRepository
                .iniciarSesion(Email)
                .orElseThrow(() -> new UsernameNotFoundException("El cliente con email " + Email + " no existe."));

        return new UserDetailsImp(cliente);
    }
}
