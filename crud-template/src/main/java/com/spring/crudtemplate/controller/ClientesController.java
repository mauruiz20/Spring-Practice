package com.spring.crudtemplate.controller;

import com.spring.crudtemplate.model.Clientes;
import com.spring.crudtemplate.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
    @Autowired
    ClientesService clientesService;

    @GetMapping("")
    public ResponseEntity<List<Clientes>> buscarClientes() {
        List<Clientes> clientes = clientesService.buscarClientes();
        return new ResponseEntity(clientes, HttpStatus.OK);
    }

    @GetMapping("/{IdCliente}")
    public ResponseEntity<Clientes> dameCliente(@PathVariable("IdCliente") int IdCliente) {
        Optional<Clientes> cliente = clientesService.dameCliente(IdCliente);
        return new ResponseEntity(cliente, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> crearCliente(@RequestBody Clientes cliente) {
        List<String> msg = clientesService.crearCliente(cliente);
        return new ResponseEntity(msg, HttpStatus.CREATED);
    }

    @DeleteMapping("/{IdCliente}")
    public ResponseEntity<?> borrarCliente(@PathVariable("IdCliente")int IdCliente){
        List<String> msg = clientesService.borrarCliente(IdCliente);
        return new ResponseEntity(msg, HttpStatus.OK);
    }
}
