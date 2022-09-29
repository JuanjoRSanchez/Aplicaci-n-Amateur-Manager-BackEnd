package com.GestorPenas.demo.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.GestorPenas.demo.Model.Gestor;
import com.GestorPenas.demo.Model.Pena;

public interface PenaRepository extends JpaRepository<Pena, Long> {
	
	@Query
	Optional<Pena> findById(Long id);
	
	@Query
	List <Pena>  findByGestor(Gestor gestor);;
	
}
