package org.utn.frd.dds.etp.dto;

import org.utn.frd.dds.etp.entity.Product;

public class RequestOrderItemDTO {

    private Product product;

    private Integer presentation;

    private Integer count;

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

    @Override
    public String toString() {
        return "RequestOrderItemDTO{" +
                "product=" + product +
                ", presentation=" + presentation +
                ", count=" + count +
                '}';
    }
}
