package com.GestorPenas.demo.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.GestorPenas.demo.Model.Jugador;
import com.GestorPenas.demo.Model.Pena;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long>{

	@Query	
	Optional<Jugador> findById(Long id);
	
	@Query
	 List<Jugador> findByPena(Pena pena);
		
}
