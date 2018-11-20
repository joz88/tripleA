package com.mbservices.tripleA.models.idao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mbservices.tripleA.models.entity.Ticket;

public interface ITicketDao extends PagingAndSortingRepository<Ticket, Long>{

}
