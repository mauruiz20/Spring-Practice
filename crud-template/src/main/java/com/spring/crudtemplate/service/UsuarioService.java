package com.spring.crudtemplate.service;

import com.spring.crudtemplate.model.Rol;
import com.spring.crudtemplate.model.Usuario;
import com.spring.crudtemplate.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Map<String, Object> buscarUsuarios(String cadena, String incluyeBajas, String orden, String offSet, String rowCount) {

        Map<String, Object> endpoint = new TreeMap<String, Object>();
        int numRows = usuarioRepository.obtenerNumRows(cadena, incluyeBajas);
        List<Usuario> usuarios = usuarioRepository.csp_buscar_usuarios(cadena, incluyeBajas, orden, offSet, rowCount);

        endpoint.put("numRows", numRows);
        endpoint.put("results", usuarios);

        return endpoint;
    }

    public Optional<Usuario> dameUsuario(int IdUsuario) {

        return usuarioRepository.csp_dame_usuario(IdUsuario);
    }

    public String crearUsuario(Usuario usuario) {

        if (!validarCampos(usuario)) return "Parámetros erróneos";
        return usuarioRepository.csp_crear_usuario(
                usuario.getRol().getIdRol(),
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
        return usuarioRepository.csp_modificar_usuario(
                IdUsuario,
                usuario.getRol().getIdRol(),
                usuario.getApellidos(),
                usuario.getNombres(),
                usuario.getEmail(),
                usuario.getDireccion(),
                usuario.getNacimiento(),
                new BCryptPasswordEncoder().encode(usuario.getClave())
        );
    }

    public String borrarUsuario(int IdUsuario) {

        return usuarioRepository.csp_borrar_usuario(IdUsuario);
    }

    public String darAltaUsuario(int IdUsuario) {

        return usuarioRepository.csp_daralta_usuario(IdUsuario);
    }

    public String darBajaUsuario(int IdUsuario) {

        return usuarioRepository.csp_darbaja_usuario(IdUsuario);
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

