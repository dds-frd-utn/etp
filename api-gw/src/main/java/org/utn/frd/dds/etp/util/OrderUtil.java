package org.utn.frd.dds.etp.util;

import org.utn.frd.dds.etp.dto.RequestOrderDTO;
import org.utn.frd.dds.etp.dto.RequestOrderItemDTO;
import org.utn.frd.dds.etp.dto.ResponseNewOrderDTO;
import org.utn.frd.dds.etp.dto.ResponseOrderDTO;
import org.utn.frd.dds.etp.entity.Local;
import org.utn.frd.dds.etp.entity.Order;
import org.utn.frd.dds.etp.entity.OrderItem;
import org.utn.frd.dds.etp.entity.User;
import org.utn.frd.dds.etp.template.LocalTemplate;
import org.utn.frd.dds.etp.template.UserTemplate;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderUtil {

    public static Order getOrder(RequestOrderDTO requestOrderDTO) {

        //User user = UserTemplate.getUser();

        //Local local = LocalTemplate.getLocal();

        Order order = new Order();
        order.setLocalDateTime(LocalDateTime.now());
        //order.setUser(user);
        //order.setLocal(local);


//        order.setLocal(requestOrderDTO );
//        order.setUser(requestOrderDTO.getUser());

        return order;
    }

    public static ResponseNewOrderDTO getResponseOrderDTO(Order order) {

        ResponseNewOrderDTO responseNewOrderDTO = new ResponseNewOrderDTO();

        responseNewOrderDTO.setUuid(order.getUuid());
        responseNewOrderDTO.setLocalDateTime(order.getLocalDateTime());

        return responseNewOrderDTO;
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
