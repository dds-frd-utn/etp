package org.utn.frd.dds.etp.service.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public abstract class ServiceImpl<T, ID> {

    public abstract CrudRepository getRepository();

    public <S extends T> S save(T object) throws EntityExistsException {

        try {
            return (S) getRepository().save(object);
        } catch (Exception e) {

            throw new EntityExistsException();
        }
    }

    public Iterable<T> saveAll(List<T> list) {

        return getRepository().saveAll(list);
    }

    public void update(T object) throws EntityNotFoundException {

        getRepository().save(object);
    }

    public void deleteById(ID id) throws EntityNotFoundException {

        getRepository().deleteById(id);
    }

    public Iterable<T> findAll() {

        return getRepository().findAll();
    }

    public Optional<T> findById(ID id) throws EntityNotFoundException {

        return getRepository().findById(id);
    }
}
