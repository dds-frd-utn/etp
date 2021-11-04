package org.utn.frd.dds.etp.util;

import org.utn.frd.dds.etp.dto.RequestOrderDTO;
import org.utn.frd.dds.etp.dto.RequestOrderItemDTO;
import org.utn.frd.dds.etp.dto.ResponseOrderDTO;
import org.utn.frd.dds.etp.entity.Order;
import org.utn.frd.dds.etp.entity.OrderItem;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderUtil {

    public static Order getOrder(RequestOrderDTO requestOrderDTO) {

        Order order = new Order();

        order.setLocalDateTime(LocalDateTime.now());
//        order.setLocal(requestOrderDTO );
//        order.setUser(requestOrderDTO.getUser());

        return order;
    }

    public static ResponseOrderDTO getResponseOrderDTO(Order order) {

        ResponseOrderDTO responseOrderDTO = new ResponseOrderDTO();

        responseOrderDTO.setUuid(order.getUuid());
        // responseOrderDTO.setLocal(order.getLocal());
        responseOrderDTO.setLocalDateTime(order.getLocalDateTime());
        responseOrderDTO.setUser(order.getUser());

        return responseOrderDTO;
    }

    public static List<ResponseOrderDTO> getListResponseOrderDTO(List<Order> listOrder) {

        return new ArrayList<ResponseOrderDTO>();
    }

    public static File generateCSV(Optional<Order> orderFound) {

        return null;
    }

    public static String generateQR(Optional<Order> orderFound) {

        return null;
    }

}
