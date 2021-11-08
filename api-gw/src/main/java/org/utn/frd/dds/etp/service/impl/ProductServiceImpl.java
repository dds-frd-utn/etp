package org.utn.frd.dds.etp.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.utn.frd.dds.etp.entity.Product;
import org.utn.frd.dds.etp.repository.ProductRepository;
import org.utn.frd.dds.etp.repository.UserRepository;

import javax.transaction.Transactional;

/**
 * @author jonatan.moreira
 *
 */
@Service
@Transactional
public class ProductServiceImpl extends ServiceImpl<Product, String> {

    private static final Log log = LogFactory.getLog(ProductServiceImpl.class);

    @Autowired
    ProductRepository repository;

    @Override
    public ProductRepository getRepository() {
        return repository;
    }
}
