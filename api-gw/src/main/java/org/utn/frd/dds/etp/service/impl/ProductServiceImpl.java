package org.utn.frd.dds.etp.service.impl;

import com.etp.crud.service.impl.CrudServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.utn.frd.dds.etp.entity.Order;
import org.utn.frd.dds.etp.entity.Product;
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
public class ProductServiceImpl extends CrudServiceImpl<Product, String> implements OrderService {

}
