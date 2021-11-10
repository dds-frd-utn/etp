package org.utn.frd.dds.etp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.utn.frd.dds.etp.entity.Order;
import org.utn.frd.dds.etp.entity.OrderItem;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, String> {

    @Query("select oi from OrderItem oi where oi.order.uuid = :orderUUID")
    Iterable<OrderItem> findAllFilterByOrderUUID(@Param("orderUUID") String orderUUID);


}
