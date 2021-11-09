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
@Table(name="cities")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class City {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @JsonAlias("uuid")
    private String uuid;

    @Column(name="name", nullable=true, length=50)
    @JsonAlias("name")
    private String name;

    @JoinColumn(name = "state_uuid")
    @OneToOne(fetch = FetchType.EAGER)
    @JsonAlias("state")
    private State state;

    @JoinColumn(name = "city_type_uuid")
    @OneToOne(fetch = FetchType.EAGER)
    @JsonAlias("cityType")
    private CityType cityType;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public CityType getCityType() {
        return cityType;
    }

    public void setCityType(CityType cityType) {
        this.cityType = cityType;
    }

    @Override
    public String toString() {
        return "City{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", state=" + state +
                ", cityType=" + cityType +
                '}';
    }

}
