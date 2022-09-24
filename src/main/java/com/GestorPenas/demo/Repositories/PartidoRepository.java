package com.GestorPenas.demo.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.GestorPenas.demo.Model.Partido;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {

	@Query
	Optional <Partido> findPartidoById(Long id);
	
}
