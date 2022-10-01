package com.GestorPenas.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GestorPenas.demo.model.Pista;

public interface PistaRepository extends JpaRepository<Pista, Long>{

	Optional <Pista> findPistaById (Long id);
}
