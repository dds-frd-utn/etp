package org.utn.frd.dds.etp.entity.builder;

import org.utn.frd.dds.etp.entity.Order;
import org.utn.frd.dds.etp.entity.OrderItem;
import org.utn.frd.dds.etp.entity.Product;

public class OrderItemBuilder {

    private String uuid;

    private Product product;

    private Integer presentation;

    private Integer count;

    private Order order;

    public OrderItem build(){

        return new OrderItem(uuid, product, presentation, count, order);
    }

    public OrderItemBuilder withUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public OrderItemBuilder withProduct(Product product) {
        this.product = product;
        return this;
    }

    public OrderItemBuilder withPresentation(Integer presentation) {
        this.presentation = presentation;
        return this;
    }

    public OrderItemBuilder withCount(Integer count) {
        this.count = count;
        return this;
    }

    public OrderItemBuilder withOrder(Order order) {
        this.order = order;
        return this;
    }
}
