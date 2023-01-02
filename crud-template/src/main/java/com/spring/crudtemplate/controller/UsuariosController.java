package com.spring.crudtemplate.controller;

import com.spring.crudtemplate.model.PagedResponse;
import com.spring.crudtemplate.model.Usuario;
import com.spring.crudtemplate.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/usuarios")
public class UsuariosController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("")
    public ResponseEntity<PagedResponse<Usuario>> buscaUsuarios(@RequestParam(name = "cadena", defaultValue = "") String cadena,
                                                       @RequestParam(name = "incluyeBajas", defaultValue = "S") String incluyeBajas,
                                                       @RequestParam(name = "orden", defaultValue = "A") String orden,
                                                       @RequestParam(name = "offSet", defaultValue = "0") int offSet,
                                                       @RequestParam(name = "rowCount", defaultValue = "25") int rowCount) {

        PagedResponse<Usuario> endpoint = usuarioService.buscarUsuarios(cadena, incluyeBajas, orden, offSet, rowCount);
        return new ResponseEntity<>(endpoint, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> dameUsuario(@PathVariable("id") int IdUsuario) {
        Optional<Usuario> usuario = usuarioService.dameUsuario(IdUsuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        String msg = usuarioService.crearUsuario(usuario);
        if (!msg.contains("Usuario")) return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> modificarUsuario(@RequestBody Usuario usuario, @PathVariable("id") int IdUsuario) {
        String msg = usuarioService.modificarUsuario(usuario, IdUsuario);
        if (!msg.contains("Usuario")) return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarUsuario(@PathVariable("id") int IdUsuario) {
        String msg = usuarioService.borrarUsuario(IdUsuario);
        if (!msg.contains("Usuario")) return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PatchMapping("/{id}/alta")
    public ResponseEntity<String> darAltaUsuario(@PathVariable("id") int IdUsuario) {
        String msg = usuarioService.darAltaUsuario(IdUsuario);
        if (!msg.contains("Usuario")) return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PatchMapping("/{id}/baja")
    public ResponseEntity<String> darBajaUsuario(@PathVariable("id") int IdUsuario) {
        String msg = usuarioService.darBajaUsuario(IdUsuario);
        if (!msg.contains("Usuario")) return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
