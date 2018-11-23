package com.mbservices.tripleA.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mbservices.tripleA.models.entity.Aseguradora;
import com.mbservices.tripleA.models.idao.IAseguradoraDao;
import com.mbservices.tripleA.utils.crud.CrudService;

@Service
public class AseguradoraService implements CrudService<Aseguradora,Long> {

	@Autowired 
	private IAseguradoraDao dao;
	
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
		this.dao.deleteById(id);
	}

	@Override
	public Page<Aseguradora> findAll(Pageable pegeable) {
		return dao.findAll(pegeable);
	}

	@Transactional
	public List<Aseguradora> findByNombre(String term){
		List<Aseguradora> l =this.dao.findByNombreLikeIgnoreCase("%"+term+"%");
		if (l.isEmpty()) {
			Aseguradora a = new Aseguradora();
			a.setNombre("Sin Datos");
			a.setId(new Long(0));
			l.add(a);
		}
		return l;
	}

	@Transactional
	public String getNombreByid(Long id){
		return this.findById(id).getNombre();
	}
}
