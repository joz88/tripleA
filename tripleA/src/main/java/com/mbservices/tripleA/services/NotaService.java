package com.mbservices.tripleA.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mbservices.tripleA.models.entity.Nota;
import com.mbservices.tripleA.models.idao.INotaDao;
import com.mbservices.tripleA.utils.crud.CrudService;

public class NotaService implements CrudService<Nota, Long> {

	@Autowired
	private INotaDao dao;
	
	@Override
	public List<Nota> findAll() {
		return (List<Nota>) this.dao.findAll();
	}

	@Override
	public Page<Nota> findAll(Pageable pegeable) {
		return this.dao.findAll(pegeable);
	}

	@Override
	public void save(Nota nota) {
		this.dao.save(nota);
	}

	@Override
	public Nota findById(Long id) {
		return this.dao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		this.dao.deleteById(id);
	}
	
}
