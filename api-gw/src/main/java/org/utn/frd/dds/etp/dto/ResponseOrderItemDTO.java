package org.utn.frd.dds.etp.dto;

import org.utn.frd.dds.etp.entity.Order;
import org.utn.frd.dds.etp.entity.Product;

public class ResponseOrderItemDTO {

    private String uuid;

    private Product product;

    private Integer presentation;

    private Integer count;

    private Order order;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getPresentation() {
        return presentation;
    }

    public void setPresentation(Integer presentation) {
        this.presentation = presentation;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "ResponseOrderItemDTO{" +
                "uuid='" + uuid + '\'' +
                ", product=" + product +
                ", presentation=" + presentation +
                ", count=" + count +
                ", order=" + order +
                '}';
    }
}
