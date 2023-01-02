package com.spring.crudtemplate.service;

import com.spring.crudtemplate.exception.BadRequestException;
import com.spring.crudtemplate.exception.NotFoundException;
import com.spring.crudtemplate.model.PagedResponse;
import com.spring.crudtemplate.model.Usuario;
import com.spring.crudtemplate.repository.RolRepository;
import com.spring.crudtemplate.repository.UsuarioRepository;
import com.spring.crudtemplate.repository.UsuarioRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/* Clase UsuarioService
*   Esta clase es un servicio que proporciona métodos para realizar operaciones CRUD (create, read, update, delete) sobre usuarios en una base de datos.
*   Atributos:
*       usuarioRepository: es una interfaz que proporciona métodos para realizar operaciones CRUD sobre usuarios en una base de datos.
*       usuarioRepositoryImpl: es una implementación de la interfaz UsuarioRepository.
*       rolRepository: es una interfaz que proporciona métodos para realizar operaciones CRUD sobre roles en una base de datos.
 */
@Service
public class UsuarioService {

    UsuarioRepository usuarioRepository;
    UsuarioRepositoryImpl usuarioRepositoryImpl;
    RolRepository rolRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioRepositoryImpl usuarioRepositoryImpl, RolRepository rolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioRepositoryImpl = usuarioRepositoryImpl;
        this.rolRepository = rolRepository;
    }

    /* Métodos:
    *   buscarUsuarios: permite buscar usuarios en la base de datos que cumplan con ciertos criterios. Recibe como parámetros una cadena de búsqueda, un indicador de si se
    *   deben incluir usuarios dados de baja (incluyeBajas), una cláusula de ordenación (orden), un índice de página (offSet) y un tamaño de página (rowCount).
    *   Devuelve un objeto de tipo PagedResponse que contiene la lista de usuarios encontrados y la cantidad total de usuarios que cumplen con los criterios de búsqueda.
     */

    public PagedResponse<Usuario> buscarUsuarios(String cadena, String incluyeBajas, String orden, int offSet, int rowCount) {

        int numRows = 0;
        return usuarioRepositoryImpl.buscarUsuarios(cadena, incluyeBajas, orden, offSet, rowCount, numRows);
    }

    /* dameUsuario: permite obtener un usuario de la base de datos a partir de su id. Recibe como parámetro el id del usuario.
    *   Si el usuario no existe, lanza una excepción NotFoundException. Devuelve el usuario encontrado.
     */

    public Usuario dameUsuario(int idUsuario) {

        return usuarioRepository.dameUsuario(idUsuario).orElseThrow(() -> new NotFoundException("Usuario no encontrado"));
    }

    /* El método crearUsuario recibe como parámetro un objeto Usuario y se encarga de validar los parámetros necesarios para crear un usuario y de crearlo en la
    *   base de datos. Antes de crear el usuario, se verifica que no haya otro usuario con el mismo email en la base de datos utilizando el método existsByEmail del
    *   objeto usuarioRepository. Si encuentra un usuario con el mismo email, lanzará una excepción de tipo BadRequestException. Si no hay problemas al crear el usuario,
    *   se retorna un mensaje de éxito. Si el mensaje de éxito no incluye la palabra "Usuario", se lanzará una excepción BadRequestException con el mensaje de error.
     */

    public String crearUsuario(Usuario usuario) {

        validarParametros(usuario);

        if(usuarioRepository.existsByEmail(usuario.getEmail())) throw new BadRequestException("Email ya existente");

        String response = usuarioRepository.crearUsuario(
                usuario.getIdRol(),
                usuario.getApellidos(),
                usuario.getNombres(),
                usuario.getEmail(),
                usuario.getDireccion(),
                usuario.getNacimiento(),
                new BCryptPasswordEncoder().encode(usuario.getClave())
        );

        if (!response.contains("Usuario")) throw new BadRequestException(response);

        return response;
    }

    /* El método modificarUsuario también recibe como parámetro un objeto Usuario y se encarga de actualizar los datos de un usuario existente en la base de datos.
    *   Antes de actualizar el usuario, se verifica que no haya otro usuario con el mismo email en la base de datos utilizando el método existsByEmailAndIdUsuarioNot
    *   del objeto usuarioRepository. Si encuentra un usuario con el mismo email, lanzará una excepción de tipo BadRequestException. Si no hay problemas al actualizar
    *   el usuario, se retorna un mensaje de éxito. Si el mensaje de éxito no incluye la palabra "Usuario", se lanzará una excepción BadRequestException con el mensaje
    *   de error.
     */

    public String modificarUsuario(Usuario usuario) {

        validarParametros(usuario);

        if(usuarioRepository.existsByEmailAndIdUsuarioNot(usuario.getEmail(), usuario.getIdUsuario())) throw new BadRequestException("Email ya existente");

        String response = usuarioRepository.modificarUsuario(
                usuario.getIdUsuario(),
                usuario.getIdRol(),
                usuario.getApellidos(),
                usuario.getNombres(),
                usuario.getEmail(),
                usuario.getDireccion(),
                usuario.getNacimiento(),
                new BCryptPasswordEncoder().encode(usuario.getClave())
        );

        if (!response.contains("Usuario")) throw new BadRequestException(response);

        return response;
    }

    /* El método borrarUsuario recibe como parámetro el id de un usuario y se encarga de eliminar ese usuario de la base de datos. Retorna un mensaje de éxito
    *   o error dependiendo del resultado de la operación.
     */

    public String borrarUsuario(int idUsuario) {

        return usuarioRepository.borrarUsuario(idUsuario);
    }

    /* El método darAltaUsuario recibe como parámetro el id de un usuario y se encarga de cambiar el estado de ese usuario a "alta".
    *   Antes de cambiar el estado, verifica que el usuario no esté dado de alta ya. Si el usuario ya está dado de alta, lanzará una excepción de tipo BadRequestException.
    *   Si no hay problemas al cambiar el estado del usuario, se retorna un mensaje de éxito. Si el mensaje de éxito no incluye la palabra "Usuario", se lanzará
    *   una excepción BadRequestException con el mensaje de error.
     */

    public String darAltaUsuario(int idUsuario) {
        
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new NotFoundException("El usuario no existe"));

        if(usuario.getEstadoUsuario().equals("A")) throw new BadRequestException("El usuario ya está dado de alta");

        String response = usuarioRepository.darAltaUsuario(idUsuario);

        if (!response.contains("Usuario")) throw new BadRequestException(response);

        return response;
    }

    /* El método darBajaUsuario recibe como parámetro el id de un usuario y se encarga de cambiar el estado de ese usuario a "baja".
    *   Antes de cambiar el estado, verifica que el usuario no esté dado de baja ya. Si el usuario ya está dado de baja, lanzará una excepción de tipo BadRequestException.
    *   Si no hay problemas al cambiar el estado del usuario, se retorna un mensaje de éxito.
     */

    public String darBajaUsuario(int idUsuario) {

        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new NotFoundException("El usuario no existe"));

        if(usuario.getEstadoUsuario().equals("B")) throw new BadRequestException("El usuario ya está dado de baja");

        return usuarioRepository.darBajaUsuario(idUsuario);
    }

    /* El método validarParametros se encarga de verificar que todos los parámetros necesarios para crear o actualizar un usuario estén presentes y no estén vacíos.
    *   Si alguno de los parámetros está ausente o vacío, lanzará una excepción de tipo BadRequestException. También verifica que el idRol del usuario sea válido,
    *   es decir, que exista en la base de datos. Si el idRol no es válido, lanzará una excepción de tipo BadRequestException.
     */

    private void validarParametros(Usuario usuario) {
        String apellidos = usuario.getApellidos();
        String nombres = usuario.getNombres();
        String email = usuario.getEmail();        
        String direccion = usuario.getDireccion();
        String nacimiento = usuario.getNacimiento();
        String clave = usuario.getClave();

        if (apellidos == null || apellidos.isBlank() ||
                nombres == null || nombres.isBlank() ||
                email == null || email.isBlank() ||
                direccion == null || direccion.isBlank() ||
                nacimiento == null || nacimiento.isBlank() ||
                clave == null || clave .isBlank()
        ) throw new BadRequestException("Parámetros erróneos");

        if(!rolRepository.existsById(usuario.getIdRol())) throw new BadRequestException("No existe el rol indicado");
    }
}

