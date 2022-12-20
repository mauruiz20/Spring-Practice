package com.cursospring.curso.controllers;

import com.cursospring.curso.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id) {

        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Mauricio");
        usuario.setApellido("Ruiz");
        usuario.setEmail("ruizmauricio@gmail.nom");
        usuario.setTelefono("12345679");

        return usuario;
    }

    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios() {

        List<Usuario> usuarios = new ArrayList<>();

        Usuario usuario1 = new Usuario();

        usuario1.setId(1L);
        usuario1.setNombre("Mauricio");
        usuario1.setApellido("Ruiz");
        usuario1.setEmail("ruizmauricio@gmail.nom");
        usuario1.setTelefono("12345679");

        Usuario usuario2 = new Usuario();

        usuario2.setId(2L);
        usuario2.setNombre("Mauricio");
        usuario2.setApellido("Ruiz");
        usuario2.setEmail("ruizmauricio@gmail.nom");
        usuario2.setTelefono("12345679");

        Usuario usuario3 = new Usuario();

        usuario3.setId(3L);
        usuario3.setNombre("Mauricio");
        usuario3.setApellido("Ruiz");
        usuario3.setEmail("ruizmauricio@gmail.nom");
        usuario3.setTelefono("12345679");

        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        return usuarios;
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

    @RequestMapping(value = "usuario41")
    public Usuario eliminar() {

        Usuario usuario = new Usuario();
        usuario.setNombre("Mauricio");
        usuario.setApellido("Ruiz");
        usuario.setEmail("ruizmauricio@gmail.nom");
        usuario.setTelefono("12345679");

        return usuario;
    }

    @RequestMapping(value = "usuario51")
    public Usuario buscar() {

        Usuario usuario = new Usuario();
        usuario.setNombre("Mauricio");
        usuario.setApellido("Ruiz");
        usuario.setEmail("ruizmauricio@gmail.nom");
        usuario.setTelefono("12345679");

        return usuario;
    }
}
