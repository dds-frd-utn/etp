/**
 * uala-jona . com.uala.controller.impl
 */
package com.etp.crud.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

/**
 * @author jonatan.moreira
 *
 */
public interface CrudController<T, ID>{
	
	Iterable<T> findAll();

	Optional<T> findById(ID id) throws EntityNotFoundException;
	
	T save(T object);

	Iterable<T> saveAll(List<T> list);
	
	void update(T object) throws EntityNotFoundException;

	void deleteById(ID id) throws EntityNotFoundException;
	
}
