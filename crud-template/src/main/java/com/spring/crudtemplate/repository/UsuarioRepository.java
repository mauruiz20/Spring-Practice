package com.spring.crudtemplate.repository;

import com.spring.crudtemplate.model.Rol;
import com.spring.crudtemplate.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "call csp_buscar_usuarios(:pCadena, :pIncluyeBajas, :pOrden, :pOffSet, :pRowCount)", nativeQuery = true)
    List<Usuario> csp_buscar_usuarios(
            @Param("pCadena") String pCadena,
            @Param("pIncluyeBajas") String pIncluyeBajas,
            @Param("pOrden") String pOrden,
            @Param("pOffSet") String pOffSet,
            @Param("pRowCount") String pRowCount
    );

    @Query(value = "call csp_obtener_num_usuarios(:pCadena, :pIncluyeBajas)", nativeQuery = true)
    Integer obtenerNumRows(
            @Param("pCadena") String pCadena,
            @Param("pIncluyeBajas") String pIncluyeBajas
    );

    @Query(value = "{call csp_dame_usuario(:pIdUsuario)}", nativeQuery = true)
    Optional<Usuario> csp_dame_usuario(@Param("pIdUsuario") int pIdUsuario);

    @Query(value = "{call csp_crear_usuario(:pIdRol, :pApellidos, :pNombres, :pEmail, :pDireccion, :pNacimiento, :pClave)}", nativeQuery = true)
    String csp_crear_usuario(
            @Param("pIdRol") int pIdRol,
            @Param("pApellidos") String pApellidos,
            @Param("pNombres") String pNombres,
            @Param("pEmail") String pEmail,
            @Param("pDireccion") String pDireccion,
            @Param("pNacimiento") String pNacimiento,
            @Param("pClave") String pClave
    );

    @Query(value = "{call csp_modificar_usuario(:pIdUsuario, :pIdRol, :pApellidos, :pNombres, :pEmail, :pDireccion, :pNacimiento, :pClave)}", nativeQuery = true)
    String csp_modificar_usuario(
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
    String csp_borrar_usuario(@Param("pIdUsuario") int pIdUsuario);

    @Query(value = "{call csp_daralta_usuario(:pIdUsuario)}", nativeQuery = true)
    String csp_daralta_usuario(@Param("pIdUsuario") int pIdUsuario);

    @Query(value = "{call csp_darbaja_usuario(:pIdUsuario)}", nativeQuery = true)
    String csp_darbaja_usuario(@Param("pIdUsuario") int pIdUsuario);

    @Query(value = "{call csp_iniciar_sesion(:pEmail)}", nativeQuery = true)
    Optional<Usuario> iniciarSesion(@Param("pEmail") String pEmail);
}
