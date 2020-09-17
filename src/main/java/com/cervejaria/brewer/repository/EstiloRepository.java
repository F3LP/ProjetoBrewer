package com.cervejaria.brewer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cervejaria.brewer.model.Estilo;

public interface EstiloRepository extends JpaRepository<Estilo, Long> {
	
	Optional<Estilo> findByNomeLike(String nome);

}
