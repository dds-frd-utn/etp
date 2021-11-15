package org.utn.frd.dds.etp.entity.builder;

import org.utn.frd.dds.etp.entity.Consumption;
import org.utn.frd.dds.etp.entity.Order;
import org.utn.frd.dds.etp.entity.User;

import java.time.LocalDateTime;

public class ConsumptionBuilder {

    private String uuid;

    private User user;

    private Order order;

    private LocalDateTime localDateTime;

    public Consumption build(){

        return new Consumption(uuid, user, order, localDateTime);
    }

    public ConsumptionBuilder withUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public ConsumptionBuilder withUser(User user) {
        this.user = user;
        return this;
    }

    public ConsumptionBuilder withOrder(Order order) {
        this.order = order;
        return this;
    }

    public ConsumptionBuilder withLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
        return this;
    }
}
