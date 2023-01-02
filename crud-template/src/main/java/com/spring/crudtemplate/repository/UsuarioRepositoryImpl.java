package com.spring.crudtemplate.repository;

import com.spring.crudtemplate.model.PagedResponse;
import com.spring.crudtemplate.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepositoryImpl {
    @PersistenceContext
    EntityManager entityManager;

    public PagedResponse<Usuario> buscarUsuarios(String cadena, String incluyeBajas, String orden, int offset, int rowCount, Integer numRows) {
        StoredProcedureQuery q = entityManager.createStoredProcedureQuery("csp_buscar_usuarios");

        q.registerStoredProcedureParameter("pCadena", String.class, ParameterMode.IN);
        q.registerStoredProcedureParameter("pIncluyeBajas", String.class, ParameterMode.IN);
        q.registerStoredProcedureParameter("pOrden", String.class, ParameterMode.IN);
        q.registerStoredProcedureParameter("pOffSet", Integer.class, ParameterMode.IN);
        q.registerStoredProcedureParameter("pRowCount", Integer.class, ParameterMode.IN);
        q.registerStoredProcedureParameter("NumRows", Integer.class, ParameterMode.OUT);

        q.setParameter("pCadena", cadena);
        q.setParameter("pIncluyeBajas", incluyeBajas);
        q.setParameter("pOrden", orden);
        q.setParameter("pOffSet", offset);
        q.setParameter("pRowCount", rowCount);

        q.execute();

        numRows = (Integer) q.getOutputParameterValue("NumRows");

        List<Object[]> usuarios = q.getResultList();
        List<Usuario> listaUsuarios = new ArrayList<>();

        for (Object[] u : usuarios) {
            Usuario usuario = new Usuario();
            usuario.setIdUsuario((int) u[0]);
            usuario.setIdRol(Byte.toUnsignedInt((byte) u[1]));
            usuario.setApellidos((String) u[2]);
            usuario.setNombres((String) u[3]);
            usuario.setEmail((String) u[4]);
            usuario.setDireccion((String) u[5]);
            usuario.setNacimiento(u[6].toString());
            usuario.setClave((String) u[7]);
            usuario.setEstadoUsuario(u[8].toString());
            listaUsuarios.add(usuario);
        }

        return new PagedResponse<>(numRows, listaUsuarios);
    }
}

