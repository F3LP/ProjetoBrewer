package com.cervejaria.brewer.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cervejaria.brewer.model.Estilo;
import com.cervejaria.brewer.repository.EstiloRepository;
import com.cervejaria.brewer.service.exception.NomeEstiloJaCadastradoException;

@Service
@Transactional
public class EstiloSeviceImpl implements EstiloService {

	private EstiloRepository repository;

	@Autowired
	public EstiloSeviceImpl(EstiloRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Estilo> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Estilo> finById(Long codigo) {
		return repository.findById(codigo);
	}

	@Override
	public Estilo save(Estilo estilo) {
		
		Optional<Estilo> estiloOptional = repository.findByNomeLike(estilo.getNome());
		
		if (estiloOptional.isPresent()) {
			throw new NomeEstiloJaCadastradoException("Nome do estilo já cadastrado.");
		}
		
		return repository.saveAndFlush(estilo);
	}
	
	
}
