package com.mbservices.tripleA.utils.crud;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CrudService<T, K> {
	public List<T> findAll();

	public Page<T> findAll(Pageable pegeable);

	public void save(T aseguradora);
	
	public T findById(K id);
	
	public void delete(K id);
}
