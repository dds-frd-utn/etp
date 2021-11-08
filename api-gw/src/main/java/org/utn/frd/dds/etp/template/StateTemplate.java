package org.utn.frd.dds.etp.template;

import org.utn.frd.dds.etp.entity.State;

public class StateTemplate {

    public static State getState() {

        State state = new State();

        state.setUuid("uuid-123");
        state.setName("Buenos Aires");
        state.setCountry(CountryTemplate.getCountry());

        return state;
    }
}
