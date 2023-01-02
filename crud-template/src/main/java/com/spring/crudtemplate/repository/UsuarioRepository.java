package com.spring.crudtemplate.repository;

import com.spring.crudtemplate.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

//    @Query(value = "{call csp_buscar_usuarios2(:pCadena, :pIncluyeBajas, :pOrden, :pOffSet, :pRowCount)}", nativeQuery = true)
//    List<UsuarioProcedureResult> buscarUsuarios(
//            @Param("pCadena") String pCadena,
//            @Param("pIncluyeBajas") String pIncluyeBajas,
//            @Param("pOrden") String pOrden,
//            @Param("pOffSet") int pOffSet,
//            @Param("pRowCount") int pRowCount
//    );

//    @Query(value = "call csp_obtener_num_usuarios(:pCadena, :pIncluyeBajas)", nativeQuery = true)
//    Integer obtenerNumRows(
//            @Param("pCadena") String pCadena,
//            @Param("pIncluyeBajas") String pIncluyeBajas
//    );

    @Query(value = "{call csp_dame_usuario(:pIdUsuario)}", nativeQuery = true)
    Optional<Usuario> dameUsuario(@Param("pIdUsuario") int pIdUsuario);

    @Query(value = "{call csp_crear_usuario(:pIdRol, :pApellidos, :pNombres, :pEmail, :pDireccion, :pNacimiento, :pClave)}", nativeQuery = true)
    String crearUsuario(
            @Param("pIdRol") int pIdRol,
            @Param("pApellidos") String pApellidos,
            @Param("pNombres") String pNombres,
            @Param("pEmail") String pEmail,
            @Param("pDireccion") String pDireccion,
            @Param("pNacimiento") String pNacimiento,
            @Param("pClave") String pClave
    );

    @Query(value = "{call csp_modificar_usuario(:pIdUsuario, :pIdRol, :pApellidos, :pNombres, :pEmail, :pDireccion, :pNacimiento, :pClave)}", nativeQuery = true)
    String modificarUsuario(
            @Param("pIdUsuario") int pIdUsuario,
            @Param("pIdRol") int pIdRol,
            @Param("pApellidos") String pApellidos,
            @Param("pNombres") String pNombres,
            @Param("pEmail") String pEmail,
            @Param("pDireccion") String pDireccion,
            @Param("pNacimiento") String pNacimiento,
            @Param("pClave") String pClave
    );

    @Query(value = "{call csp_borrar_usuario(:pIdUsuario)}", nativeQuery = true)
    String borrarUsuario(@Param("pIdUsuario") int pIdUsuario);

    @Query(value = "{call csp_daralta_usuario(:pIdUsuario)}", nativeQuery = true)
    String darAltaUsuario(@Param("pIdUsuario") int pIdUsuario);

    @Query(value = "{call csp_darbaja_usuario(:pIdUsuario)}", nativeQuery = true)
    String darBajaUsuario(@Param("pIdUsuario") int pIdUsuario);

    @Query(value = "{call csp_iniciar_sesion(:pEmail)}", nativeQuery = true)
    Optional<Usuario> iniciarSesion(@Param("pEmail") String pEmail);

    boolean existsByEmail(String email);

    boolean existsByEmailAndIdUsuarioNot(String email, int idUsuario);
}
