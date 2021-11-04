package org.utn.frd.dds.etp.dto;

import org.hibernate.annotations.GenericGenerator;
import org.utn.frd.dds.etp.entity.Order;
import org.utn.frd.dds.etp.entity.Product;

import javax.persistence.*;

public class RequestOrderItemDTO {

    private Product product;

    private Integer presentation;

    private Integer count;

    private Order order;

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
        return "RequestOrderItemDTO{" +
                "product=" + product +
                ", presentation=" + presentation +
                ", count=" + count +
                ", order=" + order +
                '}';
    }
}
