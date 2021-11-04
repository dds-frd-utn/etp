package org.utn.frd.dds.etp.controller.impl;

import com.etp.crud.controller.impl.CrudControllerImpl;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.utn.frd.dds.etp.controller.ProductController;
import org.utn.frd.dds.etp.dto.ResponseProductDTO;
import org.utn.frd.dds.etp.entity.Product;
import org.utn.frd.dds.etp.util.ProductUtil;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

//@RestController
//@RequestMapping("products")
public class ProductControllerImpl extends CrudControllerImpl<Product, String> implements ProductController {

	private static final Log log = LogFactory.getLog(ProductController.class);

	// @RequestMapping(value="/create", method= RequestMethod.POST)
	// @ApiOperation(value = "Crear un producto", notes = "Crear un producto.")
	public ResponseEntity<Product> create(@RequestBody Product product){

		return ResponseEntity.ok(super.service.save(product));
	}

	// @RequestMapping(value="/delete/{uuid}",method = RequestMethod.DELETE)
	// @ApiOperation(value = "Eliminar un producto", notes = "Eliminar un producto.")
	public ResponseEntity<String> delete(@PathVariable String uuid){

		try {
			super.service.deleteById(uuid);

			return ResponseEntity.ok().build();
		} catch (EntityNotFoundException e) {

			return ResponseEntity.notFound().build();
		}
	}

	@RequestMapping(value="/find/{uuid}", method= RequestMethod.POST)
	@ApiOperation(value = "Buscar producto por Id", notes = "Buscar producto por uuid.")
	public ResponseEntity<ResponseProductDTO>  findProductById(@PathVariable String uuid){

		Optional<Product> product = super.service.findById(uuid);

		ResponseProductDTO responseProductDTO = ProductUtil.getResponseUserDTO(product.get());

		return ResponseEntity.ok(responseProductDTO);
	}

	@RequestMapping(value="/findAll", method= RequestMethod.POST)
	@ApiOperation(value = "Buscar todos los productos", notes = "Buscar todos los productos.")
	public ResponseEntity<List<Product>> productFindAll(){

		List<Product> products = Lists.newArrayList(super.service.findAll());

		return ResponseEntity.ok(products);
	}
}
