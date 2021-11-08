package org.utn.frd.dds.etp.template;

import org.utn.frd.dds.etp.entity.Country;
import org.utn.frd.dds.etp.entity.State;

public class CountryTemplate {

    public static Country getCountry() {

        Country country = new Country();

        country.setUuid("uuid-123");
        country.setName("Argentina");

        return country;
    }
}
