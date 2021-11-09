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
@Table(name="states")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class State {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @JsonAlias("uuid")
    private String uuid;

    @Column(name="name", nullable=false, length=50)
    @JsonAlias("name")
    private String name;

    @JoinColumn(name = "country_uuid")
    @OneToOne(fetch = FetchType.EAGER)
    @JsonAlias("country_uuid")
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
