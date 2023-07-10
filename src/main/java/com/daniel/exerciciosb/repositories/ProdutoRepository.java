package com.daniel.exerciciosb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.exerciciosb.models.Produto;
import java.util.List;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Iterable<Produto> findByNomeContainingIgnoreCase(String nome);
    
}
