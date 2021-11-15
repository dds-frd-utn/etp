package org.utn.frd.dds.etp.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author jonatan.moreira
 *
 */
@Entity
@Table(name="order_items")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OrderItem {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @JsonAlias("uuid")
    private String uuid;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "code", insertable = true, updatable = true  )
    private Product product;

    @Column(name="presentation")
    private Integer presentation;

    @Column(name="count")
    private Integer count;

    @JoinColumn(name = "order_uuid", insertable = true, updatable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private Order order;

    public OrderItem() {
    }

    public OrderItem(String uuid, Product product, Integer presentation, Integer count, Order order) {
        this.uuid = uuid;
        this.product = product;
        this.presentation = presentation;
        this.count = count;
        this.order = order;
    }

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
        return "OrderItem{" +
                "uuid='" + uuid + '\'' +
                ", product=" + product +
                ", presentation=" + presentation +
                ", count=" + count +
                ", order=" + order +
                '}';
    }

}
