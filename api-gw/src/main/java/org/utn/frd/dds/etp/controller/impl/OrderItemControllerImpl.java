package org.utn.frd.dds.etp.controller.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.utn.frd.dds.etp.dto.RequestMessageDTO;
import org.utn.frd.dds.etp.dto.RequestOrderItemDTO;
import org.utn.frd.dds.etp.dto.ResponseMessage;
import org.utn.frd.dds.etp.entity.OrderItem;
import org.utn.frd.dds.etp.entity.User;
import org.utn.frd.dds.etp.service.impl.OrderItemServiceImpl;
import org.utn.frd.dds.etp.util.OrderItemUtil;
import org.utn.frd.dds.etp.util.RequestMessageUtil;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("order_items")
@Api(tags ="Order Items", description = "Manejo de los items de una orden.", position = 3)
public class OrderItemControllerImpl {

	private static final Log log = LogFactory.getLog(OrderItemControllerImpl.class);

	@Autowired
	OrderItemServiceImpl service;

	@RequestMapping(value="/add", method= RequestMethod.POST)
	@ApiOperation(value = "Agregar un item a una orden", notes = "Agregar un item a una orden")
	public ResponseEntity create(@RequestBody RequestOrderItemDTO requestOrderItemDTO, BindingResult bindingResult){

		if(!bindingResult.hasErrors()){

			try {

				return ResponseEntity.ok(service.save(OrderItemUtil.getOrderItem(requestOrderItemDTO)));
			} catch (Exception e) {

				return RequestMessageUtil.getResponseEntityOk(ResponseMessage.ENTITY_EXITS);
			}
		}

		return ResponseEntity.badRequest().build();
	}

	@RequestMapping(value="/update", method= RequestMethod.PUT)
	@ApiOperation(value = "Actualizar el item de una ordeno", notes = "Actualizar el item de una orden")
	public ResponseEntity update(@RequestBody OrderItem orderItemDTO , BindingResult bindingResult){

		if(!bindingResult.hasErrors()){

			try {

				return ResponseEntity.ok(service.save(orderItemDTO));
			} catch (Exception e) {

				return RequestMessageUtil.getResponseEntityOk(ResponseMessage.ENTITY_EXITS);
			}
		}

		return ResponseEntity.badRequest().build();
	}

	@RequestMapping(value="/delete/{uuid}",method = RequestMethod.DELETE)
	@ApiOperation(value = "Eliminar un item de una orden", notes = "Eliminar un item de orden")
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
	@ApiOperation(value = "Buscar un item de una orden por uuid", notes = "Buscar un item de una orden por uuid.")
	public ResponseEntity findOrderItemById(@PathVariable String uuid){

		Optional<OrderItem> orderItem = service.findById(uuid);
		if(orderItem.isPresent())

			return ResponseEntity.ok(orderItem);
		else
			return RequestMessageUtil.getResponseEntityOk(ResponseMessage.ENTITY_NOT_EXISTS);
	}

	@RequestMapping(value="/findAll/{uuidOrder}", method= RequestMethod.POST)
	@ApiOperation(value = "Buscar todos los items de una orden", notes = "Buscar todos los items de una orden.")
	public ResponseEntity findAll(@PathVariable String uuidOrder){

		Optional<OrderItem> orderItems = service.findById(uuidOrder);

		if(orderItems.isPresent())

			return ResponseEntity.ok(orderItems.get());
		else
			return RequestMessageUtil.getResponseEntityOk(ResponseMessage.ENTITY_NOT_EXISTS);
	}

}
