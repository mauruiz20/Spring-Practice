package com.cursospring.curso.controllers;

import com.cursospring.curso.dao.UsuarioDao;
import com.cursospring.curso.models.Usuario;
import com.cursospring.curso.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.GET)
    public Usuario getUsuario(@PathVariable Long id) {

        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Mauricio");
        usuario.setApellido("Ruiz");
        usuario.setEmail("ruizmauricio@gmail.nom");
        usuario.setTelefono("12345679");

        return usuario;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(@RequestHeader(value = "Authorization")  String token) {

        if (!validarToken(token)) return null;
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void addUsuario(@RequestBody Usuario usuario) {

        Argon2 argon2  = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.addUsuario(usuario);
    }

    @RequestMapping(value = "usuario123")
    public Usuario editar() {

        Usuario usuario = new Usuario();
        usuario.setNombre("Mauricio");
        usuario.setApellido("Ruiz");
        usuario.setEmail("ruizmauricio@gmail.nom");
        usuario.setTelefono("12345679");

        return usuario;
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void deleteUsuario(@RequestHeader(value = "Authorization")  String token, @PathVariable Long id) {

        if (validarToken(token)) {
            usuarioDao.deleteUsuario(id);
        }
    }

    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return  usuarioId != null;
    }
}
