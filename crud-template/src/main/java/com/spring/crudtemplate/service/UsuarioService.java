package com.spring.crudtemplate.service;

import com.spring.crudtemplate.model.PagedResponse;
import com.spring.crudtemplate.model.Usuario;
import com.spring.crudtemplate.repository.UsuarioRepository;
import com.spring.crudtemplate.repository.UsuarioRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UsuarioService {

    UsuarioRepository usuarioRepository;
    UsuarioRepositoryImpl usuarioRepositoryImpl;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioRepositoryImpl usuarioRepositoryImpl) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioRepositoryImpl = usuarioRepositoryImpl;
    }

    @Transactional
    public PagedResponse<Usuario> buscarUsuarios(String cadena, String incluyeBajas, String orden, int offSet, int rowCount) {

        Integer numRows = 0;
        PagedResponse<Usuario> response = usuarioRepositoryImpl.buscarUsuarios(cadena, incluyeBajas, orden, offSet, rowCount, numRows);;

//        if (!usuarios.isEmpty()) {
//            numRows = usuarios.get(0).getNumRows();
//        }

        return response;
    }

    public Optional<Usuario> dameUsuario(int IdUsuario) {

        return usuarioRepository.dameUsuario(IdUsuario);
    }

    public String crearUsuario(Usuario usuario) {

        if (!validarCampos(usuario)) return "Parámetros erróneos";
        return usuarioRepository.crearUsuario(
                usuario.getIdRol(),
                usuario.getApellidos(),
                usuario.getNombres(),
                usuario.getEmail(),
                usuario.getDireccion(),
                usuario.getNacimiento(),
                new BCryptPasswordEncoder().encode(usuario.getClave())
        );
    }

    public String modificarUsuario(Usuario usuario, int IdUsuario) {

        if (!validarCampos(usuario)) return "Parámetros erróneos";
        return usuarioRepository.modificarUsuario(
                IdUsuario,
                usuario.getIdRol(),
                usuario.getApellidos(),
                usuario.getNombres(),
                usuario.getEmail(),
                usuario.getDireccion(),
                usuario.getNacimiento(),
                new BCryptPasswordEncoder().encode(usuario.getClave())
        );
    }

    public String borrarUsuario(int IdUsuario) {

        return usuarioRepository.borrarUsuario(IdUsuario);
    }

    public String darAltaUsuario(int IdUsuario) {

        return usuarioRepository.darAltaUsuario(IdUsuario);
    }

    public String darBajaUsuario(int IdUsuario) {

        return usuarioRepository.darBajaUsuario(IdUsuario);
    }

    private boolean validarCampos(Usuario usuario) {
        String apellidos = usuario.getApellidos();
        String nombres = usuario.getNombres();
        String email = usuario.getEmail();        
        String direccion = usuario.getDireccion();
        String nacimiento = usuario.getNacimiento();
        String clave = usuario.getClave();

        return !(apellidos == null || apellidos.equals("") || nombres == null || nombres.equals("") ||
                email == null || email.equals("") || direccion == null || direccion.equals("") || nacimiento == null || nacimiento.equals("")
                || clave == null || clave .equals("")
                );
    }
}

