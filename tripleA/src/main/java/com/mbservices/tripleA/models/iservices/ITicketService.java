package com.mbservices.tripleA.models.iservices;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mbservices.tripleA.models.entity.Ticket;

public interface ITicketService {
	public List<Ticket> findAll();

	public Page<Ticket> findAll(Pageable pegeable);

	public void save(Ticket ticket);
	
	public Ticket findById(Long id);
	
	public void delete(Long id);
}
