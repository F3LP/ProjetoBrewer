package com.cervejaria.brewer.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cervejaria.brewer.model.Cerveja;
import com.cervejaria.brewer.model.Estilo;
import com.cervejaria.brewer.repository.CervejaRepository;

@Service
@Transactional
public class CervejaServiceImpl implements CervejaService {
	
	private CervejaRepository repository;

	@Autowired
	public CervejaServiceImpl(CervejaRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void save(Cerveja cerveja) {
		repository.save(cerveja);	
	}
	
}
