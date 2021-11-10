package org.utn.frd.dds.etp.controller.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.utn.frd.dds.etp.dto.RequestMessageDTO;
import org.utn.frd.dds.etp.dto.RequestOrderItemDTO;
import org.utn.frd.dds.etp.dto.RequestUpdateOrderItemDTO;
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
	public List<OrderItem>  findAll(@PathVariable String uuidOrder){

		return service.findAll(uuidOrder);
	}

	@RequestMapping(value="/csv/{uuid}",method = RequestMethod.GET)
	@ApiOperation(value = "Obtener CSV de una orden", notes = "Obtener CSV de una orden")
	public ResponseEntity<HttpStatus> getCSV(@PathVariable String uuid){

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + uuid + ".csv");
		// defining the custom Content-Type
		responseHeaders.set(HttpHeaders.CONTENT_TYPE, "text/csv");

		// Armar archivo de la orden
		List<OrderItem> orderItems = findAll(uuid);
		StringBuffer data = new StringBuffer();

//		orderItems.stream().forEach(o -> data.append(o.getProduct().getCode() + "-" + o.getPresentation() + ";" + o.getCount()+ "\n"));

		// TODO: Actualizar descargas de CSV para poder cobrarle al cliente

		StringBuffer data2 = new StringBuffer();
		data2.append("SKU;COUNT\n");
		data2.append("11540-1;2\n");
		data2.append("20322-1;5\n");
		data2.append("24749-1;3\n");

		return new ResponseEntity(data2.toString(), responseHeaders, HttpStatus.OK);
	}
}
