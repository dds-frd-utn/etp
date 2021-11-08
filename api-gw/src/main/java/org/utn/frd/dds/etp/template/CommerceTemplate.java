package org.utn.frd.dds.etp.template;

import org.utn.frd.dds.etp.entity.Commerce;
import org.utn.frd.dds.etp.entity.State;

public class CommerceTemplate {

    public static Commerce getCommerce() {

        Commerce commerce = new Commerce();
        commerce.setUuid("uuid-123");
        //commerce.se

        return commerce;
    }
}
