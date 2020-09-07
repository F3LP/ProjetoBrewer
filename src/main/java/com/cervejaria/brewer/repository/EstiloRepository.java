package com.cervejaria.brewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cervejaria.brewer.model.Estilo;

public interface EstiloRepository extends JpaRepository<Estilo, Long> {

}
