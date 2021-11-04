package org.utn.frd.dds.etp.service.impl;

import com.etp.crud.service.impl.CrudServiceImpl;
import org.springframework.stereotype.Service;
import org.utn.frd.dds.etp.entity.OrderItem;
import org.utn.frd.dds.etp.entity.Product;
import org.utn.frd.dds.etp.service.OrderItemService;
import org.utn.frd.dds.etp.service.OrderService;

import javax.transaction.Transactional;

/**
 * @author jonatan.moreira
 *
 */
@Service
@Transactional
public class OrderItemServiceImpl extends CrudServiceImpl<OrderItem, String> implements OrderItemService {

}
