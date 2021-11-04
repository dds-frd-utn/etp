package org.utn.frd.dds.etp.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author jonatan.moreira
 *
 */
@Entity
@Table(name="cities")
public class City {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String uuid;

    @Column(name="name", nullable=true, length=50)
    private String name;

    @JoinColumn(name = "state_uuid")
    @OneToOne(fetch = FetchType.EAGER)
    private State state;

    @JoinColumn(name = "city_type_uuid")
    @OneToOne(fetch = FetchType.EAGER)
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
