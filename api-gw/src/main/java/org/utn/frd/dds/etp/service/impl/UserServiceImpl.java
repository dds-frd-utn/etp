package org.utn.frd.dds.etp.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.utn.frd.dds.etp.entity.User;
import org.utn.frd.dds.etp.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author jonatan.moreira
 *
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<User, String> {

    private static final Log log = LogFactory.getLog(UserServiceImpl.class);

    @Autowired
    UserRepository repository;

    public UserRepository getRepository() {
        return repository;
    }

}
