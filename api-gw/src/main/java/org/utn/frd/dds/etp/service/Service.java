package org.utn.frd.dds.etp.service;

import org.springframework.data.repository.CrudRepository;
import org.utn.frd.dds.etp.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

public interface Service<T,ID> {

    public abstract CrudRepository getRepository();

    public void setRepository(CrudRepository repository);

    public <S extends T> S save(T object);

    public Iterable<T> saveAll(List<T> list);

    public void update(T object) throws EntityNotFoundException;

    public void deleteById(ID id) throws EntityNotFoundException;

    public Iterable<T> findAll();

    public Optional<T> findById(ID id) throws EntityNotFoundException;

}
