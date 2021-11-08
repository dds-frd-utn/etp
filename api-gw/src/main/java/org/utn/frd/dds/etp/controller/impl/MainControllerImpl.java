package org.utn.frd.dds.etp.controller.impl;

import io.swagger.annotations.Api;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;
import org.utn.frd.dds.etp.entity.Order;

@RestController
@RequestMapping("pin")
@Api(tags ="Main", description = "Verifica si el servicio esta activo.", position = 0)
public class MainControllerImpl {

	private static final Log log = LogFactory.getLog(MainControllerImpl.class);

	@RequestMapping(value="", method= RequestMethod.GET)
	@ResponseBody
	String home() {

		log.info("Active service!!");

		return "Active service!!";
	}

}
