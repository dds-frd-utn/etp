package org.utn.frd.dds.etp.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.utn.frd.dds.etp.entity.Order;
import org.utn.frd.dds.etp.entity.OrderItem;
import org.utn.frd.dds.etp.repository.OrderRepository;
import org.utn.frd.dds.etp.repository.ProductRepository;
import org.utn.frd.dds.etp.util.OrderUtil;

import javax.transaction.Transactional;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author jonatan.moreira
 *
 */
@Service
@Transactional
public class OrderServiceImpl extends ServiceImpl<Order, String> {

    private static final Log log = LogFactory.getLog(OrderServiceImpl.class);

    @Autowired
    OrderRepository repository;

    public List<Order> findAllFilterByUserUUID(String userUUID) {

        Iterable<Order> list = repository.findAllFilterByUserUUID(userUUID);

        List<Order> result = new ArrayList<Order>();
        list.forEach(result::add);

        return result;
    }

    @Override
    public OrderRepository getRepository() {
        return repository;
    }

    public File getCSV(String orderUUID) {

        Optional<Order> orderFound = getRepository().findById(orderUUID);

        return OrderUtil.generateCSV(orderFound);
    }

    public String getQR(String orderUUID) {

        Optional<Order> orderFound = getRepository().findById(orderUUID);

        return OrderUtil.generateQR(orderFound);
    }
}
