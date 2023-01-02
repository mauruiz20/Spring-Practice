package com.spring.crudtemplate.controller;

import com.spring.crudtemplate.model.PagedResponse;
import com.spring.crudtemplate.model.Usuario;
import com.spring.crudtemplate.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuarios")
public class UsuariosController {

    UsuarioService usuarioService;

    @Autowired
    public UsuariosController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /* buscaUsuarios: maneja peticiones GET a la ruta api/usuarios. Recibe como parámetros opcionales una cadena de búsqueda, una bandera para incluir o no usuarios
    *   dados de baja, una bandera para ordenar los resultados por nombre o por fecha de alta, un offset y una cantidad de resultados a retornar.
    *   Utiliza el servicio UsuarioService para buscar usuarios y devuelve una respuesta HTTP con un código de estado OK y un cuerpo que contiene la lista de usuarios
    *   encontrados e información adicional.
     */

    @GetMapping
    public ResponseEntity<PagedResponse<Usuario>> buscaUsuarios(@RequestParam(name = "cadena", defaultValue = "") String cadena,
                                                       @RequestParam(name = "incluyeBajas", defaultValue = "S") String incluyeBajas,
                                                       @RequestParam(name = "orden", defaultValue = "A") String orden,
                                                       @RequestParam(name = "offSet", defaultValue = "0") int offSet,
                                                       @RequestParam(name = "rowCount", defaultValue = "25") int rowCount) {

        PagedResponse<Usuario> response = usuarioService.buscarUsuarios(cadena, incluyeBajas, orden, offSet, rowCount);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /* dameUsuario: maneja peticiones GET a la ruta api/usuarios/{id}. Recibe como parámetro obligatorio el id de un usuario. Utiliza el servicio UsuarioService para
    *   obtener un usuario y devuelve una respuesta HTTP con un código de estado OK y un cuerpo que contiene el usuario encontrado.
     */

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> dameUsuario(@PathVariable("id") int idUsuario) {

        Usuario response = usuarioService.dameUsuario(idUsuario);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /* crearUsuario: maneja peticiones POST a la ruta api/usuarios. Recibe como parámetro obligatorio un objeto Usuario. Utiliza el servicio UsuarioService para crear
    *   un usuario y devuelve una respuesta HTTP con un código de estado CREATED y un cuerpo que contiene el resultado de la operación.
     */

    @PostMapping
    public ResponseEntity<String> crearUsuario(@RequestBody Usuario usuario) {
        
        String response = usuarioService.crearUsuario(usuario);        
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /* modificarUsuario: maneja peticiones PUT a la ruta api/usuarios/{id}. Recibe como parámetros obligatorios un objeto Usuario y el id del usuario a modificar.
    *   Utiliza el servicio UsuarioService para modificar un usuario y devuelve una respuesta HTTP con un código de estado OK y un cuerpo que contiene el resultado
    *   de la operación.
     */

    @PutMapping("/{id}")
    public ResponseEntity<String> modificarUsuario(@RequestBody Usuario usuario, @PathVariable("id") int idUsuario) {

        usuario.setIdUsuario(idUsuario);
        String response = usuarioService.modificarUsuario(usuario);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /* borrarUsuario: maneja peticiones DELETE a la ruta api/usuarios/{id}. Recibe como parámetro obligatorio el id del usuario a eliminar.
    *   Utiliza el servicio UsuarioService para eliminar un usuario y devuelve una respuesta HTTP con un código de estado OK y un cuerpo que contiene el resultado de
    *   la operación.
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarUsuario(@PathVariable("id") int idUsuario) {

        String response = usuarioService.borrarUsuario(idUsuario);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /* darAltaUsuario: maneja peticiones PATCH a la ruta api/usuarios/{id}/alta. Recibe como parámetro obligatorio el id del usuario a dar de alta.
        Utiliza el servicio UsuarioService para cambiar el estado de un usuario a "alta" y devuelve una respuesta HTTP con un código de estado OK y un cuerpo que
        contiene el resultado de la operación.
     */

    @PatchMapping("/{id}/alta")
    public ResponseEntity<String> darAltaUsuario(@PathVariable("id") int idUsuario) {

        String response = usuarioService.darAltaUsuario(idUsuario);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    /* darBajaUsuario: maneja peticiones PATCH a la ruta api/usuarios/{id}/baja. Recibe como parámetro obligatorio el id del usuario a dar de baja. 
        Utiliza el servicio UsuarioService para cambiar el estado de un usuario a "baja" y devuelve una respuesta HTTP con un código de estado OK y un cuerpo que
        contiene el resultado de la operación.
     */

    @PatchMapping("/{id}/baja")
    public ResponseEntity<String> darBajaUsuario(@PathVariable("id") int idUsuario) {

        String response = usuarioService.darBajaUsuario(idUsuario);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
