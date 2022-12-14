package com.GestorPenas.demo.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.GestorPenas.demo.Model.Partido;
import com.GestorPenas.demo.Model.Pena;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {

	@Query
	Optional <Partido> findPartidoById(Long id);
	
	@Query
	List <Partido> findPartidoByPena(Pena Pena);
}
