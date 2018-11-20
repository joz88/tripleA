package com.mbservices.tripleA.models.idao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mbservices.tripleA.models.entity.Documento;

public interface IDocumentoDao extends PagingAndSortingRepository<Documento, Long> {

}
