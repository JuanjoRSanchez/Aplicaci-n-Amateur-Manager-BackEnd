package com.GestorPenas.demo.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GestorPenas.demo.Model.Pista;

public interface PistaRepository extends JpaRepository<Pista, Long>{

	Optional <Pista> findPistaById (Long id);
}
