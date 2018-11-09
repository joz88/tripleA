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
	@Transactional(readOnly = true)
	@Override
	public List<Aseguradora> findAll() {
		return em.createQuery("from Aseguradora").getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Aseguradora findById(Long id) {
		return em.find(Aseguradora.class, id);
	}

	@Override
	@Transactional
	public void save(Aseguradora aseguradora) {
		if (aseguradora.getId() != null & aseguradora.getId() > 0) {
			em.merge(aseguradora);
		} else {
			em.persist(aseguradora);
		}
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Aseguradora aseguradora = this.findById(id);
		em.remove(aseguradora);
	}

}
