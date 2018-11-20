package com.mbservices.tripleA.models.idao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mbservices.tripleA.models.entity.CarpetaDoc;

public interface ICarpetaDocDao extends PagingAndSortingRepository<CarpetaDoc, Long> {

}
