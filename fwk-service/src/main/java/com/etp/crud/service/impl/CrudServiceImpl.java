/**
 * uala-jona . com.uala.tools.crud.service.impl
 */
package com.etp.crud.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.etp.crud.repository.CrudRepository;
import com.etp.crud.service.CrudService;


/**
 * @author jonatan.moreira
 *
 */
@Service
public class CrudServiceImpl<T, ID> implements CrudService<T, ID> {

	CrudRepository<T, ID> repository;
	
	public CrudRepository<T, ID> getRepository() {

		return this.getRepository();
	}

	
	public Iterable<T> findAll() {

		
		
		return repository.findAll();
	}
	
	public Optional<T> findById(ID id) throws EntityNotFoundException {
		
		return repository.findById(id);
	}

	@SuppressWarnings("unchecked")	
	public <S extends T> S save(T object) {

		return (S) repository.save(object);
	}
	
	public Iterable<T> saveAll(List<T> list) {
		
		return repository.saveAll(list);
	}
	
	public void update(T object) throws EntityNotFoundException {

		repository.save(object);
	}
	
	public void deleteById(ID id) throws EntityNotFoundException {

		repository.deleteById(id);
	}


	@Override
	public CrudRepository<T, ID> getRepository1() {
		
		return null;
	}

}
