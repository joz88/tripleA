package com.mbservices.tripleA.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mbservices.tripleA.models.entity.Aseguradora;
import com.mbservices.tripleA.models.idao.IAseguradoraDao;
import com.mbservices.tripleA.models.iservices.IAseguradoraService;

@Service
public class AseguradoraService implements IAseguradoraService {

	@Autowired 
	IAseguradoraDao dao;
	
	@Override
	@Transactional
	public List<Aseguradora> findAll() {
		return (List<Aseguradora>) dao.findAll();
	}

	@Override
	@Transactional
	public Aseguradora findById(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void save(Aseguradora aseguradora) {
		dao.save(aseguradora);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		dao.deleteById(id);
	}

	@Override
	public Page<Aseguradora> findAll(Pageable pegeable) {
		return dao.findAll(pegeable);
	}

}
