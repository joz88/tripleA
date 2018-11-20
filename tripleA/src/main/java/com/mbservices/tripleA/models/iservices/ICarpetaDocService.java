package com.mbservices.tripleA.models.iservices;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mbservices.tripleA.models.entity.CarpetaDoc;

public interface ICarpetaDocService {
	public List<CarpetaDoc> findAll();

	public Page<CarpetaDoc> findAll(Pageable pegeable);

	public void save(CarpetaDoc carpetaDoc);
	
	public CarpetaDoc findById(Long id);
	
	public void delete(Long id);
}
