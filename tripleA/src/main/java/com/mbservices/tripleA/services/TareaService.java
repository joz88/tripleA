package com.mbservices.tripleA.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mbservices.tripleA.models.entity.Tarea;
import com.mbservices.tripleA.models.idao.ITareaDao;
import com.mbservices.tripleA.utils.crud.CrudService;

public class TareaService implements CrudService<Tarea, Long> {

	@Autowired
	private ITareaDao dao;
	
	@Override
	public List<Tarea> findAll() {
		return (List<Tarea>) this.dao.findAll();
	}

	@Override
	public Page<Tarea> findAll(Pageable pegeable) {
		return this.dao.findAll(pegeable);
	}

	@Override
	public void save(Tarea tarea) {
		this.dao.save(tarea);
	}

	@Override
	public Tarea findById(Long id) {
		return this.dao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		this.dao.deleteById(id);;
	}

}
