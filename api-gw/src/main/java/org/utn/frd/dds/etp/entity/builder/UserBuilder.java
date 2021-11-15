package org.utn.frd.dds.etp.entity.builder;

import org.utn.frd.dds.etp.entity.User;


public class UserBuilder {

    private String uuid;

    private String lastName;

    private String firstName;

    private String email;

    public User build(){

        return new User();
    }

    public UserBuilder withUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public UserBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }
}
