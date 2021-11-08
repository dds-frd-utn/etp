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

import org.utn.frd.dds.etp.dto.RequestOrderDTO;
import org.utn.frd.dds.etp.dto.ResponseOrderDTO;
import org.utn.frd.dds.etp.entity.Order;
import org.utn.frd.dds.etp.service.impl.OrderServiceImpl;
import org.utn.frd.dds.etp.util.OrderUtil;
import org.utn.frd.dds.etp.util.QR;

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
	public ResponseEntity<ResponseOrderDTO> create(@RequestBody RequestOrderDTO requestOrderDTO, BindingResult bindingResult){

		if(!bindingResult.hasErrors()){

			Order order = service.save(OrderUtil.getOrder(requestOrderDTO));

			if(order != null) {

				ResponseOrderDTO responseOrderDTO = OrderUtil.getResponseOrderDTO(order);

				return ResponseEntity.ok(responseOrderDTO);
			}
		}

		return ResponseEntity.badRequest().build();
	}

	@RequestMapping(value="/delete/{uuid}",method = RequestMethod.DELETE)
	@ApiOperation(value = "Eliminar una orden", notes = "Eliminar una Orden")
	public ResponseEntity delete(@PathVariable String uuid){

		try{
			service.deleteById(uuid);

			return ResponseEntity.ok().build();
		} catch (EntityNotFoundException e) {

			return ResponseEntity.notFound().build();
		}
	}

	@RequestMapping(value="/find/{uuid}", method= RequestMethod.POST)
	@ApiOperation(value = "Buscar Orden por Id", notes = "Buscar Orden por Id")
	public ResponseEntity<Order>  findOrderById(@PathVariable String uuid){

		Optional<Order> order = service.findById(uuid);

		return ResponseEntity.ok(order.get());
	}

	@RequestMapping(value="/findAll/{uuid}", method= RequestMethod.POST)
	@ApiOperation(value = "Buscar todas las ordenes de un usuario", notes = "Buscar todas las ordenes de un usuario.")
	public ResponseEntity<List<Order>>findAll(@PathVariable String uuid){

		// List<Order> orders = super.service.findById(uuid).stream().collect(Collectors.toList());

		List<Order> orders = new ArrayList<>();

		return ResponseEntity.ok(orders);
	}

	@RequestMapping(value="/qr/{uuid}",method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
	@ApiOperation(value = "Obtener codigo QR", notes = "Obtener codigo QR")
	public BufferedImage getQR(@PathVariable String uuid) throws WriterException {

		// OrderService.getQR(uuid);

		return QR.createQR(uuid);
	}

	@RequestMapping(value="/csv/{uuid}",method = RequestMethod.GET)
	@ApiOperation(value = "Obtener CSV de una orden", notes = "Obtener CSV de una orden")
	public ResponseEntity<HttpStatus> getCSV(@PathVariable String uuid){

		// orderService.getCSV(uuid);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + uuid + ".csv");
		// defining the custom Content-Type
		responseHeaders.set(HttpHeaders.CONTENT_TYPE, "text/csv");

		String data = "SKU;COUNT\n11540-1;2\n20322-1;5\n24749-1;3";
		return new ResponseEntity(data, responseHeaders, HttpStatus.OK);

	}

}
