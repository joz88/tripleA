package com.mbservices.tripleA.models.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mbservices.tripleA.models.dao.IAseguradoraDao;
import com.mbservices.tripleA.models.entity.Aseguradora;

@Repository
public class AseguradoraDaoImpl implements IAseguradoraDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Aseguradora> findAll() {
		return em.createQuery("from Aseguradora").getResultList();
	}

	@Override
	@Transactional
	public void save(Aseguradora aseguradora) {
		em.persist(aseguradora);
	}

}
