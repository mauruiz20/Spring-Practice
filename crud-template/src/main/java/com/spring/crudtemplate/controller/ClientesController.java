package com.spring.crudtemplate.controller;

import com.spring.crudtemplate.model.Busqueda;
import com.spring.crudtemplate.model.Clientes;
import com.spring.crudtemplate.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/clientes")
@CrossOrigin
public class ClientesController {
    @Autowired
    ClientesService clientesService;

    @GetMapping("")
    public ResponseEntity<Map<String, Object>> buscarClientes(@RequestParam(name = "cadena", defaultValue = "") String cadena,
                                                         @RequestParam(name = "incluyeBajas", defaultValue = "S") String incluyeBajas,
                                                         @RequestParam(name = "offSet", defaultValue = "0") String offSet,
                                                         @RequestParam(name = "rowCount", defaultValue = "25") String rowCount) {
        Map<String, Object> endpoint = clientesService.buscarClientes(cadena, incluyeBajas, offSet, rowCount);
        return new ResponseEntity<>(endpoint, HttpStatus.OK);
    }

    @GetMapping("/{IdCliente}")
    public ResponseEntity<Clientes> dameCliente(@PathVariable("IdCliente") int IdCliente) {
        Optional<Clientes> cliente = clientesService.dameCliente(IdCliente);
        return new ResponseEntity(cliente, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> crearCliente(@RequestBody Clientes cliente) {
        String msg = clientesService.crearCliente(cliente);
        if (!msg.contains("Cliente")) return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);

    }

    @PutMapping("/{IdCliente}")
    public ResponseEntity<String> modificarCliente(@RequestBody Clientes cliente, @PathVariable("IdCliente") int IdCliente) {
        String msg = clientesService.modificarCliente(cliente, IdCliente);
        if (!msg.contains("Cliente")) return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @DeleteMapping("/{IdCliente}")
    public ResponseEntity<String> borrarCliente(@PathVariable("IdCliente") int IdCliente) {
        String msg = clientesService.borrarCliente(IdCliente);
        if (!msg.contains("Cliente")) return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PatchMapping("/{IdCliente}/alta")
    public ResponseEntity<String> darAltaCliente(@PathVariable("IdCliente") int IdCliente) {
        String msg = clientesService.darAltaCliente(IdCliente);
        if (!msg.contains("Cliente")) return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PatchMapping("/{IdCliente}/baja")
    public ResponseEntity<String> darBajaCliente(@PathVariable("IdCliente") int IdCliente) {
        String msg = clientesService.darBajaCliente(IdCliente);
        if (!msg.contains("Cliente")) return new ResponseEntity<>(msg, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
