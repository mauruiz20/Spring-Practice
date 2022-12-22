package com.spring.crudtemplate.service;

import com.spring.crudtemplate.model.Clientes;
import com.spring.crudtemplate.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesService {
    @Autowired
    ClientesRepository clientesRepository;

    public List<Clientes> buscarClientes(String cadena, String incluyeBajas, String offSet, String rowCount) {

        return clientesRepository.csp_buscar_clientes(cadena, incluyeBajas, offSet, rowCount);
    }

    public Optional<Clientes> dameCliente(int IdCliente) {

        return clientesRepository.csp_dame_cliente(IdCliente);
    }

    public String crearCliente(Clientes cliente) {

        if (!validarCampos(cliente)) return "Parámetros erróneos";
        return clientesRepository.csp_crear_cliente(
                cliente.getApellidos(),
                cliente.getNombres(),
                cliente.getEmail(),
                cliente.getTelefono(),
                cliente.getDireccion(),
                cliente.getNacimiento(),
                cliente.getNacionalidad()
        );
    }

    public String modificarCliente(Clientes cliente, int IdCliente) {

        if (!validarCampos(cliente)) return "Parámetros erróneos";
        return clientesRepository.csp_modificar_cliente(
                IdCliente,
                cliente.getApellidos(),
                cliente.getNombres(),
                cliente.getEmail(),
                cliente.getTelefono(),
                cliente.getDireccion(),
                cliente.getNacimiento(),
                cliente.getNacionalidad()
        );
    }

    public String borrarCliente(int IdCliente) {

        return clientesRepository.csp_borrar_cliente(IdCliente);
    }

    public String darAltaCliente(int IdCliente) {

        return clientesRepository.csp_daralta_cliente(IdCliente);
    }

    public String darBajaCliente(int IdCliente) {

        return clientesRepository.csp_darbaja_cliente(IdCliente);
    }

    private boolean validarCampos(Clientes cliente) {
        String apellidos = cliente.getApellidos();
        String nombres = cliente.getNombres();
        String email = cliente.getEmail();
        String telefono = cliente.getTelefono();
        String direccion = cliente.getDireccion();
        String nacimiento = cliente.getNacimiento();
        String nacionalidad = cliente.getNacionalidad();

        return !(apellidos == null || apellidos.equals("") || nombres == null || nombres.equals("") ||
                email == null || email.equals("") || telefono == null || telefono.equals("") || direccion == null ||
                direccion.equals("") || nacimiento == null || nacimiento.equals("") || nacionalidad == null ||
                nacionalidad.equals(""));
    }
}

