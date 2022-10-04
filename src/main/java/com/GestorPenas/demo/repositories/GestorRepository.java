
package com.GestorPenas.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.GestorPenas.demo.Model.Gestor;

@Repository
public interface GestorRepository extends JpaRepository<Gestor, Long>{
	
	@Query
	Optional <Gestor>  findById(Long id);

	@Query
	Optional <Gestor>   findByTelefono(String telefono);
	
	@Query
	Optional <Gestor> findByPass(String pass);
	
	@Query
	Optional <Gestor>  findByEmail(String email);
	
	@Query
	Optional <Gestor> findByNombre(String nombre);
}
