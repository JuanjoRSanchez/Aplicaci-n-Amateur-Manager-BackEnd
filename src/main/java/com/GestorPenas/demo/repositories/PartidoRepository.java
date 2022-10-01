package com.GestorPenas.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.GestorPenas.demo.model.Partido;
import com.GestorPenas.demo.model.Pena;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {

	@Query
	Optional <Partido> findPartidoById(Long id);
	
	@Query
	List <Partido> findPartidoByPena(Pena Pena);
}
