package org.utn.frd.dds.etp.controller.impl;

import com.google.zxing.WriterException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.utn.frd.dds.etp.dto.RequestMessageDTO;
import org.utn.frd.dds.etp.dto.RequestOrderDTO;
import org.utn.frd.dds.etp.dto.ResponseMessage;
import org.utn.frd.dds.etp.dto.ResponseNewOrderDTO;
import org.utn.frd.dds.etp.entity.Order;
import org.utn.frd.dds.etp.entity.User;
import org.utn.frd.dds.etp.service.impl.OrderServiceImpl;
import org.utn.frd.dds.etp.util.OrderUtil;
import org.utn.frd.dds.etp.util.QR;
import org.utn.frd.dds.etp.util.RequestMessageUtil;
import org.utn.frd.dds.etp.util.UserUtil;

import javax.persistence.EntityNotFoundException;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("orders")
@Api(tags ="Orders", description = "Manejo de ordenes.", position = 2)
public class OrderControllerImpl {

	private static final Log log = LogFactory.getLog(OrderControllerImpl.class);

    @Autowired
	OrderServiceImpl service;

	@RequestMapping(value="/create", method= RequestMethod.POST)
	@ApiOperation(value = "Crear una orden", notes = "Crear una nueva Orden")
	public ResponseEntity create(@RequestBody RequestOrderDTO requestOrderDTO, BindingResult bindingResult){

		if(!bindingResult.hasErrors()){

			try {

				return ResponseEntity.ok(service.save(OrderUtil.getOrder(requestOrderDTO)));
			} catch (Exception e) {

				return RequestMessageUtil.getResponseEntityOk(ResponseMessage.ENTITY_EXITS);
			}
		}

		return ResponseEntity.badRequest().build();
	}

//	@RequestMapping(value="/update", method= RequestMethod.PUT)
//	@ApiOperation(value = "Actualizar un orden", notes = "Actualizar un orden")
	public ResponseEntity update(@RequestBody Order orderDTO , BindingResult bindingResult){

		if(!bindingResult.hasErrors()){

			try {

				return ResponseEntity.ok(service.save(orderDTO));
			} catch (Exception e) {

				return RequestMessageUtil.getResponseEntityOk(ResponseMessage.ENTITY_EXITS);
			}
		}

		return ResponseEntity.badRequest().build();
	}

	@RequestMapping(value="/delete/{uuid}",method = RequestMethod.DELETE)
	@ApiOperation(value = "Eliminar una orden", notes = "Eliminar una Orden")
	public ResponseEntity delete(@PathVariable String uuid){

		RequestMessageDTO requestMessageDTO = null;
		try {

			service.deleteById(uuid);
		} catch (Exception e) {

			return RequestMessageUtil.getResponseEntityOk(ResponseMessage.ENTITY_NOT_EXISTS);
		}

		return RequestMessageUtil.getResponseEntityOk(ResponseMessage.ENTITY_DELETE);
	}

	@RequestMapping(value="/find/{uuid}", method= RequestMethod.GET)
	@ApiOperation(value = "Buscar Orden por Id", notes = "Buscar Orden por Id")
	public ResponseEntity findOrderById(@PathVariable String uuid){

		Optional<Order> order = service.findById(uuid);
		if(order.isPresent())

			return ResponseEntity.ok(order);
		else
			return RequestMessageUtil.getResponseEntityOk(ResponseMessage.ENTITY_NOT_EXISTS);
	}

	@RequestMapping(value="/findAll/{uuid}", method= RequestMethod.GET)
	@ApiOperation(value = "Buscar todas las ordenes de un usuario", notes = "Buscar todas las ordenes de un usuario.")
	public ResponseEntity<List<Order>>findAll(@PathVariable String uuid){

		// List<Order> orders = super.service.findById(uuid).stream().collect(Collectors.toList());

		List<Order> orders = new ArrayList<>();

		return ResponseEntity.ok(orders);
	}

	@RequestMapping(value="/qr/{uuid}",method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.IMAGE_PNG_VALUE})
	@ApiOperation(value = "Obtener codigo QR", notes = "Obtener codigo QR")
	public ResponseEntity getQR(@PathVariable String uuid){

		Optional<Order> order = service.findById(uuid);
		if(order.isPresent()) {

			return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(QR.createQR(uuid));
		} else {

			return RequestMessageUtil.getResponseEntityOk(ResponseMessage.ENTITY_NOT_EXISTS);
		}
	}

}
