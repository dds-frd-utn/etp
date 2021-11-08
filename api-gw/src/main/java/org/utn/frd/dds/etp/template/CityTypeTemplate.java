package org.utn.frd.dds.etp.template;

import org.utn.frd.dds.etp.entity.City;
import org.utn.frd.dds.etp.entity.CityType;

public class CityTypeTemplate {


    public static CityType getCityType() {

        CityType cityType = new CityType();
        cityType.setUuid("uuid-123");
        cityType.setDescription("Localidad");

        return cityType;
    }
}
