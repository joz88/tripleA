package com.mbservices.tripleA.models.idao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mbservices.tripleA.models.entity.Tarea;

public interface ITareaDao extends PagingAndSortingRepository<Tarea, Long> {
	
}
