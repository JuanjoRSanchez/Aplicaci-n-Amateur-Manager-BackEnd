package com.GestorPenas.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GestorPenas.demo.Model.Jugador;
import com.GestorPenas.demo.Model.Pena;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long>{

	Optional<Jugador> findById(Long id);



	@Override
	List<Jugador> findAll(Sort sort);

	<Jugador>
	
	 List<Jugador> findByPena(Pena pena);



	List<Jugador> findAll();

	Optional<Jugador> findByTelefono(String telefono);
}
