package com.daniel.exerciciosb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    @GetMapping("/somar/{a}/{b}")
    public Double somar(@PathVariable Double a, @PathVariable Double b) {
        return a + b;
    }

    @GetMapping("/subtrair")
    public Double subtrair(@RequestParam(name = "a") Double a, @RequestParam(name = "b") Double b) {
        return a - b;
    }
    
}
