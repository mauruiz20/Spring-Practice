package com.spring.crudtemplate.controller;

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
    public ResponseEntity<Map<String, Object>> buscaUsuarios(@RequestParam(name = "cadena", defaultValue = "") String cadena,
                                                         @RequestParam(name = "incluyeBajas", defaultValue = "S") String incluyeBajas,
                                                         @RequestParam(name = "orden", defaultValue = "A") String orden,
                                                         @RequestParam(name = "offSet", defaultValue = "0") String offSet,
                                                         @RequestParam(name = "rowCount", defaultValue = "25") String rowCount) {
        Map<String, Object> endpoint = usuarioService.buscarUsuarios(cadena, incluyeBajas, orden, offSet, rowCount);
        return new ResponseEntity<>(endpoint, HttpStatus.OK);
    }

    @GetMapping("/{IdUsuario}")
    public ResponseEntity<Usuario> dameUsuario(@PathVariable("IdUsuario") int IdUsuario) {
        Optional<Usuario> usuario = usuarioService.dameUsuario(IdUsuario);
        return new ResponseEntity(usuario, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        String msg = usuarioService.crearUsuario(usuario);
        if (!msg.contains("Usuario")) return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);

    }

    @PutMapping("/{IdUsuario}")
    public ResponseEntity<String> modificarUsuario(@RequestBody Usuario usuario, @PathVariable("IdUsuario") int IdUsuario) {
        String msg = usuarioService.modificarUsuario(usuario, IdUsuario);
        if (!msg.contains("Usuario")) return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @DeleteMapping("/{IdUsuario}")
    public ResponseEntity<String> borrarUsuario(@PathVariable("IdUsuario") int IdUsuario) {
        String msg = usuarioService.borrarUsuario(IdUsuario);
        if (!msg.contains("Usuario")) return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PatchMapping("/{IdUsuario}/alta")
    public ResponseEntity<String> darAltaUsuario(@PathVariable("IdUsuario") int IdUsuario) {
        String msg = usuarioService.darAltaUsuario(IdUsuario);
        if (!msg.contains("Usuario")) return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PatchMapping("/{IdUsuario}/baja")
    public ResponseEntity<String> darBajaUsuario(@PathVariable("IdUsuario") int IdUsuario) {
        String msg = usuarioService.darBajaUsuario(IdUsuario);
        if (!msg.contains("Usuario")) return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
