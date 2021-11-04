/**
 * uala-jona . com.uala.controller.impl
 */
package com.etp.crud.controller.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.etp.crud.controller.CrudController;
import com.etp.crud.service.CrudService;



/**
 * @author jonatan.moreira
 *
 */
@Controller
public class CrudControllerImpl<T, ID> implements CrudController<T, ID> {

	@Autowired
	protected CrudService<T, ID> service;

	public Iterable<T> findAll() {

		return service.findAll();
	}

	public Optional<T> findById(ID id) throws EntityNotFoundException {

		return service.findById(id);
	}

	public T save(T object) {

		return service.save(object);
	}

	public Iterable<T> saveAll(List<T> list) {

		return service.saveAll(list);
	}

	public void update(T object) throws EntityNotFoundException {

		service.update(object);
	}

	public void deleteById(ID id) throws EntityNotFoundException {

		service.deleteById(id);
	}

}
