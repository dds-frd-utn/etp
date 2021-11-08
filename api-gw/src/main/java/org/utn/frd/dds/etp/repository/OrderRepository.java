package org.utn.frd.dds.etp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.utn.frd.dds.etp.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, String> {

}
