package org.utn.frd.dds.etp.template;

import org.utn.frd.dds.etp.entity.City;
import org.utn.frd.dds.etp.entity.User;

public class CityTemplate {


    public static City getCity() {

        City city = new City();
        city.setUuid("uuid-123");
        city.setName("Campana");
        city.setCityType(CityTypeTemplate.getCityType());
        city.setState(StateTemplate.getState());

        return city;
    }
}
