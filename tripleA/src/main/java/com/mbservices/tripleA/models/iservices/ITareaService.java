package com.mbservices.tripleA.models.iservices;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mbservices.tripleA.models.entity.Tarea;

public interface ITareaService {
	public List<Tarea> findAll();

	public Page<Tarea> findAll(Pageable pegeable);

	public void save(Tarea tarea);
	
	public Tarea findById(Long id);
	
	public void delete(Long id);
}
