package com.cervejaria.brewer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cervejaria.brewer.model.Cerveja;
import com.cervejaria.brewer.model.Estilo;

public interface CervejaRepository extends JpaRepository<Cerveja, Long> {

	Optional<Estilo> findByNomeLike(String nome);

}
