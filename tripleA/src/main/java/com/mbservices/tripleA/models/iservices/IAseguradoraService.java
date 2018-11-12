package com.mbservices.tripleA.models.iservices;

import java.util.List;

import com.mbservices.tripleA.models.entity.Aseguradora;

public interface IAseguradoraService {

	public List<Aseguradora> findAll();

	public void save(Aseguradora aseguradora);
	
	public Aseguradora findById(Long id);
	
	public void delete(Long id);
}
