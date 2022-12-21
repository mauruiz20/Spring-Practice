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
@CrossOrigin
public class ClientesController {
    @Autowired
    ClientesService clientesService;

    @GetMapping("")
    public ResponseEntity<List<Clientes>> buscarClientes(@RequestParam(name = "cadena", defaultValue = "") String cadena,
                                                         @RequestParam(name = "incluyeBajas", defaultValue = "S") String incluyeBajas,
                                                         @RequestParam(name = "offSet", defaultValue = "0") String offSet,
                                                         @RequestParam(name = "rowCount", defaultValue = "50") String rowCount) {
        List<Clientes> clientes = clientesService.buscarClientes(cadena, incluyeBajas, offSet, rowCount);
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{IdCliente}")
    public ResponseEntity<Clientes> dameCliente(@PathVariable("IdCliente") int IdCliente) {
        Optional<Clientes> cliente = clientesService.dameCliente(IdCliente);
        return new ResponseEntity(cliente, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> crearCliente(@RequestBody Clientes cliente) {
        List<String> msg = clientesService.crearCliente(cliente);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);

    }

    @PutMapping("/{IdCliente}")
    public ResponseEntity<?> modificarCliente(@RequestBody Clientes cliente, @PathVariable("IdCliente") int IdCliente) {
        List<String> msg = clientesService.modificarCliente(cliente, IdCliente);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @DeleteMapping("/{IdCliente}")
    public ResponseEntity<?> borrarCliente(@PathVariable("IdCliente") int IdCliente) {
        List<String> msg = clientesService.borrarCliente(IdCliente);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PatchMapping("/{IdCliente}/alta")
    public ResponseEntity<?> darAltaCliente(@PathVariable("IdCliente") int IdCliente) {
        List<String> msg = clientesService.darAltaCliente(IdCliente);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PatchMapping("/{IdCliente}/baja")
    public ResponseEntity<?> darBajaCliente(@PathVariable("IdCliente") int IdCliente) {
        List<String> msg = clientesService.darBajaCliente(IdCliente);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
