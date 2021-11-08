package org.utn.frd.dds.etp.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.utn.frd.dds.etp.entity.OrderItem;
import org.utn.frd.dds.etp.repository.OrderItemRepository;
import org.utn.frd.dds.etp.repository.OrderRepository;

import javax.transaction.Transactional;

/**
 * @author jonatan.moreira
 *
 */
@Service
@Transactional
public class OrderItemServiceImpl extends ServiceImpl<OrderItem, String> {

    private static final Log log = LogFactory.getLog(OrderItemServiceImpl.class);

    @Autowired
    OrderItemRepository repository;

    @Override
    public OrderItemRepository getRepository() {
        return repository;
    }


}
