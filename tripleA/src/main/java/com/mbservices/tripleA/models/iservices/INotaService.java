package com.mbservices.tripleA.models.iservices;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mbservices.tripleA.models.entity.Nota;

public interface INotaService {

	public List<Nota> findAll();

	public Page<Nota> findAll(Pageable pegeable);

	public void save(Nota nota);
	
	public Nota findById(Long id);
	
	public void delete(Long id);
}
