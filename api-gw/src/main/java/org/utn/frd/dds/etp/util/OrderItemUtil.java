package org.utn.frd.dds.etp.util;

import org.utn.frd.dds.etp.dto.RequestOrderItemDTO;
import org.utn.frd.dds.etp.dto.ResponseOrderDTO;
import org.utn.frd.dds.etp.dto.ResponseOrderItemDTO;
import org.utn.frd.dds.etp.dto.ResponseProductDTO;
import org.utn.frd.dds.etp.entity.Order;
import org.utn.frd.dds.etp.entity.OrderItem;
import org.utn.frd.dds.etp.entity.Product;

public class OrderItemUtil {

    public static OrderItem getOrderItem(RequestOrderItemDTO requestOrderItemDTO) {

        OrderItem orderItem = new OrderItem();

        // TODO:
        // orderItem.setOrder(requestOrderItemDTO.getOrder());
        orderItem.setCount(requestOrderItemDTO.getCount());
        orderItem.setPresentation(requestOrderItemDTO.getPresentation());
        orderItem.setProduct(requestOrderItemDTO.getProduct());

        return orderItem;
    }

    public static ResponseOrderItemDTO getResponseOrderItemDTO(OrderItem orderItem) {

        ResponseOrderItemDTO responseOrderItemDTO = new ResponseOrderItemDTO();

        responseOrderItemDTO.setUuid(orderItem.getUuid());
        responseOrderItemDTO.setOrder(orderItem.getOrder());
        responseOrderItemDTO.setCount(orderItem.getCount());
        responseOrderItemDTO.setProduct(orderItem.getProduct());
        responseOrderItemDTO.setPresentation(orderItem.getPresentation());

        return responseOrderItemDTO;
    }
}
