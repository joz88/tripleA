package com.mbservices.tripleA.models.idao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mbservices.tripleA.models.entity.Aseguradora;

public interface IAseguradoraDao extends PagingAndSortingRepository<Aseguradora,Long>{
	
	@Query("select a from Aseguradora as a where a.nombre like %?1%")
	public List<Aseguradora> findByNombre(String term);
	
}
