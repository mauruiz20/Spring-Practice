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

    @Query(value = "call csp_buscar_clientes('','S',0,100)", nativeQuery = true)
    List<Clientes> csp_buscar_clientes();

    @Query(value = "{call csp_dame_cliente(:pIdCliente)}", nativeQuery = true)
    Optional<Clientes> csp_dame_cliente(@Param("pIdCliente") int pIdCliente);

    @Query(value = "{call csp_crear_cliente(:pApellidos, :pNombres, :pEmail, :pTelefono, :pDireccion, :pNacimiento, :pNacionalidad)}", nativeQuery = true)
    List<String> csp_crear_cliente(
            @Param("pApellidos")String pApellidos,
            @Param("pNombres")String pNombres,
            @Param("pEmail")String pEmail,
            @Param("pTelefono")String pTelefono,
            @Param("pDireccion")String pDireccion,
            @Param("pNacimiento")String pNacimiento,
            @Param("pNacionalidad")String pNacionalidad
    );

    @Query(value = "{call csp_borrar_cliente(:pIdCliente)}", nativeQuery = true)
    List<String> csp_borrar_cliente(@Param("pIdCliente") int pIdCliente);
}
