/**
 * uala-jona . com.uala.tools.crud.service
 */
package com.etp.crud.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.etp.crud.repository.CrudRepository;


/**
 * @author jonatan.moreira
 *
 */
public interface CrudService<T, ID> {
	
	CrudRepository<T, ID> getRepository();
	
	Iterable<T> findAll();

	Optional<T> findById(ID id) throws EntityNotFoundException;
	
	<S extends T> S save(T object);

	Iterable<T> saveAll(List<T> list);
	
	void update(T object) throws EntityNotFoundException;

	void deleteById(ID id) throws EntityNotFoundException;

}
