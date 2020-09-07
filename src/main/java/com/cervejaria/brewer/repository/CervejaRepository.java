package com.cervejaria.brewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cervejaria.brewer.model.Cerveja;

public interface CervejaRepository extends JpaRepository<Cerveja, Long> {

}
