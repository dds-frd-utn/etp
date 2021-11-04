package org.utn.frd.dds.etp.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author jonatan.moreira
 *
 */
@Entity
@Table(name="states")
public class State {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String uuid;

    @Column(name="name", nullable=false, length=50)
    private String name;

    @JoinColumn(name = "country_uuid")
    @OneToOne(fetch = FetchType.EAGER)
    private Country country;

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "State{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
