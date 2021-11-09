package org.utn.frd.dds.etp.controller.impl;

import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.utn.frd.dds.etp.dto.RequestMessageDTO;
import org.utn.frd.dds.etp.dto.RequestUserDTO;
import org.utn.frd.dds.etp.dto.ResponseMessage;
import org.utn.frd.dds.etp.dto.ResponseUserDTO;
import org.utn.frd.dds.etp.entity.User;
import org.utn.frd.dds.etp.service.impl.UserServiceImpl;
import org.utn.frd.dds.etp.util.RequestMessageUtil;
import org.utn.frd.dds.etp.util.UserUtil;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
@Api(tags ="Users", description = "Manejo de usuarios.", position = 1)
public class UserControllerImpl {

	private static final Log log = LogFactory.getLog(UserControllerImpl.class);

	@Autowired
	UserServiceImpl service;

	@RequestMapping(value="/create", method= RequestMethod.POST)
	@ApiOperation(value = "Crear un usuario", notes = "Crear un usuario")
	public ResponseEntity create(@RequestBody RequestUserDTO requestUserDTO, BindingResult bindingResult){

		if(!bindingResult.hasErrors()){

			try {

				return ResponseEntity.ok(service.save(UserUtil.getUser(requestUserDTO)));
			} catch (Exception e) {

				return RequestMessageUtil.getResponseEntityOk(ResponseMessage.ENTITY_EXITS);
			}
		}

		return ResponseEntity.badRequest().build();
	}

	@RequestMapping(value="/update", method= RequestMethod.PUT)
	@ApiOperation(value = "Actualizar un usuario", notes = "Actualizar un usuario")
	public ResponseEntity create(@RequestBody User userDTO , BindingResult bindingResult){

		if(!bindingResult.hasErrors()){

			try {

				return ResponseEntity.ok(service.save(userDTO));
			} catch (Exception e) {

				return RequestMessageUtil.getResponseEntityOk(ResponseMessage.ENTITY_EXITS);
			}
		}

		return ResponseEntity.badRequest().build();
	}

	@RequestMapping(value="/delete/{uuid}",method = RequestMethod.DELETE)
	@ApiOperation(value = "Eliminar un usuario", notes = "Eliminar un usuario")
	public ResponseEntity delete(@PathVariable String uuid){

		RequestMessageDTO requestMessageDTO = null;
		try {

			service.deleteById(uuid);
		} catch (Exception e) {

			return RequestMessageUtil.getResponseEntityOk(ResponseMessage.ENTITY_NOT_EXISTS);
		}

		return RequestMessageUtil.getResponseEntityOk(ResponseMessage.ENTITY_DELETE);
	}

	@RequestMapping(value="/find/{uuid}", method= RequestMethod.POST)
	@ApiOperation(value = "Buscar usuario por Id", notes = "Buscar usuario por Id")
	public ResponseEntity findUserById(@PathVariable String uuid){

		Optional<User> user = service.findById(uuid);
		if(user.isPresent())

			return ResponseEntity.ok(UserUtil.getResponseUserDTO(user.get()));
		else
			return RequestMessageUtil.getResponseEntityOk(ResponseMessage.ENTITY_NOT_EXISTS);
	}

	//@RequestMapping(value="/findAll", method= RequestMethod.POST)
	//@ApiOperation(value = "Buscar todos los usuarios", notes = "Buscar todos los usuarios.")
	public List<User> findAllUsers(){

		return Lists.newArrayList(service.findAll());
	}

}
