package org.utn.frd.dds.etp.controller.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.utn.frd.dds.etp.dto.RequestMessageDTO;
import org.utn.frd.dds.etp.dto.RequestOrderItemDTO;
import org.utn.frd.dds.etp.dto.RequestUpdateOrderItemDTO;
import org.utn.frd.dds.etp.dto.ResponseMessage;
import org.utn.frd.dds.etp.entity.Consumption;
import org.utn.frd.dds.etp.entity.Order;
import org.utn.frd.dds.etp.entity.OrderItem;
import org.utn.frd.dds.etp.entity.User;
import org.utn.frd.dds.etp.entity.builder.ConsumptionBuilder;
import org.utn.frd.dds.etp.entity.builder.OrderBuilder;
import org.utn.frd.dds.etp.entity.builder.UserBuilder;
import org.utn.frd.dds.etp.service.impl.ConsumptionServiceImpl;
import org.utn.frd.dds.etp.service.impl.OrderItemServiceImpl;
import org.utn.frd.dds.etp.service.impl.ProductServiceImpl;
import org.utn.frd.dds.etp.util.OrderItemUtil;
import org.utn.frd.dds.etp.util.ProductUtil;
import org.utn.frd.dds.etp.util.RequestMessageUtil;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("order_items")
@Api(tags ="Order Items", description = "Manejo de los items de una orden.", position = 3)
public class OrderItemControllerImpl {

	private static final Log log = LogFactory.getLog(OrderItemControllerImpl.class);

	@Autowired
	OrderItemServiceImpl service;

	@Autowired
	ConsumptionServiceImpl consumptionService;

	@Autowired
	ProductServiceImpl productService;

	@RequestMapping(value="/add", method= RequestMethod.POST)
	@ApiOperation(value = "Agregar un item a una orden", notes = "Agregar un item a una orden")
	public ResponseEntity create(@RequestBody RequestOrderItemDTO requestOrderItemDTO, BindingResult bindingResult){

		if(!bindingResult.hasErrors()){

			try {

				productService.save(ProductUtil.getProduct(requestOrderItemDTO.getProduct()));

				return ResponseEntity.ok(service.save(OrderItemUtil.getOrderItem(requestOrderItemDTO)));
			} catch (Exception e) {

				e.printStackTrace();

				return RequestMessageUtil.getResponseEntityOk(ResponseMessage.ENTITY_EXITS);
			}
		}

		return ResponseEntity.badRequest().build();
	}

	@RequestMapping(value="/update", method= RequestMethod.PUT)
	@ApiOperation(value = "Actualizar el item de una ordeno", notes = "Actualizar el item de una orden")
	public ResponseEntity update(@RequestBody RequestUpdateOrderItemDTO orderItemDTO , BindingResult bindingResult){

		if(!bindingResult.hasErrors()){

			try {

				Optional<OrderItem> orderItem = service.findById(orderItemDTO.getUuid());

				if(orderItem.isPresent()) {

					OrderItem oi = orderItem.get();
					oi.setPresentation(orderItemDTO.getPresentation());
					oi.setCount(orderItemDTO.getCount());

					return ResponseEntity.ok(service.save(oi));
				} else {
					return RequestMessageUtil.getResponseEntityOk(ResponseMessage.ENTITY_EXITS);
				}

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

//	@RequestMapping(value="/findAll/{uuidOrder}", method= RequestMethod.POST)
//	@ApiOperation(value = "Buscar todos los items de una orden", notes = "Buscar todos los items de una orden.")
	public List<OrderItem> findAllFilterByOrderUUID(@PathVariable String uuidOrder){

		return service.findAllFilterByOrderUUID(uuidOrder);
	}

	@RequestMapping(value="/csv/{uuid}",method = RequestMethod.GET)
	@ApiOperation(value = "Obtener CSV de una orden", notes = "Obtener CSV de una orden")
	public ResponseEntity<HttpStatus> getCSV(@PathVariable String uuid, @Param("commerceUUID") String commerceUUID){

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + uuid + ".csv");
		// defining the custom Content-Type
		responseHeaders.set(HttpHeaders.CONTENT_TYPE, "text/csv");

		// Armar archivo de la orden
		List<OrderItem> orderItems = findAllFilterByOrderUUID(uuid);
		StringBuffer data = new StringBuffer();

		data.append("SKU;COUNT\n");
		orderItems.stream().forEach(o -> data.append(o.getProduct().getCode() + "-" + o.getPresentation() + ";" + o.getCount()+ "\n"));


		User user = null;

		if(commerceUUID!=null)
			user = new UserBuilder()
					.withUuid(commerceUUID)
					.build();

		// Guardo el registro de quien consumio el servicio.
		Consumption consumption = new ConsumptionBuilder()
				.withOrder(new OrderBuilder().withUuid(uuid).build())
				.withLocalDateTime(LocalDateTime.now())
				.withUser(user)
				.build();

		consumptionService.save(consumption);

		return new ResponseEntity(data.toString(), responseHeaders, HttpStatus.OK);
	}
}
