package com.mbservices.tripleA.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mbservices.tripleA.models.entity.Documento;
import com.mbservices.tripleA.models.idao.IDocumentoDao;
import com.mbservices.tripleA.utils.crud.CrudService;

public class DocumentoService implements CrudService<Documento, Long> {

	@Autowired
	private IDocumentoDao dao;
	@Override
	public List<Documento> findAll() {
		return (List<Documento>) this.dao.findAll();
	}

	@Override
	public Page<Documento> findAll(Pageable pegeable) {
		return this.dao.findAll(pegeable);
	}

	@Override
	public void save(Documento documento) {
		this.dao.save(documento);
	}

	@Override
	public Documento findById(Long id) {
		return this.dao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		this.dao.deleteById(id);
	}

}
