package com.daniel.exerciciosb.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.exerciciosb.models.Produto;
import com.daniel.exerciciosb.repositories.ProdutoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public Produto novoProduto(@RequestBody @Valid Produto produto) {
        return produtoRepository.save(produto);
    }

    @GetMapping
    public Iterable<Produto> obterProduto() {
        return produtoRepository.findAll();
    }

    @GetMapping("/nome/{nome}")
    public Iterable<Produto> obterProdutoPorNome(@PathVariable String nome) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    } 

    @GetMapping("/pagina/{numero}")
    public Iterable<Produto> obterProdutoPorPagina(@PathVariable int numero) {
        Pageable page = PageRequest.of(numero, 3);
        return produtoRepository.findAll(page);
    } 
    
    @GetMapping("/{id}")
    public Optional<Produto> obterProdutoPorId(@PathVariable Long id) {
        return produtoRepository.findById(id);
    }

    @PutMapping
    public Produto alterarProduto(@Valid Produto produto) {
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/{id}")
    public void excluirProduto(@PathVariable Long id) {
        produtoRepository.deleteById(id);
    }
}
