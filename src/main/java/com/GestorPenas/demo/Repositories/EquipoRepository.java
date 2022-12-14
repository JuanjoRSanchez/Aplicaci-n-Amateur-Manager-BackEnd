
package com.GestorPenas.demo.Repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.GestorPenas.demo.Model.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long>{
	
	@Query
	Optional<Equipo> findById(Long id);
	
}
