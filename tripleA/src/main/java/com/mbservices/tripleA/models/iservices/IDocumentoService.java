package com.mbservices.tripleA.models.iservices;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mbservices.tripleA.models.entity.Documento;

public interface IDocumentoService {
	public List<Documento> findAll();

	public Page<Documento> findAll(Pageable pegeable);

	public void save(Documento documento);
	
	public Documento findById(Long id);
	
	public void delete(Long id);
	
}
