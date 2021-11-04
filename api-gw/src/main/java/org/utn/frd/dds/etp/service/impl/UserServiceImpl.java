package org.utn.frd.dds.etp.service.impl;

import com.etp.crud.service.impl.CrudServiceImpl;
import org.springframework.stereotype.Service;
import org.utn.frd.dds.etp.entity.User;
import org.utn.frd.dds.etp.service.UserService;

import javax.transaction.Transactional;

/**
 * @author jonatan.moreira
 *
 */
@Service
@Transactional
public class UserServiceImpl extends CrudServiceImpl<User, String> implements UserService {

}
