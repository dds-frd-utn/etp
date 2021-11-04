package org.utn.frd.dds.etp.controller.impl;

import com.etp.crud.controller.impl.CrudControllerImpl;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.utn.frd.dds.etp.controller.UserController;
import org.utn.frd.dds.etp.dto.RequestUserDTO;
import org.utn.frd.dds.etp.dto.ResponseUserDTO;
import org.utn.frd.dds.etp.entity.User;
import org.utn.frd.dds.etp.util.UserUtil;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
@Api(tags ="Users", description = "Manejo de usuarios.", position = 1)
public class UserControllerImpl extends CrudControllerImpl<User, String> implements UserController {

	private static final Log log = LogFactory.getLog(UserController.class);

	@RequestMapping(value="/create", method= RequestMethod.POST)
	@ApiOperation(value = "Crear un usuario", notes = "Crear un usuario")
	public ResponseEntity<User> create(@RequestBody RequestUserDTO requestUserDTO, BindingResult bindingResult){

		if(!bindingResult.hasErrors()){

			User user = super.service.save(UserUtil.getUser(requestUserDTO));

			if(user != null) {

				return ResponseEntity.ok(user);
			}
		}

		return ResponseEntity.badRequest().build();
	}

	@RequestMapping(value="/delete/{uuid}",method = RequestMethod.DELETE)
	@ApiOperation(value = "Eliminar un usuario", notes = "Eliminar un usuario")
	public ResponseEntity<String> delete(@PathVariable String uuid){

		try {
			super.service.deleteById(uuid);

			return ResponseEntity.ok().build();
		} catch (EntityNotFoundException e) {

			return ResponseEntity.notFound().build();
		}
	}

	@RequestMapping(value="/find/{uuid}", method= RequestMethod.POST)
	@ApiOperation(value = "Buscar usuario por Id", notes = "Buscar usuario por Id")
	public ResponseEntity<ResponseUserDTO> findUserById(@PathVariable String uuid){

		Optional<User> user = super.service.findById(uuid);

		ResponseUserDTO responseUserDTO = UserUtil.getResponseUserDTO(user.get());

		return ResponseEntity.ok(responseUserDTO);
	}

	//@RequestMapping(value="/findAll", method= RequestMethod.POST)
	//@ApiOperation(value = "Buscar todos los usuarios", notes = "Buscar todos los usuarios.")
	public List<User> findAllUsers(){

		return Lists.newArrayList(super.service.findAll());
	}

}
