package org.utn.frd.dds.etp.entity.builder;

import org.utn.frd.dds.etp.entity.Local;
import org.utn.frd.dds.etp.entity.Order;
import org.utn.frd.dds.etp.entity.User;

import java.time.LocalDateTime;

public class OrderBuilder {

    private String uuid;

    private LocalDateTime localDateTime;

    private Local local;

    private User user;

    public Order build(){

        return new Order();
    }

    public OrderBuilder withUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public OrderBuilder withLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
        return this;
    }

    public OrderBuilder withLocal(Local local) {
        this.local = local;
        return this;
    }

    public OrderBuilder withUser(User user) {
        this.user = user;
        return this;
    }
}
