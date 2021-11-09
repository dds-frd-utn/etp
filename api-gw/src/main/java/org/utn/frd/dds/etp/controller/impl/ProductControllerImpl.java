package org.utn.frd.dds.etp.controller.impl;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.utn.frd.dds.etp.dto.ResponseMessage;
import org.utn.frd.dds.etp.dto.ResponseProductDTO;
import org.utn.frd.dds.etp.entity.Product;
import org.utn.frd.dds.etp.entity.User;
import org.utn.frd.dds.etp.service.impl.ProductServiceImpl;
import org.utn.frd.dds.etp.util.ProductUtil;
import org.utn.frd.dds.etp.util.RequestMessageUtil;
import org.utn.frd.dds.etp.util.UserUtil;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

//@RestController
//@RequestMapping("products")
public class ProductControllerImpl {

	private static final Log log = LogFactory.getLog(ProductControllerImpl.class);

	@Autowired
	ProductServiceImpl service;

	// @RequestMapping(value="/create", method= RequestMethod.POST)
	// @ApiOperation(value = "Crear un producto", notes = "Crear un producto.")
	public ResponseEntity create(@RequestBody Product product){

		return ResponseEntity.ok(service.save(product));
	}

	// @RequestMapping(value="/delete/{uuid}",method = RequestMethod.DELETE)
	// @ApiOperation(value = "Eliminar un producto", notes = "Eliminar un producto.")
	public ResponseEntity delete(@PathVariable String uuid){

		try {

			service.deleteById(uuid);
		} catch (Exception e) {

			return RequestMessageUtil.getResponseEntityOk(ResponseMessage.ENTITY_NOT_EXISTS);
		}

		return RequestMessageUtil.getResponseEntityOk(ResponseMessage.ENTITY_DELETE);
	}

//	@RequestMapping(value="/find/{uuid}", method= RequestMethod.GET)
//	@ApiOperation(value = "Buscar producto por Id", notes = "Buscar producto por uuid.")
	public ResponseEntity findProductById(@PathVariable String uuid){

		Optional<Product> product = service.findById(uuid);
		if(product.isPresent())

			return ResponseEntity.ok(ProductUtil.getResponseProductDTO(product.get()));
		else
			return RequestMessageUtil.getResponseEntityOk(ResponseMessage.ENTITY_NOT_EXISTS);
	}

	@RequestMapping(value="/findAll", method= RequestMethod.POST)
	@ApiOperation(value = "Buscar todos los productos", notes = "Buscar todos los productos.")
	public ResponseEntity<List<Product>> productFindAll(){

		List<Product> products = Lists.newArrayList(service.findAll());

		return ResponseEntity.ok(products);
	}
}
