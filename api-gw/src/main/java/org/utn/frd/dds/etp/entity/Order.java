/**
 * 
 */
package org.utn.frd.dds.etp.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="orders")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Order {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @JsonAlias("uuid")
    private String uuid;

    @Column(name="localDateTime")
    @JsonAlias("localDateTime")
    private LocalDateTime localDateTime;

    @JoinColumn(name = "local_uuid", insertable = false, nullable = true)
    @OneToOne(fetch = FetchType.EAGER)
    private Local local;

    @JoinColumn(name = "user_uuid", insertable = true, nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    public Order() {
    }

    public Order(String uuid, LocalDateTime localDateTime, Local local, User user) {
        this.uuid = uuid;
        this.localDateTime = localDateTime;
        this.local = local;
        this.user = user;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "uuid='" + uuid + '\'' +
                ", localDateTime=" + localDateTime +
                ", local=" + local +
                ", user=" + user +
                '}';
    }

}
