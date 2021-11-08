package org.utn.frd.dds.etp.template;

import org.utn.frd.dds.etp.entity.Local;
import org.utn.frd.dds.etp.entity.User;

public class LocalTemplate {


    public static Local getLocal() {

        Local local = new Local();

        local.setUuid("uuid");
        local.setAddress("mitre");
        local.setAddressNo("123");
        local.setCity(CityTemplate.getCity());
        local.setCommerce(CommerceTemplate.getCommerce());

        return local;
    }
}
