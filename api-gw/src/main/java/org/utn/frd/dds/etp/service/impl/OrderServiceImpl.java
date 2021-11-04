package org.utn.frd.dds.etp.service.impl;

import com.etp.crud.service.impl.CrudServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.utn.frd.dds.etp.entity.Order;
import org.utn.frd.dds.etp.repository.OrderRepository;
import org.utn.frd.dds.etp.service.OrderService;
import org.utn.frd.dds.etp.util.OrderUtil;

import javax.transaction.Transactional;
import java.io.File;
import java.util.Optional;

/**
 * @author jonatan.moreira
 *
 */
@Service
@Transactional
public class OrderServiceImpl extends CrudServiceImpl<Order, String> implements OrderService {

    private static final Log log = LogFactory.getLog(OrderServiceImpl.class);

    @Autowired
    OrderRepository orderRepository;

    public File getCSV(String orderUUID) {

        Optional<Order> orderFound = orderRepository.findById(orderUUID);

        return OrderUtil.generateCSV(orderFound);
    }

    public String getQR(String orderUUID) {

        Optional<Order> orderFound = orderRepository.findById(orderUUID);

        return OrderUtil.generateQR(orderFound);
    }
}
