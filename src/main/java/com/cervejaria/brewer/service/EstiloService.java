package com.cervejaria.brewer.service;

import java.util.List;
import java.util.Optional;

import com.cervejaria.brewer.model.Estilo;

public interface EstiloService {

	List<Estilo> findAll();

	Optional<Estilo> finById(Long codigo);
}
