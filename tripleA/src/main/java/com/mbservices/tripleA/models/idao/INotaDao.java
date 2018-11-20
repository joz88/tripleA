package com.mbservices.tripleA.models.idao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mbservices.tripleA.models.entity.Nota;

public interface INotaDao extends PagingAndSortingRepository<Nota, Long> {

}
