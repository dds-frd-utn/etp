package org.utn.frd.dds.etp.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="locals")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Local {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @JsonAlias("uuid")
    private String uuid;

    @JoinColumn(name = "city_uuid")
    @OneToOne(fetch = FetchType.EAGER)
    @JsonAlias("city")
    private City city;

    @Column(name="Address", nullable=true, length=50)
    @JsonAlias("address")
    private String address;

    @Column(name="AddressNo", nullable=true, length=50)
    @JsonAlias("addressNo")
    private String addressNo;

    @JoinColumn(name = "commerce_uuid")
    @OneToOne(fetch = FetchType.EAGER)
    private Commerce commerce;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressNo() {
        return addressNo;
    }

    public void setAddressNo(String addressNo) {
        this.addressNo = addressNo;
    }

    public Commerce getCommerce() {
        return commerce;
    }

    public void setCommerce(Commerce commerce) {
        this.commerce = commerce;
    }

    @Override
    public String toString() {
        return "Local{" +
                "uuid='" + uuid + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", addressNo='" + addressNo + '\'' +
                ", commerce=" + commerce +
                '}';
    }

}
