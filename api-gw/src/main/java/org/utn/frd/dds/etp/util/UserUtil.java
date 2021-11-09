package org.utn.frd.dds.etp.util;

import org.utn.frd.dds.etp.dto.RequestUserDTO;
import org.utn.frd.dds.etp.dto.ResponseOrderDTO;
import org.utn.frd.dds.etp.dto.ResponseUserDTO;
import org.utn.frd.dds.etp.entity.Order;
import org.utn.frd.dds.etp.entity.User;

public class UserUtil {

    public static User getUser(RequestUserDTO requestUserDTO) {

        User user = new User();
        user.setEmail(requestUserDTO.getEmail());
        user.setFirstName(requestUserDTO.getFirstName());
        user.setLastName(requestUserDTO.getLastName());

        return user;
    }

    public static ResponseUserDTO getResponseUserDTO(User user) {

        ResponseUserDTO responseUserDTO = new ResponseUserDTO();

        responseUserDTO.setUuid(user.getUuid());
        responseUserDTO.setEmail(user.getEmail());
        responseUserDTO.setFirstName(user.getFirstName());
        responseUserDTO.setLastName(user.getLastName());

        return responseUserDTO;
    }

}
