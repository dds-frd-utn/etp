package org.utn.frd.dds.etp.util;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.utn.frd.dds.etp.dto.RequestMessageDTO;
import org.utn.frd.dds.etp.dto.ResponseMessage;

public class RequestMessageUtil {

    public static ResponseEntity getResponseEntityOk(ResponseMessage responseMessage){

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new RequestMessageDTO(responseMessage.getCode(), responseMessage.getDescription()));
    }


}
