package org.utn.frd.dds.etp.controller.impl;

import com.etp.crud.controller.impl.CrudControllerImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.utn.frd.dds.etp.controller.OrderController;
import org.utn.frd.dds.etp.entity.Order;
import org.utn.frd.dds.etp.service.impl.OrderServiceImpl;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("pin")
@Api(tags ="Main", description = "Verifica si el servicio esta activo.", position = 0)
public class MainControllerImpl extends CrudControllerImpl<Order, String> {

	private static final Log log = LogFactory.getLog(MainControllerImpl.class);

	@RequestMapping(value="", method= RequestMethod.GET)
	@ResponseBody
	String home() {

		log.info("Active service!!");

		return "Active service!!";
	}

}
