package com.mbservices.tripleA.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mbservices.tripleA.models.entity.Ticket;
import com.mbservices.tripleA.models.idao.ITicketDao;
import com.mbservices.tripleA.utils.crud.CrudService;

public class TicketService implements CrudService<Ticket,Long> {

	@Autowired
	private ITicketDao dao;
	
	@Override
	public List<Ticket> findAll() {
		return (List<Ticket>) this.dao.findAll();
	}

	@Override
	public Page<Ticket> findAll(Pageable pegeable) {
		return this.dao.findAll(pegeable);
	}

	@Override
	public void save(Ticket ticket) {
		this.dao.save(ticket);
	}

	@Override
	public Ticket findById(Long id) {
		return this.dao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		this.dao.deleteById(id);
	}

}
