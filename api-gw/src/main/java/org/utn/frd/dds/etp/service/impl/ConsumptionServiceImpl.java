package org.utn.frd.dds.etp.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.utn.frd.dds.etp.entity.Consumption;
import org.utn.frd.dds.etp.entity.Product;
import org.utn.frd.dds.etp.repository.ConsumptionRepository;
import org.utn.frd.dds.etp.repository.ProductRepository;

import javax.transaction.Transactional;

/**
 * @author jonatan.moreira
 *
 */
@Service
@Transactional
public class ConsumptionServiceImpl extends ServiceImpl<Consumption, String> {

    private static final Log log = LogFactory.getLog(ConsumptionServiceImpl.class);

    @Autowired
    ConsumptionRepository repository;

    @Override
    public ConsumptionRepository getRepository() {
        return repository;
    }
}
