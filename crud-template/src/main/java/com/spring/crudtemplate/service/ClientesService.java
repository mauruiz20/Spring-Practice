package com.spring.crudtemplate.service;

import com.spring.crudtemplate.exception.BadRequestException;
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

    public List<String> crearCliente(Clientes cliente) {

        validarCampos(cliente);

        List<String> response = clientesRepository.csp_crear_cliente(
                cliente.getApellidos(),
                cliente.getNombres(),
                cliente.getEmail(),
                cliente.getTelefono(),
                cliente.getDireccion(),
                cliente.getNacimiento(),
                cliente.getNacionalidad()
        );

        if (!response.get(0).equals("OK")) throw new BadRequestException(response.get(0));

        return response;
    }

    public List<String> modificarCliente(Clientes cliente, int IdCliente) {

        validarCampos(cliente);

        List<String> response = clientesRepository.csp_modificar_cliente(
                IdCliente,
                cliente.getApellidos(),
                cliente.getNombres(),
                cliente.getEmail(),
                cliente.getTelefono(),
                cliente.getDireccion(),
                cliente.getNacimiento(),
                cliente.getNacionalidad()
        );

        if (!response.get(0).equals("OK")) throw new BadRequestException(response.get(0));

        return response;
    }

    public List<String> borrarCliente(int IdCliente) {

        return clientesRepository.csp_borrar_cliente(IdCliente);
    }

    public List<String> darAltaCliente(int IdCliente) {

        List<String> response = clientesRepository.csp_daralta_cliente(IdCliente);

        if (!response.get(0).equals("OK")) throw new BadRequestException(response.get(0));

        return response;
    }

    public List<String> darBajaCliente(int IdCliente) {

        List<String> response = clientesRepository.csp_darbaja_cliente(IdCliente);

        if (!response.get(0).equals("OK")) throw new BadRequestException(response.get(0));

        return response;
    }

    private void validarCampos(Clientes cliente) {
        String apellidos = cliente.getApellidos();
        String nombres = cliente.getNombres();
        String email = cliente.getEmail();
        String telefono = cliente.getTelefono();
        String direccion = cliente.getDireccion();
        String nacimiento = cliente.getNacimiento();
        String nacionalidad = cliente.getNacionalidad();

        if (apellidos == null || apellidos.equals("") || nombres == null || nombres.equals("") ||
                email == null || email.equals("") || telefono == null || telefono.equals("") || direccion == null ||
                direccion.equals("") || nacimiento == null || nacimiento.equals("") || nacionalidad == null ||
                nacionalidad.equals(""))
            throw new BadRequestException("Parámetros erróneos.");
    }
}

