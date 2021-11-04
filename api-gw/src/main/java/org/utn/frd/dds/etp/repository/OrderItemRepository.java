package org.utn.frd.dds.etp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.utn.frd.dds.etp.entity.Order;
import org.utn.frd.dds.etp.entity.OrderItem;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, String> {

}
