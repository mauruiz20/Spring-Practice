package com.spring.crudtemplate.repository;

import com.spring.crudtemplate.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Integer> {

    @Query(value = "call csp_buscar_clientes(:pCadena, :pIncluyeBajas, :pOrden, :pOffSet, :pRowCount)", nativeQuery = true)
    List<Clientes> csp_buscar_clientes(
            @Param("pCadena") String pCadena,
            @Param("pIncluyeBajas") String pIncluyeBajas,
            @Param("pOrden") String pOrden,
            @Param("pOffSet") String pOffSet,
            @Param("pRowCount") String pRowCount
    );

    @Query(value = "call csp_obtener_num_clientes(:pCadena, :pIncluyeBajas)", nativeQuery = true)
    Integer obtenerNumRows(
            @Param("pCadena") String pCadena,
            @Param("pIncluyeBajas") String pIncluyeBajas
    );

    @Query(value = "{call csp_dame_cliente(:pIdCliente)}", nativeQuery = true)
    Optional<Clientes> csp_dame_cliente(@Param("pIdCliente") int pIdCliente);

    @Query(value = "{call csp_crear_cliente(:pApellidos, :pNombres, :pEmail, :pTelefono, :pDireccion, :pNacimiento, :pNacionalidad, :pClave)}", nativeQuery = true)
    String csp_crear_cliente(
            @Param("pApellidos") String pApellidos,
            @Param("pNombres") String pNombres,
            @Param("pEmail") String pEmail,
            @Param("pTelefono") String pTelefono,
            @Param("pDireccion") String pDireccion,
            @Param("pNacimiento") String pNacimiento,
            @Param("pNacionalidad") String pNacionalidad,
            @Param("pClave") String pClave
    );

    @Query(value = "{call csp_modificar_cliente(:pIdCliente, :pApellidos, :pNombres, :pEmail, :pTelefono, :pDireccion, :pNacimiento, :pNacionalidad, :pClave)}", nativeQuery = true)
    String csp_modificar_cliente(
            @Param("pIdCliente") int pIdCliente,
            @Param("pApellidos") String pApellidos,
            @Param("pNombres") String pNombres,
            @Param("pEmail") String pEmail,
            @Param("pTelefono") String pTelefono,
            @Param("pDireccion") String pDireccion,
            @Param("pNacimiento") String pNacimiento,
            @Param("pNacionalidad") String pNacionalidad,
            @Param("pClave") String pClave
    );

    @Query(value = "{call csp_borrar_cliente(:pIdCliente)}", nativeQuery = true)
    String csp_borrar_cliente(@Param("pIdCliente") int pIdCliente);

    @Query(value = "{call csp_daralta_cliente(:pIdCliente)}", nativeQuery = true)
    String csp_daralta_cliente(@Param("pIdCliente") int pIdCliente);

    @Query(value = "{call csp_darbaja_cliente(:pIdCliente)}", nativeQuery = true)
    String csp_darbaja_cliente(@Param("pIdCliente") int pIdCliente);

    @Query(value = "{call csp_iniciar_sesion(:pEmail)}", nativeQuery = true)
    Optional<Clientes> iniciarSesion(@Param("pEmail") String pEmail);
}
