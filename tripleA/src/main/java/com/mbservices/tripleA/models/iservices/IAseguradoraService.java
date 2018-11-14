package com.mbservices.tripleA.models.iservices;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mbservices.tripleA.models.entity.Aseguradora;

public interface IAseguradoraService {

	public List<Aseguradora> findAll();

	public Page<Aseguradora> findAll(Pageable pegeable);

	public void save(Aseguradora aseguradora);
	
	public Aseguradora findById(Long id);
	
	public void delete(Long id);
}
