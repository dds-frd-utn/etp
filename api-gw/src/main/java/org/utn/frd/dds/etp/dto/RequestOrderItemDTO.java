package org.utn.frd.dds.etp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.utn.frd.dds.etp.entity.Product;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RequestOrderItemDTO {

    private String uuidOrder;

    private RequestProductDTO product;

    private Integer presentation;

    private Integer count;

    public RequestProductDTO getProduct() {
        return product;
    }

    public String getUuidOrder() {
        return uuidOrder;
    }

    public void setUuidOrder(String uuidOrder) {
        this.uuidOrder = uuidOrder;
    }

    public void setProduct(RequestProductDTO product) {
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
                "uuidOrder='" + uuidOrder + '\'' +
                ", product=" + product +
                ", presentation=" + presentation +
                ", count=" + count +
                '}';
    }
}
