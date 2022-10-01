package com.GestorPenas.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.GestorPenas.demo.model.Jugador;
import com.GestorPenas.demo.model.Pena;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long>{

	@Query	
	Optional<Jugador> findById(Long id);
	
	@Query
	 List<Jugador> findByPena(Pena pena);
		
}
