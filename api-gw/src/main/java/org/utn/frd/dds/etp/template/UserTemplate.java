package org.utn.frd.dds.etp.template;

import org.utn.frd.dds.etp.entity.User;

public class UserTemplate {


    public static User getUser() {

        User user = new User();

        user.setUuid("uuid-123");
        user.setCode("123");
        user.setFirstName("Jonatan");
        user.setLastName("Moreira");
        user.setEmail("moreirajonatan1983@gmail.com");

        return user;
    }
}
