package com.daniel.exerciciosb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.exerciciosb.models.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    // @GetMapping
    // public Cliente obterCliente() {
    //     return new Cliente(20, "Daniel", "123.456.789-00");
    // }

    @GetMapping("/{id}")
    public Cliente obterClientePorId(@PathVariable int id) {
        return new Cliente(id, "Valéria", "123.456.789-00");
    }
    
    @GetMapping
    public Cliente obterClientePorId2(@RequestParam(name = "id") int id) {
        return new Cliente(id, "Valéria", "123.456.789-00");
    }
}
