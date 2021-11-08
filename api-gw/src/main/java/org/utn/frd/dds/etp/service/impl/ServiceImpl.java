package org.utn.frd.dds.etp.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public abstract class ServiceImpl<T, ID> {

    public abstract CrudRepository getRepository();

    public <S extends T> S save(T object) {

        return (S) getRepository().save(object);
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
