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

    public List<Clientes> buscarClientes() {
        return clientesRepository.csp_buscar_clientes();
    }

    public Optional<Clientes> dameCliente(int IdCliente) {
        return clientesRepository.csp_dame_cliente(IdCliente);
    }

    public List<String> crearCliente(Clientes cliente) {
        return clientesRepository.csp_crear_cliente(cliente.getApellidos(), cliente.getNombres(), cliente.getEmail(),
                cliente.getTelefono(), cliente.getDireccion(), cliente.getNacimiento(), cliente.getNacionalidad());
    }

    public List<String> borrarCliente(int IdCliente){
        return clientesRepository.csp_borrar_cliente(IdCliente);
    }
}
