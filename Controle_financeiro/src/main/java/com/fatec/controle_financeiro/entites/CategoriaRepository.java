package com.fatec.controle_financeiro.entites;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fatec.controle_financeiro.*;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByDescricao(String descricao);
}
