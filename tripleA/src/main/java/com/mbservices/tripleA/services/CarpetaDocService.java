package com.mbservices.tripleA.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mbservices.tripleA.models.entity.CarpetaDoc;
import com.mbservices.tripleA.models.idao.ICarpetaDocDao;
import com.mbservices.tripleA.utils.crud.CrudService;

public class CarpetaDocService implements CrudService<CarpetaDoc, Long> {

	@Autowired
	private ICarpetaDocDao dao;
	
	@Override
	public List<CarpetaDoc> findAll() {
		return (List<CarpetaDoc>) this.dao.findAll();
	}

	@Override
	public Page<CarpetaDoc> findAll(Pageable pegeable) {
		return this.dao.findAll(pegeable);
	}

	@Override
	public void save(CarpetaDoc carpetaDoc) {
		this.dao.save(carpetaDoc);
	}

	@Override
	public CarpetaDoc findById(Long id) {
		return this.dao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		this.dao.deleteById(id);
	}

}
